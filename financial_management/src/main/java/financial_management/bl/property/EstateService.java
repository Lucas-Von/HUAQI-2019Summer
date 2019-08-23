package financial_management.bl.property;

import financial_management.vo.BasicResponse;
import org.apache.ibatis.annotations.Param;

/**
 * @author lt
 * @date 2019/08/20 16:47
 */
public interface EstateService {

    /**
     * 获取用户资产概况
     *
     * @param userId
     * @return
     */
    BasicResponse getPropertyByUser(@Param("userId") Long userId);

    /**
     * 获取用户累计收益
     *
     * @param userId
     * @return
     */
    BasicResponse getTotalIncome(@Param("userId") Long userId);

    /**
     * 获取用户昨日收益
     *
     * @param userId
     * @return
     */
    BasicResponse getNewlyIncome(@Param("userId") Long userId);

    /**
     * 获取用户储蓄产品列表
     *
     * @return
     * @Param userId
     */
    BasicResponse getDepositList(@Param("userId") Long userId);

    /**
     * 获取用户指定资产类型信息列表
     *
     * @param userId, assetType
     * @return
     */
    BasicResponse getAssetInfoList(Long userId, String assetType);

}
