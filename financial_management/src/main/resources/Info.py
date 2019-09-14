import datetime
import sympy
import sys
import json
import demjson
import requests
import re
import pandas as pd
'''
入参:accumulated_earning,float
banalce,float

出参:accumulated,float
balance,float
last_revenue,float
'''
def find_fund_inf(code:str):
    url = "http://fund.eastmoney.com/"+code+".html"
    headers = {
        'referer':'http://fund.eastmoney.com/'+code+'.html',
        'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36'
        }  
    r = requests.get(url = url, headers = headers)
    r.encoding = 'unicode'
    result_list = []
    comp_list= [r'<span class="fix_dwjz  bold ui-color-red">(.*?)</span>',
                r'</dt><dd class="dataNums"><span class="ui-font-middle ui-color-red ui-num">(.*?)</span>',
                r'<span class="sp01 nocolor">14日年化</span></span></p></dt><dd class="dataNums"><span class="ui-font-middle ui-color-red ui-num">(.*?)</span>',
                r'<span class="sp01">28日年化</span></p></dt><dd class="dataNums"><span class="ui-font-middle ui-color-red ui-num">(.*?)</span>',
                r'<span>近1月：</span><span class="ui-font-middle ui-color-red ui-num">(.*?)</span>',
                r'<span>近3月：</span><span class="ui-font-middle ui-color-red ui-num">(.*?)</span>',
                r'<span>成立来：</span><span class="ui-font-middle ui-color-red ui-num">(.*?)</span>']
    for patt in comp_list:
        matchObj = re.search(patt , r.text)
        result_list.append(matchObj.group(1))
    return result_list

def revenue_update(ten_thou_earning,accumulated_earning,balance):
    last_revenue = ten_thou_earning*balance
    balance += last_revenue
    accumulated_earning += last_revenue
    return balance,accumulated_earning,last_revenue

def operation(Info_json):
    #print(Info_json)
    c=json.loads(Info_json)
    v=list(c.values())
    return v
    
if __name__=='__main__':
    v = operation(sys.argv[1])#新
    fund_info = find_fund_inf('000836')
    ten_thou_earning = float(fund_info[0])
    balance,accumulated_earning,last_revenue = revenue_update(ten_thou_earning,v[0],v[1])
    info_display = {}
    info_display['seven_days_annualized_return'] = fund_info[1]
    info_display['fourteen_days_annualized_return'] = fund_info[2]
    info_display['twentyseven_days_annualized_return'] = fund_info[3]
    info_display['thirty_days_yield_rate'] = fund_info[4]
    info_display['ninety_days_yield_rate'] = fund_info[5]
    info_display['yield_rate_since_establishment'] = fund_info[6]
    dict0 = {'balance':balance,'accumulated_earning':accumulated_earning,'last_revenue':last_revenue,'info_display':info_display}#出参的字典
    array_json=json.dumps(dict0) #将字典转换为json格式字符串
    print(array_json) #输出json字符串给软件组
    
