package financial_management.data.property;

import financial_management.entity.property.IncomePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lt
 * @date 2019/08/26 00:59
 */
@Repository
@Mapper
public interface IncomeMapper {

    /**
     * 获取平台所有用户近7/30/90天的收益率
     *
     * @param days
     * @return
     */
    IncomePO getRecentProfitRate(@Param("days") int days);

}
