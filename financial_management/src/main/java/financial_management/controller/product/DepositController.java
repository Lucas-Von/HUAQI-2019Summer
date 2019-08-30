package financial_management.controller.product;

import financial_management.bl.product.DepositService;
import financial_management.bl.product.FundService;
import financial_management.bl.product.InsuranceService;
import financial_management.bl.product.InvestmentService;
import financial_management.entity.MyDepoPO;
import financial_management.parameter.product.DepositPurchaseParam;

import financial_management.parameter.product.SelfDepositParam;
import financial_management.util.JwtUtil;

import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.product.DepRecProductVO;
import financial_management.vo.product.MyDepositVO;
import org.apache.ibatis.annotations.Param;
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
    private DepositService depositService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(value = "/product/deposit/get")
    public BasicResponse getSelfDeposits(HttpServletRequest request) {
        List<MyDepositVO> myDeposits = new ArrayList<>();
        MyDepoPO myDepoPO1 = new MyDepoPO();
        myDepoPO1.setId(1L);
        myDepoPO1.setUserId(5L);
        myDepoPO1.setType(0);
        myDepoPO1.setAmount(20000.0);
        myDepoPO1.setName("个人储蓄产品1");
        myDepoPO1.setRate(0.38);
        myDepoPO1.setEndtime(new Date());
        myDepoPO1.setProportion(0.14285714285714285);
        MyDepositVO myDepositVO1 = myDepoPO1.getMyDepositVO();
        MyDepoPO myDepoPO2 = new MyDepoPO();
        myDepoPO2.setId(2L);
        myDepoPO2.setUserId(1L);
        myDepoPO2.setType(1);
        myDepoPO2.setAmount(20000.0);
        myDepoPO2.setName("个人储蓄产品2");
        myDepoPO2.setRate(0.88);
        myDepoPO2.setEndtime(new Date());
        myDepoPO2.setProportion(0.2857142857142857);
        MyDepositVO myDepositVO2 = myDepoPO2.getMyDepositVO();
        myDeposits.add(myDepositVO1);
        myDeposits.add(myDepositVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, myDeposits);
    }

    @PostMapping(value = "/product/deposit/add")
    public BasicResponse addSelfDeposit(@RequestBody SelfDepositParam selfDepositParam, HttpServletRequest request) {
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping(value = "/product/deposit/update")
    public BasicResponse updateSelfDeposit(@RequestBody SelfDepositParam selfDepositParam) {
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping(value = "/product/deposit/delete")
    public BasicResponse deleteSelfDeposit(@RequestParam Long id) {
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @GetMapping(value = "/product/deposit/recommend")
    public BasicResponse RecommendDepProduct() {
        List<DepRecProductVO> vos = depositService.getAllDeposits();
        DepRecProductVO depRecProductVO1 = new DepRecProductVO("产品1", 365, 0.0575);
        DepRecProductVO depRecProductVO2 = new DepRecProductVO("产品2", 200, 0.0175);
        vos.add(depRecProductVO1);
        vos.add(depRecProductVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @PostMapping(value = "/product/deposit")
    public BasicResponse purchaseDepositProduct(HttpServletRequest request, @RequestBody DepositPurchaseParam param) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }
}
