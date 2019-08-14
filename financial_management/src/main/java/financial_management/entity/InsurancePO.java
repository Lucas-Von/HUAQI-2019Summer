package financial_management.entity;

import java.util.List;

/**
 * @Description 保险PO
 * @Author 233loser
 * @Date 2019/8/14 13:08
 * @Version 1.0
 **/
public class InsurancePO {
    /**
     * @Description //保险的总额
     **/
    Float amount;

    /**
     * @Description //所占总额的百分比
     **/
    Float percentage;

    /**
     * @Description //我的商品，不入库
     **/
    List<MyInsPO> insuranceProducts;



    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public List<MyInsPO> getInsuranceProducts() {
        return insuranceProducts;
    }

    public void setInsuranceProducts(List<MyInsPO> insuranceProducts) {
        this.insuranceProducts = insuranceProducts;
    }
}
