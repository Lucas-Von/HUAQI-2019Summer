package financial_management.service.product.gold;

/**
 * @author xyh
 * @date 2019/9/3
 */
public interface GoldServiceForBl {
    /**
     * 获得用户的黄金总额
     * @param userId
     * @return
     */
    double getTotalGoldByUser(Long userId);
}
