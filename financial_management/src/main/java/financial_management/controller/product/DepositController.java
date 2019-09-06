package financial_management.controller.product;

import financial_management.bl.product.DepositService;
import financial_management.bl.product.FundService;
import financial_management.bl.product.InsuranceService;
import financial_management.bl.product.InvestmentService;
import financial_management.parameter.product.DepositPurchaseParam;

import financial_management.parameter.product.DepositRecommendParam;
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
    public BasicResponse getSelfDeposits(HttpServletRequest request){
        return depositService.getSelfDeposits(jwtUtil.getIdFromRequest(request));
    }

    @PostMapping(value = "/product/deposit/add")
    public BasicResponse addSelfDeposit(@RequestBody SelfDepositParam selfDepositParam, HttpServletRequest request){
        return depositService.addSelfDeposit(selfDepositParam,jwtUtil.getIdFromRequest(request));
    }

    @PostMapping(value = "/product/deposit/add/list")
    public BasicResponse addSelfDepositList(@RequestBody List<SelfDepositParam> selfDepositParams, HttpServletRequest request){
        return depositService.addSelfDepositList(selfDepositParams,jwtUtil.getIdFromRequest(request));
    }

    @PostMapping(value = "/product/deposit/update")
    public BasicResponse updateSelfDeposit(@RequestBody SelfDepositParam selfDepositParam){
        return depositService.updateSelfDeposit(selfDepositParam);
    }

    @PostMapping(value = "/product/deposit/delete")
    public BasicResponse deleteSelfDeposit(@RequestParam Long id){
        return depositService.deleteSelfDeposit(id);
    }

    @PostMapping(value = "/product/deposit/recommend/add")
    public BasicResponse addDepositRecommend(@RequestBody DepositRecommendParam depositRecommendParam){
        return depositService.addDepositRecommend(depositRecommendParam);
    }

    @PostMapping(value = "/product/deposit/recommend/update")
    public BasicResponse updateDepositRecommend(@RequestBody DepositRecommendParam depositRecommendParam){
        return depositService.updateDepositRecommend(depositRecommendParam);
    }

    @PostMapping(value = "/product/deposit/recommend/delete")
    public BasicResponse deleteDepositRecommend(@RequestParam Long id){
        return depositService.deleteDepositRecommend(id);
    }

    @GetMapping(value = "/product/deposit/recommend/get")
    public BasicResponse getDepositRecommend(){
        return depositService.getDepositRecommend();
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
