package financial_management.controller.product;

import financial_management.bl.product.BondService;
import financial_management.parameter.bond.ReturnRateVO;
import financial_management.parameter.bond.bondFundInfoVO;
import financial_management.util.DateConverterUtil;
import financial_management.util.JwtUtil;
import financial_management.util.PyInvoke.PyParam.bond.BondsInfo;
import financial_management.vo.ResponseStatus;
import financial_management.vo.BasicResponse;
import financial_management.vo.product.BondPurchaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/5 23:42
 * @Version 1.0
 **/
@RestController
@CrossOrigin
@RequestMapping(value = "/bondFundInfo")
public class BondController {

    @Autowired
    BondService service;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = "/{fundName}")
    public BasicResponse getInfo(@PathVariable String fundName){
        return service.getInfo(fundName);
    }

    @GetMapping(value = "/fundInfo/{fundName}")
    public BasicResponse getFundInfo(@PathVariable String fundName){
        return service.getFundInfo(fundName);
    }

    @GetMapping(value = "/exponent/{fundName}")
    public BasicResponse expo(@PathVariable String fundName){
        return service.exponent(fundName);
    }

    @GetMapping(value = "/user/fundInfo")
    public BasicResponse fundInfo(HttpServletRequest re){
        return service.userInfo(jwtUtil.getIdFromRequest(re));
    }

    @PostMapping(value = "/user/purchase")
    public BasicResponse userPurcharse(HttpServletRequest re,@RequestBody BondPurchaseVO vo){
        return service.adjustWarehouse(jwtUtil.getIdFromRequest(re),vo.getAmount());
    }

}
