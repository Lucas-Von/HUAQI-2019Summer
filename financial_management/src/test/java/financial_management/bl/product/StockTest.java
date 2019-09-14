package financial_management.bl.product;

import financial_management.FinancialManagementApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class StockTest {
    @Autowired
    private StockService stockService;

    @Before
    public void setUp(){

    }

    @Test
    @Transactional
    public void QDIIEstablish_normal(){
        long userID = 1L;
        stockService.firstQDII(userID);
    }
}
