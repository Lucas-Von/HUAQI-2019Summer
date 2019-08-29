package financial_management.controller.wallet;

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
    JwtUtil jwtUtil;

    @PostMapping(value = "/recharge")
    public BasicResponse recharging(@RequestBody RechargeParam param, HttpServletRequest request) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @PostMapping(value = "/payment/balance")
    public BasicResponse payment(@RequestBody PaymentParam payment, HttpServletRequest request) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @PostMapping(value = "/withdraw")
    public BasicResponse withdraw(@RequestBody WithdrawParam withdraw) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @PostMapping(value = "/binding")
    public BasicResponse cardBinding(@RequestBody BindingParam binding) {
        BindingVO vo = new BindingVO();
        vo.setBound(true);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vo);
    }

    @GetMapping(value = "/balance")
    public BasicResponse checkBalance(HttpServletRequest request) {
        //逻辑部分
        BalanceVO balance = new BalanceVO();
        balance.setBalance(2000L);
        balance.setCardid("3211233211233211");
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, balance);
    }

    @PostMapping(value = "/payment/thirdparty")
    public BasicResponse payByCard(HttpServletRequest request, @RequestBody ThirdPartyPaymentParam param) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

}
