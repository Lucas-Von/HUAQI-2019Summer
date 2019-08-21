package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.QuestionnairePO;
import financial_management.parameter.property.QuestionnaireParam;
import financial_management.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return null;
        }
    }

    /**
     * 查看空白问卷内容
     * @param
     * @return
     */
    @Override
    public ResponseVO viewQuestionnaire() {
        try {
            return ResponseVO.buildSuccess(new QuestionnairePO().getVO());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
