package financial_management.service.property.estate;

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

}
