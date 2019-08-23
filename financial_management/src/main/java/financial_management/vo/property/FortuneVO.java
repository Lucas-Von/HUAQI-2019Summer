package financial_management.vo.property;

import java.util.Date;

/**
 * @author lt
 * @date 2019/08/23 11:34
 */
public class FortuneVO {

    /**
     * 日期
     */
    private Date date;

    /**
     * 资产
     */
    private double asset;

    public FortuneVO(Date date, double funds, double saving, double insurance, double stocks, double gold, double bond) {
        this.date = date;
        this.asset = funds + saving + insurance + stocks + gold + bond;
    }

    public FortuneVO() {

    }

    public Date getDate() {
        return date;
    }

    public double getAsset() {
        return asset;
    }

}
