package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.property.QuestionnaireConfigPO;
import financial_management.parameter.property.QuestionnaireParam;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.AssetConfigParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.MLearningConfigParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.VulnerabilityConfigParam;
import financial_management.util.PyInvoke.PyResponse.questionnaire.AssetConfigResponse;
import financial_management.util.PyInvoke.PyResponse.questionnaire.MLearningConfigResponse;
import financial_management.util.PyInvoke.PyResponse.questionnaire.VulnerabilityConfigResponse;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.QuestionnaireVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lt
 * @date 2019/08/18 20:01
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService, QuestionnaireServiceForBl {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    /**
     * 判断用户是否已填写问卷
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse hasQuestionnaire(Long userId) {
        try {
            boolean hasRecorded = questionnaireMapper.hasQuest(userId);
            if (hasRecorded) {
                return new BasicResponse<>(ResponseStatus.STATUS_QUESTIONNAIRE_EXIST, true);
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_QUESTIONNAIRE_NOT_EXIST, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 判断用户是否已填写问卷
     *
     * @param userId
     * @return
     */
    @Override
    public boolean hasQuest(Long userId) {
        try {
            return questionnaireMapper.hasQuest(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断是否已完成推荐用户推荐
     *
     * @param userId
     * @return
     */
    public boolean hasRecommend(Long userId) {
        try {
            return questionnaireMapper.hasRecommend(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查看空白问卷内容
     *
     * @param
     * @return
     */
    @Override
    public BasicResponse viewQuestionnaire() {
        try {
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new QuestionnaireVO());
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 增加&更新问卷
     *
     * @param questionnaireParam
     * @return
     */
    @Override
    public BasicResponse setQuestionnaire(QuestionnaireParam questionnaireParam) {
        try {
            Long userId = questionnaireParam.getUserId();
            if (!hasQuest(userId)) {
                questionnaireMapper.insertQuest(questionnaireParam);
            } else {
                questionnaireMapper.updateQuest(questionnaireParam);
            }

            QuestionnaireConfigPO questionnaireConfigPO = new QuestionnaireConfigPO();
            questionnaireConfigPO.setUserId(userId);

            PyParam pyParam1 = new MLearningConfigParam(questionnaireParam.getFinInfo(), questionnaireParam.getVolChose(), questionnaireParam.getStockPrefer(), questionnaireParam.getBankCard(), questionnaireParam.getCurrentDeposit(), questionnaireParam.getFixedDeposit(), questionnaireParam.getHaveFund(), questionnaireParam.getHaveBank(), questionnaireParam.getBoardWages(), questionnaireParam.getBoardWageOutside(), questionnaireParam.getMonthlySupply(), questionnaireParam.getMonthlyTraffic(), questionnaireParam.getMonthlyPhone(), questionnaireParam.getMonthlyPlay(), questionnaireParam.getLastClothes(), questionnaireParam.getLastTourist(), questionnaireParam.getMonthlyTenement(), questionnaireParam.getAsset(), questionnaireParam.getTotalIncome());
            List<Object> invokeResult1 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_INVEST_PREFERENCE, pyParam1, MLearningConfigResponse.class);
            List<MLearningConfigResponse> list1 = new ArrayList<>();
            for (Object object : Objects.requireNonNull(invokeResult1)) {
                list1.add((MLearningConfigResponse) object);
            }
            if (list1.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_MLEARNING_WRONG);
            }
            MLearningConfigResponse mLearningConfigResponse = list1.get(0);
            questionnaireConfigPO.setInvest_prefer(mLearningConfigResponse.getPreferLabel());

            PyParam pyParam2 = new VulnerabilityConfigParam(questionnaireParam.getWifeInbornYear(), questionnaireParam.getHusInbornYear(), questionnaireParam.getChildNum(), questionnaireParam.getOldNum(), questionnaireParam.getHusIncome(), questionnaireParam.getWifeIncome(), questionnaireParam.getCarValue(), questionnaireParam.getLifeCost(), questionnaireParam.getAsset(), questionnaireParam.getAge(), questionnaireParam.getMarriage(), mLearningConfigResponse.getPreferLabel(), Arrays.asList(questionnaireParam.getChildBornYear1(), questionnaireParam.getChildBornYear2()));
            List<Object> invokeResult2 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_VULNERABILITY, pyParam2, VulnerabilityConfigResponse.class);
            List<VulnerabilityConfigResponse> list2 = new ArrayList<>();
            for (Object object : Objects.requireNonNull(invokeResult2)) {
                list2.add((VulnerabilityConfigResponse) object);
            }
            if (list2.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_VULNERABILITY_WRONG);
            }
            VulnerabilityConfigResponse vulnerabilityConfigResponse = list2.get(0);
            questionnaireConfigPO.setFunds_rate(vulnerabilityConfigResponse.getAmount_cash() / questionnaireParam.getAsset());
            questionnaireConfigPO.setInsurance_rate(vulnerabilityConfigResponse.getAmount_insurance() / questionnaireParam.getAsset());
            questionnaireConfigPO.setSaving_rate(vulnerabilityConfigResponse.getAmount_deposit() / questionnaireParam.getAsset());
            questionnaireConfigPO.setInvest_rate(vulnerabilityConfigResponse.getAmount_risk() / questionnaireParam.getAsset());
            questionnaireConfigPO.setMin_finance_fragility(vulnerabilityConfigResponse.getMin_finance_fragility());

            PyParam pyParam3 = new AssetConfigParam(-1, mLearningConfigResponse.getPreferLabel());
            if (hasRecommend(userId)) pyParam3 = new AssetConfigParam(questionnaireMapper.getExpectedYield(userId), mLearningConfigResponse.getPreferLabel());
            List<Object> invokeResult3 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_ASSET_ALLOCATION, pyParam3, AssetConfigResponse.class);
            List<AssetConfigResponse> list3 = new ArrayList<>();
            for (Object object : Objects.requireNonNull(invokeResult3)) {
                list3.add((AssetConfigResponse) object);
            }
            if (list3.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_ASSET_WRONG);
            }
            AssetConfigResponse assetConfigResponse = list3.get(0);
            questionnaireConfigPO.setStocks_rate(assetConfigResponse.getWeight_1());
            questionnaireConfigPO.setQdii_rate(assetConfigResponse.getWeight_2());
            questionnaireConfigPO.setGold_rate(assetConfigResponse.getWeight_0());
            questionnaireConfigPO.setBond_rate(assetConfigResponse.getWeight_3());
            questionnaireConfigPO.setTotal_volatility(assetConfigResponse.getVol());
            questionnaireConfigPO.setTotal_yield(assetConfigResponse.getEarnings());
            questionnaireConfigPO.setTotal_risk_level(assetConfigResponse.getLabel());

            questionnaireMapper.insertQuestionnaireConfig(questionnaireConfigPO);

            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取投资偏好
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getInvestPrefer(Long userId) {
        try {
            if (hasQuest(userId)) {
                String investPrefer = questionnaireMapper.getInvestPrefer(userId);
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, investPrefer);
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_RECOMMEND_ALLOCATION_NOT_EXIST, "当前用户无推荐资产配置");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_NOT_EXIST);
        }
    }

    /**
     * 修改期望收益率
     *
     * @param userId
     * @param expectedYield
     * @return
     */
    @Override
    public BasicResponse editExpectedYield(Long userId, double expectedYield) {
        try {
            if (hasQuest(userId)) {
                questionnaireMapper.editExpectedYield(userId, expectedYield);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_RECOMMEND_ALLOCATION_NOT_EXIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取期望收益率
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getExpectedYield(Long userId) {
        try {
            if (hasQuest(userId)) {
                double expectedYield = questionnaireMapper.getExpectedYield(userId);
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, expectedYield);
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_RECOMMEND_ALLOCATION_NOT_EXIST, -1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_NOT_EXIST);
        }
    }

    /**
     * 获取用户第一次填写问卷的时间
     *
     * @param userId
     * @return
     */
    @Override
    public Date getRecordDate(Long userId) {
        try {
            if (questionnaireMapper.hasQuest(userId)) {
                return questionnaireMapper.getRecordDate(userId);
            } else {
                return new Date();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 获取用户第一份问卷的资产总额
     *
     * @param userId
     * @return
     */
    @Override
    public double getOriginAsset(Long userId) {
        try {
            if (hasQuest(userId)) {
                return questionnaireMapper.getOriginAsset(userId);
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
