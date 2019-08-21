package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/18 19:01
 */
public class AssetsVO {
    /**
     * 现金
     */
    private int funds;

    /**
     * 储蓄
     */
    private int saving;

    /**
     * 保险
     */
    private int insurance;

    /**
     * 股票
     */
    private int stocks;

    /**
     * 黄金
     */
    private int gold;

    /**
     * 债券
     */
    private int bond;

    public AssetsVO() {

    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setBond(int bond) {
        this.bond = bond;
    }

    public InvestVO getInvestVO() {
        return new InvestVO(stocks, gold, bond);
    }

}
