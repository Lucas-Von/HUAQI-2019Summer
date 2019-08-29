package financial_management.controller.property;

import financial_management.bl.property.EstateService;
import financial_management.entity.property.DepositPO;
import financial_management.entity.property.FortunePO;
import financial_management.entity.property.InvestPO;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/20 16:43
 */
@CrossOrigin
@RestController
@RequestMapping("/property")
public class EstateController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EstateService estateService;

    @GetMapping("/estate/getOverview")
    public BasicResponse getOverviewByUser(HttpServletRequest request) {
        OverviewVO overviewVO = new OverviewVO(new Date(), 588.0, 688.0);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, overviewVO);
    }

    @GetMapping("/estate/getProperty")
    public BasicResponse getPropertyByUser(HttpServletRequest request) {
        EstateVO estateVO = new EstateVO(123, 88, 66, 2333, 100, 200, 666, 555, 444, 333, 222, 111);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, estateVO);
    }

    @GetMapping("/estate/getTotalIncome")
    public BasicResponse getTotalIncome(HttpServletRequest request) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, 8888);
    }

    @GetMapping("/estate/getNewlyIncome")
    public BasicResponse getNewlyIncome(HttpServletRequest request) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, 666);
    }

    @GetMapping("/estate/getDepositList")
    public BasicResponse getDepositList(HttpServletRequest request) {
        List<DepositPO> depositPOList = new ArrayList<>();
        List<DepositVO> depositVOList = new ArrayList<>();
        DepositPO depositPO1 = new DepositPO();
        depositPO1.setName("储蓄产品1");
        depositPO1.setMoney(888);
        depositPO1.setAnnualizedRate(0.56);
        depositPO1.setExpirationDate(new Date());
        DepositPO depositPO2 = new DepositPO();
        depositPO2.setName("储蓄产品2");
        depositPO2.setMoney(666);
        depositPO2.setAnnualizedRate(0.65);
        depositPO2.setExpirationDate(new Date());
        depositPOList.add(depositPO1);
        depositPOList.add(depositPO2);
        double accTotal = 0;
        for (DepositPO depositPO : depositPOList) {
            accTotal += depositPO.getMoney();
        }
        final double total = accTotal;
        depositPOList.stream().forEach(deposit -> {
            DepositVO depositVO = new DepositVO(deposit.getName(), deposit.getMoney(), total, deposit.getAnnualizedRate(), deposit.getExpirationDate());
            depositVOList.add(depositVO);
        });
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, depositVOList);
    }

    @GetMapping("/estate/getFundsInfoList")
    public BasicResponse getFundsInfoList(HttpServletRequest request) {
        SubEstateVO subEstateVO = new SubEstateVO(999, 100, 200);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subEstateVO);
    }

    @GetMapping("/estate/getSavingInfoList")
    public BasicResponse getSavingInfoList(HttpServletRequest request) {
        SubEstateVO subEstateVO = new SubEstateVO(999, 200, 100);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subEstateVO);
    }

    @GetMapping("/estate/getInsuranceInfoList")
    public BasicResponse getInsuranceInfoList(HttpServletRequest request) {
        SubEstateVO subEstateVO = new SubEstateVO(999, 150, 150);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subEstateVO);
    }

    @GetMapping("/estate/getInvestmentInfoList")
    public BasicResponse getInvestmentInfoList(HttpServletRequest request) {
        SubEstateVO subEstateVO = new SubEstateVO(999, 90, 9);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subEstateVO);
    }

    @GetMapping("/estate/getMonthlyProList")
    public BasicResponse getMonthlyProList(HttpServletRequest request) {
        List<FortunePO> monthlyFortunePOList = new ArrayList<>();
        List<FortuneVO> monthlyFortuneVOList = new ArrayList<>();
        FortunePO fortunePO1 = new FortunePO();
        fortunePO1.setRecordDate(new Date());
        fortunePO1.setFunds(25);
        fortunePO1.setSaving(50);
        fortunePO1.setInsurance(255);
        fortunePO1.setStocks(20);
        fortunePO1.setGold(66);
        fortunePO1.setBond(81);
        FortunePO fortunePO2 = new FortunePO();
        fortunePO2.setRecordDate(new Date());
        fortunePO2.setFunds(25);
        fortunePO2.setSaving(50);
        fortunePO2.setInsurance(255);
        fortunePO2.setStocks(20);
        fortunePO2.setGold(66);
        fortunePO2.setBond(81);
        monthlyFortunePOList.add(fortunePO1);
        monthlyFortunePOList.add(fortunePO2);
        monthlyFortunePOList.stream().forEach(monthlyFortunePO -> {
            FortuneVO monthlyFortuneVO = new FortuneVO(monthlyFortunePO.getRecordDate(), monthlyFortunePO.getFunds(), monthlyFortunePO.getSaving(), monthlyFortunePO.getInsurance(), monthlyFortunePO.getStocks(), monthlyFortunePO.getGold(), monthlyFortunePO.getBond());
            monthlyFortuneVOList.add(monthlyFortuneVO);
        });
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, monthlyFortuneVOList);
    }

    @GetMapping("/estate/getMonthlyInvList")
    public BasicResponse getMonthlyInvList(HttpServletRequest request) {
        List<InvestPO> monthlyInvestPOList = new ArrayList<>();
        List<InvestVO> monthlyInvestVOList = new ArrayList<>();
        InvestPO investPO1 = new InvestPO();
        investPO1.setRecordDate(new Date());
        investPO1.setStocks(255);
        investPO1.setGold(50);
        investPO1.setBond(25);
        InvestPO investPO2 = new InvestPO();
        investPO2.setRecordDate(new Date());
        investPO2.setStocks(105);
        investPO2.setGold(25);
        investPO2.setBond(88);
        monthlyInvestPOList.add(investPO1);
        monthlyInvestPOList.add(investPO2);
        monthlyInvestPOList.stream().forEach(monthlyInvestPO -> {
            InvestVO monthlyInvestVO = new InvestVO(monthlyInvestPO.getRecordDate(), monthlyInvestPO.getStocks(), monthlyInvestPO.getGold(), monthlyInvestPO.getBond());
            monthlyInvestVOList.add(monthlyInvestVO);
        });
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, monthlyInvestVOList);
    }

    @GetMapping("/estate/getDailyProList")
    public BasicResponse getDailyProList(HttpServletRequest request) {
        List<FortunePO> dailyFortunePOList = new ArrayList<>();
        List<FortuneVO> dailyFortuneVOList = new ArrayList<>();
        FortunePO fortunePO1 = new FortunePO();
        fortunePO1.setRecordDate(new Date());
        fortunePO1.setFunds(25);
        fortunePO1.setSaving(50);
        fortunePO1.setInsurance(255);
        fortunePO1.setStocks(20);
        fortunePO1.setGold(66);
        fortunePO1.setBond(81);
        FortunePO fortunePO2 = new FortunePO();
        fortunePO2.setRecordDate(new Date());
        fortunePO2.setFunds(25);
        fortunePO2.setSaving(50);
        fortunePO2.setInsurance(255);
        fortunePO2.setStocks(20);
        fortunePO2.setGold(66);
        fortunePO2.setBond(81);
        dailyFortunePOList.add(fortunePO1);
        dailyFortunePOList.add(fortunePO2);
        dailyFortunePOList.stream().forEach(dailyFortunePO -> {
            FortuneVO monthlyFortuneVO = new FortuneVO(dailyFortunePO.getRecordDate(), dailyFortunePO.getFunds(), dailyFortunePO.getSaving(), dailyFortunePO.getInsurance(), dailyFortunePO.getStocks(), dailyFortunePO.getGold(), dailyFortunePO.getBond());
            dailyFortuneVOList.add(monthlyFortuneVO);
        });
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, dailyFortuneVOList);
    }

    @GetMapping("/estate/getDailyInvList")
    public BasicResponse getDailyInvList(HttpServletRequest request) {
        List<InvestPO> dailyInvestPOList = new ArrayList<>();
        List<InvestVO> dailyInvestVOList = new ArrayList<>();
        InvestPO investPO1 = new InvestPO();
        investPO1.setRecordDate(new Date());
        investPO1.setStocks(255);
        investPO1.setGold(50);
        investPO1.setBond(25);
        InvestPO investPO2 = new InvestPO();
        investPO2.setRecordDate(new Date());
        investPO2.setStocks(105);
        investPO2.setGold(25);
        investPO2.setBond(88);
        dailyInvestPOList.add(investPO1);
        dailyInvestPOList.add(investPO2);
        dailyInvestPOList.stream().forEach(dailyInvestPO -> {
            InvestVO monthlyInvestVO = new InvestVO(dailyInvestPO.getRecordDate(), dailyInvestPO.getStocks(), dailyInvestPO.getGold(), dailyInvestPO.getBond());
            dailyInvestVOList.add(monthlyInvestVO);
        });
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, dailyInvestVOList);
    }

    @GetMapping("/estate/getMyRecAlloc")
    public BasicResponse getMyRecAlloc(HttpServletRequest request) {
        MyRecAllocVO myRecAllocVO = new MyRecAllocVO(0.25, 0.28, 0.22, 0.25);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, myRecAllocVO);
    }

}
