package financial_management.vo.property;

import java.util.Date;

/**
 * @author lt
 * @date 2019/08/23 11:42
 */
public class InvestVO {

    /**
     * 日期
     */
    private Date recordDate;

    /**
     * 投资
     */
    private double invest;

    public InvestVO(Date recordDate, double stocks, double gold, double bond) {
        this.recordDate = recordDate;
        this.invest = stocks + gold + bond;
    }

    public InvestVO() {

    }

    public Date getRecordDate() {
        return recordDate;
    }

    public double getInvest() {
        return invest;
    }

}
