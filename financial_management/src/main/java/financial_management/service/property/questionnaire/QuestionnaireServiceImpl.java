package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.QuestionnairePO;
import financial_management.parameter.property.QuestionnaireParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author lt
 * @date 2019/08/18 20:01
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    /**
     * 判断用户是否已填写问卷
     * @param userId
     * @return
     */
    @Override
    public ResponseVO hasQuestionnaire(Long userId) {
        try{
            boolean hasRecorded = questionnaireMapper.hasQuest(userId);
            return ResponseVO.buildSuccess(hasRecorded);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

    /**
     * 查看空白问卷内容
     * @param
     * @return
     */
    @Override
    public BasicResponse viewQuestionnaire() {
        try {
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS, new QuestionnairePO().getVO());
//            return ResponseVO.buildSuccess(new QuestionnairePO().getVO());
        } catch (IOException e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.STATUS_PSW_WRONG, null);

        } catch (Exception e){
            return new BasicResponse(ResponseStatus.STATUS_USERNAME_WRONG, null);
        }
    }

    /**
     * 添加问卷内容
     * @param questionnaireParam
     * @return
     */
    @Override
    public ResponseVO addQuestionnaire(QuestionnaireParam questionnaireParam) {
        try {
            questionnaireMapper.insertQuest(questionnaireParam);
            return ResponseVO.buildSuccess("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

}
