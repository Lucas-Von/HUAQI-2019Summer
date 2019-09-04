package financial_management.bl.product;

import financial_management.FinancialManagementApplication;
import financial_management.vo.product.InvestmentVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class InvestmentTest {
    @Autowired
    private InvestmentService investmentService;
    @Autowired
    private StockService stockService;

    @Test
    public void test1(){
        List<InvestmentVO> result = investmentService.getSelfInvProduct(1L);
        System.out.println(result.size());
    }


    @Test
    public void getStockByUser_normal(){
        assertEquals(999,stockService.getTotalStockByUser(1),1);
    }

    @Test
    public void getQDIIByUser_normal(){
        assertEquals(999,stockService.getTotalQDIIByUser(1),1);
    }

}
