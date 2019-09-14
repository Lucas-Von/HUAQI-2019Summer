#入参：
#	 1.股指基金代码       str
#    2.股指基金当前持有份数 int
#    3.股指基金当前持有份额  float   //修改
#    3.购买金额          float //小于0则为卖出

#出参：
#	  股指基金代码        str
#     股指基金名称         str      //修改
#     配置份额（以当前价格此次买入的数量，也可能是卖出，即负）     float
#     配置份数             int //
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

def buy_sell_qdiifund(code:str, cur_number:int, cur_share:float, money_tobuy:float):
    result_lst = []
    code, name, netvalue = get_fund_netvalue(code)
    netvalue = float(netvalue)
    share = money_tobuy / netvalue
    num = int('%0.0f' % (share / cur_share * cur_number))

    tmp_dct = {'qdiicode':code,
               'qdiiname':name,
               'share_deployed':share,        #配置份额，float
               'number_deployed':num,         #配置份数，int
               'm_already_deployed':money_tobuy,
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
        buy_sell_qdiifund(v[0],v[1],v[2],v[3])
        return 0
    except:
        return -1

if __name__ == '__main__':
    main(sys.argv[1])    
    




















