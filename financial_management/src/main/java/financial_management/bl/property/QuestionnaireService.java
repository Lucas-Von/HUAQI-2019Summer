package financial_management.bl.property;

import financial_management.parameter.property.QuestionnaireParam;
import financial_management.vo.BasicResponse;

/**
 * @author lt
 * @date 2019/08/18 18:35
 */
public interface QuestionnaireService {

    /**
     * 根据userId判断用户是否已填写问卷，若无则返回空的问卷【值皆为0】
     *
     * @param userId
     * @return
     */
    BasicResponse hasQuestionnaire(Long userId);

    /**
     * 问卷内容获取
     *
     * @param
     * @return
     */
    BasicResponse viewQuestionnaire();

    /**
     * 保存&更新问卷内容
     *
     * @param questionnaireParam
     * @return
     */
    BasicResponse addQuestionnaire(QuestionnaireParam questionnaireParam);

    /**
     * 获取投资偏好
     *
     * @param userId
     * @return
     */
    BasicResponse getInvestPrefer(Long userId);

}
