package financial_management.entity;

public class MyQDIIPO {
    private Long userId;

    private String code;

    private Float purchasePrice;

    private Float purchaseAmount;

    private Float purchaseTotal;

    private Float holdPrice;

    private Float holdAmount;

    private Float holdTotal;

    private Float profit;

    private Float profitRate;

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

    public Float getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Float purchaseAmount) {
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

    public Float getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(Float holdAmount) {
        this.holdAmount = holdAmount;
    }

    public Float getHoldTotal() {
        return holdTotal;
    }

    public void setHoldTotal(Float holdTotal) {
        this.holdTotal = holdTotal;
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
