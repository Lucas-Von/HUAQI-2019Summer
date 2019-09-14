package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/09/14 21:16
 */
public class QuestResWithInvRateVO {

    /**
     * 股票投资比例
     */
    private double stocksRate;

    /**
     *股指投资比例
     */
    private double qdiiRate;

    /**
     * 黄金投资比例
     */
    private double goldRate;

    /**
     * 债券投资比例
     */
    private double bondRate;

    public QuestResWithInvRateVO(double stocksRate, double qdiiRate, double goldRate, double bondRate) {
        this.stocksRate = stocksRate;
        this.qdiiRate = qdiiRate;
        this.goldRate = goldRate;
        this.bondRate = bondRate;
    }

    public QuestResWithInvRateVO() {

    }

    public double getStocksRate() {
        return stocksRate;
    }

    public double getQdiiRate() {
        return qdiiRate;
    }

    public double getGoldRate() {
        return goldRate;
    }

    public double getBondRate() {
        return bondRate;
    }

}