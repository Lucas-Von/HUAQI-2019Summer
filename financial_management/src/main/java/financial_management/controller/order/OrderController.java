package financial_management.controller.order;

import financial_management.bl.order.OrderService;
import financial_management.entity.Response;
import financial_management.vo.order.TradeRecordVO;
import financial_management.vo.order.TransferRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("trade")
    public ResponseEntity<?> getTradeRecordsByUserID(@RequestParam Long userID){
        Response<List<TradeRecordVO>> response = orderService.getTradeRecordByUser(userID);
        return judge(response);
    }

    @GetMapping("trade/{ID}")
    public ResponseEntity<?> getTradeRecordByRecordID(@PathVariable Long ID){
        Response<TradeRecordVO> response = orderService.getTradeRecordByRecord(ID);
        return judge(response);
    }

    @GetMapping("transfer")
    public ResponseEntity<?> getTransferRecordByUserID(@RequestParam Long userID){
        Response<List<TransferRecordVO>> response = orderService.getTransferRecordByUser(userID);
        return judge(response);
    }

    @GetMapping("/transfer/{ID}")
    public ResponseEntity<?> getTransferRecordByRecordID(@PathVariable Long ID){
        Response<TransferRecordVO> response = orderService.getTransferRecordByRecord(ID);
        return judge(response);
    }

    private static ResponseEntity judge(Response response){
        if (response.isSuccess()){
            return ResponseEntity.ok(response.getContent());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getMessage());
        }
    }
}
