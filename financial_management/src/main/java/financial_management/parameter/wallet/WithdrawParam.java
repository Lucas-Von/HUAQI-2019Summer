package financial_management.parameter.wallet;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 13:46
 * @Version 1.0
 **/
public class WithdrawParam {

    Double cost;
    String cardid;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}
