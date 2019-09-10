package financial_management.entity.property;

/**
 * @author lt
 * @version 1.0
 * @description 用户各项投资的金额
 * @date 2019/09/10 20:29
 */
public class SubInvestPO {

    /**
     * 股票数额
     */
    private double stocks;

    /**
     * 股指数额
     */
    private double qdii;

    /**
     * 黄金数额
     */
    private double gold;

    /**
     * 债券数额
     */
    private double bond;

    /**
     * 总投资额
     */
    private double invest;

    public double getStocks() {
        return stocks;
    }

    public void setStocks(double stocks) {
        this.stocks = stocks;
    }

    public double getQdii() {
        return qdii;
    }

    public void setQdii(double qdii) {
        this.qdii = qdii;
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

    public double getInvest() {
        return (stocks + qdii + gold + bond);
    }

}