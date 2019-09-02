package financial_management.entity.property;

/**
 * @author lt
 * @version 1.0
 * @description 计算债券07/30/90天的收益率所需的信息
 * @date 2019/09/02 23:39
 */
public class BondIncomePO {

    /**
     * 当日净值
     */
    private double todayNetWorth;

    /**
     * days前净值
     */
    private double beforeDaysNetWorth;

    public double getTodayNetWorth() {
        return todayNetWorth;
    }

    public void setTodayNetWorth(double todayNetWorth) {
        this.todayNetWorth = todayNetWorth;
    }

    public double getBeforeDaysNetWorth() {
        return beforeDaysNetWorth;
    }

    public void setBeforeDaysNetWorth(double beforeDaysNetWorth) {
        this.beforeDaysNetWorth = beforeDaysNetWorth;
    }

}