package financial_management.entity;

/**
 * @Description 用户持有的债券实体类
 * @Author 233loser
 * @Date 2019/8/14 12:56
 * @Version 1.0
 **/
public class MyBondPO {
    /**
     * @Description //用户Id
     **/
    Long userId;

    /**
     * @Description //债券代码
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
    Integer Quantity;

    /**
     * @Description //持有额
     **/
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

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
