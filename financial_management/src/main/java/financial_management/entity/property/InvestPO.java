package financial_management.entity.property;

import java.util.Date;

/**
 * @author lt
 * @version 1.0
 * @description 用户投资信息日志
 * @date 2019/08/23 11:30
 */
public class InvestPO {

    /**
     * 日期
     */
    private Date date;

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
