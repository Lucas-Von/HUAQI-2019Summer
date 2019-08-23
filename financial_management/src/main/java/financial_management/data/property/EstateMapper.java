package financial_management.data.property;

import financial_management.entity.property.DepositPO;
import financial_management.entity.property.EstatePO;
import financial_management.entity.property.FortunePO;
import financial_management.entity.property.InvestPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lt
 * @date 2019/08/20 16:48
 */
@Repository
@Mapper
public interface EstateMapper {

    /**
     * 获取用户资产概况
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
    Double getNewlyIncome(@Param("userId") Long userId);

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
    FortunePO getMonthlyProList(@Param("userId") Long userId);

    /**
     * 获取用户自注册起所有月份的投资列表
     *
     * @param userId
     * @return
     */
    InvestPO getMonthlyInvList(@Param("userId") Long userId);

    /**
     * 获取用户最近30天的资产列表
     *
     * @param userId
     * @return
     */
    FortunePO getDailyProList(@Param("userId") Long userId);

    /**
     * 获取用户最近30天的投资列表
     *
     * @param userId
     * @return
     */
    InvestPO getDailyInvList(@Param("userId") Long userId);

}
