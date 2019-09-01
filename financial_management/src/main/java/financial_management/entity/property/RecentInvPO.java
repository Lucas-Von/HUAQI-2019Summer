package financial_management.entity.property;

/**
 * @author lt
 * @version 2.0
 * @description 用户最近两天的投资信息
 * @date 2019/08/23 22:30
 */
public class RecentInvPO {

    /**
     * 当前股票
     */
    private double currentStocks;

    /**
     * 当前股指
     */
    private double currentQdii;

    /**
     * 当前黄金
     */
    private double currentGold;

    /**
     * 当前债券
     */
    private double currentBond;

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

    public double getCurrentStocks() {
        return currentStocks;
    }

    public void setCurrentStocks(double currentStocks) {
        this.currentStocks = currentStocks;
    }

    public double getCurrentQdii() {
        return currentQdii;
    }

    public void setCurrentQdii(double currentQdii) {
        this.currentQdii = currentQdii;
    }

    public double getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(double currentGold) {
        this.currentGold = currentGold;
    }

    public double getCurrentBond() {
        return currentBond;
    }

    public void setCurrentBond(double currentBond) {
        this.currentBond = currentBond;
    }

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

}
