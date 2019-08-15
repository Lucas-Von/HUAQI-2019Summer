package financial_management.entity;

import java.util.Date;

/**
 * @Description 用户储蓄产品实体类
 * @Author 233loser
 * @Date 2019/8/14 13:20
 * @Version 1.0
 **/
public class MyDepoPO {
    /**
     * @Description //用户Id
     **/
    Long userId;

    /**
     * @Description //产品Id
     **/
    Long productId;

    /**
     * @Description //持有额度
     **/
    Float amount;

    /**
    * @Description //到期时间
     **/
    Date maturity;

    /**
     * @Description //类别，不入库，由productID sql加载
     **/
    String type;

    /**
     * @Description //名称，不入库，由productID sql加载
     **/
    String name;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
