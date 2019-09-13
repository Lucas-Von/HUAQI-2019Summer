package financial_management.runner;

import financial_management.data.product.BondFundMapper;
import financial_management.entity.bond.BondFoundationPO;
import financial_management.entity.bond.BondPlatformPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/30 16:35
 * @Version 1.0
 **/
@Component
public class InitializationRunner implements ApplicationRunner {

    @Autowired
    BondFundMapper mapper;

    @Override
    public void run (
            ApplicationArguments args) {
        if(mapper.selectBondFundByName("national")==null){
            BondFoundationPO po = new BondFoundationPO();
            po.setDebtSum(1000.0F);
            po.setExpectReturnRate(0.2F);
            po.setFundName("national");
            po.setFundScale(200000F);
            po.setFundShare(1000F);
            po.setFundUnitValue(200F);
            po.setUpdateTime(new Timestamp(new Date().getTime()));
            mapper.insertBondFund(po);
        }
        if(mapper.selectBondFundByName("corporate")==null){
            BondFoundationPO po = new BondFoundationPO();
            po.setDebtSum(1000.0F);
            po.setExpectReturnRate(0.2F);
            po.setFundName("corporate");
            po.setFundScale(100000F);
            po.setFundShare(1000F);
            po.setFundUnitValue(100F);
            po.setUpdateTime(new Timestamp(new Date().getTime()));
            mapper.insertBondFund(po);
        }
        if(mapper.selectBondPlatform()==null){
            BondPlatformPO platform = new BondPlatformPO();
            platform.setBondAssets(300000F);
            platform.setResidualAssets(10000F);
            mapper.insertBondPlatform(platform);
        }
    }
}
