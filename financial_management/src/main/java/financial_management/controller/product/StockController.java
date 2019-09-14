package financial_management.controller.product;

import financial_management.bl.product.StockService;
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

    @PostMapping("qdii/trans/{transID}")
    public BasicResponse checkQDIITransfer(@PathVariable long transID, @RequestParam boolean accepted, HttpServletRequest request) {
        return stockService.QDIITransferCheck(transID,jwtUtil.getIdFromRequest(request),accepted);
    }

    @PostMapping("stock/trans/{transID}")
    public BasicResponse checkStockTransfer(@PathVariable long transID, @RequestParam boolean accepted, HttpServletRequest request) {
        return stockService.StockTransCheck(transID,jwtUtil.getIdFromRequest(request),accepted);
    }

    @GetMapping("stock/hold")
    public BasicResponse getHoldStock(HttpServletRequest request){
        return stockService.getHoldStock(jwtUtil.getIdFromRequest(request));
    }
}
