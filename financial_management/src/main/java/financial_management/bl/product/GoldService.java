package financial_management.bl.product;

import financial_management.vo.BasicResponse;

/**
 * @author xyh
 * @date 2019/8/29
 */
public interface GoldService {
    /**
     * 用户买入黄金
     * @param money
     * @return
     */
    BasicResponse buyGold(Double money, Long userId);

    /**
     * 用户卖出黄金
     * @param money
     * @return
     */
    BasicResponse sellGold(Double money, Long userId);

    /**
     * 黄金历史配置情况列表展示
     * @param userId
     * @return
     */
    BasicResponse getHistoryConfig(Long userId);

    /**
     * 获得用户当前黄金配置
     * @param userId
     * @return
     */
    BasicResponse getNowConfig(Long userId);

    /**
     * 更新黄金收益
     */
    void updateProfit();
}
