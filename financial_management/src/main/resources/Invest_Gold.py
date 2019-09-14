from datetime import datetime
import tushare as ts
import sys
import json
import demjson

#入参：3个（按序）
#     已配置黄金ETF份额数           int
#     在黄金资产中未配置金额diff(因为份额应该为整数，故会有不满一份额的金额留下）      float
#     期望配置金额（即期望配置到多少金额）        float

#dict0 = {'account_already_deployed': 1, 'diff_already_deployed': 2,'money_expected_deployed': 3}

#出参:5个（按序）
#     即时配置价格（也是当前价格，可以根据这个进行一些计算）       float
#     即时配置数量（以当前价格此次配置入的数量，也可能是配置出，即负）      int
#     即时配置成功金额(即去除掉未满一份黄金ETF金额的diff项）       float
#     所有配置数量（加上之前的黄金ETF配置数量）        int
#     更新后的diff项         float

# 给出配置金额的黄金配置函数
def deploy_goldETF(money_to_deployed):
    m_deployed = float(money_to_deployed)
    df = ts.get_realtime_quotes('518880')
    price_deployed = float('%0.3f' % df['price'])
    account_deployed = int(m_deployed / price_deployed)
    m_already_deployed = float('%0.3f' % (account_deployed * price_deployed))
    diff_deployed = float('%0.3f' % (m_deployed - m_already_deployed))

    #print((price_deployed, account_deployed, m_already_deployed, diff_deployed, nowtime))
    return price_deployed, account_deployed, m_already_deployed, diff_deployed


# 给出当前已配置黄金总份额，已配置黄金总金额，预期配置总金额
#输入为 已配置黄金ETF份额数，在黄金资产中未配置金额diff(因为份额应该为整数，故会有不满一份额的金额留下），期望配置金额
def deploy_all_goldETF(account_already_deployed,
                       diff_already_deployed, money_expected_deployed):
    #str转float
    money_expected_deployed = float(money_expected_deployed)
    diff_already_deployed = float(diff_already_deployed)
    account_already_deployed=int(account_already_deployed)

    #输入项皆为正数
    if account_already_deployed < 0 or diff_already_deployed < 0 or money_expected_deployed < 0:
        return -1

    #获取即时情况
    df = ts.get_realtime_quotes('518880')
    #即时价格，即买入价格
    price_deployed = float('%0.3f' % df['price'])

    # 已配置总金额，分为曾经配置时的入价（应当分别计在列表内，可以考虑算总体），而这里是现在这些份额黄金的价值
    money_already_deployed = account_already_deployed * price_deployed
    #需要额外进行配置的金额数量，即需买入或卖出数量
    m_deployed = float('%0.3f' % (money_expected_deployed - money_already_deployed))

    #即时配置将达的份额
    account_deployed = int(m_deployed / price_deployed )
    #即时配置将配置成功的金额（本次配置）
    money_deployed = float('%0.3f' % (account_deployed * price_deployed))
    #新的diff，即不满一份黄金ETF的留存金额
    diff_all_deployed = float('%0.3f' % (m_deployed - money_deployed))
    #即时时间
    nowtime = datetime.now().strftime('%Y-%m-%d %H:%M:%S')

    #合计总配置黄金ETF份额
    account_all_deployed = account_deployed + account_already_deployed
    #合计总配置黄金ETF金额
    money_all_deployed = money_expected_deployed -diff_all_deployed

    dict0={'price2deploy':price_deployed,
           'account2deployed':account_deployed,
          'money2deployed':money_deployed,
           'accounet_all_deployed':account_all_deployed,
           'money_all_deployed':money_all_deployed,
           'diff_all_deployed':diff_all_deployed}
    array_json=json.dumps(dict0)

    print(array_json)
    return 0

def deploy_all_goldETF_json(gold_json):
    # print(gold_json)
    c=json.loads(gold_json)
    v=list(c.values())
    return deploy_all_goldETF( v[0],v[1],v[2])

if __name__=='__main__':
    #deploy_all_goldETF(sys.argv[1],sys.argv[2],sys.argv[3])
    deploy_all_goldETF_json(sys.argv[1])