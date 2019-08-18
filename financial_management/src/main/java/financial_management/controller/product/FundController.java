package financial_management.controller.product;

import financial_management.vo.product.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 14:28
 * @Version 1.0
 **/
@CrossOrigin
@RestController
public class FundController {


    @GetMapping(value = "/product/imf")
    public ResponseEntity<?> getFund(HttpServletRequest request){
        FundVO fund = new FundVO();
        fund.setAmount(20000.0);
        fund.setName("并夕夕");
        fund.setRate(0.036);
        String dateString = "2018-02-23";
        try{
        Date date= new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        fund.setUpdateTime(date);}
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(fund);
    }
    @GetMapping(value = "/product/imf/all")
    public ResponseEntity<?> getFundBasicInfo(){
        FundBasicVO vo  = new FundBasicVO();
        vo.setName("并夕夕");
        vo.setRate(0.036);
        return ResponseEntity.ok().body(vo);
    }


}
