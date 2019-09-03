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

}
