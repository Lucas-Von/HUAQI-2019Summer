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
    }

    @Test
    public void adjustWarehouse() {
    }

    @Test
    public void dailyPurchase() {
    }

    @Test
    public void dailyUpdate() {
    }

    @Test
    public void exponent() {
        service.exponent("national");
    }
}