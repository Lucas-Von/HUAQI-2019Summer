package financial_management.entity.bond;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/12 22:06
 * @Version 1.0
 **/
public class NetWorthPO {
    Long fundId;
    String fundName;
    Double netWorth;
    Date time;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(Double netWorth) {
        this.netWorth = netWorth;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
