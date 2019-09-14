package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.property.QuestionnaireConfigPO;
import financial_management.entity.property.QuestionnaireSetPO;
import financial_management.parameter.property.NVipQuestionnaireParam;
import financial_management.parameter.property.VipQuestionnaireParam;
import financial_management.service.property.estate.EstateServiceForBl;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.AssetConfigParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.MLearningConfigParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.VipConfigParam;
import financial_management.util.PyInvoke.PyParam.questionnaire.VulnerabilityConfigParam;
import financial_management.util.PyInvoke.PyResponse.questionnaire.AssetConfigResponse;
import financial_management.util.PyInvoke.PyResponse.questionnaire.MLearningConfigResponse;
import financial_management.util.PyInvoke.PyResponse.questionnaire.VipConfigResponse;
import financial_management.util.PyInvoke.PyResponse.questionnaire.VulnerabilityConfigResponse;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.QuestionnaireVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
            return new BasicResponse<>(ResponseStatus.STATUS_QUESTIONNAIRE_EXIST, hasQuest(userId));
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
     * 增加&更新VIP用户的问卷
     *
     * @param userId
     * @param vipQuestionnaireParam
     * @return
     */
    @Override
    public BasicResponse setVipQuestionnaire(Long userId, VipQuestionnaireParam vipQuestionnaireParam) {
        try {
            QuestionnaireSetPO questionnaireSetPO = new QuestionnaireSetPO(userId, new Date(), vipQuestionnaireParam.getFinInfo(), vipQuestionnaireParam.getVolChose(), vipQuestionnaireParam.getStockPrefer(), vipQuestionnaireParam.getBankCard(), vipQuestionnaireParam.getCurrentDeposit(), vipQuestionnaireParam.getFixedDeposit(), vipQuestionnaireParam.getHaveFund(), vipQuestionnaireParam.getHaveBank(), vipQuestionnaireParam.getBoardWages(), vipQuestionnaireParam.getBoardWageOutside(), vipQuestionnaireParam.getMonthlySupply(), vipQuestionnaireParam.getMonthlyTraffic(), vipQuestionnaireParam.getMonthlyPhone(), vipQuestionnaireParam.getMonthlyPlay(), vipQuestionnaireParam.getLastClothes(), vipQuestionnaireParam.getLastTourist(), vipQuestionnaireParam.getMonthlyTenement(), vipQuestionnaireParam.getAsset(), vipQuestionnaireParam.getTotalIncome(), vipQuestionnaireParam.getWifeInbornYear(), vipQuestionnaireParam.getHusInbornYear(), vipQuestionnaireParam.getChildNum(), vipQuestionnaireParam.getOldNum(), vipQuestionnaireParam.getHusIncome(), vipQuestionnaireParam.getWifeIncome(), vipQuestionnaireParam.getCarValue(), vipQuestionnaireParam.getLifeCost(), vipQuestionnaireParam.getAge(), vipQuestionnaireParam.getMarriage(), vipQuestionnaireParam.getChildBornYear(), vipQuestionnaireParam.getVipLevel(), 0, 0, 0, 0, 0, 0);
            if (hasQuest(userId)) {
                questionnaireMapper.updateVipQuest(questionnaireSetPO);
            } else {
                questionnaireMapper.insertVipQuest(questionnaireSetPO);
            }

            QuestionnaireConfigPO questionnaireConfigPO = new QuestionnaireConfigPO();
            questionnaireConfigPO.setUserId(userId);
            questionnaireConfigPO.setVip_level(vipQuestionnaireParam.getVipLevel());

            PyParam pyParam1 = new MLearningConfigParam(vipQuestionnaireParam.getFinInfo(), vipQuestionnaireParam.getVolChose(), vipQuestionnaireParam.getStockPrefer(), vipQuestionnaireParam.getBankCard(), vipQuestionnaireParam.getCurrentDeposit(), vipQuestionnaireParam.getFixedDeposit(), vipQuestionnaireParam.getHaveFund(), vipQuestionnaireParam.getHaveBank(), vipQuestionnaireParam.getBoardWages(), vipQuestionnaireParam.getBoardWageOutside(), vipQuestionnaireParam.getMonthlySupply(), vipQuestionnaireParam.getMonthlyTraffic(), vipQuestionnaireParam.getMonthlyPhone(), vipQuestionnaireParam.getMonthlyPlay(), vipQuestionnaireParam.getLastClothes(), vipQuestionnaireParam.getLastTourist(), vipQuestionnaireParam.getMonthlyTenement(), vipQuestionnaireParam.getAsset(), vipQuestionnaireParam.getTotalIncome());
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

            String[] childrenBornYears = vipQuestionnaireParam.getChildBornYear().split("&");
            PyParam pyParam2 = new VulnerabilityConfigParam(vipQuestionnaireParam.getWifeInbornYear(), vipQuestionnaireParam.getHusInbornYear(), vipQuestionnaireParam.getChildNum(), vipQuestionnaireParam.getOldNum(), vipQuestionnaireParam.getHusIncome(), vipQuestionnaireParam.getWifeIncome(), vipQuestionnaireParam.getCarValue(), vipQuestionnaireParam.getLifeCost(), vipQuestionnaireParam.getAsset(), vipQuestionnaireParam.getAge(), vipQuestionnaireParam.getMarriage(), mLearningConfigResponse.getPreferLabel(), Arrays.asList(childrenBornYears).stream().map(Integer::parseInt).collect(Collectors.toList()));
            List<Object> invokeResult2 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_VULNERABILITY, pyParam2, VulnerabilityConfigResponse.class);
            List<VulnerabilityConfigResponse> list2 = new ArrayList<>();
            for (Object object : Objects.requireNonNull(invokeResult2)) {
                list2.add((VulnerabilityConfigResponse) object);
            }
            if (list2.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_VULNERABILITY_WRONG);
            }
            VulnerabilityConfigResponse vulnerabilityConfigResponse = list2.get(0);
            questionnaireConfigPO.setFunds_rate(vulnerabilityConfigResponse.getAmount_cash() / vipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setInsurance_rate(vulnerabilityConfigResponse.getAmount_insurance() / vipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setSaving_rate(vulnerabilityConfigResponse.getAmount_deposit() / vipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setInvest_rate(vulnerabilityConfigResponse.getAmount_risk() / vipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setMin_finance_fragility(vulnerabilityConfigResponse.getMin_finance_fragility());

            PyParam pyParam3 = new AssetConfigParam(-1, mLearningConfigResponse.getPreferLabel());
            if (hasRecommend(userId))
                pyParam3 = new AssetConfigParam(questionnaireMapper.getExpectedYield(userId), mLearningConfigResponse.getPreferLabel());
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

            if (hasRecommend(userId)) {
                questionnaireMapper.updateQuestionnaireConfig(questionnaireConfigPO);
            } else {
                questionnaireMapper.insertQuestionnaireConfig(questionnaireConfigPO);
            }

            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 增加&更新非VIP用户的问卷
     *
     * @param userId
     * @param nVipQuestionnaireParam
     * @return
     */
    @Override
    public BasicResponse setNVipQuestionnaire(Long userId, NVipQuestionnaireParam nVipQuestionnaireParam) {
        try {
            QuestionnaireSetPO questionnaireSetPO = new QuestionnaireSetPO(userId, new Date(), nVipQuestionnaireParam.getFinInfo(), nVipQuestionnaireParam.getVolChose(), nVipQuestionnaireParam.getStockPrefer(), nVipQuestionnaireParam.getBankCard(), nVipQuestionnaireParam.getCurrentDeposit(), nVipQuestionnaireParam.getFixedDeposit(), nVipQuestionnaireParam.getHaveFund(), nVipQuestionnaireParam.getHaveBank(), nVipQuestionnaireParam.getBoardWages(), nVipQuestionnaireParam.getBoardWageOutside(), nVipQuestionnaireParam.getMonthlySupply(), nVipQuestionnaireParam.getMonthlyTraffic(), nVipQuestionnaireParam.getMonthlyPhone(), nVipQuestionnaireParam.getMonthlyPlay(), nVipQuestionnaireParam.getLastClothes(), nVipQuestionnaireParam.getLastTourist(), nVipQuestionnaireParam.getMonthlyTenement(), nVipQuestionnaireParam.getAsset(), nVipQuestionnaireParam.getTotalIncome(), nVipQuestionnaireParam.getWifeInbornYear(), nVipQuestionnaireParam.getHusInbornYear(), nVipQuestionnaireParam.getChildNum(), nVipQuestionnaireParam.getOldNum(), nVipQuestionnaireParam.getHusIncome(), nVipQuestionnaireParam.getWifeIncome(), nVipQuestionnaireParam.getCarValue(), nVipQuestionnaireParam.getLifeCost(), nVipQuestionnaireParam.getAge(), nVipQuestionnaireParam.getMarriage(), nVipQuestionnaireParam.getChildBornYear(), 0, nVipQuestionnaireParam.getUnpaidArrears(), nVipQuestionnaireParam.getPreviousArrearsDue(), nVipQuestionnaireParam.getLineOfCredit(), nVipQuestionnaireParam.getCashAdvance(), nVipQuestionnaireParam.getLastPayment(), nVipQuestionnaireParam.getMinimumDuePayment());
            if (hasQuest(userId)) {
                questionnaireMapper.updateNVipQuest(questionnaireSetPO);
            } else {
                questionnaireMapper.insertNVipQuest(questionnaireSetPO);
            }

            QuestionnaireConfigPO questionnaireConfigPO = new QuestionnaireConfigPO();
            questionnaireConfigPO.setUserId(userId);

            PyParam pyParam1 = new MLearningConfigParam(nVipQuestionnaireParam.getFinInfo(), nVipQuestionnaireParam.getVolChose(), nVipQuestionnaireParam.getStockPrefer(), nVipQuestionnaireParam.getBankCard(), nVipQuestionnaireParam.getCurrentDeposit(), nVipQuestionnaireParam.getFixedDeposit(), nVipQuestionnaireParam.getHaveFund(), nVipQuestionnaireParam.getHaveBank(), nVipQuestionnaireParam.getBoardWages(), nVipQuestionnaireParam.getBoardWageOutside(), nVipQuestionnaireParam.getMonthlySupply(), nVipQuestionnaireParam.getMonthlyTraffic(), nVipQuestionnaireParam.getMonthlyPhone(), nVipQuestionnaireParam.getMonthlyPlay(), nVipQuestionnaireParam.getLastClothes(), nVipQuestionnaireParam.getLastTourist(), nVipQuestionnaireParam.getMonthlyTenement(), nVipQuestionnaireParam.getAsset(), nVipQuestionnaireParam.getTotalIncome());
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

            String[] childrenBornYears = nVipQuestionnaireParam.getChildBornYear().split("&");
            PyParam pyParam2 = new VulnerabilityConfigParam(nVipQuestionnaireParam.getWifeInbornYear(), nVipQuestionnaireParam.getHusInbornYear(), nVipQuestionnaireParam.getChildNum(), nVipQuestionnaireParam.getOldNum(), nVipQuestionnaireParam.getHusIncome(), nVipQuestionnaireParam.getWifeIncome(), nVipQuestionnaireParam.getCarValue(), nVipQuestionnaireParam.getLifeCost(), nVipQuestionnaireParam.getAsset(), nVipQuestionnaireParam.getAge(), nVipQuestionnaireParam.getMarriage(), mLearningConfigResponse.getPreferLabel(), Arrays.asList(childrenBornYears).stream().map(Integer::parseInt).collect(Collectors.toList()));
            List<Object> invokeResult2 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_VULNERABILITY, pyParam2, VulnerabilityConfigResponse.class);
            List<VulnerabilityConfigResponse> list2 = new ArrayList<>();
            for (Object object : Objects.requireNonNull(invokeResult2)) {
                list2.add((VulnerabilityConfigResponse) object);
            }
            if (list2.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_VULNERABILITY_WRONG);
            }
            VulnerabilityConfigResponse vulnerabilityConfigResponse = list2.get(0);
            questionnaireConfigPO.setFunds_rate(vulnerabilityConfigResponse.getAmount_cash() / nVipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setInsurance_rate(vulnerabilityConfigResponse.getAmount_insurance() / nVipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setSaving_rate(vulnerabilityConfigResponse.getAmount_deposit() / nVipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setInvest_rate(vulnerabilityConfigResponse.getAmount_risk() / nVipQuestionnaireParam.getAsset());
            questionnaireConfigPO.setMin_finance_fragility(vulnerabilityConfigResponse.getMin_finance_fragility());

            PyParam pyParam3 = new AssetConfigParam(-1, mLearningConfigResponse.getPreferLabel());
            if (hasRecommend(userId))
                pyParam3 = new AssetConfigParam(questionnaireMapper.getExpectedYield(userId), mLearningConfigResponse.getPreferLabel());
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

            PyParam pyParam4 = new VipConfigParam(nVipQuestionnaireParam.getUnpaidArrears(), nVipQuestionnaireParam.getPreviousArrearsDue(), nVipQuestionnaireParam.getLineOfCredit(), nVipQuestionnaireParam.getCashAdvance(), nVipQuestionnaireParam.getLastPayment(), nVipQuestionnaireParam.getMinimumDuePayment(), nVipQuestionnaireParam.getFixedDeposit());
            List<Object> invokeResult4 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_VIP_LEVEL, pyParam4, VipConfigResponse.class);
            List<VipConfigResponse> list4 = new ArrayList<>();
            for (Object object : Objects.requireNonNull(invokeResult4)) {
                list4.add((VipConfigResponse) object);
            }
            if (list4.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_VIP_WRONG);
            }
            VipConfigResponse vipConfigResponse = list4.get(0);
            questionnaireConfigPO.setVip_level(vipConfigResponse.getVip_level());

            if (hasRecommend(userId)) {
                questionnaireMapper.updateQuestionnaireConfig(questionnaireConfigPO);
            } else {
                questionnaireMapper.insertQuestionnaireConfig(questionnaireConfigPO);
            }

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
     * 获取用户推荐现金金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecFunds(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecFundsRate(userId) * estateServiceForBl.getTotalAsset(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取用户推荐储蓄金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecSaving(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecSavingRate(userId) * estateServiceForBl.getTotalAsset(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取用户推荐保险金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecInsurance(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecInsuranceRate(userId) * estateServiceForBl.getTotalAsset(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取用户推荐投资金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecInvest(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecInvestRate(userId) * estateServiceForBl.getTotalAsset(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取用户推荐股票金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecStocks(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecStocksRate(userId) * getRecInvest(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取用户推荐股指金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecQdii(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecQdiiRate(userId) * getRecInvest(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取用户推荐黄金金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecGold(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecGoldRate(userId) * getRecInvest(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取用户推荐债券金额
     *
     * @param userId
     * @return
     */
    @Override
    public double getRecBond(Long userId) {
        try {
            if (hasRecommend(userId)) {
                return questionnaireMapper.getRecBondRate(userId) * getRecInvest(userId);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
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