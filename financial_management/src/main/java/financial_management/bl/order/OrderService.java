package financial_management.bl.order;

import financial_management.vo.BasicResponse;
import financial_management.vo.order.TradeRecordVO;
import financial_management.vo.order.TransferRecordVO;

import java.util.List;

public interface OrderService {
    BasicResponse<List<TradeRecordVO>> getTradeRecordByUser(Long ID);

    BasicResponse<TradeRecordVO> getTradeRecordByRecord(Long ID);

    BasicResponse<List<TransferRecordVO>> getTransferRecordByUser(Long ID);

    BasicResponse<TransferRecordVO> getTransferRecordByRecord(Long ID);

    BasicResponse<?> addTradeRecord(TradeRecordVO tradeRecordVO, boolean isCustomize);

    BasicResponse<?> addTransferRecord(TransferRecordVO transferRecordVO, boolean isCustomize);
}
