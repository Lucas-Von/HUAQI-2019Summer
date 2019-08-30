package financial_management.entity;

import financial_management.vo.product.GoldHistoryConfigVO;

import java.sql.Timestamp;

/**
 * @author xyh
 * @date 2019/8/30
 */
public class GoldHistoryConfigPO {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 当时配置价格
     */
    private Double price;
    /**
     * 当时配置数量
     */
    private Integer amount;
    /**
     * 当时该份配置成功金额
     */
    private Double sum;
    /**
     * 当时配置时间
     */
    private Timestamp time;
    /**
     * 买入：0；卖出：1
     */
    private Integer status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public GoldHistoryConfigVO getGoldHistoryConfigVO(){
        return new GoldHistoryConfigVO(userId, price, amount, sum, time, status);
    }

    public GoldHistoryConfigPO() {
    }

    public GoldHistoryConfigPO(Long userId, Double price, Integer amount, Double sum, Timestamp time, Integer status) {
        this.userId = userId;
        this.price = price;
        this.amount = amount;
        this.sum = sum;
        this.time = time;
        this.status = status;
    }
}
