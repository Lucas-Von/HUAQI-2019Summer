import datetime
import sys
import json
import demjson
import requests
import re
import pandas as pd
from bs4 import BeautifulSoup
'''
入参:fund_cash, float，5
fund_bonds, float，4
platform_accelerate_national, float，3
platform_accelerate_corporate, float，2
bonds_info_national,格式如下段注释，1
bonds_info_corporate，0

出参:fund_cash, float
fund_bonds, float
platform_accelerate_national, float
platform_accelerate_corporate, float
bonds_info_national, 格式如下段注释
bonds_info_corporate,
trans_record_national, 格式见purchase函数
trans_record_corporate,
price_list_national,
price_list_corporate
'''


'''
bonds_info_national格式：
[{'product':national(str),'code':xxx(str),'proportion':xx%(float),'amount':x(float),'quantity':x(int)},
 {'product':national(str),'code':yyy(str),'proportion':yy%(float),'amount':y(float),'quantity':y(int)}
 ……]
'''
def bond_price(code):
    #date为格式为‘2019-08-18’的字符串
    today = datetime.date.today()
    week_day = today.strftime('%w')
    if week_day == '1':
        mist = 3
    if week_day == '7':
        mist = 2
    else:
        mist = 1
    day_confirmed=today + datetime.timedelta(days=-mist)
    date = day_confirmed.strftime("%Y/%m/%d")
    url = "http://www.shclearing.com/shchapp/web/valuationclient/findvaluationdata"
    headers = {
            'referer':'http://www.shclearing.com/cpgz/zqjqysp/zqgz/',
            'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36'
            }
    parameters = {
            'startTime':date,
            'endTime':date,
            'bondNames':'',
            'bondCodes':code,
            'bondTypes':'',
            'limit':'10',
            'start':'0',
            'sortFlag':'1',
            'sortNameFlag':'1',
            'sortDateFlag':'1'
            }
    cookies = {
            'HDSESSIONID':'a4daadae-b221-42f4-b531-9c7402e44389',
            'Hm_lvt_d885bd65f967ea9372fc7200bc83fa81':'1567313496', 
            'Hm_lpvt_d885bd65f967ea9372fc7200bc83fa81':'1567316206'
            }
    #HDSESSIONID=a4daadae-b221-42f4-b531-9c7402e44389; Hm_lvt_d885bd65f967ea9372fc7200bc83fa81=1567313496; Hm_lpvt_d885bd65f967ea9372fc7200bc83fa81=1567316206
    #HDSESSIONID=c22e55c4-7b09-47e9-bf0d-0899c6a29526; Hm_lvt_d885bd65f967ea9372fc7200bc83fa81=1567313496; Hm_lpvt_d885bd65f967ea9372fc7200bc83fa81=1567316206
    r = requests.get(url = url, headers = headers, params = parameters)
    result = r.json()
    price = result['data']['datas'][0]['estimatenetprice']
    return price

def bond_commission(purchase_amount):
    commission = purchase_amount*0.0001
    return commission

def transaction_time():
    trans_time = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    #print(trans_time)
    return trans_time

def platform_purchase_national(fund_cash,fund_bonds,platform_accelerate_national,bonds_info_national):
    total_purchase = 0
    total_commission = 0
    time = transaction_time()
    trans_record_national = []
    price_list_national = []
    if platform_accelerate_national > 0:
        sign = 1
    else:
        sign = 0
    for bond in bonds_info_national:
        price = float(bond_price(bond['code']))
        purchase_quantity = int(platform_accelerate_national*bond['proportion']/price)
        purchase_amount = purchase_quantity*price
        bond['amount'] += purchase_amount
        bond['quantity'] += purchase_quantity
        total_purchase  += purchase_amount
        commission = bond_commission(purchase_amount)
        total_commission += commission
        trans_record = {}
        trans_record['code'] = bond['code']
        trans_record['purchase_amount'] = purchase_amount
        trans_record['purchase_quantity'] = purchase_quantity
        trans_record['sign'] = sign
        trans_record['time'] = time
        trans_record_national.append(trans_record)
        price_list = {}
        price_list['code'] = bond['code']
        price_list['price'] = price
        price_list_national.append(price_list)
    platform_accelerate_national = 0
    fund_cash = fund_cash-total_purchase-total_commission
    fund_bonds += total_purchase
    return fund_cash,fund_bonds,platform_accelerate_national,bonds_info_national,trans_record_national,price_list_national

def platform_purchase_corporate(fund_cash,fund_bonds,platform_accelerate_corporate,bonds_info_corporate):
    total_purchase = 0
    total_commission = 0
    time = transaction_time()
    trans_record_corporate = []
    price_list_corporate = []
    if platform_accelerate_corporate > 0:
        sign = 1
    else:
        sign = 0
    for bond in bonds_info_corporate:
        price = float(bond_price(bond['code']))
        purchase_quantity = int(platform_accelerate_corporate*bond['proportion']/price)
        purchase_amount = purchase_quantity*price
        bond['amount'] += purchase_amount
        bond['quantity'] += purchase_quantity
        total_purchase  += purchase_amount
        commission = bond_commission(purchase_amount)
        total_commission += commission
        trans_record = {}
        trans_record['code'] = bond['code']
        trans_record['purchase_amount'] = purchase_amount
        trans_record['purchase_quantity'] = purchase_quantity
        trans_record['sign'] = sign
        trans_record['time'] = time
        trans_record_corporate.append(trans_record)
        price_list = {}
        price_list['code'] = bond['code']
        price_list['price'] = price
        price_list_corporate.append(price_list)
    platform_accelerate_corporate = 0
    fund_cash = fund_cash-total_purchase-total_commission
    fund_bonds += total_purchase
    return fund_cash,fund_bonds,platform_accelerate_corporate,bonds_info_corporate,trans_record_corporate,price_list_corporate

'''
以下为个人持有份额与总份额的更新
调取所有当日个人的交易记录，输入当日单位净值
If 买/卖标志=0，个人份额变化=变化金额/当日基金单位净值
If 买/卖标志=1，个人份额变化=(变化金额-手续费)/当日基金单位净值
个人持有份额+=个人份额变化
总份额+=sum(所有用户的份额变化)

个人持有份额格式;{'id':id,'product':'国债/企业债','份额':xxx}
总份额格式:{'product':'国债/企业债','总份额':}
'''
def operation(Daily_Purchase_json):
    #print(Daily_Purchase_json)
    c=json.loads(Daily_Purchase_json)
    v=list(c.values())
    return v

if __name__=='__main__':
    v = operation(sys.argv[1])#新
    fund_cash,fund_bonds,platform_accelerate_corporate,bonds_info_corporate,trans_record_corporate,price_list_corporate = platform_purchase_corporate(v[5],v[4],v[2],v[0])
    fund_cash,fund_bonds,platform_accelerate_national,bonds_info_national,trans_record_national,price_list_national = platform_purchase_national(fund_cash,fund_bonds,v[3],v[1])
    #更新平台交易记录
    #更新持有份额与总份额
    dict0 = {'fund_cash':fund_cash,'fund_bonds':fund_bonds,'platform_accelerate_national':platform_accelerate_national,'platform_accelerate_corporate':platform_accelerate_corporate,'bonds_info_national':bonds_info_national,'bonds_info_corporate':bonds_info_corporate,'trans_record_national':trans_record_national,'trans_record_corporate':trans_record_corporate,'price_list_national':price_list_national,'price_list_corporate':price_list_corporate}
    array_json=json.dumps(dict0) #将字典转换为json格式字符串
    print(array_json) #输出json字符串给软件组
    

