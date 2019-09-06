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
    BasicResponse setQuestionnaire(QuestionnaireParam questionnaireParam);

    /**
     * 获取投资偏好
     *
     * @param userId
     * @return
     */
    BasicResponse getInvestPrefer(Long userId);

    /**
     * 修改期望收益率
     *
     * @param userId
     * @param expectedYield
     * @return
     */
    BasicResponse editExpectedYield(Long userId, double expectedYield);

    /**
     * 获取期望收益率
     *
     * @param userId
     * @return
     */
    BasicResponse getExpectedYield(Long userId);

}
