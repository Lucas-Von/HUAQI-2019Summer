package financial_management.entity.bond.transferPython;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 18:54
 * @Version 1.0
 **/
public class First_PurchaseVO {
    //债券期望收益率
    Float expected_rate;
    //国债收益率
    Float yieldrate_national;
    //企业债收益率
    Float yieldrate_corporate;
    //债券基金变化金额
    Float amount_change;
    //平台国债累计购买
    Float platform_accelerate_national;
    //平台企业债累计购买
    Float platform_accelerate_corporate;
    //为什么手续费率会是一个list????
    List<Float> commission_rate;

    public Float getExpected_rate() {
        return expected_rate;
    }

    public void setExpected_rate(Float expected_rate) {
        this.expected_rate = expected_rate;
    }

    public Float getYieldrate_national() {
        return yieldrate_national;
    }

    public void setYieldrate_national(Float yieldrate_national) {
        this.yieldrate_national = yieldrate_national;
    }

    public Float getYieldrate_corporate() {
        return yieldrate_corporate;
    }

    public void setYieldrate_corporate(Float yieldrate_corporate) {
        this.yieldrate_corporate = yieldrate_corporate;
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

    public List<Float> getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(List<Float> commission_rate) {
        this.commission_rate = commission_rate;
    }
}
