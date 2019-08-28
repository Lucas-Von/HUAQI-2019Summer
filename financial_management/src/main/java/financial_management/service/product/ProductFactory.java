package financial_management.service.product;

import financial_management.bl.product.InsuranceService;
import financial_management.bl.product.ProductService4Order;
import financial_management.vo.order.ProductVO4Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.Proxy;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/24 14:48
 * @Version 1.0
 **/
@Service
public class ProductFactory implements ProductService4Order {

    @Autowired DepositServiceImpl deposit;

    @Autowired FundServiceImpl fund;

    @Autowired InvestmentServiceImpl investment;

    @Autowired InsuranceServiceImpl insurance;

    @Override
    public ProductVO4Order getProducts(Long id, String type) {
        switch (type){
            case "fund":return fund.getProduct(null);
            case "deposit":return deposit.getProduct(id);
            case "insurance":return insurance.getProduct(id);
            default:return investment.getProduct(id,type);
        }
    }
}
