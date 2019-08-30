package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.property.QuestionnairePO;
import financial_management.parameter.property.QuestionnaireParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
