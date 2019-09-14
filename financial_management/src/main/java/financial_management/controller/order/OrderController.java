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

    /**
     * 用户和管理员共用获取交易记录接口
     * @param request 不多说
     * @param userID  如果是普通用户获取则不需要，但管理员获取则必须
     * @return
     */
    @GetMapping("trade")
    public BasicResponse getTradeRecordsByUserID(HttpServletRequest request, @RequestParam(required = false) Long userID) {
        //TODO 权限判断，现在先这样丑陋的做
        long reqUserID = jwtUtil.getIdFromRequest(request);
        if (reqUserID == 0) {
            return orderService.getPersonalTradeRecordByRecord(userID);
        } else {
            return orderService.getPersonalTradeRecordByUser(reqUserID);
        }
    }

    @GetMapping("trade/{ID}")
    public BasicResponse getTradeRecordByRecordID(@PathVariable Long ID) {
        return orderService.getPersonalTradeRecordByRecord(ID);
    }

    /**
     * 支付未支付的个人交易
     * @param ID 交易ID
     * @param request 不多说
     * @return 如果支付没有成功，会在data中填入具体原因，成功则返回一个本次交易记录vo
     */
    @PostMapping("pay/{ID}")
    public BasicResponse payPersonalTrade(@PathVariable long ID, HttpServletRequest request) {
        return orderService.completePersonalTrade(ID, jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("transfer")
    public BasicResponse getTransferRecordByUserID(HttpServletRequest request) {
        return orderService.getTransferRecordByUser(jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("transfer/{ID}")
    public BasicResponse getTransferRecordByRecordID(@PathVariable Long ID) {
        return orderService.getTransferRecordByRecord(ID);
    }

}
