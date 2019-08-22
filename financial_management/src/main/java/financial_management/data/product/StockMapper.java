package financial_management.data.product;

import financial_management.entity.DomStockPO;
import financial_management.entity.ForStockPO;
import financial_management.entity.MyStockPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/21 16:48
 * @Version 1.0
 **/
@Mapper
@Repository
public interface StockMapper {

    List<DomStockPO> selectAllDomStock();

    List<ForStockPO> selectAllForStock();

    List<MyStockPO> selectSelfDomStock(Long userId);

    List<MyStockPO> selectSelfForStock(Long userId);

    int insertMyStock(MyStockPO po);

    DomStockPO selectDomStockByCode(String code);

    ForStockPO selectForStockByCode(String code);
}
