package financial_management.service.wallet;

import financial_management.bl.wallet.FundService4Wallet;
import financial_management.bl.wallet.WalletService;
import financial_management.data.wallet.WalletMapper;
import financial_management.entity.CardPO;
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
    public void payByCash(Long userId,Double cost, String password) {
        wallet.DecreaseCapital(userId,cost);

    }

    @Override
    public void withdraw(Long userId,Double cost, String cardId) {
        //第三方接口
        wallet.DecreaseCapital(userId,cost);
    }

    @Override
    public boolean binding(Long userId, String cardId, String password) {
        //防止Null
        Optional<Integer> bindNum = Optional.ofNullable(mapper.exist(userId));
        Integer num = bindNum.orElse(0);
        if (num == 0){
            return true;
        }
        else{
            CardPO po = new CardPO();
            po.setCardnum(cardId);
            po.setUserId(userId);

            wallet.setPayPassword(userId,password);
            mapper.insertCard(po);
            return false;
        }
    }

    @Override
    public BalanceVO checkBalance(Long userId) {
        Double balance = wallet.checkBalance(userId);
        BalanceVO vo = new BalanceVO();
        Optional<String> cardId = Optional.ofNullable(mapper.selectCardId(userId));
        vo.setCardid(cardId.orElse(""));
        vo.setBalance(new Double(balance).longValue());
        return vo;
    }

    @Override
    public void payByThird(Long cost, String password, Long userId, String cardId) {
        //校验密码，其他无

    }
}
