import datetime
import sympy
import sys
import json
import demjson
'''
入参:prop_national, float，6
prop_corporate, float，5
amount_change, float，0
platform_accelerate_national, float，4
platform_accelerate_corporate, float，3
commission_rate, 列表[1][2][3]，1
fund_cash, float，2

出参:platform_accelerate_national, float
platform_accelerate_corporate, float
amountchange_national, float
amountchange_corporate, float
sign, int
commission_amount_national, float
commission_amount_corporate, float
trans_time, data
fund_cash, float
'''

def change_in_amount(prop_national,prop_corporate,amount_change,platform_accelerate_national,platform_accelerate_corporate):
    amountchange_national = prop_national*amount_change
    amountchange_corporate = prop_corporate*amount_change
    platform_accelerate_national += amountchange_national
    platform_accelerate_corporate += amountchange_corporate
    if amount_change > 0:
        sign = 1
    else:
        sign = 0
    return platform_accelerate_national,platform_accelerate_corporate,amountchange_national,amountchange_corporate,sign

#commission_rate格式为列表
def commission(amountchange_national,amountchange_corporate,sign,commission_rate):
    if sign == 1:
        commission_amount_national = amountchange_national*commission_rate[1]
    else:
        commission_amount_national = amountchange_national*commission_rate[0]
    if sign == 1:
        commission_amount_corporate = amountchange_corporate*commission_rate[2]
    else:
        commission_amount_corporate = amountchange_corporate*commission_rate[0]  
    #print(commission_amount_national,commission_amount_corporate)
    return commission_amount_national,commission_amount_corporate
def transaction_time():
    trans_time = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    #print(trans_time)
    return trans_time
#以下要更新交易记录，今日净投入金额、累计净投入金额、最大投入金额
'''
交易记录格式为[id,"国债",amountchange_national，sign,commission_amount_national,trans_time]
              [id,"企业债",amountchange_corporate，sign,commission_amount_corporate,trans_time]
'''
#今日净投入金额、累计净投入金额、最大投入金额的更新见收益率函数

def operation(Adjustment_json):
    #print(FAdjustment_json)
    c=json.loads(Adjustment_json)
    v=list(c.values())
    # print(v)
    return v
if __name__=='__main__':
    v = operation(sys.argv[1])#新
    platform_accelerate_national,platform_accelerate_corporate,amountchange_national,amountchange_corporate,sign = change_in_amount(v[6],v[5],v[0],v[4],v[3])
    commission_amount_national,commission_amount_corporate = commission(amountchange_national,amountchange_corporate,sign,v[1])
    fund_cash = v[2]+v[0]+commission_amount_national+commission_amount_corporate
    trans_time = transaction_time()
    dict0 = {'platform_accelerate_national':platform_accelerate_national,'platform_accelerate_corporate':platform_accelerate_corporate,'amountchange_national':amountchange_national,'amountchange_corporate':amountchange_corporate,'sign':sign,'commission_amount_national':commission_amount_national,'commission_amount_corporate':commission_amount_corporate,'trans_time':trans_time,'fund_cash':fund_cash}#出参的字典
    array_json=json.dumps(dict0) #将字典转换为json格式字符串
    print(array_json) #输出json字符串给软件组
