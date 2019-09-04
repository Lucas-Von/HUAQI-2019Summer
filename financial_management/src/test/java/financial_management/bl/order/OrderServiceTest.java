package financial_management.bl.order;

import financial_management.FinancialManagementApplication;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.PlatformTradeVO;
import financial_management.vo.order.ProductVO4Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class OrderServiceTest {
    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    private PersonalTradeVO personalTradeVO;

    private PlatformTradeVO platformTradeVO;

    {
        personalTradeVO = new PersonalTradeVO();
        personalTradeVO.setCreateTime(new Date());
        personalTradeVO.setType(OrderService.Type.DOMSTOCK);
        personalTradeVO.setProduct(new ProductVO4Order(1L, "name", "123456"));
        personalTradeVO.setAmount(100);
        personalTradeVO.setPrice(1.0f);
        personalTradeVO.setFee(0.0f);
        personalTradeVO.setTotal(100.0f);
        personalTradeVO.setUserID(1);

        platformTradeVO = new PlatformTradeVO();
        platformTradeVO.setProduct("不知道");
        platformTradeVO.setPrice(1.0f);
        platformTradeVO.setAmount(1);
        platformTradeVO.setTotal(1.1f);
        platformTradeVO.setRealTotal(1.0f);
        platformTradeVO.setTime(new Date());
    }

    @Test
    public void testInsertPersonalTrade() {
        BasicResponse response = orderService.addPersonalTradeRecord(personalTradeVO, false);
        assertEquals(ResponseStatus.STATUS_SUCCESS,response.getStatus());
    }

    @Test
    public void testInsertPersonalTrade_IDSetNull(){
        personalTradeVO.setID(null);
        BasicResponse response = orderService.addPersonalTradeRecord(personalTradeVO, false);
        System.out.println(response.getStatus().code);
        assertEquals(ResponseStatus.STATUS_SUCCESS,response.getStatus());
    }

    @Test
    public void testInsertPlatformTrade() {
        BasicResponse response = orderService.addPlatformTradeRecord(platformTradeVO);
        System.out.println(response.getStatus().code);
        assertEquals(ResponseStatus.STATUS_SUCCESS,response.getStatus());
    }
}
