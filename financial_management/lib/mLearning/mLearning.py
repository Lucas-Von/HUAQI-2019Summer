import pandas as pd
import sys
import json
import warnings
import joblib
import os


warnings.filterwarnings('ignore')
#样例：
#python mLearning.py {"""FinInfor""":2,"""volChose""":3,"""stockPrefer""":1,"""bankCard""":3,"""currentDeposit""":20000,"""fixedDeposit""":150000,"""ifFund""":2,"""ifBank""":2,"""boardWages""":5000,"""boardWageOutside""":2000,"""monthlySupply""":30,"""monthlyTraffic""":40,"""monthlyPhone""":100,"""monthlyPlay""":50,"""lastClothes""":900,"""lastTourist""":0,"""monthlyTenement""":150,"""asset""":1439698,"""total_income""":109520}
#输出：{"preferLabel": 2}
#入参：18个，见文档
#出参：preferLabel，投资偏好

def outputPrefer(parameter):
    parameter.append(parameter[0]/(parameter[3]+0.0001))
    parameter.append(parameter[0]/(parameter[8]+0.0001)*1000)
    parameter.append(parameter[1]/(parameter[15]+0.0001))

    clf = joblib.load(os.path.dirname(__file__) + '/g_model.pkl')
    p=pd.DataFrame([parameter])
    #print(p.as_matrix())
    y_pred = clf.predict_proba(p.as_matrix())
    #print(y_pred)
    y_pred[0][0] = y_pred[0][0]-0.2 #确定最低保守需要更高的置信度
    #print(y_pred)
    max_value = max(y_pred[0])
    for j in range(len(y_pred[0])):
        if max_value == y_pred[0][j]:
            return j

def resPrefer(argv_json):
    #print(argv_json)
    c=json.loads(argv_json)
    parameter=list(c.values())
    if len(parameter)!=19:
        return -1
    label=outputPrefer(parameter)+1
    label_json = json.dumps({'preferLabel':label})
    print(label_json)
    return 0

def main():
    # try:
    return resPrefer(sys.argv[1])
    # except Exception:
    #     return -1

if __name__=='__main__':
    main()

