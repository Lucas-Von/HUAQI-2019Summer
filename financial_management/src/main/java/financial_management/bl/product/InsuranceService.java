package financial_management.bl.product;

import financial_management.vo.product.InsRecProductVO;
import financial_management.vo.product.MyInsuranceVO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 16:58
 * @Version 1.0
 **/
public interface InsuranceService {

    List<MyInsuranceVO> getMyInsurance(Long userId);

    List<InsRecProductVO> getAllInsProduct();

    void purchase(Long userId,String name,String insurant);

}
