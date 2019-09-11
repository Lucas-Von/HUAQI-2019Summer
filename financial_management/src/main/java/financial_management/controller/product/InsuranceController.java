package financial_management.controller.product;

import financial_management.bl.product.InsuranceService;
import financial_management.parameter.product.InsuranceDeleteParam;
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
@RequestMapping
public class InsuranceController {

    @Autowired
    InsuranceService service;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = "/product/insurance")
    public BasicResponse MyInsurance(HttpServletRequest request){
        return service.getSelfProducts(jwtUtil.getIdFromRequest(request));
    }

    @GetMapping(value = "/product/insurance/recommend")
    public BasicResponse RecommendedProduct(HttpServletRequest request){
//        Long userId = jwtUtil.getIdFromRequest(request);
        return service.getRecommands(jwtUtil.getIdFromRequest(request));
    }

    @PostMapping(value = "/product/insurance")
    public BasicResponse purchaseProduct(@RequestBody List<MyInsuranceVO> param,HttpServletRequest request){
        return service.registerProduct(param,jwtUtil.getIdFromRequest(request));
    }

    @PutMapping(value = "/product/insurance")
    public BasicResponse updateProduct(HttpServletRequest request,@RequestBody MyInsuranceVO param){
        return service.update(param,jwtUtil.getIdFromRequest(request));
    }

    @DeleteMapping(value = "/product/insurance")
    public BasicResponse deleteProduct(HttpServletRequest request, @RequestBody InsuranceDeleteParam param){

        return  service.deleteProduct(jwtUtil.getIdFromRequest(request),param.getProductId());


    }

//
//    @PostMapping(value = "/product/insurance")
//    public BasicResponse purchaseInsurance(@RequestBody InsuranceDeleteParam param, HttpServletRequest request){
//        return  service.purchase(jwtUtil.getIdFromRequest(request),param.getName(),param.getInsurant());
//
//    }
}
