package financial_management.controller.product;

import financial_management.bl.product.FundService;
import financial_management.entity.FundPO;
import financial_management.entity.MyFundPO;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.product.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    FundService fundService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = "/product/imf")
    public BasicResponse getFund(HttpServletRequest request){
        FundVO fund = fundService.getFund(jwtUtil.getIdFromRequest(request));
        MyFundPO myFundPO = new MyFundPO();
        myFundPO.setUserId(5L);
        myFundPO.setBalance(2000f);
        myFundPO.setUpdateTime(new Date());
        myFundPO.setRate(0.8f);
        myFundPO.setPayPassword("123456");
        FundPO fundPO = new FundPO("并夕夕", 0.0548f, new Date());
        FundVO fundVO = new FundVO(myFundPO, fundPO);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, fundVO);
    }
    @GetMapping(value = "/product/imf/all")
    public BasicResponse getFundBasicInfo(){
        FundPO fundPO = new FundPO("并夕夕", 0.0548f, new Date());
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new FundBasicVO(fundPO));
    }


}
