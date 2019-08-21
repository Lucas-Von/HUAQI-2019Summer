package financial_management.bl.product;

import financial_management.vo.product.InvestRecProductVO;
import financial_management.vo.product.InvestmentVO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 16:58
 * @Version 1.0
 **/
public interface InvestmentService {
    List<InvestmentVO> getSelfInvProduct(Long userId);

    List<InvestRecProductVO> getAllInvProduct();

    void purchase(Long userId,String code,Integer amount,Double totalprice,String type);

}
