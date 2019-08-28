package financial_management.controller.order;

import financial_management.bl.order.OrderService;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    @Qualifier(value = "orderServiceImpl")
    private OrderService orderService;

    @GetMapping("trade")
    public BasicResponse getTradeRecordsByUserID(@RequestParam Long userID) {
        return orderService.getTradeRecordByUser(userID);
    }

    @GetMapping("trade/{ID}")
    public BasicResponse getTradeRecordByRecordID(@PathVariable Long ID) {
        return orderService.getTradeRecordByRecord(ID);
    }

    @GetMapping("transfer")
    public BasicResponse getTransferRecordByUserID(@RequestParam Long userID) {
        return orderService.getTransferRecordByUser(userID);
    }

    @GetMapping("/transfer/{ID}")
    public BasicResponse getTransferRecordByRecordID(@PathVariable Long ID) {
        return orderService.getTransferRecordByRecord(ID);
    }

}
