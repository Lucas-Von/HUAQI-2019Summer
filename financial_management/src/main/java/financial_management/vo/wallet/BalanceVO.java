package financial_management.vo.wallet;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 14:01
 * @Version 1.0
 **/
public class BalanceVO {
    Long balance;
    String cardid;

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}
