package financial_management.util.PyInvoke.PyParam.bond;

import financial_management.util.PyInvoke.PyParam.PyParam;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 18:47
 * @Version 1.0
 **/
public class AdjuestmentVO  extends PyParam {
    Float prop_national;
    Float prop_corporate;
    Float amount_change;
    Float platform_accelerate_national;
    Float platform_accelerate_corporate;
    List<Float> commission_rate;
    Float fund_cash;

    public Float getFund_cash() {
        return fund_cash;
    }

    public void setFund_cash(Float fund_cash) {
        this.fund_cash = fund_cash;
    }

    public List<Float> getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(List<Float> commission_rate) {
        this.commission_rate = commission_rate;
    }

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

    public Float getAmount_change() {
        return amount_change;
    }

    public void setAmount_change(Float amount_change) {
        this.amount_change = amount_change;
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
    public AdjuestmentVO(){

    }

    public AdjuestmentVO(Float prop_national, Float prop_corporate, Float amount_change, Float platform_accelerate_national, Float platform_accelerate_corporate, List<Float> commission_rate, Float fund_cash) {
        this.prop_national = prop_national;
        this.prop_corporate = prop_corporate;
        this.amount_change = amount_change;
        this.platform_accelerate_national = platform_accelerate_national;
        this.platform_accelerate_corporate = platform_accelerate_corporate;
        this.commission_rate = commission_rate;
        this.fund_cash = fund_cash;
    }
}
