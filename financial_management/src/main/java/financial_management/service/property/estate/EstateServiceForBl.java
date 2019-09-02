package financial_management.service.property.estate;

import java.util.Date;

/**
 * @author lt
 * @date 2019/08/23 01:30
 */
public interface EstateServiceForBl {

    /**
     * 计算用户总资产
     *
     * @param userId
     * @return
     */
    double getTotalAsset(Long userId);

    /**
     * 获取资产上次更新时间
     *
     * @param userId
     * @return
     */
    Date getFortuneUpdateTime(Long userId);

    /**
     * 获取用户最新的投资收益率
     *
     * @param userId
     * @return
     */
    double getNewlyInvestRate(Long userId);

    /**
     * 获取用户最新的股票收益率
     *
     * @param userId
     * @return
     */
    double getNewlyStocksRate(Long userId);

    /**
     * 获取用户最新的股指收益率
     *
     * @param userId
     * @return
     */
    double getNewlyQdiiRate(Long userId);

    /**
     * 获取用户最新的黄金收益率
     *
     * @param userId
     * @return
     */
    double getNewlyGoldRate(Long userId);

    /**
     * 获取用户最新的债券收益率
     *
     * @param userId
     * @return
     */
    double getNewlyBondRate(Long userId);

    /**
     * 获取用户累计的股票收益率
     *
     * @param userId
     * @return
     */
    double getTotalStocksRate(Long userId);

    /**
     * 获取用户累计的投资收益率
     *
     * @param userId
     * @return
     */
    double getTotalInvestRate(Long userId);

    /**
     * 获取用户累计的股指收益率
     *
     * @param userId
     * @return
     */
    double getTotalQdiiRate(Long userId);

    /**
     * 获取用户累计的黄金收益率
     *
     * @param userId
     * @return
     */
    double getTotalGoldRate(Long userId);

    /**
     * 获取用户累计的债券收益率
     *
     * @param userId
     * @return
     */
    double getTotalBondRate(Long userId);

    /**
     * 获取债券的days日收益率
     *
     * @param bondId, days
     * @return
     */
    double getBondProfitOfDays(Long bondId, int days);

}
