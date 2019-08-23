package financial_management.entity.property;

import java.util.Date;

/**
 * @author lt
 * @version 1.0
 * @description 用户资产信息日志
 * @date 2019/08/23 11:30
 */
public class FortunePO {

    /**
     * 日期
     */
    private Date date;

    /**
     * 现金
     */
    private double funds;

    /**
     * 储蓄
     */
    private double saving;

    /**
     * 保险
     */
    private double insurance;

    /**
     * 股票
     */
    private double stocks;

    /**
     * 黄金
     */
    private double gold;

    /**
     * 债券
     */
    private double bond;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getStocks() {
        return stocks;
    }

    public void setStocks(double stocks) {
        this.stocks = stocks;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getBond() {
        return bond;
    }

    public void setBond(double bond) {
        this.bond = bond;
    }

}
