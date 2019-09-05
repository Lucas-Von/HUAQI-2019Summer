package financial_management.util.PyInvoke.PyParam.bond;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 19:36
 * @Version 1.0
 **/
public class First_PurchasePO
{
    //国债投资比例
    Float prop_national;
    //企业债投资比例
    Float prop_corporate;
    //平台国债累计购买
    Float platform_accelerate_national;
    //平台企业债累计购买
    Float platform_accelerate_corporate;
    //国债变化金额
    Float amountchange_national;
    //企业债变化金额
    Float amountchange_corporate;
    //买卖标志
    Integer sign;
    //手续费
    Float commission_amount_national;
    //手续费
    Float commission_amount_corporate;
    //时间
    Date trans_time;
    //TODO 平台剩余现金资产呢


    public Float getProp_national() {
        return prop_national;
    }

    public void setProp_national(Float prop_national) {
        this.prop_national = prop_national;
    }

    public Float getProp_corporate() {
        return prop_corporate;
    }

    public void setProp_corporate(Float prop_corporate) {
        this.prop_corporate = prop_corporate;
    }

    public Float getPlatform_accelerate_national() {
        return platform_accelerate_national;
    }

    public void setPlatform_accelerate_national(Float platform_accelerate_national) {
        this.platform_accelerate_national = platform_accelerate_national;
    }

    public Float getPlatform_accelerate_corporate() {
        return platform_accelerate_corporate;
    }

    public void setPlatform_accelerate_corporate(Float platform_accelerate_corporate) {
        this.platform_accelerate_corporate = platform_accelerate_corporate;
    }

    public Float getAmountchange_national() {
        return amountchange_national;
    }

    public void setAmountchange_national(Float amountchange_national) {
        this.amountchange_national = amountchange_national;
    }

    public Float getAmountchange_corporate() {
        return amountchange_corporate;
    }

    public void setAmountchange_corporate(Float amountchange_corporate) {
        this.amountchange_corporate = amountchange_corporate;
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
