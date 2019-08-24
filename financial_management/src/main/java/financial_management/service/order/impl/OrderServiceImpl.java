package financial_management.service.order.impl;

import financial_management.bl.order.OrderService;
import financial_management.data.order.TradeRecordMapper;
import financial_management.data.order.TransferRecordMapper;
import financial_management.vo.BasicResponse;
import financial_management.vo.order.TradeRecordVO;
import financial_management.vo.order.TransferRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TradeRecordMapper tradeRecordMapper;
    @Autowired
    private TransferRecordMapper transferRecordMapper;

    @Override
    public BasicResponse<List<TradeRecordVO>> getTradeRecordByUser(Long ID) {

        return null;
    }

    @Override
    public BasicResponse<TradeRecordVO> getTradeRecordByRecord(Long ID) {
        return null;
    }

    @Override
    public BasicResponse<List<TransferRecordVO>> getTransferRecordByUser(Long ID) {
        return null;
    }

    @Override
    public BasicResponse<TransferRecordVO> getTransferRecordByRecord(Long ID) {
        return null;
    }

    @Override
    public BasicResponse<?> addTradeRecord(TradeRecordVO tradeRecordVO) {
        return null;
    }

    @Override
    public BasicResponse<?> addTransferRecord(TransferRecordVO transferRecordVO) {
        return null;
    }
}
