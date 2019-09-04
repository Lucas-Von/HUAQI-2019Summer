package financial_management.entity.bond.transferPython;

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
    Integer quantity;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
