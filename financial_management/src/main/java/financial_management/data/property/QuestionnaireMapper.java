package financial_management.data.property;

import financial_management.parameter.property.QuestionnaireParam;
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
     * 根据userId判断用户是否已填写问卷，若无则返回空的问卷【值皆为0】
     *
     * @param userId
     * @return
     */
    boolean hasQuest(@Param("userId") Long userId);

    /**
     * 插入用户填写的问卷
     *
     * @param questionnaireParam
     * @return
     */
    void insertQuest(QuestionnaireParam questionnaireParam);

    /**
     * 更新用户填写的问卷
     *
     * @param questionnaireParam
     * @return
     */
    void updateQuest(QuestionnaireParam questionnaireParam);

    /**
     * 获取投资偏好
     *
     * @param userId
     * @return
     */
    String getInvestPrefer(@Param("userId") Long userId);

    /**
     * 获取用户第一次填写问卷的时间
     *
     * @param userId
     * @return
     */
    Date getRecordTime(@Param("userId") Long userId);

    /**
     * 获取用户第一份问卷的资产总额
     *
     * @param userId
     * @return
     */
    Double getOriginAssets(@Param("userId") Long userId);

}
