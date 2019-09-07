package financial_management.entity.stock;

public class MyQDIIPO {
    private Long userId;

    private String code;

    private Float holdPrice;

    private Integer holdNum;

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

    public Float getHoldPrice() {
        return holdPrice;
    }

    public void setHoldPrice(Float holdPrice) {
        this.holdPrice = holdPrice;
    }

    public Integer getHoldNum() {
        return holdNum;
    }

    public void setHoldNum(Integer holdNum) {
        this.holdNum = holdNum;
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
