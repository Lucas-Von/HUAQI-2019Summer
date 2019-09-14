package financial_management.bl.property;

import financial_management.parameter.property.NVipQuestionnaireParam;
import financial_management.parameter.property.VipQuestionnaireParam;
import financial_management.vo.BasicResponse;

/**
 * @author lt
 * @date 2019/08/18 18:35
 */
public interface QuestionnaireService {

    /**
     * 判断用户是否已填写问卷
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
     * 增加&更新VIP用户的问卷
     *
     * @param vipQuestionnaireParam
     * @return
     */
    BasicResponse setVipQuestionnaire(VipQuestionnaireParam vipQuestionnaireParam);

    /**
     * 增加&更新非VIP用户的问卷
     *
     * @param nVipQuestionnaireParam
     * @return
     */
    BasicResponse setNVipQuestionnaire(NVipQuestionnaireParam nVipQuestionnaireParam);

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
