package financial_management.vo.property;

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
     * 资产更新时间
     */
    private Date fortuneUpdateTime;

    /**
     * 资产净值
     */
    private double assetsEquity;

    /**
     * 资产总额
     */
    private double totalAssets;

    public OverviewVO(Date startRecordTime, Date fortuneUpdateTime, double originAssets, double totalAssets) {
        this.startRecordTime = startRecordTime;
        this.fortuneUpdateTime = fortuneUpdateTime;
        this.totalAssets = totalAssets;
        this.assetsEquity = totalAssets / originAssets;
    }

    public OverviewVO() {

    }

    public Date getStartRecordTime() {
        return startRecordTime;
    }

    public Date getFortuneUpdateTime() {
        return fortuneUpdateTime;
    }

    public double getAssetsEquity() {
        return assetsEquity;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

}