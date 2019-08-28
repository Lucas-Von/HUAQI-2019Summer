package financial_management.controller.product;

import financial_management.bl.product.InsuranceService;
import financial_management.parameter.product.InsurancePurchaseParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.product.InsRecProductVO;
import financial_management.vo.product.MyInsuranceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 19:34
 * @Version 1.0
 **/
@CrossOrigin
@RestController
public class InsuranceController {

    @Autowired
    InsuranceService service;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = "/product/insurance")
    public BasicResponse MyInsurance(HttpServletRequest request){
        List<MyInsuranceVO> vos = service.getMyInsurance(jwtUtil.getIdFromRequest(request));

        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vos);
    }

    @GetMapping(value = "/product/insurance/recommend")
            public BasicResponse RecommendedProduct(HttpServletRequest request){
        List<InsRecProductVO> vos = service.getAllInsProduct();
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vos);
    }

    @PostMapping(value = "/product/insurance")
    public BasicResponse purchaseInsurance(@RequestBody InsurancePurchaseParam param, HttpServletRequest request){
        return  service.purchase(jwtUtil.getIdFromRequest(request),param.getName(),param.getInsurant());

    }
}
