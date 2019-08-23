package financial_management.entity.property;

/**
 * @author lt
 * @version 1.0
 * @description 用户最近两天的投资信息
 * @date 2019/08/23 22:30
 */
public class RecentInvPO {

    /**
     * 今日股票
     */
    private double todayStocks;

    /**
     * 今日黄金
     */
    private double todayGold;

    /**
     * 今日债券
     */
    private double todayBond;

    /**
     * 昨日股票
     */
    private double yesterdayStocks;

    /**
     * 昨日黄金
     */
    private double yesterdayGold;

    /**
     * 昨日债券
     */
    private double yesterdayBond;

    public double getTodayStocks() {
        return todayStocks;
    }

    public void setTodayStocks(double todayStocks) {
        this.todayStocks = todayStocks;
    }

    public double getTodayGold() {
        return todayGold;
    }

    public void setTodayGold(double todayGold) {
        this.todayGold = todayGold;
    }

    public double getTodayBond() {
        return todayBond;
    }

    public void setTodayBond(double todayBond) {
        this.todayBond = todayBond;
    }

    public double getYesterdayStocks() {
        return yesterdayStocks;
    }

    public void setYesterdayStocks(double yesterdayStocks) {
        this.yesterdayStocks = yesterdayStocks;
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

}
