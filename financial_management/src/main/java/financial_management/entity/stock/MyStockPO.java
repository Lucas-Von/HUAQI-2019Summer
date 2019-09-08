package financial_management.entity.stock;

/**
 * @Description 用户持有的股票实体类
 * @Author 233loser
 * @Date 2019/8/14 12:44
 * @Version 1.0
 **/
public class MyStockPO {
    /**
     * @Description //用户Id
     **/
    Long userId;

    /**
     * @Description //股票代码
     **/
    String code;

    /**
     * @Description //购买价格
     **/
    Float purchasePrice;

    Integer purchaseAmount;

    Float purchaseTotal;

    /**
     * @Description 单位持有成本价
     */
    Float holdPrice;

    /**
     * @Description //持有数量
     **/
    Float holdAmount;

    /**
     * @Description //持有额
     **/
    Float holdTotal;

    Float profit;

    Float profitRate;

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

    public Float getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(float holdAmount) {
        this.holdAmount = holdAmount;
    }

    public Float getHoldTotal() {
        return holdTotal;
    }

    public void setHoldTotal(Float holdTotal) {
        this.holdTotal = holdTotal;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Float getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Float purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public Float getHoldPrice() {
        return holdPrice;
    }

    public void setHoldPrice(Float holdPrice) {
        this.holdPrice = holdPrice;
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
}
