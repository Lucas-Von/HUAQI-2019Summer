package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/09/10 20:32
 */
public class SubInvestVO {

    /**
     * 投资项
     */
    private String subInvItem;

    /**
     * 数额
     */
    private double money;

    /**
     * 占比
     */
    private double rate;

    /**
     * 累计盈亏
     */
    private double totalIncome;

    public SubInvestVO(String subInvItem, double money, double invest, double totalIncome) {
        this.subInvItem = subInvItem;
        this.money = money;
        this.rate = money / invest;
        this.totalIncome = totalIncome;
    }

    public SubInvestVO() {

    }

    public String getSubInvItem() {
        return subInvItem;
    }

    public double getMoney() {
        return money;
    }

    public double getRate() {
        return rate;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

}