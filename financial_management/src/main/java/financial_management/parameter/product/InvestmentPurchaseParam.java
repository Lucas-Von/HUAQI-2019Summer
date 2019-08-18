package financial_management.parameter.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:45
 * @Version 1.0
 **/
public class InvestmentPurchaseParam {

    String code;
    Integer amount;
    Double totalprice;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }
}
