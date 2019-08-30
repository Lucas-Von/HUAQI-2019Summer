package financial_management.bl.order;

import financial_management.vo.BasicResponse;
import financial_management.vo.order.MaxInvestVO;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.PlatformTradeVO;
import financial_management.vo.order.TransferRecordVO;

import java.util.Date;
import java.util.List;

public interface OrderService {
    BasicResponse<List<PersonalTradeVO>> getPersonalTradeRecordByUser(Long ID);

    BasicResponse<PersonalTradeVO> getPersonalTradeRecordByRecord(Long ID);

    BasicResponse<List<TransferRecordVO>> getTransferRecordByUser(Long ID);

    BasicResponse<TransferRecordVO> getTransferRecordByRecord(Long ID);

    //获取今日所有个人交易记录（这个方法只是债券）
    BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord();

    //获取今日所有个人交易记录（按类型）
    BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord(PersonalTradeVO.Type type);

    //获取平台交易记录
    BasicResponse<List<PlatformTradeVO>> getAllPlatformTradeRecord();

    //新增个人交易记录
    BasicResponse<?> addPersonalTradeRecord(PersonalTradeVO personalTradeVO, boolean isCustomize);

    //新增平台交易记录
    BasicResponse<?> addPlatfromTradeRecord(PlatformTradeVO platformTradeVO);

    BasicResponse<?> addTransferRecord(TransferRecordVO transferRecordVO, boolean isCustomize);

    //获取累计净投入峰值
    BasicResponse<MaxInvestVO> getMaxInvestBy(Long userID, String type);

    //获取当日&累计净投入，date为null则为累计
    BasicResponse<Float> getInvestBy(Long userID, String type, Date date);
}
