package financial_management.vo.property;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lt
 * @date 2019/08/22
 */
public class DepositVO {

    /**
     * 产品名称
     */
    private String name;

    /**
     * 已购金额
     */
    private double money;

    /**
     * 占比
     */
    private double rate;

    /**
     * 年化收益率
     */
    private double annualizedRate;

    /**
     * 到期时间
     */
    private Date expirationDate;

    /**
     * 距到期日
     */
    private int distance;

    public DepositVO(String name, double money, double total, double annualizedRate, Date expirationDate) {
        this.name = name;
        this.money = money;
        this.rate = money / total;
        this.annualizedRate = annualizedRate;
        this.expirationDate = expirationDate;
        this.distance = daysBetween(new Date(), expirationDate);
    }


    /**
     * 计算两个日期之间相差的天数
     */
    public static int daysBetween(Date smallDate, Date bigDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smallDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bigDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }


    public DepositVO() {

    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public double getRate() {
        return rate;
    }

    public double getAnnualizedRate() {
        return annualizedRate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getDistance() {
        return distance;
    }

}
