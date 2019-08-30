package financial_management.entity;

/**
 * @Description 用户持有的黄金实体类
 * @Author 233loser
 * @Date 2019/8/14 12:50
 * @Version 1.0
 **/
public class MyGoldPO {
    /**
     * @Description //用户Id
     **/
    Long userId;

    /**
     * @Description //黄金代码
     **/
    String code;

    /**
     * @Description //购买价格，用于计算累计盈亏额
     **/
    Float purchasePrice;

    /**
     * @Description //累计盈亏额
     **/
    Float profit;

    /**
     * @Description //累计盈亏率
     **/
    Float profitRate;

    /**
     * @Description //持有数量
     **/
    Float quantity;

    /**
     * @Description //持有额
     **/
    Float amount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }

    public Float getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(Float profitRate) {
        this.profitRate = profitRate;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
