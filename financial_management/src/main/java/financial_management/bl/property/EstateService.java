package financial_management.bl.property;

import financial_management.vo.BasicResponse;

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
    BasicResponse getOverviewByUser(Long userId);

    /**
     * 获取用户资产记录
     *
     * @param userId
     * @return
     */
    BasicResponse getPropertyByUser(Long userId);

    /**
     * 获取用户累计收益
     *
     * @param userId
     * @return
     */
    BasicResponse getTotalIncome(Long userId);

    /**
     * 获取用户昨日收益
     *
     * @param userId
     * @return
     */
    BasicResponse getNewlyIncome(Long userId);

    /**
     * 获取用户储蓄产品列表
     *
     * @param userId
     * @return
     */
    BasicResponse getDepositList(Long userId);

    /**
     * 获取用户指定资产类型信息列表
     *
     * @param userId, assetType
     * @return
     */
    BasicResponse getAssetInfoList(Long userId, String assetType);

    /**
     * 获取用户自注册起所有月份的资产列表
     *
     * @param userId
     * @return
     */
    BasicResponse getMonthlyProList(Long userId);

    /**
     * 获取用户自注册起所有月份的投资列表
     *
     * @param userId
     * @return
     */
    BasicResponse getMonthlyInvList(Long userId);

    /**
     * 获取用户最近30天的资产列表
     *
     * @param userId
     * @return
     */
    BasicResponse getDailyProList(Long userId);

    /**
     * 获取用户最近30天的投资列表
     *
     * @param userId
     * @return
     */
    BasicResponse getDailyInvList(Long userId);

    /**
     * 获取用户自身的推荐资产配置
     *
     * @param userId
     * @return
     */
    BasicResponse getMyRecAlloc(Long userId);

}
