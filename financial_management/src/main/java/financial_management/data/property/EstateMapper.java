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
     * 获取用户累计收益
     *
     * @param userId
     * @return
     */
    Double getTotalIncome(@Param("userId") Long userId);

    /**
     * 获取用户昨日收益
     *
     * @param userId
     * @return
     */
    RecentInvPO getNewlyIncome(@Param("userId") Long userId);

    /**
     * 获取用户储蓄产品列表
     *
     * @param userId
     * @return
     */
    List<DepositPO> getDepositList(@Param("userId") Long userId);

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
     * 获取资产上次更新时间
     *
     * @param userId
     * @return
     */
    Date getFortuneUpdateTime(@Param("userId") Long userId);

    @Scheduled(cron = "0 0 23 * * ?")
    void updateFortuneByDay();
}
