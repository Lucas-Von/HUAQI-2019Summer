package financial_management.bl.product;

import financial_management.vo.order.ProductVO4Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/24 14:51
 * @Version 1.0
 **/
public interface ProductService4Order {

    public ProductVO4Order getProducts(Long id,String type);
}
