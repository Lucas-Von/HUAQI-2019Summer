package financial_management.bl.order;

import financial_management.entity.Response;
import financial_management.vo.order.TradeRecordVO;
import financial_management.vo.order.TransferRecordVO;

import java.util.List;

public interface OrderService {
    Response<List<TradeRecordVO>> getTradeRecordByUser(Long ID);

    Response<TradeRecordVO> getTradeRecordByRecord(Long ID);

    Response<List<TransferRecordVO>> getTransferRecordByUser(Long ID);

    Response<TransferRecordVO> getTransferRecordByRecord(Long ID);

    //TODO addTradeRecord & addTransferRecord
}
