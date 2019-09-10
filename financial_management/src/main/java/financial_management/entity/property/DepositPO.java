package financial_management.entity.property;

import java.util.Date;

/**
 * @author lt
 * @version 1.0
 * @description 储蓄产品类
 * @date 2019/08/22
 */
public class DepositPO {

    /**
     * 储蓄产品名称
     */
    private String name;

    /**
     * 产品已购金额
     */
    private double money;

    /**
     * 年化收益率
     */
    private double annualizedRate;

    /**
     * 产品到期时间
     */
    private Date expirationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getAnnualizedRate() {
        return annualizedRate;
    }

    public void setAnnualizedRate(double annualizedRate) {
        this.annualizedRate = annualizedRate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}