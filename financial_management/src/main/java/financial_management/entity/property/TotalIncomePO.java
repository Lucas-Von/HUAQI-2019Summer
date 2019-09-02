package financial_management.entity.property;

/**
 * @author lt
 * @version 1.0
 * @description 计算累计收益率所需信息
 * @date 2019/09/01 20:37
 */
public class TotalIncomePO {

    /**
     * 账户内股票资产额
     */
    private double totalStocks;

    /**
     * 账户内股指资产额
     */
    private double totalQdii;

    /**
     * 账户内黄金资产额
     */
    private double totalGold;

    /**
     * 账户内黄金资产额
     */
    private double totalBond;

    public double getTotalStocks() {
        return totalStocks;
    }

    public void setTotalStocks(double totalStocks) {
        this.totalStocks = totalStocks;
    }

    public double getTotalQdii() {
        return totalQdii;
    }

    public void setTotalQdii(double totalQdii) {
        this.totalQdii = totalQdii;
    }

    public double getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(double totalGold) {
        this.totalGold = totalGold;
    }

    public double getTotalBond() {
        return totalBond;
    }

    public void setTotalBond(double totalBond) {
        this.totalBond = totalBond;
    }

}
