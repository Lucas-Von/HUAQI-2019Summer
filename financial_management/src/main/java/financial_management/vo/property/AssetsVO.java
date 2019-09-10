package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/18 19:01
 */
public class AssetsVO {

    /**
     * 现金
     */
    private double funds;

    /**
     * 储蓄
     */
    private double saving;

    /**
     * 保险
     */
    private double insurance;

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

    public AssetsVO() {

    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

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

    public InvestOfAssetsVO getInvestVO() {
        return new InvestOfAssetsVO(stocks, gold, qdii, bond);
    }

}