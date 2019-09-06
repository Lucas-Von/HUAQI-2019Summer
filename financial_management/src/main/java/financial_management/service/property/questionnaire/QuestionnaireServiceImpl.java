package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.property.QuestionnaireConfigPO;
import financial_management.parameter.property.QuestionnaireParam;
import financial_management.service.property.estate.EstateServiceForBl;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/18 20:01
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService, QuestionnaireServiceForBl {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Autowired
    private EstateServiceForBl estateServiceForBl;

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
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_EXIST);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_NOT_EXIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
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
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new QuestionnaireVO().getQuestionList());
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 添加&更新问卷内容
     *
     * @param questionnaireParam
     * @return
     */
    @Override
    public BasicResponse setQuestionnaire(QuestionnaireParam questionnaireParam) {
        try {
            Long userId = questionnaireParam.getUserId();
            boolean hasRecorded = questionnaireMapper.hasQuest(userId);
            if (!hasRecorded) {
                questionnaireMapper.insertQuest(questionnaireParam);
            } else {
                questionnaireMapper.updateQuest(questionnaireParam);
            }

            QuestionnaireConfigPO questionnaireConfigPO = new QuestionnaireConfigPO();
            questionnaireConfigPO.setUserId(userId);

            PyParam pyParam1 = new MLearningConfigParam(questionnaireParam.getFinInfo(), questionnaireParam.getVolChose(), questionnaireParam.getStockPrefer(), questionnaireParam.getBankCard(), questionnaireParam.getCurrentDeposit(), questionnaireParam.getFixedDeposit(), questionnaireParam.getHaveFund(), questionnaireParam.getHaveBank(), questionnaireParam.getBoardWages(), questionnaireParam.getBoardWageOutside(), questionnaireParam.getMonthlySupply(), questionnaireParam.getMonthlyTraffic(), questionnaireParam.getMonthlyPhone(), questionnaireParam.getMonthlyPlay(), questionnaireParam.getLastClothes(), questionnaireParam.getLastTourist(), questionnaireParam.getMonthlyTenement(), questionnaireParam.getAsset(), questionnaireParam.getTotalIncome());
            List<Object> invokeResult1 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_INVEST_PREFERENCE, pyParam1, MLearningConfigResponse.class);
            List<MLearningConfigResponse> list1 = new ArrayList<>();
            for (Object object : invokeResult1) {
                list1.add((MLearningConfigResponse) object);
            }
            if (list1.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
            }
            MLearningConfigResponse mLearningConfigResponse = list1.get(0);
            questionnaireConfigPO.setInvest_prefer(mLearningConfigResponse.getPrefer_label());

            PyParam pyParam2 = new VulnerabilityConfigParam(questionnaireParam.getWifeInbornYear(), questionnaireParam.getHusInbornYear(), questionnaireParam.getChildNum(), questionnaireParam.getOldNum(), questionnaireParam.getHusIncome(), questionnaireParam.getWifeIncome(), questionnaireParam.getCarValue(), questionnaireParam.getLifeCost(), questionnaireParam.getAsset(), questionnaireParam.getAge(), questionnaireParam.getMarriage(), mLearningConfigResponse.getPrefer_label(), questionnaireParam.getChildBornYear());
            List<Object> invokeResult2 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_VULNERABILITY, pyParam2, VulnerabilityConfigResponse.class);
            List<VulnerabilityConfigResponse> list2 = new ArrayList<>();
            for (Object object : invokeResult2) {
                list2.add((VulnerabilityConfigResponse) object);
            }
            if (list2.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
            }
            VulnerabilityConfigResponse vulnerabilityConfigResponse = list2.get(0);
            questionnaireConfigPO.setAmount_risk(vulnerabilityConfigResponse.getAmount_risk());
            questionnaireConfigPO.setAmount_deposit(vulnerabilityConfigResponse.getAmount_deposit());
            questionnaireConfigPO.setAmount_cash(vulnerabilityConfigResponse.getAmount_cash());
            questionnaireConfigPO.setAmount_insurance(vulnerabilityConfigResponse.getAmount_insurance());
            questionnaireConfigPO.setMin_finance_fragility(vulnerabilityConfigResponse.getMin_finance_fragility());

            PyParam pyParam3 = new AssetConfigParam(-1, mLearningConfigResponse.getPrefer_label());
            if (hasRecorded) pyParam3 = new AssetConfigParam(questionnaireMapper.getExpectedYield(userId), mLearningConfigResponse.getPrefer_label());
            List<Object> invokeResult3 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_ASSET_ALLOCATION, pyParam3, AssetConfigResponse.class);
            List<AssetConfigResponse> list3 = new ArrayList<>();
            for (Object object : invokeResult3) {
                list3.add((AssetConfigResponse) object);
            }
            if (list3.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
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
            String investPrefer = questionnaireMapper.getInvestPrefer(userId);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, investPrefer);
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
            questionnaireMapper.editExpectedYield(userId, expectedYield);
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
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
            double expectedYield = questionnaireMapper.getExpectedYield(userId);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, expectedYield);
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
            return questionnaireMapper.getRecordDate(userId);
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
            return questionnaireMapper.getOriginAsset(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
