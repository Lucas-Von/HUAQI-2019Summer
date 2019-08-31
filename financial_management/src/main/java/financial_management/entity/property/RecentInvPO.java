package financial_management.entity.property;

/**
 * @author lt
 * @version 1.0
 * @description 用户最近两天的投资信息
 * @date 2019/08/23 22:30
 */
public class RecentInvPO {

    /**
     * 昨日股票
     */
    private double yesterdayStocks;

    /**
     * 昨日股指
     */
    private double yesterdayQdii;

    /**
     * 昨日黄金
     */
    private double yesterdayGold;

    /**
     * 昨日债券
     */
    private double yesterdayBond;

    /**
     * 前日股票
     */
    private double dayBeforeYesterdayStocks;

    /**
     * 前日股指
     */
    private double dayBeforeYesterdayQdii;

    /**
     * 前日黄金
     */
    private double dayBeforeYesterdayGold;

    /**
     * 前日债券
     */
    private double dayBeforeYesterdayBond;

    public double getYesterdayStocks() {
        return yesterdayStocks;
    }

    public void setYesterdayStocks(double yesterdayStocks) {
        this.yesterdayStocks = yesterdayStocks;
    }

    public double getYesterdayQdii() {
        return yesterdayQdii;
    }

    public void setYesterdayQdii(double yesterdayQdii) {
        this.yesterdayQdii = yesterdayQdii;
    }

    public double getYesterdayGold() {
        return yesterdayGold;
    }

    public void setYesterdayGold(double yesterdayGold) {
        this.yesterdayGold = yesterdayGold;
    }

    public double getYesterdayBond() {
        return yesterdayBond;
    }

    public void setYesterdayBond(double yesterdayBond) {
        this.yesterdayBond = yesterdayBond;
    }

    public double getDayBeforeYesterdayStocks() {
        return dayBeforeYesterdayStocks;
    }

    public void setDayBeforeYesterdayStocks(double dayBeforeYesterdayStocks) {
        this.dayBeforeYesterdayStocks = dayBeforeYesterdayStocks;
    }

    public double getDayBeforeYesterdayQdii() {
        return dayBeforeYesterdayQdii;
    }

    public void setDayBeforeYesterdayQdii(double dayBeforeYesterdayQdii) {
        this.dayBeforeYesterdayQdii = dayBeforeYesterdayQdii;
    }

    public double getDayBeforeYesterdayGold() {
        return dayBeforeYesterdayGold;
    }

    public void setDayBeforeYesterdayGold(double dayBeforeYesterdayGold) {
        this.dayBeforeYesterdayGold = dayBeforeYesterdayGold;
    }

    public double getDayBeforeYesterdayBond() {
        return dayBeforeYesterdayBond;
    }

    public void setDayBeforeYesterdayBond(double dayBeforeYesterdayBond) {
        this.dayBeforeYesterdayBond = dayBeforeYesterdayBond;
    }

}
