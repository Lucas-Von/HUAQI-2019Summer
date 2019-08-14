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
}
