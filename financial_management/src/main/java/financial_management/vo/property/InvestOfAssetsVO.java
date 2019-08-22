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
     * 黄金
     */
    private double gold;

    /**
     * 债券
     */
    private double bond;

    public InvestOfAssetsVO(double stocks, double gold, double bond) {
        this.stocks = stocks;
        this.gold = gold;
        this.bond = bond;
    }

    public InvestOfAssetsVO() {

    }

    public double getStocks() {
        return stocks;
    }

    public void setStocks(double stocks) {
        this.stocks = stocks;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getBond() {
        return bond;
    }

    public void setBond(double bond) {
        this.bond = bond;
    }
}
