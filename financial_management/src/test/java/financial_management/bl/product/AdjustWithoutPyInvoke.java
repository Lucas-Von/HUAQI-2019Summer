package financial_management.bl.product;

import financial_management.FinancialManagementApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class AdjustWithoutPyInvoke {
    @Autowired
    private StockService service;

    @Test
    public void changeDomStock_normal(){
        service.changeDomStock(1L);
    }
}
