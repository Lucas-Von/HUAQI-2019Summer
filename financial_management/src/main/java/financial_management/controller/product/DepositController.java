package financial_management.controller.product;

import financial_management.parameter.product.DepositPurchaseParam;
import financial_management.vo.product.DepRecProductVO;
import financial_management.vo.product.MyDepositVO;
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
 * @Date 2019/8/18 19:33
 * @Version 1.0
 **/
@CrossOrigin
@RestController
public class DepositController {

    @GetMapping(value = "/product/deposit")
    public ResponseEntity<?> MyDeposit(HttpServletRequest request){
        List<MyDepositVO> vos = new ArrayList<>();
        String dateString = "2020-02-23";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            MyDepositVO vo = new MyDepositVO("产品1","type1",20000.0,0.035,date);
            vos.add(vo);
            vo = new MyDepositVO("产品2","type2",130000.0,0.05,date);
            vos.add(vo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(vos);
    }


    @GetMapping(value = "/product/deposit/recommend")
    public ResponseEntity<?> RecommendDepProduct(HttpServletRequest request){
        List<DepRecProductVO> vos = new ArrayList<>();
        DepRecProductVO vo = new DepRecProductVO("产品1",200,0.03);
        vos.add(vo);
        vo = new DepRecProductVO("产品2",1200,0.08);
        vos.add(vo);
        return ResponseEntity.ok().body(vos);
    }

    @PostMapping(value = "/product/deposit")
    public ResponseEntity<?> purchaseDepositProduct(@RequestBody DepositPurchaseParam param){
        return ResponseEntity.ok().build();
    }
}
