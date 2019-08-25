package financial_management.controller.product;

import financial_management.bl.product.DepositService;
import financial_management.bl.product.FundService;
import financial_management.bl.product.InsuranceService;
import financial_management.bl.product.InvestmentService;
import financial_management.parameter.product.DepositPurchaseParam;

import financial_management.util.JwtUtil;

import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.product.DepRecProductVO;
import financial_management.vo.product.MyDepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.RemoteEndpoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 19:33
 * @Version 1.0
 **/
@CrossOrigin
@RestController
public class DepositController {


    @Autowired
    DepositService depositService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = "/product/deposit")
    public BasicResponse MyDeposit(HttpServletRequest request){
        List<MyDepositVO> vos = depositService.getSelfDeposits(jwtUtil.getIdFromRequest(request));
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }


    @GetMapping(value = "/product/deposit/recommend")
    public BasicResponse RecommendDepProduct(HttpServletRequest request){
        List<DepRecProductVO> vos = depositService.getAllDeposits();
        return  new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vos);
    }

    @PostMapping(value = "/product/deposit")
    public BasicResponse purchaseDepositProduct(HttpServletRequest request, @RequestBody DepositPurchaseParam param) {
        if (depositService.purchase(jwtUtil.getIdFromRequest(request), param.getName(), param.getAmount())) {
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);

        } else {
            return new BasicResponse<>(ResponseStatus.STATUS_DEPOSITPRODUCT_UNFINED, null);
        }
    }
}
