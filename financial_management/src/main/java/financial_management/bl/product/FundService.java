package financial_management.bl.product;

import financial_management.vo.BasicResponse;
import financial_management.vo.product.FundBasicVO;
import financial_management.vo.product.FundVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 16:55
 * @Version 1.0
 **/
public interface FundService {
    public FundVO getFund(Long userId);

    public FundBasicVO getBasicFund();

    public BasicResponse getMoreTraceInfo();
}
