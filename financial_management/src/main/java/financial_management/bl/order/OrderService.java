package financial_management.bl.order;

import financial_management.entity.TransferRecordPO;
import financial_management.vo.BasicResponse;
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

    TransferRecordPO getTransferRecordByID(long id);

    List<TransferRecordPO> getTransferRecordByUserID(long userID);

    //获取今日所有个人交易记录（这个方法只是债券）
    BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord();

    //获取今日所有个人交易记录（按类型）
    BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord(Type type);

    //获取平台交易记录
    BasicResponse<List<PlatformTradeVO>> getAllPlatformTradeRecord();

    //新增个人交易记录
    BasicResponse<PersonalTradeVO> addPersonalTradeRecord(PersonalTradeVO personalTradeVO, boolean isCustomize);

    //新增平台交易记录
    BasicResponse<?> addPlatformTradeRecord(PlatformTradeVO platformTradeVO);

    TransferRecordPO addTransferRecord(TransferRecordPO po);

    TransferRecordPO updateTransferRecord(TransferRecordPO po);

    //获取累计净投入峰值
    double getMaxInvestBy(Long userID, String type);

    //获取当日&累计净投入，date为null则为累计，否则为该日期的结果
    double getInvestBy(Long userID, String type, Date date);

    /**
     * 获取date日期之前的累计净投入峰值
     * @param userID 用户ID
     * @param type 类型，见下方
     * @param noLaterThanDate 统计截止日期（包括该日期）
     * @return date之前的累计净投入峰值
     */
    double getMaxInvestBy(Long userID, Type type, Date noLaterThanDate);

    enum Type{
        FUND,//基金
        DEPOSIT,//储蓄
        INSURANCE,//保险
        GOLD,//黄金
        BOND,//债券
        DOMSTOCK,//股票
        FORSTOCK;//股指
    }
}
