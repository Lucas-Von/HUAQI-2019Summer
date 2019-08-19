package financial_management.service.property.questionnaire;

import financial_management.bl.property.QuestionnaireService;
import financial_management.data.property.QuestionnaireMapper;
import financial_management.entity.QuestionnairePO;
import financial_management.parameter.QuestionnaireParam;
import financial_management.vo.QuestionnaireVO;
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
            QuestionnairePO questionnaire = questionnaireMapper.viewQuestById(userId);
            if(questionnaire != null){
                return ResponseVO.buildSuccess(null);
            }else{
                return ResponseVO.buildSuccess(new QuestionnaireVO());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseVO addQuestionnaire(Long userId, QuestionnaireParam questionnaireParam) {
        try {
            questionnaireMapper.insertOneQuest(userId, questionnaireParam);
            return ResponseVO.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

}
