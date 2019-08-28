package financial_management.data.product;

import financial_management.entity.FundPO;
import financial_management.entity.MyFundPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 16:59
 * @Version 1.0
 **/
@Mapper
@Repository
public interface FundMapper {

    MyFundPO selectSelfFund(Long userId);

    FundPO selectFund();

    int updateSelfFund(MyFundPO po);

    int updateSelfPassword(@Param("userId")Long userId,@Param("payPassword")String passowrd);

    int insertNewFund(@Param("userId") Long userId,@Param("balance") Float balance);
}