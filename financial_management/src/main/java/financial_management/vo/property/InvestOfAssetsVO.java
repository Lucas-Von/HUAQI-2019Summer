package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/18 19:12
 */
public class InvestOfAssetsVO {

    /**
     * 股票
     */
    private double stocks;

    /**
     * 股指
     */
    private double qdii;

    /**
     * 黄金
     */
    private double gold;

    /**
     * 债券
     */
    private double bond;

    public InvestOfAssetsVO(double stocks, double qdii, double gold, double bond) {
        this.stocks = stocks;
        this.qdii = qdii;
        this.gold = gold;
        this.bond = bond;
    }

    public InvestOfAssetsVO() {

    }

    public double getStocks() {
        return stocks;
    }

    public double getQdii() {
        return qdii;
    }

    public double getGold() {
        return gold;
    }

    public double getBond() {
        return bond;
    }

}
