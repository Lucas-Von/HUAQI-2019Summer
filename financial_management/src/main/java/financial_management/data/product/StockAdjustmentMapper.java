package financial_management.data.product;

import financial_management.entity.stock.QDIIAdjustmentPO;
import financial_management.entity.stock.StockAdjustmentPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface StockAdjustmentMapper {
    List<QDIIAdjustmentPO> selectQDIIAdjustmentByTransID(long transID);

    List<StockAdjustmentPO> selectStockAdjustmentByTransID(long transID);

    Date selectLastStockTransferDate();

    int insertQDII(QDIIAdjustmentPO po);

    int insertStock(StockAdjustmentPO po);
}
