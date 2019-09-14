#入参：
#	1.股指目标配置金额       float
#   2.股指已配置总【成本】    float  
#	3.股指已配置总份数	      int
#   4.当前股指持仓    	   [{'代码':'','份数':'','份额':},{'代码':'','份数':'','份额':}]

#出参：
#	  股指基金代码        str
#     股指基金名称         str
#     配置份额（以当前价格此次买入的数量，也可能是卖出，即负）     float
#     配置份数             int //新增项，同有可能负
#     配置成功金额       float
#     即时交易价格（记录买入价）    float

import numpy as np
import pandas as pd
import requests
import re
import json
import sys

def get_fund_netvalue(code:str):
    '''获取基金净值'''
    url = "http://fund.eastmoney.com/"+code+".html"
    headers = {
        'referer':'http://fund.eastmoney.com/'+code+'.html',
        }  
    r = requests.get(url = url, headers = headers)
    r.encoding = 'unicode'

    matchObj = re.search( r'基金名称：</span><span class="funCur-FundName">(.*?)</span>', r.text)
    name = matchObj.group(1)
    matchObj = re.search( r'日增长率</th></tr><tr>  <td class="alignLeft">(.*?)</td>  <td class="alignRight bold">(.*?)</td>', r.text)
    netvalue = matchObj.group(2)
    return [code, name, netvalue]
        
def cal_val_percentile(cur_val:float, his_val_lst:list):
    """输入当前估值、历史估值序列，判断估值百分位float"""
    count = 0
    for item in his_val_lst:
        if cur_val > item:
            count += 1
    return count/len(his_val_lst)

def judge_valpercent_range(valpercent:float):
    '''判断估值区间，输出字符串'''
    if valpercent < 0.05:
        return '最极度低估'
    elif valpercent < 0.10:
        return '极度低估'
    elif valpercent < 0.20:
        return '低估'
    elif valpercent < 0.40:
        return '正常低估'
    elif valpercent < 0.60:
        return '正常'
    elif valpercent < 0.80:
        return '正常高估'
    elif valpercent < 0.90:
        return '高估'
    else:
        return '极度高估'

def invest_algorithm():
    '''给出推荐购买/卖出的基金代码和份数'''
    #读历史估值序列数据，数据为df，列名为指数名
    his_val_data_df = pd.read_excel('指数估值.xlsx')
    cur_val_data_df = pd.read_excel('当前指数估值股息率.xlsx')
    #建立 列名--基金代码 的字典
    fundcode_dct = {'SP1200HealthCare': '000369', 'SP500信息科技': '161128', 'SP500': '050025', '标普美国品质消费股票': '162415', '标普全球高端消费品': '118002', '标普生物科技精选行业': '161127', 'DAX30': '513030', '富时发达市场': '005613', '恒生中国企业': '160717', '美国REIT': '000179', '纳斯达克100': '270042', '纳斯达克生物科技': '001092', '香港恒生': '164705'}
    
    #将历史估值和当前估值、股息率数据取出来
    his_index_val_dct = {}                   #key = code, val = hisdata_list
    cur_index_val_dct = {}
    cur_index_dividend_dct = {}
    for key in his_val_data_df:
        lst0 = his_val_data_df[key]
        lst0 = list(lst0[~np.isnan(lst0)])   #去空值
        his_index_val_dct[key] = lst0
        
        cur_val_lst = list(cur_val_data_df[key])
        cur_index_val_dct[key] = cur_val_lst[0]         #估值
        cur_index_dividend_dct[key] = cur_val_lst[1]    #股息率
    
    #选择符合购买/卖出条件的指数(只选正常低估以下的，且比上个月低了的)
    cur_index_low_valpercent_dct = {}
    cur_index_high_valpercent_dct = {}
    for key in his_val_data_df:
        val0 = cur_index_val_dct[key]
        his_val_lst0 = his_index_val_dct[key]
        valpercent = cal_val_percentile(val0, his_val_lst0)
        if judge_valpercent_range(valpercent) in ['最极度低估','极度低估'] or (judge_valpercent_range(valpercent) in ['低估','正常低估'] and val0 < his_val_lst0[-1]) :
            cur_index_low_valpercent_dct[key] = valpercent
        if judge_valpercent_range(valpercent) in ['高估','极度高估']:
            cur_index_high_valpercent_dct[key] = valpercent
            
    #博格公式：盈利收益率+股息率，确定买入顺序和卖出顺序
    Berg_result_dct = {}
    for key in cur_index_low_valpercent_dct:
        Berg_result_dct[key] = 100 * 1/cur_index_val_dct[key] + cur_index_dividend_dct[key]
    order_tobuy = sorted(Berg_result_dct.items(), key=lambda d: d[1], reverse = True)
    order_tosell = sorted(cur_index_high_valpercent_dct.items(), key=lambda d:d[1], reverse = True)
    
    #确定最终买入 代码，份数
    buy_lst = []
    for item in order_tobuy:
        code = fundcode_dct[item[0]]
        number = 0
        if judge_valpercent_range(cur_index_low_valpercent_dct[item[0]]) == '最极度低估':
            number = 3
            buy_lst.append([code,number])
        elif judge_valpercent_range(cur_index_low_valpercent_dct[item[0]]) == '极度低估':
            number = 2
        else:
            number = 1
            buy_lst.append([code,number])
        if len(buy_lst) >= 4:         #最多买入4种
            break

    #确定最终卖出 代码，份数
    sell_lst = []
    for item in order_tosell:
        code = fundcode_dct[item[0]]
        number = 0
        if judge_valpercent_range(cur_index_high_valpercent_dct[item[0]]) == '极度高估':
            number = 3
            sell_lst.append([code,number])
        elif judge_valpercent_range(cur_index_high_valpercent_dct[item[0]]) == '高估':
            number = 2
        else:
            number = 1
            sell_lst.append([code,number])
            
    #更新历史估值数据
    rownum = his_val_data_df.shape[0]
    colnum = his_val_data_df.shape[1]
    his_val_data_df.loc[rownum] = [np.nan for i in range(colnum)]
    for col in his_val_data_df:
        lst = list(his_val_data_df[col])
        for i in range(len(lst)):
            if np.isnan(lst[i]):
                lst[i] = list(cur_val_data_df[col])[0]
                break
        his_val_data_df[col] = lst
    #his_val_data_df.to_excel('指数估值.xlsx',index = False)     #更新历史估值序列
    return buy_lst, sell_lst

def buy_sell_result(buy_lst:list, sell_lst:list, money_expected_deploy:float, total_cost:float, total_number:int, qdiifund_position:list):
    '''给出最终的购买/卖出结果输出'''
    #确立当前持仓字典   <code>:<number>
    cur_position = {}
    for item in qdiifund_position:
        key = item['代码']
        val1 = item['份数']
        val2 = item['份额']
        cur_position[key] = (val1,val2)
        
    
    #确定购买结果
    result_lst = []
    remain_number = 100 - total_number
    if remain_number > 0 and money_expected_deploy - total_cost > 0:
        buy_per_num_money = (money_expected_deploy - total_cost) / remain_number
        #sell_per_num_money
        for item in buy_lst:
            if remain_number == 0:
                break
            code = item[0]
            num = min(item[1], remain_number)
            tmp_index_buy_result = get_fund_netvalue(code)
            name = tmp_index_buy_result[1]
            netvalue =  float(tmp_index_buy_result[2])
            share = num * buy_per_num_money / netvalue     #购买份额
            tmp_dct = {'qdiicode':code,
                       'qdiiname':name,
                       'share_deployed':share,        #配置份额，float
                       'number_deployed':int(num),         #配置份数，int
                       'm_already_deployed':num * buy_per_num_money,
                       'price_deployed':netvalue
                       }
            remain_number -= num
            result_lst.append(tmp_dct)
    
    #确定卖出结果
    for item in sell_lst:
        code = item[0]
        if code in cur_position.keys():
            num = min(item[1],cur_position[code][0])
            if num == 0:   #如果当前并未持仓
                continue
            tmp_index_buy_result = get_fund_netvalue(code)
            name = tmp_index_buy_result[1]
            netvalue = float(tmp_index_buy_result[2])
            share = cur_position[code][1] * num / cur_position[code][0]     #卖出份额
            tmp_dct = {'qdiicode':code,
                       'qdiiname':name,
                       'share_deployed':-share,        #配置份额，float
                       'number_deployed':-int(num),         #配置份数，int
                       'm_already_deployed':-share * netvalue,
                       'price_deployed':netvalue
                       }
            result_lst.append(tmp_dct)
        
    
    result_dct = {'result':result_lst}
    array_json=json.dumps(result_dct)
    print(array_json)
    return 0

def main(jsondata):
    c=json.loads(jsondata) #加载json字符串为字典
    v=list(c.values()) #取字典的值
    try:
        buy_lst, sell_lst = invest_algorithm()
        buy_sell_result(buy_lst, sell_lst, v[0],v[1],v[2],v[3])
        return 0
    except:
        return -1

if __name__ == '__main__':
    main(sys.argv[1])
















