package financial_management.util.PyInvoke.PyParam;

/**
 * @author xyh
 * @date 2019/8/29
 */
public class GoldConfigParam extends PyParam{
    /**
     * 已配置黄金ETF份额数（初配置取0）
     */
    private int account_already_deployed;
    /**
     * 在黄金资产中未配置diff（初配置取0）
     */
    private double diff_already_deployed;
    /**
     * 期望配置金额
     */
    private double money_expected_deployed;

    public int getAccount_already_deployed() {
        return account_already_deployed;
    }

    public void setAccount_already_deployed(int account_already_deployed) {
        this.account_already_deployed = account_already_deployed;
    }

    public double getDiff_already_deployed() {
        return diff_already_deployed;
    }

    public void setDiff_already_deployed(double diff_already_deployed) {
        this.diff_already_deployed = diff_already_deployed;
    }

    public double getMoney_expected_deployed() {
        return money_expected_deployed;
    }

    public void setMoney_expected_deployed(double money_expected_deployed) {
        this.money_expected_deployed = money_expected_deployed;
    }

    public GoldConfigParam() {
    }

    public GoldConfigParam(int account_already_deployed, double diff_already_deployed, double money_expected_deployed) {
        this.account_already_deployed = account_already_deployed;
        this.diff_already_deployed = diff_already_deployed;
        this.money_expected_deployed = money_expected_deployed;
    }
}
