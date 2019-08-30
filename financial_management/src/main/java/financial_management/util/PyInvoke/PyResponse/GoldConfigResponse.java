package financial_management.util.PyInvoke.PyResponse;

/**
 * @author xyh
 * @date 2019/8/29
 */
public class GoldConfigResponse {
    /**
     * 即时配置价格
     */
    private double price2deploy;
    /**
     * 即时配置数量
     */
    private int account2deployed;
    /**
     * 即时配置成功金额
     */
    private double money2deployed;
    /**
     * 所有配置数量
     */
    private int accounet_all_deployed;
    /**
     * 所有配置金额
     */
    private double money_all_deployed;
    /**
     * 更新后的diff项
     */
    private double diff_all_deployed;

    public double getPrice2deploy() {
        return price2deploy;
    }

    public void setPrice2deploy(double price2deploy) {
        this.price2deploy = price2deploy;
    }

    public int getAccount2deployed() {
        return account2deployed;
    }

    public void setAccount2deployed(int account2deployed) {
        this.account2deployed = account2deployed;
    }

    public double getMoney2deployed() {
        return money2deployed;
    }

    public void setMoney2deployed(double money2deployed) {
        this.money2deployed = money2deployed;
    }

    public int getAccounet_all_deployed() {
        return accounet_all_deployed;
    }

    public void setAccounet_all_deployed(int accounet_all_deployed) {
        this.accounet_all_deployed = accounet_all_deployed;
    }

    public double getMoney_all_deployed() {
        return money_all_deployed;
    }

    public void setMoney_all_deployed(double money_all_deployed) {
        this.money_all_deployed = money_all_deployed;
    }

    public double getDiff_all_deployed() {
        return diff_all_deployed;
    }

    public void setDiff_all_deployed(double diff_all_deployed) {
        this.diff_all_deployed = diff_all_deployed;
    }

    public GoldConfigResponse() {
    }

    public GoldConfigResponse(double price2deploy,
                              int account2deployed,
                              double money2deployed,
                              int accounet_all_deployed,
                              double money_all_deployed,
                              double diff_all_deployed) {
        this.price2deploy = price2deploy;
        this.account2deployed = account2deployed;
        this.money2deployed = money2deployed;
        this.accounet_all_deployed = accounet_all_deployed;
        this.money_all_deployed = money_all_deployed;
        this.diff_all_deployed = diff_all_deployed;
    }
}
