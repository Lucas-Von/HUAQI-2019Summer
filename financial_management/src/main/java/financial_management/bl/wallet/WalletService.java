package financial_management.bl.wallet;

import financial_management.vo.BasicResponse;
import financial_management.vo.wallet.BalanceVO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 13:26
 * @Version 1.0
 **/
public interface WalletService {
    /**
     * @Author jyh
     * @Description //账户充值，需调用product模块fund接口
    * @Date 13:30 2019/8/20
     * @Param [cost, userId]
     * @return void
     **/
    public void recharge(Double cost,Long userId);

    /**
     * @Author jyh
     * @Description //支付接口，逻辑上减去开销和支付
     * @Date 13:32 2019/8/20
     * @Param [cost, password]
     * @return void
     **/
    public BasicResponse payByCash(Long userId, Double cost, String password);

    /**
     * @Author jyh
     * @Description //提现接口
     * @Date 13:33 2019/8/20
     * @Param [cost, cardId]
     * @return void
     **/
    public BasicResponse withdraw(Long userId,Double cost,String cardId);

    /**
     * @Author jyh
     * @Description //TODO 
     * @Date 13:37 2019/8/20
     * @Param 
     * @return 
     **/
    public boolean binding(Long userId,String cardId,String password);

    public BasicResponse checkBalance(Long userId);

    public void payByThird(Long cost,String password,Long userId,String cardId);
}
