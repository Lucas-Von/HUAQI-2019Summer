package financial_management.bl.stock;

import financial_management.FinancialManagementApplication;
import financial_management.service.property.estate.Stock_SorryIDontKnowWhereToPlace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class PythonInvokeTest {
    @Autowired
    Stock_SorryIDontKnowWhereToPlace service = new Stock_SorryIDontKnowWhereToPlace();

    @Test
    public void changeDomStockTest(){
        service.changeDomStock(1L);
    }
}
