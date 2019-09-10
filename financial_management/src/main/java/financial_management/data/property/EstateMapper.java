package financial_management.data.property;

import financial_management.entity.property.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/20 16:48
 */
@Repository
@Mapper
public interface EstateMapper {

    /**
     * 获取用户资产记录
     *
     * @param userId
     * @return
     */
    EstatePO getPropertyByUser(@Param("userId") Long userId);

    /**
     * 获取用户的各项投资持仓情况
     *
     * @param userId
     * @return
     */
    SubInvestPO getSubInvInfo(@Param("userId") Long userId);

    /**
     * 获取用户自注册起所有月份的资产列表
     *
     * @param userId
     * @return
     */
    List<FortunePO> getMonthlyProList(@Param("userId") Long userId);

    /**
     * 获取用户自注册起所有月份的投资列表
     *
     * @param userId
     * @return
     */
    List<InvestPO> getMonthlyInvList(@Param("userId") Long userId);

    /**
     * 获取用户最近30天的资产列表
     *
     * @param userId
     * @return
     */
    List<FortunePO> getDailyProList(@Param("userId") Long userId);

    /**
     * 获取用户最近30天的投资列表
     *
     * @param userId
     * @return
     */
    List<InvestPO> getDailyInvList(@Param("userId") Long userId);

    /**
     * 获取用户自注册起每天的资产列表
     *
     * @param userId
     * @return
     */
    List<FortunePO> getCompleteProList(@Param("userId") Long userId);

    /**
     * 判断平台外现金&投资表中是否存在该用户的记录
     *
     * @param userId
     * @reutrn
     */
    boolean ifExistOutRecord(@Param("userId") Long userId);

    /**
     * 判断资产变更表中是否存在该用户的记录
     *
     * @param userId
     * @reutrn
     */
    boolean ifExistFortuneRecord(@Param("userId") Long userId);

    /**
     * 插入用户平台外现金数额
     *
     * @param userId
     * @param fundsOutPlatform
     * @return
     */
    void insertOutFundsRecord(@Param("userId") Long userId, @Param("fundsOutPlatform") double fundsOutPlatform);

    /**
     * 删除用户的平台外现金数额【修改该值为0】
     *
     * @param userId
     * @return
     */
    void delOutFundsRecord(@Param("userId") Long userId);

    /**
     * 更新用户平台外现金数额
     *
     * @param userId
     * @param fundsOutPlatform
     * @return
     */
    void updateOutFundsRecord(@Param("userId") Long userId, @Param("fundsOutPlatform") double fundsOutPlatform);

    /**
     * 查看用户平台外现金数额
     *
     * @param userId
     * @return
     */
    double getOutFundsRecord(@Param("userId") Long userId);

    /**
     * 插入用户平台外投资数额
     *
     * @param userId
     * @param investOutPlatform
     * @return
     */
    void insertOutInvestRecord(@Param("userId") Long userId, @Param("investOutPlatform") double investOutPlatform);

    /**
     * 删除用户的平台外投资数额【修改该值为0】
     *
     * @param userId
     * @return
     */
    void delOutInvestRecord(@Param("userId") Long userId);

    /**
     * 更新用户平台外投资数额
     *
     * @param userId
     * @param investOutPlatform
     * @return
     */
    void updateOutInvestRecord(@Param("userId") Long userId, @Param("investOutPlatform") double investOutPlatform);

    /**
     * 查看用户平台外投资数额
     *
     * @param userId
     * @return
     */
    double getOutInvestRecord(@Param("userId") Long userId);

    /**
     * 获取资产上次更新时间
     *
     * @param userId
     * @return
     */
    Date getFortuneUpdateTime(@Param("userId") Long userId);

    @Scheduled(cron = "0 0 23 * * ?")
    void updateFortuneByDay();

}