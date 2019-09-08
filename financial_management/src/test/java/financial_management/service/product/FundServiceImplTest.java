package financial_management.service.product;

import financial_management.FinancialManagementApplication;
import org.junit.Test;

import static org.junit.Assert.*;
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
public class FundServiceImplTest {

    @Autowired
    FundServiceImpl service;

    @Test
    public void generate(){
        service.generateFund(2L);
        service.setPayPassword(2L,"kkkkkk");
    }

    @Test
    public void increaseCapital() {
        service.IncreaseCapital(2L,2000D);

    }

    @Test
    public void decreaseCapital() {
    }

    @Test
    public void checkBalance() {
       System.out.println(service.getFund(2L).getAmount().floatValue());
    }

    @Test
    public void checkPayPassword() {

    }

    @Test
    public void getFund() {
    }

    @Test
    public void getBasicFund() {
    }
}