package financial_management.entity;

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
}
