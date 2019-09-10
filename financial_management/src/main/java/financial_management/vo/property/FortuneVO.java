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
    private Date recordDate;

    /**
     * 资产
     */
    private double asset;

    public FortuneVO(Date recordDate, double funds, double saving, double insurance, double stocks, double qdii, double gold, double bond) {
        this.recordDate = recordDate;
        this.asset = funds + saving + insurance + stocks + qdii + gold + bond;
    }

    public FortuneVO() {

    }

    public Date getRecordDate() {
        return recordDate;
    }

    public double getAsset() {
        return asset;
    }

}