package financial_management.service.product.bond;

import financial_management.FinancialManagementApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class BondServiceImplTest {
    @Autowired
    BondServiceImpl service;

    @Test
    public void firstPurchase() {
        service.firstPurchase(1L,0.2,20000F);
    }

    @Test
    public void adjustWarehouse() {
        service.adjustWarehouse(1L,10000F);
    }

    @Test
    public void adjustWarehouse2() {
        service.adjustWarehouse(1L,-10000F);
    }

    @Test
    public void dailyPurchase() {
        service.dailyPurchase();
    }

    @Test
    public void dailyUpdate() {
        service.dailyUpdate();
    }

    @Test
    public void exponent() {
        service.exponent("national");
    }

    @Test
    public void info(){service.getFundInfo("national");}
}