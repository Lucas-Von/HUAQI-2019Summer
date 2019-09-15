import numpy as np
from pulp import *
import pandas as pd
from scipy.optimize import minimize
import sys
import json
import os

#入参：2个（按序）
#       波动率要求等级   int 1,2,3,4,5
#       收益率要求       double  e.g.0.03

#出参:6个（按序）
#     黄金部分投资权重      weight_0      double
#     股票部分投资权重      weight_1      double
#     股指部分投资权重      weight_2      double
#     债券部分投资权重      weight_3      double
#     投资组合整体波动率    vol           double
#     投资组合整体收益率    earnings      double
#     投资组合风险等级      label         int

#实例：python asset.py {"""earnings""":-1,"""vol""":5}
#print:{"weight_0": 0.060523084783344804, "weight_1": 0.0011233158958028823, "weight_2": 0.40157033342962745, "weight_3": 0.536783265891225,
#           "earnings": 0.06326398497217041, "vol": 0.3162277660176906, "label":5}



#U为收益率矩阵(2-D)   #多个资产的收益向量构成
def w_expection(U):
    #w=[0]*len(U[0])
    #for i in U:
    #    w[i]=np.sum(i)/len(i)
    w=[]
    for i in U.columns:
        w.append(1)
    n=0
    #for i in range(len(U.columns)):
    for i in U.columns:
        w[n]=np.sum(U[i])/len(U[i])*12
        #w[n]=U.iloc[-1,i]-1
        n=n+1
    return w

#此处的std使用的是无偏估计
#单资产波动率（输出数值）
#u为单资产日收益率（向量）
def volatility(u): 
    return np.var(u)
#*np.sqrt(len(u))

#单资产波动率（输出向量）
#u为单资产日收益率（矩阵，以年份为列标签，一年为一个向量，或不均衡）
#这个u可能是需要先转换改造出的
def volatility2(u):
    res=[]
    for i in u.columns:
        res.append(volatility(u[i])*12)
    return res
    #return list(volatility(i) for i in u)


#U为2-D资产收益矩阵
def covMatrix(U):
    lenth=len(U.columns)
    res=np.zeros(lenth*lenth).reshape(lenth,lenth)
    col=volatility2(U)
    for i in range(lenth):
        for j in range(lenth):
            res[i][j]=np.correlate(U.iloc[:,i],U.iloc[:,j])*col[i]*col[j]
    return res

#def func(x):
    #for 

def minimizeDR(U,label,earnings):
    V=covMatrix(U)
    seigema_day=np.array(volatility2(U)) 
    w_exp=w_expection(U)
    fun=lambda x:-(np.dot(x,seigema_day))/np.sqrt(np.dot(np.dot(np.transpose(x),V),x))

    vol_0,vol_1=0,0
    if label==1:
        vol_0,vol_1=0,0.01    
    elif label==2:
        vol_0,vol_1=0.01,0.023
    elif label==3:
        vol_0,vol_1=0.023,0.034
    elif label==4:
        vol_0,vol_1=0.034,0.067
    #elif var<
    elif label==5:
        vol_0,vol_1=0.067,1

    cons=({'type':'eq','fun':lambda x:x[1]+x[2]+x[0]+x[3]-1})
    if earnings!=-1 and label==-1:
        cons=({'type':'eq','fun':lambda x:x[1]+x[2]+x[0]+x[3]-1},
              {'type':'ineq','fun':lambda x:np.dot(x,w_exp)-earnings}
              )
    elif earnings==-1 and label!=-1:
        cons=({'type':'eq','fun':lambda x:x[1]+x[2]+x[0]+x[3]-1},
              {'type':'ineq','fun':lambda x:np.dot(x,seigema_day)-vol_0},
              {'type':'ineq','fun':lambda x:vol_1-np.dot(x,seigema_day)}
              )
    elif earnings!=-1 and label!=-1:
        cons=({'type':'eq','fun':lambda x:x[1]+x[2]+x[0]+x[3]-1},
              {'type':'ineq','fun':lambda x:np.dot(x,w_exp)-earnings},
              {'type':'ineq','fun':lambda x:np.dot(x,seigema_day)-vol_0},
              {'type':'ineq','fun':lambda x:vol_1-np.dot(x,seigema_day)}
              )

    bnds = ((0.05, 0.25),( 0.1, 1), (0.05, 0.3), (0.05, 1))

    x0=np.asarray((0.1,0.5,0.1,0.3))
    res = minimize(fun, x0, method='SLSQP',constraints=cons,bounds=bnds)
    res_vol=np.dot(res.x,seigema_day)
    res_expection=np.dot(res.x,w_exp)
    #print(res)
    #print(res_vol)
    #print(res_expection)
    return res,res_expection,res_vol

def getResult(datapath,ev_json):
    c=json.loads(ev_json)
    v=list(c.values())
    U=pd.read_csv(datapath)

    #res引出权重，res_exp是收益率，res_vol是风险
    res,res_expection,res_vol=minimizeDR(U,v[0],v[1])

    var=res_vol
    label=0
    if var<0.01:
        label=1
    elif var<0.0229:
        label=2
    elif var<0.0339:
        label=3
    elif var<0.055:
        label=4
    #elif var<
    else:
        label=5

    if res.success==True:
        k=np.array(res.x)
        array_json=json.dumps({'weight_0':k[0],'weight_1':k[1],'weight_2':k[2],'weight_3':k[3],
                               'vol':var,'earnings':res_expection,'label':label})
        print(array_json)
        #return array_json

    if res.success==False:
        return -1


def main():
    datapath = os.path.dirname(__file__) + '/asset_matrix.csv'
    #try
    return getResult(datapath,sys.argv[1])
    #except Exception:
     #   print("Exception")
     #   return -1

if __name__ == '__main__':
    main()