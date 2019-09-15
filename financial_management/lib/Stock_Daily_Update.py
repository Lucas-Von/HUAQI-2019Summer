#股票日更新
#输入：代码                 str
#输出：最新价格price        float

import datetime
import sys
import json
import tushare as ts

def get_stock_price(code:str):
    today = datetime.date.today()
    date = today.strftime("%Y%m%d")
    daysago = today - datetime.timedelta(days=20)
    startdate = daysago.strftime('%Y%m%d')
    pro = ts.pro_api('4c4f8f415d01ba6b7454e55e356501d6bcc6538298e6c3e9c1c2c8cd')
    if code[0] == '6':
        code += '.SH'
    elif code[0] == '3' or code[0] == '0':
        code +='.SZ'
    df = pro.daily(ts_code=code, start_date=startdate, end_date=date)
    return float(df['close'][0])
    
      
if __name__ == '__main__':
    jsondata = sys.argv[1]
    c=json.loads(jsondata) #加载json字符串为字典
    v=list(c.values()) #取字典的值
    price = get_stock_price(v[0])
    result = {'aFloat':price}
    json_result = json.dumps(result)
    print(json_result)