package financial_management.parameter.wallet;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 13:40
 * @Version 1.0
 **/
public class PaymentParam {
    Double cost;
    String pay_password;

    public String getPay_password() {
        return pay_password;
    }

    public void setPay_password(String pay_password) {
        this.pay_password = pay_password;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
