package financial_management.vo.product;

/**
 * @author xyh
 * @date 2019/8/30
 */
public class MyGoldVO {
    private Long userId;
    private Integer amount;
    private Double diff;
    private Double sum;
    private Double profit;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getDiff() {
        return diff;
    }

    public void setDiff(Double diff) {
        this.diff = diff;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public MyGoldVO() {
    }

    public MyGoldVO(Long userId, Integer amount, Double diff, Double sum, Double profit) {
        this.userId = userId;
        this.amount = amount;
        this.diff = diff;
        this.sum = sum;
        this.profit = profit;
    }
}
