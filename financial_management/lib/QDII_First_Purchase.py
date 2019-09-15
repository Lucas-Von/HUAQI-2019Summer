# coding=utf-8

# 入参：
#	1.股指目标配置金额       float


import json
import os
import re
import sys

# 出参：
#	  股指基金代码        str
#     股指基金名称         str
#     配置份额（以当前价格此次买入的数量，也可能是卖出，即负）     float
#     配置份数             int //新增项，同有可能负
#     配置成功金额       float
#     即时交易价格（记录买入价）    float
import pandas as pd
import requests


def get_fund_netvalue(code: str):
    """获取基金净值"""
    url = "http://fund.eastmoney.com/" + code + ".html"
    headers = {
        'referer': 'http://fund.eastmoney.com/' + code + '.html',
    }
    r = requests.get(url=url, headers=headers)
    r.encoding = 'UTF-8-SIG'

    matchObj = re.search(r'基金名称：</span><span class="funCur-FundName">(.*?)</span>', r.text)
    name = matchObj.group(1)
    matchObj = re.search(
        r'日增长率</th></tr><tr>  <td class="alignLeft">(.*?)</td>  <td class="alignRight bold">(.*?)</td>', r.text)
    netvalue = matchObj.group(2)
    return [code, name, netvalue]


def first_purchase(money_expected_deploy: float):
    std_pos_df = pd.read_excel(os.path.dirname(__file__) + '/标准持仓.xlsx')
    # 建立 列名--基金代码 的字典
    fundcode_dct = {'SP1200HealthCare': '000369', 'SP500信息科技': '161128', 'SP500': '050025', '标普美国品质消费股票': '162415',
                    '标普全球高端消费品': '118002', '标普生物科技精选行业': '161127', 'DAX30': '513030', '富时发达市场': '005613',
                    '恒生中国企业': '160717', '美国REIT': '000179', '纳斯达克100': '270042', '纳斯达克生物科技': '001092', '香港恒生': '164705'}
    # 标准持仓字典    code:(number, cost_price)
    std_pos_dct = {}
    for col in std_pos_df:
        code = fundcode_dct[col]
        lst = list(std_pos_df[col])
        if lst[0] != 0:  # 不统计持仓为0的
            std_pos_dct[code] = (lst[0], lst[1])

    # buy_lst
    result_lst = []
    buy_per_num_money = money_expected_deploy / 100
    for item in std_pos_dct:
        code, name, netvalue = get_fund_netvalue(item)
        netvalue = float(netvalue)
        if netvalue <= std_pos_dct[code][1]:
            num = std_pos_dct[code][0]
            share = num * buy_per_num_money / netvalue  # 购买份额
            tmp_dct = {'qdii_code': code,
                       'name': name,
                       'share_deployed': share,  # 配置份额，float
                       'number_deployed': num,  # 配置份数，int
                       'm_already_deployed': num * buy_per_num_money,
                       'price_deployed': netvalue
                       }
            result_lst.append(tmp_dct)

    # result_dct = {'result':result_lst}
    # array_json=json.dumps(result_dct)
    return result_lst


def main(jsondata):
    c = json.loads(jsondata)  # 加载json字符串为字典
    # v=list(c.values()) #取字典的值
    # try:
    print(first_purchase(c["target"]))
    return 0
    # except:
    #     return -1


if __name__ == '__main__':
    main(sys.argv[1])
