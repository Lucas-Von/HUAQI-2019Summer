package financial_management.controller.product;

import financial_management.parameter.product.InsurancePurchaseParam;
import financial_management.vo.product.InsRecProductVO;
import financial_management.vo.product.MyInsuranceVO;
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
    @GetMapping(value = "/product/insurance")
    public ResponseEntity<?> MyInsurance(HttpServletRequest request){
        List<MyInsuranceVO> vos = new ArrayList<>();
        String dateString = "2020-02-23";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            MyInsuranceVO vo =new MyInsuranceVO("英大泰和","cxk","万能险",10000.0,2000.0,date);
            vos.add(vo);
            vo =new MyInsuranceVO("金盛人寿","cxk","分红险",30000.0,2000.0,date);
            vos.add(vo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(vos);
    }

    @GetMapping(value = "/product/insurance/recommend")
    public ResponseEntity<?> RecommendedProduct(HttpServletRequest request){
        List<InsRecProductVO> vos = new ArrayList<>();
        InsRecProductVO vo = new InsRecProductVO("金盛人寿","分红险",30000.0,2000.0,365);
        vos.add(vo);
        vo = new InsRecProductVO("英大泰和","全能险",20000.0,2000.0,365);
        vos.add(vo);
        return ResponseEntity.ok().body(vos);
    }

    @PostMapping(value = "/product/insurance")
    public ResponseEntity purchaseInsurance(@RequestBody InsurancePurchaseParam param, HttpServletRequest request){
        return ResponseEntity.ok().build();
    }
}
