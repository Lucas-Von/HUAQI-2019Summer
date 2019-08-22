package financial_management.controller.product;

import financial_management.bl.product.InvestmentService;
import financial_management.parameter.product.InvestmentPurchaseParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.product.InvestRecProductVO;
import financial_management.vo.product.InvestmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 19:34
 * @Version 1.0
 **/
@CrossOrigin
@RestController
public class InvestmentController {

    @Autowired
    InvestmentService service;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(value = "/product/invest")
    public BasicResponse purchaseInvestment(HttpServletRequest request, @RequestBody InvestmentPurchaseParam param){

        service.purchase(jwtUtil.getIdFromRequest(request),param.getCode(),param.getAmount(), param.getTotalprice(), param.getType());

        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,null);
    }

    @GetMapping(value = "/product/invest")
    public BasicResponse investConsult(HttpServletRequest request){
        List<InvestmentVO> investments = service.getSelfInvProduct(jwtUtil.getIdFromRequest(request));
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,investments);
    }

    @GetMapping(value = "/product/invest/recommend")
    public BasicResponse investRecommend(HttpServletRequest request){
        List<InvestRecProductVO> recs = service.getAllInvProduct();
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,recs);

    }
}
