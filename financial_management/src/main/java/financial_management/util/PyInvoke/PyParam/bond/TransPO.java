package financial_management.util.PyInvoke.PyParam.bond;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/2 21:50
 * @Version 1.0
 **/
public class TransPO {
    String code;
    Float purchase_amount;
    Integer purchase_quantity;
    Integer sign;
    Date time;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getPurchase_amount() {
        return purchase_amount;
    }

    public void setPurchase_amount(Float purchase_amount) {
        this.purchase_amount = purchase_amount;
    }

    public Integer getPurchase_quantity() {
        return purchase_quantity;
    }

    public void setPurchase_quantity(Integer purchase_quantity) {
        this.purchase_quantity = purchase_quantity;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
