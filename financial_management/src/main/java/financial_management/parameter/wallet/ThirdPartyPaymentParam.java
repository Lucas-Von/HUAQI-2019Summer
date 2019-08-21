package financial_management.parameter.wallet;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 14:06
 * @Version 1.0
 **/
public class ThirdPartyPaymentParam {

    String pay_password;
    Long cost;
    String cardid;

    public String getPay_password() {
        return pay_password;
    }

    public void setPay_password(String pay_password) {
        this.pay_password = pay_password;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}
