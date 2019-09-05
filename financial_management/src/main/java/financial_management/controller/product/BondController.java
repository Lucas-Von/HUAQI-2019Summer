package financial_management.controller.product;

import financial_management.parameter.bond.ReturnRateVO;
import financial_management.parameter.bond.bondFundInfoVO;
import financial_management.util.DateConverterUtil;
import financial_management.util.PyInvoke.PyParam.bond.BondsInfo;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{fundName}")
    public BasicResponse getInfo(@PathVariable String fundName){
        List<BondsInfo> infos = new ArrayList<>();
        BondsInfo info = new BondsInfo("债券1","111111",0.4F,10000F,14);
        infos.add(info);
        info = new BondsInfo("债券2","222222",0.35F,30000F,16);
        infos.add(info);
        info = new BondsInfo("债券3","333333",0.25F,20000F,11);
        infos.add(info);

        List<ReturnRateVO> sevenNetWorth = new ArrayList<>();
        List<ReturnRateVO> monthNetWorth = new ArrayList<>();
        List<ReturnRateVO> threeNetWorth = new ArrayList<>();
        for(int i = 0;i<7;i++) {
            ReturnRateVO vo = new ReturnRateVO(DateConverterUtil.moveForwardByDay(new Date(),-i),20.0F);
            sevenNetWorth.add(vo);
        }
        for(int i = 0;i<30;i++) {
            ReturnRateVO vo = new ReturnRateVO(DateConverterUtil.moveForwardByDay(new Date(),-i),20.0F);
            monthNetWorth.add(vo);
        }
        for(int i = 0;i<90;i++) {
            ReturnRateVO vo = new ReturnRateVO(DateConverterUtil.moveForwardByDay(new Date(),-i),20.0F);
            threeNetWorth.add(vo);
        }

        List<Float> returnRate = new ArrayList<>();
        returnRate.add(0.03F);
        returnRate.add(0.06F);
        returnRate.add(0.013F);
        List<Float> commissionRate = new ArrayList<>();
        commissionRate.add(0.015F);
        commissionRate.add(0.016F);
        commissionRate.add(0.013F);
        bondFundInfoVO vo = new bondFundInfoVO(sevenNetWorth,monthNetWorth,threeNetWorth,returnRate,new Date(),"Fin-mily家庭资产配置平台",1200000F,"开放购买/开放赎回",commissionRate,infos);
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS,vo);

    }
}
