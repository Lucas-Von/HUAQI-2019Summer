package financial_management.service.property.income;

/**
 * @author lt
 * @date 2019/09/03 19:35
 */
public interface IncomeServiceForBl {

    /**
     * 获取用户最新的投资收益率
     *
     * @param userId
     * @return
     */
    double getNewlyInvestRate(Long userId);

    /**
     * 获取用户最新的股票收益
     *
     * @param userId
     * @return
     */
    double getNewlyStocksIncome(Long userId);

    /**
     * 获取用户最新的股指收益
     *
     * @param userId
     * @return
     */
    double getNewlyQdiiIncome(Long userId);

    /**
     * 获取用户最新的黄金收益
     *
     * @param userId
     * @return
     */
    double getNewlyGoldIncome(Long userId);

    /**
     * 获取用户最新的债券收益
     *
     * @param userId
     * @return
     */
    double getNewlyBondIncome(Long userId);

    /**
     * 获取用户累计的投资收益率
     *
     * @param userId
     * @return
     */
    double getTotalInvestRate(Long userId);

    /**
     * 获取用户累计的股票收益
     *
     * @param userId
     * @return
     */
    double getTotalStocksIncome(Long userId);

    /**
     * 获取用户累计的股指收益
     *
     * @param userId
     * @return
     */
    double getTotalQdiiIncome(Long userId);

    /**
     * 获取用户累计的黄金收益
     *
     * @param userId
     * @return
     */
    double getTotalGoldIncome(Long userId);

    /**
     * 获取用户累计的债券收益
     *
     * @param userId
     * @return
     */
    double getTotalBondIncome(Long userId);

    /**
     * 获取债券的days日收益率
     *
     * @param bondId, days
     * @return
     */
    double getBondProfitOfDays(Long bondId, int days);

}