package financial_management.data.product;

import financial_management.entity.stock.QDIIAdjustmentPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockAdjustmentMapper {
    List<QDIIAdjustmentPO> selectQDIIAdjustmentByTransID(long transID);

    int insertQDII(QDIIAdjustmentPO po);
}
