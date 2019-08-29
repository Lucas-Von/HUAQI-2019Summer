package financial_management.bl.order;

import financial_management.vo.BasicResponse;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.PlatformTradeVO;
import financial_management.vo.order.TransferRecordVO;

import java.util.List;

public interface OrderService {
    BasicResponse<List<PersonalTradeVO>> getPersonalTradeRecordByUser(Long ID);

    BasicResponse<PersonalTradeVO> getPersonalTradeRecordByRecord(Long ID);

    BasicResponse<List<TransferRecordVO>> getTransferRecordByUser(Long ID);

    BasicResponse<TransferRecordVO> getTransferRecordByRecord(Long ID);

    //获取平台交易记录
    BasicResponse<List<PlatformTradeVO>> getAllPlatformTradeRecord();

    BasicResponse<?> addPersonalTradeRecord(PersonalTradeVO personalTradeVO, boolean isCustomize);

    //新增平台交易记录
    BasicResponse<?> addPlatfromTradeRecord(PlatformTradeVO platformTradeVO);

    BasicResponse<?> addTransferRecord(TransferRecordVO transferRecordVO, boolean isCustomize);
}
