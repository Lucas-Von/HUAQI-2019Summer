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
    private Date date;

    /**
     * 投资
     */
    private double invest;

    public InvestVO(Date date, double stocks, double gold, double bond) {
        this.date = date;
        this.invest = stocks + gold + bond;
    }

    public InvestVO() {

    }

    public Date getDate() {
        return date;
    }

    public double getInvest() {
        return invest;
    }

}
