package financial_management.vo.product;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 15:48
 * @Version 1.0
 **/
public class FundVO {

    Double amount;
    String name;
    Double rate;
    Date updateTime;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
