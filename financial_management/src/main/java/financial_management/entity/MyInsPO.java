package financial_management.entity;

import java.util.Date;

/**
 * @Description 用户持有的保险产品
 * @Author 233loser
 * @Date 2019/8/14 11:03
 * @Version 1.0
 **/
public class MyInsPO {

    /**
     * @Description //用户Id
     **/
    Long userId;

    /**
     * @Description //受保人
     **/
    String beneficiary;

    /**
     * @Description //保险产品Id
     **/
    Long productId;

    /**
     * @Description //到期时间
     **/

    Date maturity;
    /**
     * @Description //产品名，不入库
     **/
    String name;

    /**
     * @Description //类别，不入库
     **/
    String type;

    /**
     * @Description //购买金额
     **/
    Float price;

    /**
     * @Description //当前最高保额，不入库
     **/
    Float Compensation;

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

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCompensation() {
        return Compensation;
    }

    public void setCompensation(Float compensation) {
        Compensation = compensation;
    }
}
