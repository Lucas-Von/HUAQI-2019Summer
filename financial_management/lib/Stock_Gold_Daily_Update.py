#股票/黄金更新
#输入：代码                 str
#输出：最新价格price        float

import json
import sys

import tushare as ts


def get_stock_price(code:str):
    df = ts.get_realtime_quotes(code)
    price = float(df['price'][0])
    return price
    
    
    
      
if __name__ == '__main__':
    jsondata = sys.argv[1]
    c=json.loads(jsondata) #加载json字符串为字典
    v=list(c.values()) #取字典的值
    price = get_stock_price(v[0])
    result = {'aFloat':price}
    json_result = json.dumps(result)
    print(json_result)