package financial_management.util.PyInvoke.PyParam.bond;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 20:51
 * @Version 1.0
 **/
public class TransRecordNational {
    //用户Id
    String id;
    //姓名;
    String name;
    //改变数量,不太一样
    Float amountchange;
    Integer sign;
    //手续费 也不太遥远
    Float commission_amount_national;
    Date trans_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Float getCommission_amount_national() {
        return commission_amount_national;
    }

    public void setCommission_amount_national(Float commission_amount_national) {
        this.commission_amount_national = commission_amount_national;
    }

    public Date getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(Date trans_time) {
        this.trans_time = trans_time;
    }
}
