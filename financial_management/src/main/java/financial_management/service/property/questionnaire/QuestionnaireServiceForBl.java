package financial_management.service.property.questionnaire;

import java.util.Date;

/**
 * @author lt
 * @date 2019/08/28 18:50
 */
public interface QuestionnaireServiceForBl {

    /**
     * 判断用户是否已填写问卷
     *
     * @param userId
     * @return
     */
    boolean hasQuest(Long userId);

    /**
     * 获取用户推荐现金金额
     *
     * @param userId
     * @return
     */
    double getRecFunds(Long userId);

    /**
     * 获取用户推荐储蓄金额
     *
     * @param userId
     * @return
     */
    double getRecSaving(Long userId);

    /**
     * 获取用户推荐保险金额
     *
     * @param userId
     * @return
     */
    double getRecInsurance(Long userId);

    /**
     * 获取用户推荐投资金额
     *
     * @param userId
     * @return
     */
    double getRecInvest(Long userId);

    /**
     * 获取用户推荐股票金额
     *
     * @param userId
     * @return
     */
    double getRecStocks(Long userId);

    /**
     * 获取用户推荐股指金额
     *
     * @param userId
     * @return
     */
    double getRecQdii(Long userId);

    /**
     * 获取用户推荐黄金金额
     *
     * @param userId
     * @return
     */
    double getRecGold(Long userId);

    /**
     * 获取用户推荐债券金额
     *
     * @param userId
     * @return
     */
    double getRecBond(Long userId);

    /**
     * 获取用户第一次填写问卷的时间
     *
     * @param userId
     * @return
     */
    Date getRecordDate(Long userId);

    /**
     * 获取用户第一份问卷的资产总额
     *
     * @param userId
     * @return
     */
    double getOriginAsset(Long userId);

}