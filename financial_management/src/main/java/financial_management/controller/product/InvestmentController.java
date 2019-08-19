package financial_management.controller.product;

import financial_management.parameter.product.InvestmentPurchaseParam;
import financial_management.vo.product.InvestRecProductVO;
import financial_management.vo.product.InvestmentVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 19:34
 * @Version 1.0
 **/
@CrossOrigin
@RestController
public class InvestmentController {
    @PostMapping(value = "/product/invest")
    public ResponseEntity<?> purchaseInvestment(HttpServletRequest request, @RequestBody InvestmentPurchaseParam param){
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/product/invest")
    public ResponseEntity<?> investConsult(HttpServletRequest request){
        List<InvestmentVO> investments = new ArrayList<>();
        InvestmentVO investment = new InvestmentVO("大唐发电","stock","601991",4.06,30000,120000.0,1800.0,0.06);
        investments.add(investment);
        investment = new InvestmentVO("东方财富","stock","300059",13.82,20000,260000.0,16400.0,0.063);
        investments.add(investment);
        investment = new InvestmentVO("国际现货黄金","gold","XAUUSD",1513.26,2000,3000000.0,26520.0,0.00884);
        investments.add(investment);
        investment = new InvestmentVO("19国债10","bond","019620",100.0,2000,3000000.0,2000.0,0.0386);
        investments.add(investment);
        return ResponseEntity.ok(investments);
    }

    @GetMapping(value = "/product/invest/recommend")
    public ResponseEntity<?> investRecommend(HttpServletRequest request){
        List<InvestRecProductVO> recs = new ArrayList<>();
        InvestRecProductVO vo = new InvestRecProductVO("大唐发电","601991",4.06);
        recs.add(vo);
        vo = new InvestRecProductVO("国际现货黄金","XAUUSD",1513.26);
        recs.add(vo);
        vo = new InvestRecProductVO("19国债10","019620",100.0);
        recs.add(vo);
        return ResponseEntity.ok().body(recs);

    }
}
