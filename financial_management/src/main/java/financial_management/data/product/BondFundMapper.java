package financial_management.data.product;

import financial_management.entity.bond.*;
import financial_management.entity.bond.RateList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/28 15:46
 * @Version 1.0
 **/
@Repository
@Mapper
public interface BondFundMapper {
    /**
     * @Author jyh
     * @Description //获取国债/企业债收益率
     * @Date 15:48 2019/8/28
     * @Param [name]
     * @return java.lang.Float
    */
    int updateInvestRateByName(@Param("name")String name, @Param("rate")Float rate,@Param("userId")Long userId);

    UserBondPO selectUserBond(@Param("userId") Long userId,@Param("name")String name);

    int insertvestRateByName(@Param("name")String name, @Param("rate")Float rate, @Param("userId")Long userId, @Param("time")Timestamp time);

    BondFoundationPO selectBondFundByName(String name);

    int updateSumPurchaseByName(@Param("sum")Float purchase,@Param("name")String name);

    List<BondPO> selectAllBond();


    List<BondAndFundPO> selectAllBondAndFund(Long fundId);

    int updateBondFundNetWorthy(@Param("price")Float worthy,@Param("name")String name);

    int updateFundScale(@Param("sum")Float worthy,@Param("name")String name);

    BondPlatformPO selectBondPlatform();

    int updateBondPlatform(@Param("rest")Float rest,@Param("bond")Float total);

    int deletePurchaseRecord();

    int updateTotalShare(@Param("name") String name,@Param("amount")Float amount);

    int deleteBondAndFund(@Param("id")Long id);

    int insertBondAndFund(@Param("fundId")Long fundId,@Param("bondId")Long bondId,@Param("invest")Float investment,@Param("amount")Float amount);

    int insertBondFund(BondFoundationPO po);

    int insertBondPlatform(BondPlatformPO po );

    int updateUserFundShare(@Param("id")Long userId,@Param("amount")Float amount,@Param("name")String name);

    int insertRateLog(@Param("id")Long id,@Param("netWorth")Float netWorth,@Param("time") Date time);

    List<NetWorthPO> getRateLogs(Long id);

    BondPO selectBondByCode(String code);

    int updateBondPriceByCode(@Param("code")String code,@Param("price")Float price);

    int insertBond(@Param("code")String code,@Param("price")Float price);

    RateList selectRateList();

}
