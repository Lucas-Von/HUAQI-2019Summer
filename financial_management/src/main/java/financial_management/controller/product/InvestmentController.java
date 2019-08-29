package financial_management.controller.product;

import financial_management.bl.product.InvestmentService;
import financial_management.entity.*;
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
    public BasicResponse purchaseInvestment(HttpServletRequest request, @RequestBody InvestmentPurchaseParam param) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @GetMapping(value = "/product/invest")
    public BasicResponse investConsult(HttpServletRequest request) {
        List<InvestmentVO> investments = new ArrayList<>();
        MyGoldPO myGoldPO1 = new MyGoldPO();
        myGoldPO1.setUserId(5L);
        myGoldPO1.setCode("XAUUSD");
        myGoldPO1.setPurchasePrice(20000f);
        myGoldPO1.setProfit(200f);
        myGoldPO1.setProfitRate(0.03f);
        myGoldPO1.setQuantity(2000);
        myGoldPO1.setAmount(23123f);
        GoldPO goldPO1 = new GoldPO();
        goldPO1.setId(1L);
        goldPO1.setName("国际现货黄金");
        goldPO1.setCode("XAUUSD");
        goldPO1.setLatestPrice(1513.26f);
        InvestmentVO investmentVO1 = new InvestmentVO(goldPO1.getName(), "黄金", myGoldPO1.getCode(), goldPO1.getLatestPrice().doubleValue(), myGoldPO1.getQuantity(), myGoldPO1.getAmount().doubleValue(), myGoldPO1.getProfit().doubleValue(), myGoldPO1.getProfitRate().doubleValue());
        MyGoldPO myGoldPO2 = new MyGoldPO();
        myGoldPO2.setUserId(1L);
        myGoldPO2.setCode("JAUUSD");
        myGoldPO2.setPurchasePrice(2828f);
        myGoldPO2.setProfit(66f);
        myGoldPO2.setProfitRate(0.05f);
        myGoldPO2.setQuantity(666);
        myGoldPO2.setAmount(8888f);
        GoldPO goldPO2 = new GoldPO();
        goldPO2.setId(2L);
        goldPO2.setName("国际现货黄金");
        goldPO2.setCode("JAUUSD");
        goldPO2.setLatestPrice(2828.66f);
        InvestmentVO investmentVO2 = new InvestmentVO(goldPO2.getName(), "黄金", myGoldPO2.getCode(), goldPO2.getLatestPrice().doubleValue(), myGoldPO2.getQuantity(), myGoldPO2.getAmount().doubleValue(), myGoldPO2.getProfit().doubleValue(), myGoldPO2.getProfitRate().doubleValue());

        MyBondPO myBondPO = new MyBondPO();
        myBondPO.setUserId(2L);
        myBondPO.setCode("019620");
        myBondPO.setPurchasePrice(30000f);
        myBondPO.setProfit(100f);
        myBondPO.setProfitRate(0.003f);
        myBondPO.setQuantity(23000);
        myBondPO.setAmount(234234f);
        BondPO bondPO = new BondPO();
        bondPO.setId(1L);
        bondPO.setName("19国债10");
        bondPO.setCode("019620");
        bondPO.setLatestPrice(100f);
        InvestmentVO investmentVO3 = new InvestmentVO(bondPO.getName(), "债券", myBondPO.getCode(), bondPO.getLatestPrice().doubleValue(), myBondPO.getQuantity(), myBondPO.getAmount().doubleValue(), myBondPO.getProfit().doubleValue(), myBondPO.getProfitRate().doubleValue());

        MyStockPO myStockPO1 = new MyStockPO();
        myStockPO1.setUserId(5L);
        myStockPO1.setCode("601991");
        myStockPO1.setPurchasePrice(20003f);
        myStockPO1.setProfit(2123f);
        myStockPO1.setProfitRate(0.043f);
        myStockPO1.setQuantity(200);
        myStockPO1.setAmount(23133f);
        DomStockPO domStockPO = new DomStockPO();
        domStockPO.setId(1L);
        domStockPO.setName("大唐发电");
        domStockPO.setCode("601991");
        domStockPO.setLatestPrice(4.06f);
        InvestmentVO investmentVO4 = new InvestmentVO(domStockPO.getName(), "国内股票", myStockPO1.getCode(), domStockPO.getLatestPrice().doubleValue(), myStockPO1.getQuantity(), myStockPO1.getAmount().doubleValue(), myStockPO1.getProfit().doubleValue(), myStockPO1.getProfitRate().doubleValue());

        MyStockPO myStockPO2 = new MyStockPO();
        myStockPO2.setUserId(5L);
        myStockPO2.setCode("601991");
        myStockPO2.setPurchasePrice(20003f);
        myStockPO2.setProfit(2123f);
        myStockPO2.setProfitRate(0.043f);
        myStockPO2.setQuantity(200);
        myStockPO2.setAmount(23133f);
        ForStockPO forStockPO = new ForStockPO();
        forStockPO.setId(2L);
        forStockPO.setName("外方财富");
        forStockPO.setCode("613991");
        forStockPO.setLatestPrice(14.06f);
        InvestmentVO investmentVO5 = new InvestmentVO(forStockPO.getName(), "海外股票", myStockPO2.getCode(), forStockPO.getLatestPrice().doubleValue(), myStockPO2.getQuantity(), myStockPO2.getAmount().doubleValue(), myStockPO2.getProfit().doubleValue(), myStockPO2.getProfitRate().doubleValue());

        investments.add(investmentVO1);
        investments.add(investmentVO2);
        investments.add(investmentVO3);
        investments.add(investmentVO4);
        investments.add(investmentVO5);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, investments);
    }

    @GetMapping(value = "/product/invest/recommend")
    public BasicResponse investRecommend(HttpServletRequest request) {
        List<InvestRecProductVO> invests = new ArrayList<>();
        GoldPO goldPO1 = new GoldPO();
        goldPO1.setId(1L);
        goldPO1.setName("国际现货黄金");
        goldPO1.setCode("XAUUSD");
        goldPO1.setLatestPrice(1513.26f);
        GoldPO goldPO2 = new GoldPO();
        goldPO2.setId(2L);
        goldPO2.setName("国际现货黄金");
        goldPO2.setCode("JAUUSD");
        goldPO2.setLatestPrice(2828.66f);
        InvestRecProductVO investRecProductVO1 = new InvestRecProductVO(goldPO1.getName(),goldPO1.getCode(),goldPO1.getLatestPrice().doubleValue());
        InvestRecProductVO investRecProductVO2 = new InvestRecProductVO(goldPO2.getName(),goldPO2.getCode(),goldPO2.getLatestPrice().doubleValue());

        BondPO bondPO = new BondPO();
        bondPO.setId(1L);
        bondPO.setName("19国债10");
        bondPO.setCode("019620");
        bondPO.setLatestPrice(100f);
        InvestRecProductVO investRecProductVO3 = new InvestRecProductVO(bondPO.getName(),bondPO.getCode(),bondPO.getLatestPrice().doubleValue());

        DomStockPO domStockPO = new DomStockPO();
        domStockPO.setId(1L);
        domStockPO.setName("大唐发电");
        domStockPO.setCode("601991");
        domStockPO.setLatestPrice(4.06f);
        InvestRecProductVO investRecProductVO4 = new InvestRecProductVO(domStockPO.getName(),domStockPO.getCode(),domStockPO.getLatestPrice().doubleValue());

        ForStockPO forStockPO = new ForStockPO();
        forStockPO.setId(2L);
        forStockPO.setName("外方财富");
        forStockPO.setCode("613991");
        forStockPO.setLatestPrice(14.06f);
        InvestRecProductVO vo = new InvestRecProductVO(forStockPO.getName(),forStockPO.getCode(),forStockPO.getLatestPrice().doubleValue());

        invests.add(investRecProductVO1);
        invests.add(investRecProductVO2);
        invests.add(investRecProductVO3);
        invests.add(investRecProductVO4);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, invests);

    }
}
