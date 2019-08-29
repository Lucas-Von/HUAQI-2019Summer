package financial_management.controller.product;

import financial_management.bl.product.InsuranceService;
import financial_management.entity.InsProductPO;
import financial_management.entity.MyInsPO;
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
    public BasicResponse MyInsurance(HttpServletRequest request) {
        List<MyInsPO> myInsurances = new ArrayList<>();
        MyInsPO myInsPO1 = new MyInsPO(5L, "cxk", 1L, new Date(), 20000f);
        MyInsPO myInsPO2 = new MyInsPO(1L, "xyh", 2L, new Date(), 2828f);
        myInsurances.add(myInsPO1);
        myInsurances.add(myInsPO2);
        List<MyInsuranceVO> vos = new ArrayList<>();
        if (myInsurances.size() > 0) {
            myInsurances.stream().forEach(o -> {
                MyInsuranceVO vo = new MyInsuranceVO(o);
                vos.add(vo);
            });
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @GetMapping(value = "/product/insurance/recommend")
    public BasicResponse RecommendedProduct(HttpServletRequest request) {
        List<InsProductPO> insProducts = new ArrayList<>();
        InsProductPO insProductPO1 = new InsProductPO();
        insProductPO1.setId(1L);
        insProductPO1.setName("金盛人寿");
        insProductPO1.setType("分红险");
        insProductPO1.setPrice(30000f);
        insProductPO1.setCompensation(2000f);
        insProductPO1.setLength(365);
        InsProductPO insProductPO2 = new InsProductPO();
        insProductPO2.setId(2L);
        insProductPO2.setName("英大泰和");
        insProductPO2.setType("全能险");
        insProductPO2.setPrice(25000f);
        insProductPO2.setCompensation(1400f);
        insProductPO2.setLength(365);
        insProducts.add(insProductPO1);
        insProducts.add(insProductPO2);
        List<InsRecProductVO> vos = new ArrayList<>();
        insProducts.stream().forEach(o->{
            InsRecProductVO vo = new InsRecProductVO(o);
            vos.add(vo);
        });
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @PostMapping(value = "/product/insurance")
    public BasicResponse purchaseInsurance(@RequestBody InsurancePurchaseParam param, HttpServletRequest request) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }
}
