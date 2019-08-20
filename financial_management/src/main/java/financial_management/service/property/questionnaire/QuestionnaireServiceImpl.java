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

    @Override
    public ResponseVO viewQuestionnaire(Long userId) {
        try {
            boolean hasQuestionnaire = questionnaireMapper.viewQuestById(userId);
            System.out.println(hasQuestionnaire);
            if (hasQuestionnaire) {
                return ResponseVO.buildSuccess("该用户已填写问卷");
            } else {
                return ResponseVO.buildSuccess(new QuestionnairePO().getVO());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseVO addQuestionnaire(QuestionnaireParam questionnaireParam) {
        try {
            questionnaireMapper.insertOneQuest(questionnaireParam);
            return ResponseVO.buildSuccess("成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

}
