package financial_management.bl.product;

import financial_management.parameter.product.StockCustomizeParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.product.MyStockVO;

import java.util.List;
import java.util.Map;

public interface StockService {
    void stockEstablish(Long userId);

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

    BasicResponse<?> StockCustomize(StockCustomizeParam param, long userID);

    BasicResponse<?> QDIICustomize(StockCustomizeParam param, long userID);

    BasicResponse<?> transferCheck(long transID, long userID, boolean accepted);

    BasicResponse<?> QDIITransferCheck(long transID, long userID, boolean accepted);

    BasicResponse<?> StockTransCheck(long transID, long userID, boolean accepted);

    double getTotalStockByUser(long userID);

    double getTotalQDIIByUser(long userID);

    BasicResponse<Map<String,List<MyStockVO>>> getHoldStock(long userID);
}
