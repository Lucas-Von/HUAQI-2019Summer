package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/22 11:41
 */
public class InvestOfEstateVO {

    /**
     * 用户平台内股票数额
     */
    private double stocksInPlatform;

    /**
     * 用户平台外股票数额
     */
    private double stocksOutPlatform;

    /**
     * 用户平台内黄金数额
     */
    private double goldInPlatform;

    /**
     * 用户平台外黄金数额
     */
    private double goldOutPlatform;

    /**
     * 用户平台内债券数额
     */
    private double bondInPlatform;

    /**
     * 用户平台外债券数额
     */
    private double bondOutPlatform;

    public InvestOfEstateVO(double stocksInPlatform, double stocksOutPlatform, double goldInPlatform, double goldOutPlatform, double bondInPlatform, double bondOutPlatform) {
        this.stocksInPlatform = stocksInPlatform;
        this.stocksOutPlatform = stocksOutPlatform;
        this.goldInPlatform = goldInPlatform;
        this.goldOutPlatform = goldOutPlatform;
        this.bondInPlatform = bondInPlatform;
        this.bondOutPlatform = bondOutPlatform;
    }

    public InvestOfEstateVO() {

    }

    public double getStocksInPlatform() {
        return stocksInPlatform;
    }

    public double getStocksOutPlatform() {
        return stocksOutPlatform;
    }

    public double getGoldInPlatform() {
        return goldInPlatform;
    }

    public double getGoldOutPlatform() {
        return goldOutPlatform;
    }

    public double getBondInPlatform() {
        return bondInPlatform;
    }

    public double getBondOutPlatform() {
        return bondOutPlatform;
    }

}
