package financial_management.data.property;

import financial_management.entity.property.QuestionnaireConfigPO;
import financial_management.entity.property.QuestionnaireSetPO;
import financial_management.parameter.property.NVipQuestionnaireParam;
import financial_management.parameter.property.VipQuestionnaireParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author lt
 * @date 2019/08/17 15:02
 */
@Repository
@Mapper
public interface QuestionnaireMapper {

    /**
     * 判断用户是否已填写问卷
     *
     * @param userId
     * @return
     */
    boolean hasQuest(@Param("userId") Long userId);

    /**
     * 判断是否已完成推荐用户推荐
     *
     * @param userId
     * @return
     */
    boolean hasRecommend(@Param("userId") Long userId);

    /**
     * 插入VIP用户填写的问卷
     *
     * @param questionnaireSetPO
     * @return
     */
    void insertVipQuest(QuestionnaireSetPO questionnaireSetPO);

    /**
     * 更新VIP用户填写的问卷
     *
     * @param questionnaireSetPO
     * @return
     */
    void updateVipQuest(QuestionnaireSetPO questionnaireSetPO);

    /**
     * 插入非VIP用户填写的问卷
     *
     * @param questionnaireSetPO
     * @return
     */
    void insertNVipQuest(QuestionnaireSetPO questionnaireSetPO);

    /**
     * 更新非VIP用户填写的问卷
     *
     * @param questionnaireSetPO
     * @return
     */
    void updateNVipQuest(QuestionnaireSetPO questionnaireSetPO);

    /**
     * 获取投资偏好
     *
     * @param userId
     * @return
     */
    String getInvestPrefer(@Param("userId") Long userId);

    /**
     * 修改期望收益率
     *
     * @param userId
     * @param expectedYield
     * @return
     */
    void editExpectedYield(@Param("userId") Long userId, @Param("expectedYield") double expectedYield);

    /**
     * 获取期望收益率
     *
     * @param userId
     * @return
     */
    double getExpectedYield(@Param("userId") Long userId);

    /**
     * 获取用户推荐现金金额
     *
     * @param userId
     * @return
     */
    double getRecFundsRate(@Param("userId") Long userId);

    /**
     * 获取用户推荐储蓄金额
     *
     * @param userId
     * @return
     */
    double getRecSavingRate(@Param("userId") Long userId);

    /**
     * 获取用户推荐保险金额
     *
     * @param userId
     * @return
     */
    double getRecInsuranceRate(@Param("userId") Long userId);

    /**
     * 获取用户推荐保险金额
     *
     * @param userId
     * @return
     */
    double getRecInvestRate(@Param("userId") Long userId);

    /**
     * 获取用户推荐股票金额
     *
     * @param userId
     * @return
     */
    double getRecStocksRate(@Param("userId") Long userId);

    /**
     * 获取用户推荐股指金额
     *
     * @param userId
     * @return
     */
    double getRecQdiiRate(@Param("userId") Long userId);

    /**
     * 获取用户推荐黄金金额
     *
     * @param userId
     * @return
     */
    double getRecGoldRate(@Param("userId") Long userId);

    /**
     * 获取用户推荐债券金额
     *
     * @param userId
     * @return
     */
    double getRecBondRate(@Param("userId") Long userId);

    /**
     * 获取用户第一次填写问卷的时间
     *
     * @param userId
     * @return
     */
    Date getRecordDate(@Param("userId") Long userId);

    /**
     * 获取用户第一份问卷的资产总额
     *
     * @param userId
     * @return
     */
    Double getOriginAsset(@Param("userId") Long userId);

    /**
     * 插入用户问卷答案的分析结果
     */
    void insertQuestionnaireConfig(QuestionnaireConfigPO questionnaireConfigPO);

    /**
     * 更新用户问卷答案的分析结果
     */
    void updateQuestionnaireConfig(QuestionnaireConfigPO questionnaireConfigPO);

}