package financial_management.entity.bond.transferPython;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/1 17:00
 * @Version 1.0
 **/
public class TransRecordCorporation {
    //用户Id
    Long id;
    //姓名;
    String product;
    //改变数量,不太一样
    Float amountchange;
    Integer sign;
    //手续费 也不太一样
    Float commission_amount_corporate;
    Date trans_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Float getAmountchange() {
        return amountchange;
    }

    public void setAmountchange(Float amountchange) {
        this.amountchange = amountchange;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Float getCommission_amount_corporate() {
        return commission_amount_corporate;
    }

    public void setCommission_amount_corporate(Float commission_amount_corporate) {
        this.commission_amount_corporate = commission_amount_corporate;
    }

    public Date getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(Date trans_time) {
        this.trans_time = trans_time;
    }
}
