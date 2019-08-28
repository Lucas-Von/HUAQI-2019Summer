package financial_management.data.property;

import financial_management.parameter.property.QuestionnaireParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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

}
