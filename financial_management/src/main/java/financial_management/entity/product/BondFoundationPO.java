package financial_management.entity.product;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/28 18:14
 * @Version 1.0
 **/
public class BondFoundationPO {
    Long id;
    String fundName;
    //总份额
    Float fundShare;
    //基金规模
    Float fundScale;
    Float fundUnitValue;
    Float expectReturnRate;
    Timestamp updateTime;
    Float debtSum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Float getFundShare() {
        return fundShare;
    }

    public void setFundShare(Float fundShare) {
        this.fundShare = fundShare;
    }

    public Float getFundScale() {
        return fundScale;
    }

    public void setFundScale(Float fundScale) {
        this.fundScale = fundScale;
    }

    public Float getFundUnitValue() {
        return fundUnitValue;
    }

    public void setFundUnitValue(Float fundUnitValue) {
        this.fundUnitValue = fundUnitValue;
    }

    public Float getExpectReturnRate() {
        return expectReturnRate;
    }

    public void setExpectReturnRate(Float expectReturnRate) {
        this.expectReturnRate = expectReturnRate;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Float getDebtSum() {
        return debtSum;
    }

    public void setDebtSum(Float debtSum) {
        this.debtSum = debtSum;
    }
}
