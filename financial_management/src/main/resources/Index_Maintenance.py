import datetime
import sys
import json
import demjson
import requests
import re
import pandas as pd
from bs4 import BeautifulSoup
'''
入参:product_name, str，5
fund_cash, float，3
fund_bonds, float，2
size_national, float，7
bonds_info_national, 见Daily_purchase.py，1
size_corporate, float，6
bonds_info_corporate，0
new_fund_info，4

出参：
fund_cash,
fund_bonds,
trans_record,
new_fund_info
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


'''
new_fund_info格式:
[{'product':national/corporate,'code':xxx,'proportion':xx},
{'product':national/corporate,'code':yyy,'proportion':yy},
……]
'''

'''
old_fund_info格式：
[{'product':national(str),'code':xxx(str),'proportion':xx%(float),'amount':x(float),'quantity':x(int)},
 {'product':national(str),'code':yyy(str),'proportion':yy%(float),'amount':y(float),'quantity':y(int)}
 ……]
'''
def transaction_time():
    trans_time = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    #print(trans_time)
    return trans_time

def info_confirm(product_name,size_national,bonds_info_national,size_corporate,bonds_info_corporate):
    if product_name == 'national':
        size = size_national
        old_fund_info = bonds_info_national
    # if product_name == 'corporate':
    else:
        size = size_corporate
        old_fund_info = bonds_info_corporate
    return size,old_fund_info

def fund_info_update(product_name,fund_cash,fund_bonds,size_national,bonds_info_national,size_corporate,bonds_info_corporate,new_fund_info):
    total_purchase_amount = 0
    total_commission = 0
    trans_record_total = []
    time = transaction_time()
    size,old_fund_info = info_confirm(product_name,size_national,bonds_info_national,size_corporate,bonds_info_corporate)
    old_bonds_list = []
    for bond in old_fund_info:
        list1 = list(bond.keys())
        name = list1[1]
        old_bonds_list.append(name)
    new_bonds_list = []
    for bond in new_fund_info:
        list1 = list(bond.keys())
        name = list1[0]
        new_bonds_list.append(name)   
    for bond in new_fund_info:
        price = float(bond_price(bond['code']))
        quantity = int(size*bond['proportion']/price)
        amount = quantity*price
        bond['amount'] = amount
        bond['quantity'] = quantity
        trans_record = {}
        trans_record['code'] = bond['code']
        if bond['code'] not in old_bonds_list:
            trans_record['purchase_amount'] = amount
            trans_record['purchase_quantity'] = quantity
            if amount > 0:
                sign = 1
            else:
                sign = 0
            trans_record['sign'] = sign
            trans_record['time'] = time
            trans_record_total.append(trans_record)
            commission = bond_commission(amount)
            total_purchase_amount += amount
            total_commission += commission
        if bond['code'] in old_bonds_list:
            district = old_bonds_list.index(bond['code'])
            old_amount = old_fund_info[district]['amount']
            old_quantity = old_fund_info[district]['quantity']
            purchase_amount = amount-old_amount
            purchase_quantity = quantity-old_quantity
            trans_record['purchase_amount'] = purchase_amount
            trans_record['purchase_quantity'] = purchase_quantity
            if purchase_amount > 0:
                sign = 1
            else:
                sign = 0
            trans_record['sign'] = sign
            trans_record['time'] = time            
            trans_record_total.append(trans_record)
            commission = bond_commission(purchase_amount)
            total_purchase_amount += purchase_amount
            total_commission += commission

    for name in old_bonds_list:
        if name not in new_bonds_list:
            trans_record = {}
            district = old_bonds_list.index(name)
            amount = old_fund_info[district]['amount']
            quantity = old_fund_info[district]['quantity']
            purchase_amount = -amount
            purchase_quantity = -quantity
            trans_record['purchase_amount'] = purchase_amount
            trans_record['purchase_quantity'] = purchase_quantity
            sign = 0
            trans_record['sign'] = sign
            trans_record['time'] = time            
            trans_record_total.append(trans_record)            
            commission = bond_commission(purchase_amount)
            total_purchase_amount += purchase_amount
            total_commission += commission

    fund_cash = fund_cash-total_purchase_amount-total_commission
    fund_bonds += total_purchase_amount            
    return fund_cash,fund_bonds,trans_record_total,new_fund_info

def operation(Index_Maintenance_json):
    #print(Index_Maintenance_json)
    c=json.loads(Index_Maintenance_json)
    v=list(c.values())

    return v

if __name__=='__main__':
    v = operation(sys.argv[1])#新
    # v = [[{'amount': 300000.0, 'code': '1880025', 'product': '债券4', 'proportion': 0.4, 'quantity': 13}, {'amount': 300000.0, 'code': '101751041', 'product': '债券5', 'proportion': 0.6, 'quantity': 11}], [{'amount': 100000.0, 'code': '019613', 'product': '债券1', 'proportion': 0.4, 'quantity': 14}, {'amount': 300000.0, 'code': '9802', 'product': '债券2', 'proportion': 0.35, 'quantity': 16}, {'amount': 200000.0, 'code': '019320', 'product': '债券3', 'proportion': 0.25, 'quantity': 11}], 1200000.0, 3000.0, [{'code': '019603', 'product': 'national', 'proportion': 0.1}], 'national', 60000.0, 60000.0]
    fund_cash,fund_bonds,trans_record,new_fund_info = fund_info_update(v[5],v[3],v[2],v[7],v[1],v[6],v[0],v[4])
    #更新平台交易记录
    dict0 = {'fund_cash':fund_cash,'fund_bonds':fund_bonds,'trans_record':trans_record,'new_fund_info':new_fund_info}
    array_json=json.dumps(dict0) #将字典转换为json格式字符串
    print(array_json) #输出json字符串给软件组

            
        
        
