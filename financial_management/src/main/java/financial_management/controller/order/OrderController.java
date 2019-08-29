package financial_management.controller.order;

import financial_management.bl.order.OrderService;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    @Qualifier(value = "orderServiceImpl")
    private OrderService orderService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("trade")
    public BasicResponse getTradeRecordsByUserID(HttpServletRequest request) {
        return orderService.getPersonalTradeRecordByUser(jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("trade/{ID}")
    public BasicResponse getTradeRecordByRecordID(@PathVariable Long ID) {
        return orderService.getPersonalTradeRecordByRecord(ID);
    }

    @GetMapping("transfer")
    public BasicResponse getTransferRecordByUserID(HttpServletRequest request) {
        return orderService.getTransferRecordByUser(jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("/transfer/{ID}")
    public BasicResponse getTransferRecordByRecordID(@PathVariable Long ID) {
        return orderService.getTransferRecordByRecord(ID);
    }

}
