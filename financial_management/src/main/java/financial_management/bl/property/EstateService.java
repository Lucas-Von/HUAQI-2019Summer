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
     * 获取资产上次更新时间
     *
     * @param userId
     * @return
     */
    BasicResponse getFortuneUpdateTimeByUser(Long userId);

    /**
     * 获取用户指定资产类型信息列表
     *
     * @param userId
     * @param assetType
     * @return
     */
    BasicResponse getAssetInfoList(Long userId, String assetType);

    /**
     * 获取用户的各项投资持仓情况
     *
     * @param userId
     * @return
     */
    BasicResponse getSubInvPosition(Long userId);

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
     * 获取用户自注册起每天的资产列表
     *
     * @param userId
     * @return
     */
    BasicResponse getCompleteProList(Long userId);

    /**
     * 判断该用户是否已完善资产信息
     *
     * @param userId
     * @reutrn
     */
    BasicResponse hasImproveInfo(Long userId);

    /**
     * 获取用户自身的推荐资产配置
     *
     * @param userId
     * @return
     */
    BasicResponse getMyRecAlloc(Long userId);

    /**
     * 设定用户的平台外现金数额
     *
     * @param userId
     * @param fundsOutPlatform
     * @return
     */
    BasicResponse setFundsOutPlatform(Long userId, double fundsOutPlatform);

    /**
     * 删除用户的平台外现金数额【修改该值为0】
     *
     * @param userId
     * @return
     */
    BasicResponse delFundsOutPlatform(Long userId);

    /**
     * 查看用户的平台外现金数额
     *
     * @param userId
     * @return
     */
    BasicResponse getFundsOutPlatform(Long userId);

    /**
     * 设定用户的平台外投资数额
     *
     * @param userId
     * @param investOutPlatform
     * @return
     */
    BasicResponse setInvestOutPlatform(Long userId, double investOutPlatform);

    /**
     * 删除用户的平台外投资数额【修改该值为0】
     *
     * @param userId
     * @return
     */
    BasicResponse delInvestOutPlatform(Long userId);

    /**
     * 查看用户的平台外投资数额
     *
     * @param userId
     * @return
     */
    BasicResponse getInvestOutPlatform(Long userId);

}