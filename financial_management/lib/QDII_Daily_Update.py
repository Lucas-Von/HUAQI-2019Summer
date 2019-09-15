# 股指日更新
# 输入：代码                 str
# 输出：最新价格price        float

import requests
import re
import sys
import json


def get_fund_netvalue(code: str):
    '''获取基金净值'''
    url = "http://fund.eastmoney.com/" + code + ".html"
    headers = {
        'referer': 'http://fund.eastmoney.com/' + code + '.html',
    }
    r = requests.get(url=url, headers=headers)
    r.encoding = 'unicode'

    matchObj = re.search(
        r'日增长率</th></tr><tr>  <td class="alignLeft">(.*?)</td>  <td class="alignRight bold">(.*?)</td>', r.text)
    netvalue = matchObj.group(2)
    return netvalue


if __name__ == '__main__':
    jsondata = sys.argv[1]
    c = json.loads(jsondata)  # 加载json字符串为字典
    v = list(c.values())  # 取字典的值
    price = get_fund_netvalue(v[0])
    result = {'aFloat': price}
    json_result = json.dumps(result)
    print(json_result)
