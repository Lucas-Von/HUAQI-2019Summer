package financial_management.controller.product;

import financial_management.bl.product.StockService;
import financial_management.parameter.product.StockCustomizeParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 确认股指调仓操作
     * @param transID 调仓记录序号
     * @param accepted 是否接受调仓
     * @param request 这还用说
     * @return data恒为null
     */
    @Deprecated
    @PostMapping("qdii/trans/{transID}")
    public BasicResponse checkQDIITransfer(@PathVariable long transID, @RequestParam boolean accepted, HttpServletRequest request) {
        return stockService.QDIITransferCheck(transID, jwtUtil.getIdFromRequest(request), accepted);
    }

    /**
     * 确认股票/股指调仓操作
     * @param transID 调仓记录序号
     * @param accepted 是否接受调仓
     * @param request 这还用说
     * @return data恒为null
     */
    @PostMapping("stock/trans/{transID}")
    public BasicResponse checkStockTransfer(@PathVariable long transID, @RequestParam boolean accepted, HttpServletRequest request) {
        return stockService.transferCheck(transID, jwtUtil.getIdFromRequest(request), accepted);
    }

    /**
     * 获取股票和股指持仓
     * 股票的键为"DOMSTOCK"
     * 股指的键为"FORSTOCK"
     *
     * @param request 这还用说
     * @return 一个dict，如{"DOMSTOCK":[myStockVO1,...], "FORSTOCK":[myStockVO1,...]}
     */
    @GetMapping("stock/hold")
    public BasicResponse getHoldStock(HttpServletRequest request) {
        return stockService.getHoldStock(jwtUtil.getIdFromRequest(request));
    }

    /**
     * 用户手动买入、卖出股指的接口
     * @param param 该参数中两个属性值都必填
     * @param request 这还用说
     * @return 交易成功，data会返回生成的交易记录，失败则返回null
     */
    @PostMapping("qdii/trade")
    public BasicResponse QDIICustomizeTrade(@RequestBody StockCustomizeParam param, HttpServletRequest request) {
        return stockService.QDIICustomize(param, jwtUtil.getIdFromRequest(request));
    }

    /**
     * 用户手动买入、卖出股票的接口
     * @param param 该参数只需填写money，code不需要
     * @param request 这还用说
     * @return 同上
     */
    @PostMapping("stock/trade")
    public BasicResponse StockCustomizeTrade(@RequestBody StockCustomizeParam param, HttpServletRequest request) {
        return stockService.StockCustomize(param, jwtUtil.getIdFromRequest(request));
    }
}
