package financial_management.vo;

/**
 * @author lt
 * @date 2019/08/18 19:12
 */
public class InvestVO {

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

    public InvestVO(int stocks, int gold, int bond) {
        this.stocks = stocks;
        this.gold = gold;
        this.bond = bond;
    }

    public InvestVO() {
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getBond() {
        return bond;
    }

    public void setBond(int bond) {
        this.bond = bond;
    }
}
