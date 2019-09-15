package financial_management.bl.product;

import financial_management.parameter.product.StockCustomizeParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.product.MyStockVO;

import java.util.List;
import java.util.Map;

public interface StockService {
    /**
     * 股票建仓
     * @param userId
     */
    void stockEstablish(Long userId);

    /**
     * 每周股票调仓推荐方案的生成
     * @param userId
     */
    void weeklyStockTransfer(Long userId);

    /**
     * 用户首次购买时
     * 从本地获取标准持仓excel（对应标准持仓的代码、份数、成本）
     * 获取各基金当前价格（python里自己获取，不需要传参数）
     * 和数据库中参数，输出购买/卖出信息
     *
     * @param userId 用户ID
     */
    void firstQDII(Long userId);

    /**
     * 每月执行一次，从本地读取最新指数估值excel数据，从数据库获取对应参数，输出购买/卖出信息
     *
     * @param userId 用户ID
     */
    void MonthlyQDIITransfer(Long userId);

    /**
     * 用户手动买卖股票
     * @param param 只有金额
     * @param userID 用户ID
     * @return
     */
    BasicResponse<?> StockCustomize(StockCustomizeParam param, long userID);

    /**
     * 用户手动调整海外股指配置
     * @param param 包含要买卖的指数和买卖金额
     * @param userID 用户ID
     * @return
     */
    BasicResponse<?> QDIICustomize(StockCustomizeParam param, long userID);

    /**
     * 对调仓建议进行确认，接受或者拒绝调仓推荐方案
     * @param transID 调仓记录ID
     * @param userID 用户ID
     * @param accepted 是否接受
     * @return
     */
    BasicResponse<?> transferCheck(long transID, long userID, boolean accepted);

    BasicResponse<?> QDIITransferCheck(long transID, long userID, boolean accepted);

    BasicResponse<?> StockTransCheck(long transID, long userID, boolean accepted);

    /**
     * 获取用户持有的股票资产总额
     * @param userID
     * @return
     */
    double getTotalStockByUser(long userID);

    /**
     * 获取用户持有的海外股指资产总额
     * @param userID
     * @return
     */
    double getTotalQDIIByUser(long userID);

    /**
     * 获取用户的股票和股指持仓情况
     * @param userID
     * @return
     */
    BasicResponse<Map<String,List<MyStockVO>>> getHoldStock(long userID);

    BasicResponse<PersonalTradeVO> completeStockOrder(long orderID, Long userID);

    void marketDailyUpdate();
}
