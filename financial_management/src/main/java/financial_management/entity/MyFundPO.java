package financial_management.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 用户持有的基金类
 * @Author 233loser
 * @Date 2019/8/13 21:59
 * @Version 1.0
 **/
public class MyFundPO {
    /**
     * @Author jyh
     * @Description //用户ID
     **/
    Long userId;

    /**
     * @Author jyh
     * @Description //持有金额
     **/
    Float balance;

    /**
     * @Author jyh
     * @Description //余额更新时间
     **/
    Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
