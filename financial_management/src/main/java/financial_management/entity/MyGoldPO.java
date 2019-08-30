package financial_management.entity;

/**
 * @Description 用户持有的黄金实体类
 * @Author 233loser
 * @Date 2019/8/14 12:50
 * @Version 1.0
 **/
public class MyGoldPO {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 所有配置数量
     */
    private Integer amount;
    /**
     * 剩余未买黄金的钱
     */
    private Double diff;
    /**
     * 所有配置金额
     */
    private Double sum;

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

    public MyGoldPO() {
    }

    public MyGoldPO(Long userId, Integer amount, Double diff, Double sum) {
        this.userId = userId;
        this.amount = amount;
        this.diff = diff;
        this.sum = sum;
    }
}
