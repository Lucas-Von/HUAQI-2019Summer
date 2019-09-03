package financial_management.data.property;

import financial_management.entity.property.BondIncomePO;
import financial_management.entity.property.RecentInvPO;
import financial_management.entity.property.TotalIncomePO;
import org.apache.ibatis.annotations.Param;

public interface IncomeMapper {

    /**
     * 获取用户累计收益
     *
     * @param userId
     * @return
     */
    Double getTotalIncome(@Param("userId") Long userId);

    /**
     * 获取用户昨日收益
     *
     * @param userId
     * @return
     */
    RecentInvPO getNewlyIncome(@Param("userId") Long userId);

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
     * @param bondId, days
     * @return
     */
    boolean ifExistDaysBondLog(@Param("bondId") Long bondId, @Param("days") int days);

    /**
     * 获取债券的days日收益率
     *
     * @param bondId, days
     * @return
     */
    BondIncomePO getBondProfitOfDays(@Param("bondId") Long bondId, @Param("days") int days);

}