package financial_management.controller.wallet;

import financial_management.parameter.wallet.*;
import financial_management.util.JwtUtil;
import financial_management.vo.wallet.BalanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public ResponseEntity<?> recharging(@RequestBody RechargeParam param, HttpServletRequest request){

        //逻辑部分
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/payment/balance")
    public ResponseEntity<?> payment(@RequestBody PaymentParam payment,HttpServletRequest request){

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawParam withdraw){
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/binding")
    public ResponseEntity<?> cardBinding(@RequestBody BindingParam binding){
        return ResponseEntity.ok().build();
    }
    @PostMapping(value = "/balance")
    public ResponseEntity<?> checkBalance(HttpServletRequest request){
        //逻辑部分
        BalanceVO balance = new BalanceVO();
        balance.setBalance(2000L);
        balance.setCardid("3211233211233211");
        return ResponseEntity.ok().body(balance);
    }

    @PostMapping(value = "/payment/thirdparty")
    public ResponseEntity<?> payByCard(HttpServletRequest request, @RequestBody ThirdPartyPaymentParam param){

        return ResponseEntity.ok().build();
    }
}
