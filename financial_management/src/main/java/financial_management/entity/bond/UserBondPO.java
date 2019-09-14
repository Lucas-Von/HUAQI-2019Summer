package financial_management.entity.bond;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/28 16:16
 * @Version 1.0
 **/
public class UserBondPO {

    Long userId;
    String fundName;
    Float bondProportion;
    Float fundShare;
    Float netWorth;
    Timestamp updateTime;
    Float inject;

    public Float getInject() {
        return inject;
    }

    public void setInject(Float inject) {
        this.inject = inject;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Float getBondProportion() {
        return bondProportion;
    }

    public void setBondProportion(Float bondProportion) {
        this.bondProportion = bondProportion;
    }

    public Float getFundShare() {
        return fundShare;
    }

    public void setFundShare(Float fundShare) {
        this.fundShare = fundShare;
    }

    public Float getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(Float netWorth) {
        this.netWorth = netWorth;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
