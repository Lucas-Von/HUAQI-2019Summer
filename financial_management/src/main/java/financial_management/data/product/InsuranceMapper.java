package financial_management.data.product;

import financial_management.entity.InsProductPO;
import financial_management.entity.InsurancePO;
import financial_management.entity.MyInsPO;
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
public interface InsuranceMapper {

    List<InsProductPO> selectAllInsProduct();

    List<MyInsPO> selectSelfInsProducts(Long userId);

    int insertMyProduct(MyInsPO po);

    InsProductPO selectProductByName(String name);

}
