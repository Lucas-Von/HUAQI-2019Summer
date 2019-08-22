package financial_management.bl.product;

import financial_management.vo.product.DepRecProductVO;
import financial_management.vo.product.FundBasicVO;
import financial_management.vo.product.FundVO;
import financial_management.vo.product.MyDepositVO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 16:56
 * @Version 1.0
 **/
public interface DepositService {

    List<MyDepositVO> getSelfDeposits(Long userId);

    List<DepRecProductVO> getAllDeposits();

    void purchase(Long userId,String productName,Double amount);
}
