package financial_management.service.property.questionnaire;

import java.util.Date;

/**
 * @author lt
 * @date 2019/08/28 18:50
 */
public interface QuestionnaireServiceForBl {

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
