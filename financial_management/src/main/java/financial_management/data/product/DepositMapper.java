package financial_management.data.product;

import financial_management.entity.DepositProductPO;
import financial_management.entity.MyDepoPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 19:38
 * @Version 1.0
 **/
@Repository
@Mapper
public interface DepositMapper {

    List<DepositProductPO> selectAllProducts();

    List<MyDepoPO> selectSelfProducts(Long userId);

    int insertMyProduct(MyDepoPO po);

    DepositProductPO selectProductByName(String name);
}
