package financial_management.entity;

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

    /**
     * @Author jyh
     * @Description //收益率，不入库，有FundPO所在库动态加载
     **/
    Float rate;
    /**
     * @Description //用户支付密码
     **/
    String payPassword;

    /**
     *
     * @return 累计收益
     */
    Float accuringAmount;

    Float lastRevenue;

    public Float getLastRevenue() {
        return lastRevenue;
    }

    public void setLastRevenue(Float lastRevenue) {
        this.lastRevenue = lastRevenue;
    }

    public Float getAccuringAmount() {
        return accuringAmount;
    }

    public void setAccuringAmount(Float accuringAmount) {
        this.accuringAmount = accuringAmount;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
