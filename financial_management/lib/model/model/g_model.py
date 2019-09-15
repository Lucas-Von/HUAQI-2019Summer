import pandas as pd
import numpy as np
import lightgbm as lgb
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report
import matplotlib.pylab as plt
from sklearn.svm import SVC
import missingno as msno
from fancyimpute import KNN

#数据预处理部分较为复杂，未详细给出
#详细模型试验过程、调参过程代码未给出

m=pd.read_csv('origin_class.csv')

def KNNtrans(d):
    m= KNN(k=20).fit_transform(d)
    m=pd.DataFrame(m,columns=d.columns)
    return m
#d_np_corr=np.array(d.corr('spearman'))
#msno.matrix(d)
d=m
d[1:]=KNNtrans(m[1:])

'''
#构造交叉特征
# 两两相除
a = pd.Series(d['风险等级'])

for i in range(len(d.columns)):
    col_i=d.columns[i]
    if col_i == '风险等级':
        continue
    for j in range(i,len(d.columns)):
        col_j=d.columns[j]
        if col_j == '风险等级':
            continue
        new_col_name = col_i + ' ÷ ' + col_j
        tmp = d.apply(lambda x: x[col_i] / (x[col_j] + 0.0001), axis=1)
        tmp_1= d.apply(lambda x: x[col_j] / (x[col_i] + 0.0001), axis=1)
        tmp_b = pd.Series(tmp)
        tmp_b_1= pd.Series(tmp_1)
        tmp_score = a.corr(tmp_b, method='spearman')
        tmp_score_1 = a.corr(tmp_b, method='spearman')
        if tmp_score >= 0.3 or tmp_score <= -0.3:
            kkk=a.corr(d[col_i],method='spearman')
            mmm=a.corr(d[col_j],method='spearman')
            if np.abs(tmp_score)>np.abs(kkk)+0.03 and np.abs(tmp_score)>np.abs(mmm)+0.03:
                print(new_col_name + ':', tmp_score, end='')
                #print('【*****】')
                print(' ',kkk,' ',mmm)
                #file_out = open('valuable_new_2.txt', 'a')
                #print(new_col_name + ':', tmp_score, file = file_out)
                #file_out.close()
        #else:
            #print()
'''
'''
#互相相关度过高筛除
for i in range(len(d_np_corr)):
    for j in range(len(d_np_corr[i])):
        if d_np_corr[i][j]>=0.7:
            if i!=j:
                print(str(d_np_corr[i][j])+'  '+d.columns[i]+'  '+d.columns[j])
'''
'''
#目标相关度过低筛除
print(len(d_np_corr[0]))
for i in range(len(d_np_corr[0])):
    if np.abs(d_np_corr[0][i])<=0.3:
        print(str(d_np_corr[0][i])+'  '+d.columns[i]+'  '+d.columns[0])
'''

y = d['风险等级']
X = d.drop(['风险等级'], axis=1)

X_train = pd.DataFrame()
y_train = pd.DataFrame()
X_test = pd.DataFrame()
y_test = pd.DataFrame()
for i in range(5):
    d_temp = d[d['风险等级'] == i]
    y = d_temp['风险等级']
    X = d_temp.drop(['风险等级'], axis=1)
    X_train_temp, X_test_temp, y_train_temp, y_test_temp = train_test_split(X, y, test_size=0.1, random_state=12)
    X_train = pd.concat([X_train, X_train_temp], axis=0)
    y_train = pd.concat([y_train, y_train_temp], axis=0)
    # for j in range(2):
    #    if i!=0:
    #        X_train=pd.concat([X_train,X_train_temp],axis=0)
    #        y_train=pd.concat([y_train,y_train_temp],axis=0)
    X_test = pd.concat([X_test, X_test_temp], axis=0)
    y_test = pd.concat([y_test, y_test_temp], axis=0)

# X_train,X_test,y_train,y_test =train_test_split(X,y,test_size=0.3,random_state=12)
# train_X_y=pd.concat([y_train,X_train],axis=1)
# test_X_y=pd.concat([y_test,X_test],axis=1)

train_X_y=pd.concat([y_train,X_train],axis=1)
test_X_y=pd.concat([y_test,X_test],axis=1)
#train_X_y=KNNtrans(train_X_y)
train_X_y_temp=train_X_y.reset_index(drop=True)

train_X_y=train_X_y_temp[1900:].sample(frac=1,random_state=1)

test_X_y=test_X_y.sample(frac=1,random_state=1).reset_index(drop=True)

y_train=train_X_y[0]
X_train=train_X_y.drop([0],axis=1)
y_test=test_X_y[0]
X_test=test_X_y.drop([0],axis=1)

'''
#lgbmodel
lgb_train = lgb.Dataset(X_train, y_train) 
lgb_eval = lgb.Dataset(X_test, y_test, reference=lgb_train)
params = {
    'task': 'train',
    'nthread':'6',
    'boosting_type': 'gbdt',  # 设置提升类型
    #'objective': 'multiclass', # 目标函数
    'objective': 'multiclass',
    'num_leaves': 10,   # 叶子节点数
    'learning_rate': 0.01,  # 学习速率
    'max_depth':4,
    'subsample':0.8,
    'colsample_bytree':0.6,
    'max_bin':10000,
    'min_data_in_leaf':10,
    'lambda_l1':3,
    'lambda_l2': 3,
    'feature_fraction': 0.9, # 建树的特征选择比例
    #'bagging_fraction': 0.9, # 建树的样本采样比例
    #'bagging_freq': 5,  # k 意味着每 k 次迭代执行bagging
    'verbose': 1, # <0 显示致命的, =0 显示错误 (警告), >0 显示信息
    'num_class':5
}
 
print('Start training...')

gbm = lgb.train(params,lgb_train,num_boost_round=2000,valid_sets=lgb_eval,early_stopping_rounds=100,categorical_feature=[1,2])

y_true=y_test
y_pred=gbm.predict(X_test,num_iteration=793)
y=[]
for i in range(len(y_pred)):
    y_pred[i][0]=y_pred[i][0]
    y_pred[i][1]=y_pred[i][1]
    y_pred[i][3]=y_pred[i][3]
    y_pred[i][4]=y_pred[i][4]
    max_value=max(y_pred[i])
    for j in range(len(y_pred[i])):
        if max_value==y_pred[i][j]:
            y.append(j)
                
target_names = ['class 0', 'class 1', 'class 2','class 3','class 4']
print(classification_report(y_true,y,target_names = target_names ))
y_true=y_test
y_pred=gbm.predict(X_test,num_iteration=793)
y=[]
for i in range(len(y_pred)):
    y_pred[i][0]=y_pred[i][0]
    y_pred[i][1]=y_pred[i][1]
    y_pred[i][3]=y_pred[i][3]
    y_pred[i][4]=y_pred[i][4]
    max_value=max(y_pred[i])
    for j in range(len(y_pred[i])):
        if max_value==y_pred[i][j]:
            y.append(j)
                
target_names = ['class 0', 'class 1', 'class 2','class 3','class 4']
print(classification_report(y_true,y,target_names = target_names ))
'''
'''
#查验各变量在树模型分支情况
plt.rcParams['font.sans-serif'] = [u'SimHei']
plt.rcParams['figure.figsize'] = (20.0, 20.0) # 显示大小
plt.rcParams['axes.unicode_minus'] = False
plt.rcParams['figure.dpi'] = 100
lgb.plot_importance(gbm,ignore_zero=False)
#plt.savefig('./test2.jpg')
plt.show()
'''
#另外试xgb，rf，svm等等，MLP因为样本量过小放弃

#gcforest
import warnings

warnings.filterwarnings("ignore")
from gcforest.gcforest import *
import pandas as pd
from numpy import sort
import xgboost as xgb
from sklearn.metrics import roc_auc_score, accuracy_score, precision_score, recall_score, classification_report, \
    confusion_matrix
from sklearn.feature_selection import SelectFromModel
from lightgbm import LGBMClassifier


# %%
def get_toy_config():
    config = {}
    ca_config = {}
    ca_config["random_state"] = 0
    ca_config["max_layers"] = 100
    ca_config["early_stopping_rounds"] = 3
    ca_config["n_classes"] = 5
    ca_config["estimators"] = []

    ca_config["estimators"].append({"n_folds": 5, "type": 0, "n_estimators": 400, 'num_leaves': 10,
                                    'max_depth': 4,
                                    'subsample': 0.8,
                                    'colsample_bytree': 0.8,
                                    'max_bin': 10000, 'min_data_in_leaf': 10,
                                    'feature_fraction': 0.7, 'lambda_l1': 2,
                                    'lambda_l2': 2,
                                    'objective': 'multiclass', "silent": True, "nthread": -1, "learning_rate": 0.01})
    ca_config["estimators"].append(
        {"n_folds": 5, 'min_data_in_leaf': 10, 'num_leaves': 12, "type": "XGBClassifier", "n_estimators": 400,
         "max_depth": 4, "objective": "multiclass", 'num_class': 5, "silent": True, "nthread": -1,
         "learning_rate": 0.01})
    ca_config["estimators"].append(
        {"n_folds": 5, "type": "RandomForestClassifier", "n_estimators": 20, "max_depth": 4, "n_jobs": -1})
    ca_config["estimators"].append(
        {"n_folds": 5, "type": "ExtraTreesClassifier", "n_estimators": 30, "max_depth": 4, "n_jobs": -1})

    config['silent'] = True
    config["cascade"] = ca_config
    config["window"] = 16
    config["stride"] = 2
    return config


# %%
def get_Xy(csv_f):
    X = csv_f.drop(['本期内是否理赔'], axis=1)
    y = csv_f['本期内是否理赔']
    return X, y


# %%
conf = get_toy_config()
gc = GCForest(conf)  # should be a dict
X_train_enc = gc.fit_transform(X_train.as_matrix(), y_train.as_matrix())
# pre_y = gc.predict(X_test.as_matrix())

# %%
# print(classification_report(y_test, pre_y))
# prec = precision_score(test_y, pre_y)
# print("Test Precision of GcForest = {:.2f} %".format(prec * 100))

y_pred = gc.predict_proba(X_test.as_matrix())
y_true = y_test
y = []
for i in range(len(y_pred)):
    y_pred[i][0] = y_pred[i][0] - 0.2
    y_pred[i][1] = y_pred[i][1]
    y_pred[i][3] = y_pred[i][3]
    y_pred[i][4] = y_pred[i][4]
    max_value = max(y_pred[i])
    for j in range(len(y_pred[i])):
        if max_value == y_pred[i][j]:
            y.append(j)

# print(y)
# print(y_true)

target_names = ['class 0', 'class 1', 'class 2', 'class 3', 'class 4']
print(classification_report(y_true, y, target_names=target_names))

from sklearn.externals import joblib
joblib.dump(gc,'g_model.pkl')
#clf=joblib.load('filename.pkl')

clf = joblib.load('g_model.pkl')
# print(d.iloc[0,1:])
# print(len(d.iloc[0,1:]))
# print(m)
y_true = y_test
y_pred = clf.predict_proba(k.iloc[0, :].as_matrix().reshape(1, 22))
print(y_pred)
y = []
for i in range(len(y_pred)):
    y_pred[i][0] = y_pred[i][0] - 0.2
    y_pred[i][1] = y_pred[i][1]
    y_pred[i][2] = y_pred[i][2]
    y_pred[i][3] = y_pred[i][3]
    y_pred[i][4] = y_pred[i][4]
    max_value = max(y_pred[i])
    for j in range(len(y_pred[i])):
        if max_value == y_pred[i][j]:
            y.append(j)

target_names = ['class 0', 'class 1', 'class 2', 'class 3', 'class 4']
print(classification_report(y_true, y, target_names=target_names))