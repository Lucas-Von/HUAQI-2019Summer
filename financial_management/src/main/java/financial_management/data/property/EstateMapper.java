package financial_management.data.property;

import financial_management.entity.DepositPO;
import financial_management.entity.EstatePO;
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

}
