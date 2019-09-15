# coding=utf-8

import json
import sys
import time

import requests
# 导入fake_useragent,伪装生成headers请求头中的User Agent值
from fake_useragent import UserAgent


class Uqer(object):

    def __init__(self):
        self.ua = UserAgent()
        self.baseurl = 'https://gw.datayes.com/mercury_trade/backtest/order/%E7%99%BD%E7%9A%AE%E4%B9%A6%E7%9A%84%E4%BE%8B%E5%AD%90.ipynb/E3382A012DB04B828B899A2C9AC3C2F7'

    # 发起一级页面请求
    def start_requests(self, url):
        login_payload = {
            'username': '19962005395',
            'password': 'Jason110228',
            'rememberMe': False,
            'app': 'cloud',
            'isSlide': True
        }
        header = {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }

        login_res = requests.post(
            url='https://app.datayes.com/server/usermaster/authenticate/v1.json', headers=header, data=login_payload)
        cookie = login_res.cookies.get_dict()

        headers = {
            "authority": "gw.datayes.com",
            "method": "GET",
            "path": "/mercury_trade/backtest/order/%E7%99%BD%E7%9A%AE%E4%B9%A6%E7%9A%84%E4%BE%8B%E5%AD%90.ipynb/E3382A012DB04B828B899A2C9AC3C2F7",
            "scheme": "https",
            "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
            "accept-encoding": "gzip, deflate, br",
            "accept-language": "zh-CN,zh;q=0.9,en;q=0.8",
            "cache-control": "max-age=0",
            "dnt": "1",
            "sec-fetch-mode": "navigate",
            "sec-fetch-site": "none",
            "sec-fetch-user": "?1",
            "upgrade-insecure-requests": "1",
            "User-Agent": self.ua.random
        }  # 随意变换headers
        r = requests.get(url, headers=headers, cookies=cookie)
        r.encoding = 'utf-8'
        return r.content

    def start(self, fromDate, isBefore: bool):
        content = self.start_requests(self.baseurl)
        # print(json.loads(content))
        obj = json.loads(content)
        orders = list(obj['fantasy_account'])
        realOrders = []
        fromDate = time.mktime(time.strptime(fromDate, "%Y-%m-%d"))

        orderss = []

        for order in orders:
            if len(list(order['order'])) != 0:
                orderss.append(order)

        for order in orderss:
            orderDate = time.mktime(time.strptime(order['date'], "%Y%m%d"))
            if (orderDate < fromDate) ^ isBefore:
                continue
            else:
                li = list(order['order'])
                for unit in li:
                    direction = int(unit['direction'])
                    retunit = {
                        'order_time': time.mktime(time.strptime(unit['order_time'], "%Y-%m-%d")),
                        'code': unit['symbol'],
                        'state_message': unit['state_message'],
                        'order_amount': direction * unit['order_amount'],
                        'complete_amount': direction * unit['filled_amount'],
                        'fee': direction * unit['commission'],
                        'price': unit['transact_price'],
                        'total': direction * unit['turnover_value'] + unit['commission']
                    }
                    # print(retunit)
                    realOrders.append(retunit)
        print(realOrders)


def main(jsonstr):
    obj = json.loads(jsonstr)
    uqer = Uqer()
    uqer.start(obj['fromDate'], obj['wantBefore'])


if __name__ == '__main__':
    main(sys.argv[1])
