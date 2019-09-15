package financial_management.service.wallet;

import financial_management.bl.wallet.FundService4Wallet;
import financial_management.bl.wallet.WalletService;
import financial_management.data.wallet.WalletMapper;
import financial_management.entity.CardPO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.wallet.BalanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 13:44
 * @Version 1.0
 **/
@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    FundService4Wallet wallet;

    @Autowired
    WalletMapper mapper;

    @Override
    public void recharge(Double cost, Long userId) {
        wallet.IncreaseCapital(userId,cost);
    }

    @Override
    public BasicResponse payByCash(Long userId, Double cost, String password) {
        if(wallet.checkBalance(userId)>=cost) {
            wallet.DecreaseCapital(userId, cost);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,null);
        }
        return new BasicResponse<>(ResponseStatus.STATUS_BALANCE_LEAK,null);

    }

    @Override
    public BasicResponse withdraw(Long userId,Double cost, String cardId) {
        if(wallet.checkBalance(userId)>=cost) {
            wallet.DecreaseCapital(userId, cost);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,null);
        }
        return new BasicResponse<>(ResponseStatus.STATUS_BALANCE_LEAK,null);
    }

    @Override
    public boolean binding(Long userId, String cardId, String password) {
        //防止Null
        CardPO po = new CardPO();
        po.setCardnum(cardId);
        po.setUserId(userId);

        wallet.setPayPassword(userId,password);
        mapper.insertCard(po);
        return true;
    }

    @Override
    public BasicResponse checkBalance(Long userId) {
        Double balance = wallet.checkBalance(userId);
        BalanceVO vo = new BalanceVO();
        try {
            Optional<String> cardId = Optional.ofNullable(mapper.selectCardId(userId));
            vo.setCardid(cardId.orElse(""));
        }catch (Exception e ){
            vo.setCardid("");
        }
        vo.setBalance(new Double(balance).longValue());

        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vo);
    }

    @Override
    public void payByThird(Long cost, String password, Long userId, String cardId) {
        //校验密码，其他无

    }

    public void checkAccount(Long userId){
        if(mapper.exist(userId)==0){
            wallet.generateFund(userId);
        }
    }
}
