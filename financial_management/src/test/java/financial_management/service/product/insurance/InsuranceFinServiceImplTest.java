package financial_management.service.product.insurance;

import financial_management.FinancialManagementApplication;
import financial_management.entity.insurance.InsuranceRecommandPO;
import financial_management.entity.insurance.RecommandInsuranceParam;
import financial_management.entity.insurance.RecommandInsuranceResponse;
import financial_management.entity.insurance.SelfInsuranceProductPO;
import financial_management.util.DateConverterUtil;
import financial_management.util.PyInvoke.PyParam.PyParam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class InsuranceFinServiceImplTest {

    @Autowired
    InsuranceFinServiceImpl service;

    @Test
    public void getRecommands() {
//        List<InsuranceRecommandPO> responses = service.getRecommands(1L);
//        Assert.assertEquals("husband",responses.get(0).getRole());
    }


    @Test
    public void getRegisted() {
//        SelfInsuranceProductPO po = new SelfInsuranceProductPO(1L,"cxk","篮球险", DateConverterUtil.stringToDate("2019-12-11"),2000.0F,2000.0F,"我爱篮球");
//        service.registerProduct(po);
//        Assert.assertEquals("cxk",service.getRegisted(1L).get(0).getBeneficiary());
//        Assert.assertEquals(4,service.getRegisted(1L).size());
    }

    @Test
    public void recommand(){
        service.Recommand(1L,1989,1989,2f,2f,120000f,230000f,230000f,2000000f);
    }


}
