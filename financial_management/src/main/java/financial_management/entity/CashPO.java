package financial_management.entity;

/**
 * @Description 用户现金
 * @Author 233loser
 * @Date 2019/8/14 13:18
 * @Version 1.0
 **/
public class CashPO {
    Long userId;
    /**
     * @Description //现金的总额
     **/
    Float amount;

    /**
     * @Description //所占总额的百分比
     **/
    Float percentage;

    /**
     * @Description //我的资产（不入库，调取时动态加载）
     **/
    MyFundPO fundPO;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MyFundPO getFundPO() {
        return fundPO;
    }

    public void setFundPO(MyFundPO fundPO) {
        this.fundPO = fundPO;
    }
}
