package financial_management.service.product.bond;

import financial_management.bl.order.OrderService;
import financial_management.data.product.BondFundMapper;
import financial_management.entity.bond.*;
import financial_management.util.PyInvoke.PyParam.bond.*;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.PlatformTradeVO;
import financial_management.vo.order.ProductVO4Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/3 22:04
 * @Version 1.0
 **/
public interface BondServiceForBl {
    Double getAmountByUser(Long userId);


}
