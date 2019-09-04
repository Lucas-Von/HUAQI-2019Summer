package financial_management.vo.property;

import java.util.Date;

/**
 * @author lt
 * @date 2019/09/03 16:25
 */
public class IncomeRateVO {

    /**
     * 日期
     */
    private Date date;

    /**
     * 收益率
     */
    private double averageIncomeRate;

    public IncomeRateVO(Date date, double averageIncomeRate) {
        this.date = date;
        this.averageIncomeRate = averageIncomeRate;
    }

    public IncomeRateVO() {

    }

    public Date getDate() {
        return date;
    }

    public double getAverageIncomeRate() {
        return averageIncomeRate;
    }

}