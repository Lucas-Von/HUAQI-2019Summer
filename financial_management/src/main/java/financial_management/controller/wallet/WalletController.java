package financial_management.controller.wallet;

import financial_management.bl.wallet.WalletService;
import financial_management.parameter.wallet.*;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.wallet.BalanceVO;
import financial_management.vo.wallet.BindingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.RemoteEndpoint;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 13:26
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping(value = "/account")
public class WalletController {
    @Autowired
    WalletService service;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(value = "/recharge")
    public BasicResponse recharging(@RequestBody RechargeParam param, HttpServletRequest request){
        service.recharge(param.getCost(),jwtUtil.getIdFromRequest(request));
        //逻辑部分
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,true);
    }

    @PostMapping(value = "/payment/balance")
    public BasicResponse payment(@RequestBody PaymentParam payment,HttpServletRequest request){

        return service.payByCash(jwtUtil.getIdFromRequest(request),payment.getCost(),payment.getPay_password());
    }

    @PostMapping(value = "/withdraw")
    public BasicResponse withdraw(@RequestBody WithdrawParam withdraw,HttpServletRequest request){
        return service.withdraw(jwtUtil.getIdFromRequest(request),withdraw.getCost().doubleValue(),withdraw.getCardid());
    }

    @PostMapping(value = "/binding")
    public BasicResponse cardBinding(@RequestBody BindingParam binding,HttpServletRequest request){
        service.binding(jwtUtil.getIdFromRequest(request),binding.getCard_num(),binding.getPay_password());
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,null);
    }

    @GetMapping(value = "/balance")
    public BasicResponse checkBalance(HttpServletRequest request){
        //逻辑部分

        return service.checkBalance(jwtUtil.getIdFromRequest(request));
    }

    @PostMapping(value = "/payment/thirdparty")
    public BasicResponse payByCard(HttpServletRequest request, @RequestBody ThirdPartyPaymentParam param) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,null);
}
}
