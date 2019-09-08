package financial_management.data.product;

import financial_management.entity.stock.*;
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

    List<ForStockPO> selectAllQDII();

    List<MyStockPO> selectSelfDomStock(Long userId);

    List<MyQDIIPO> selectSelfQDII(Long userId);

    Integer insertMyStock(MyStockPO po);

    Integer insertMyQDII(MyQDIIPO po);

    Integer updateMyStock(MyStockPO po);

    Integer updateMyQDII(MyQDIIPO po);

    DomStockPO selectDomStockByCode(String code);

    ForStockPO selectQDIIByCode(String code);

    ForStockPO selectQDIIById(Long id);

    DomStockPO selectDomStockById(Long id);

    List<QDIIAdjustmentPO> selectQDIIAdjustmentByTransID(long transID);

    Integer insertQDIIAdjustment(QDIIAdjustmentPO po);
}
