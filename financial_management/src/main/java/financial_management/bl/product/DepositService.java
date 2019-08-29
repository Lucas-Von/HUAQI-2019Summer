package financial_management.bl.product;

import financial_management.entity.DepositRecommendPO;
import financial_management.parameter.product.DepositRecommendParam;
import financial_management.parameter.product.SelfDepositParam;
import financial_management.vo.BasicResponse;
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
    /**
     * 查看拥有的储蓄产品
     * @param userId
     * @return
     */
    BasicResponse getSelfDeposits(Long userId);

    /**
     * 用户添加一储蓄产品
     * @param selfDepositParam
     * @return
     */
    BasicResponse addSelfDeposit(SelfDepositParam selfDepositParam, Long userId);

    /**
     * 用户更新一储蓄产品
     * @param selfDepositParam
     * @return
     */
    BasicResponse updateSelfDeposit(SelfDepositParam selfDepositParam);

    /**
     * 用户删除一储蓄产品
     * @param id
     * @return
     */
    BasicResponse deleteSelfDeposit(Long id);

    /**
     * 添加一个推荐储蓄产品
     * @param depositRecommendParam
     * @return
     */
    BasicResponse addDepositRecommend(DepositRecommendParam depositRecommendParam);

    /**
     * 更新一个推荐储蓄产品
     * @param depositRecommendParam
     * @return
     */
    BasicResponse updateDepositRecommend(DepositRecommendParam depositRecommendParam);

    /**
     * 删除一个推荐储蓄产品
     * @param id
     * @return
     */
    BasicResponse deleteDepositRecommend(Long id);

    /**
     * 查看所有的推荐储蓄产品
     * @return
     */
    BasicResponse getDepositRecommend();

    /**
     * 查看所有储蓄产品（弃用）
     * @return
     */
    List<DepRecProductVO> getAllDeposits();

    /**
     * 购买储蓄产品（弃用）
     * @param userId
     * @param productName
     * @param amount
     * @return
     */
    boolean purchase(Long userId,String productName,Double amount);
}
