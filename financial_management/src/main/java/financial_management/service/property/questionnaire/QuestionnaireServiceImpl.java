package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.property.QuestionnaireConfigPO;
import financial_management.entity.property.QuestionnairePO;
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
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new QuestionnairePO().getVO());
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
    public BasicResponse addQuestionnaire(QuestionnaireParam questionnaireParam) {
        try {
            Long userId = questionnaireParam.getUserId();
            boolean hasRecorded = questionnaireMapper.hasQuest(userId);
            if (!hasRecorded) {
                questionnaireMapper.insertQuest(questionnaireParam);
            } else {
                questionnaireMapper.updateQuest(questionnaireParam);
            }

            double totalAsset = estateServiceForBl.getTotalAsset(userId);
            QuestionnaireConfigPO questionnaireConfigPO = new QuestionnaireConfigPO();

            PyParam pyParam1 = new MLearningConfigParam(questionnaireParam.getFunds(), questionnaireParam.getSaving(), questionnaireParam.getInsurance(), questionnaireParam.getStocks(), questionnaireParam.getQdii(), questionnaireParam.getGold(), questionnaireParam.getBond(), questionnaireParam.getAnswer());
            List<Object> invokeResult1 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_INVEST_PREFERENCE, pyParam1, MLearningConfigResponse.class);
            List<MLearningConfigResponse> list1 = new ArrayList<>();
            for (Object object : invokeResult1) {
                list1.add((MLearningConfigResponse) object);
            }
            if (list1.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
            }
            MLearningConfigResponse MLearningConfigResponse = list1.get(0);
            questionnaireConfigPO.setUserId(userId);
            questionnaireConfigPO.setInvest_analysis_tag(MLearningConfigResponse.getInvest_analysis_tag());
            questionnaireConfigPO.setVolatility(MLearningConfigResponse.getVolatility());
            questionnaireConfigPO.setYield(MLearningConfigResponse.getYield());

            PyParam pyParam2 = new VulnerabilityConfigParam(questionnaireParam.getFunds(), questionnaireParam.getSaving(), questionnaireParam.getInsurance(), questionnaireParam.getStocks(), questionnaireParam.getQdii(), questionnaireParam.getGold(), questionnaireParam.getBond(), questionnaireParam.getAnswer(), totalAsset);
            List<Object> invokeResult2 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_VULNERABILITY, pyParam2, VulnerabilityConfigResponse.class);
            List<VulnerabilityConfigResponse> list2 = new ArrayList<>();
            for (Object object : invokeResult2) {
                list2.add((VulnerabilityConfigResponse) object);
            }
            if (list2.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
            }
            VulnerabilityConfigResponse vulnerabilityConfigResponse = list2.get(0);
            questionnaireConfigPO.setInsurance_rate(vulnerabilityConfigResponse.getInsurance() / totalAsset);
            questionnaireConfigPO.setFunds_rate(vulnerabilityConfigResponse.getFunds() / totalAsset);
            questionnaireConfigPO.setSaving_rate(vulnerabilityConfigResponse.getSaving() / totalAsset);
            questionnaireConfigPO.setInvestment_rate(vulnerabilityConfigResponse.getInvestment() / totalAsset);

            PyParam pyParam3 = new AssetConfigParam(MLearningConfigResponse.getVolatility(), MLearningConfigResponse.getYield());
            List<Object> invokeResult3 = PyInvoke.invoke(PyFunc.QUESTIONNAIRE_ASSET_ALLOCATION, pyParam3, AssetConfigResponse.class);
            List<AssetConfigResponse> list3 = new ArrayList<>();
            for (Object object : invokeResult3) {
                list3.add((AssetConfigResponse) object);
            }
            if (list3.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
            }
            AssetConfigResponse assetConfigResponse = list3.get(0);
            questionnaireConfigPO.setStocks_rate(assetConfigResponse.getStocks_rate());
            questionnaireConfigPO.setQdii_rate(assetConfigResponse.getQdii_rate());
            questionnaireConfigPO.setGold_rate(assetConfigResponse.getGold_rate());
            questionnaireConfigPO.setBond_rate(assetConfigResponse.getBond_rate());
            questionnaireConfigPO.setTotal_volatility(assetConfigResponse.getTotal_volatility());
            questionnaireConfigPO.setTotal_yield(assetConfigResponse.getTotal_yield());
            questionnaireConfigPO.setTotal_risk_level(assetConfigResponse.getTotal_risk_level());

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
     * 获取用户第一次填写问卷的时间
     *
     * @param userId
     * @return
     */
    @Override
    public Date getRecordTime(Long userId) {
        try {
            return questionnaireMapper.getRecordTime(userId);
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
    public double getOriginAssets(Long userId) {
        try {
            return questionnaireMapper.getOriginAssets(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
