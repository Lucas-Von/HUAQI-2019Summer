package financial_management.bl.product;

import financial_management.FinancialManagementApplication;
import financial_management.service.product.StockServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class PythonInvokeTest {
    @Autowired
    StockService service = new StockServiceImpl();

    @Test
    public void changeDomStockTest(){
        service.stockEstablish(1L);
    }
}
