#coding=utf8
# 输入：问题    str
# 输出：匹配问题


import json
import sys
import jieba

path = '客服问答.txt'
textlst = open(path, 'r', encoding='utf8').read().split('\n')


class Question:
    def __init__(self):
        self.ques = ''
        self.ans = ''
        self.score = 0

    def show(self):
        print(self.ques, self.ans, self.score)


def question_matching(input_ques: str):
    # input_ques = '股指基金都有哪些种类'
    add_word_lst = ['股指基金', '调仓', '债券基金', '重疾', '重疾险', '年化']
    for word in add_word_lst:
        jieba.add_word(word)

    # 导入问题和回答列表
    QuesLst = []
    i = 0
    tmp = Question()
    while i < len(textlst):
        if textlst[i] == '':
            if tmp.ques != '':
                QuesLst.append(tmp)
            tmp = Question()
            i += 1
            if i >= len(textlst):
                break
            tmp.ques = textlst[i]
            i += 1
        else:
            tmp.ans += textlst[i]
            i += 1

    # 根据匹配数统计得分
    input_wordlist = jieba.cut_for_search(input_ques, HMM=False)
    for inputword in input_wordlist:
        for Q in QuesLst:
            if inputword in Q.ques:
                Q.score += 1

    # 确定结果
    lst = sorted(QuesLst, key=lambda x: x.score, reverse=True)
    result_lst = []
    for item in lst:
        if len(result_lst) == 5:
            break
        result_lst.append(item)

    result = []
    for item in result_lst:
        dct0 = {'q': item.ques, 'a': item.ans}
        if item.ques == input_ques:
            result = [dct0]
            print(json.dumps(result))
            return
        result.append(dct0)

    json_array = json.dumps(result)
    print(json_array)


if __name__ == '__main__':
    # c = json.loads(json.dumps({'q': '股票'}))
    c = json.loads(sys.argv[1])
    v = list(c.values())
    question_matching(v[0])
