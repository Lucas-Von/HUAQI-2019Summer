package financial_management.entity;

import java.util.List;

/**
 * @Description 用户储蓄实体类
 * @Author 233loser
 * @Date 2019/8/14 10:19
 * @Version 1.0
 **/
public class DepositPO {

    /**
     * @Description //用户ID
     */
    Long userId;

    /**
     * @Description //储蓄的总额
     **/
    Float amount;

    /**
     * @Description //所占总额的百分比
     **/
    Float percentage;

    /**
     * @Description //用户商品部分。不入库，调用时动态加载MyDepoPO
     **/
    List<MyDepoPO> depoProducts;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<MyDepoPO> getDepoProducts() {
        return depoProducts;
    }

    public void setDepoProducts(List<MyDepoPO> depoProducts) {
        this.depoProducts = depoProducts;
    }

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
