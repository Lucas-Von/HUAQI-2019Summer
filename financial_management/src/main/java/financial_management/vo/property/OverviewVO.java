package financial_management.vo.property;

import financial_management.entity.property.EstatePO;

import java.util.Date;

/**
 * @author lt
 * @date 2019/08/28 18:31
 */
public class OverviewVO {

    /**
     * 开始记录时间
     */
    private Date startRecordTime;

    /**
     * 资产净值
     */
    private double assetsEquity;

    /**
     * 资产总额
     */
    private double totalAssets;

    public OverviewVO(Date startRecordTime, double originAssets, double totalAssets) {
        this.startRecordTime = startRecordTime;
        this.totalAssets = totalAssets;
        this.assetsEquity = totalAssets / originAssets;
    }

    public OverviewVO() {

    }

    public Date getStartRecordTime() {
        return startRecordTime;
    }

    public double getAssetsEquity() {
        return assetsEquity;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

}
