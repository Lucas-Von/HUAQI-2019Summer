package financial_management.bl.property;

import financial_management.parameter.QuestionnaireParam;
import financial_management.vo.ResponseVO;

/**
 * @author lt
 * @date 2019/08/18 18:35
 */
public interface QuestionnaireService {

    /**
     * 判断用户是否已填写问卷【是否弹出问卷】&问卷内容获取
     * @param userId
     * @return
     */
    ResponseVO viewQuestionnaire(Long userId);

    /**
     * 保存问卷内容
     * @param userId
     * @param questionnaireParam
     * @return
     */
    ResponseVO addQuestionnaire(Long userId, QuestionnaireParam questionnaireParam);

}
