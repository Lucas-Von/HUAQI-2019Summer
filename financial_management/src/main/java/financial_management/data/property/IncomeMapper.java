package financial_management.data.property;

import financial_management.entity.property.BondIncomePO;
import financial_management.entity.property.RecentInvPO;
import financial_management.entity.property.TotalIncomePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author lt
 * @date 2019/09/03 19:45
 */
@Repository
@Mapper
public interface IncomeMapper {

    /**
     * 获取用户昨日收益
     *
     * @param userId
     * @return
     */
    RecentInvPO getNewlyIncome(@Param("userId") Long userId);

    /**
     * 获取用户累计收益
     *
     * @param userId
     * @return
     */
    Double getTotalIncome(@Param("userId") Long userId);

    /**
     * 获取特定日期用户累计的投资收益率
     *
     * @param userId
     * @param date
     * @return
     */
    TotalIncomePO getSomeDayTotalInvestRate(@Param("userId") Long userId, @Param("date") Date date);

    /**
     * 获取用户累计的投资收益率
     *
     * @param userId
     * @return
     */
    TotalIncomePO getTotalInvestRate(@Param("userId") Long userId);

    /**
     * 判断是否存在days天的债券收益记录
     *
     * @param bondId
     * @param days
     * @return
     */
    boolean ifExistDaysBondLog(@Param("bondId") Long bondId, @Param("days") int days);

    /**
     * 获取债券的days日收益率
     *
     * @param bondId
     * @param days
     * @return
     */
    BondIncomePO getBondProfitOfDays(@Param("bondId") Long bondId, @Param("days") int days);

}