package financial_management.entity.property;

/**
 * @author lt
 * @version 2.0
 * @description 用户资产信息
 * @date 2019/08/13 14:25
 */
public class EstatePO {

    /**
     * 用户平台内现金数额
     */
    private double fundsInPlatform;

    /**
     * 用户平台外现金数额
     */
    private double fundsOutPlatform;

    /**
     * 用户平台外储蓄数额
     */
    private double savingOutPlatform;

    /**
     * 用户平台外保险数额
     */
    private double insuranceOutPlatform;

    /**
     * 用户平台内股票数额
     */
    private double stocksInPlatform;

    /**
     * 用户平台内股指数额
     */
    private double qdiiInPlatform;

    /**
     * 用户平台内黄金数额
     */
    private double goldInPlatform;

    /**
     * 用户平台内债券数额
     */
    private double bondInPlatform;

    /**
     * 用户平台内投资数额
     */
    private double investInPlatform;

    /**
     * 用户平台外投资数额
     */
    private double investOutPlatform;

    public double getFundsInPlatform() {
        return fundsInPlatform;
    }

    public void setFundsInPlatform(double fundsInPlatform) {
        this.fundsInPlatform = fundsInPlatform;
    }

    public double getFundsOutPlatform() {
        return fundsOutPlatform;
    }

    public void setFundsOutPlatform(double fundsOutPlatform) {
        this.fundsOutPlatform = fundsOutPlatform;
    }

    public double getSavingOutPlatform() {
        return savingOutPlatform;
    }

    public void setSavingOutPlatform(double savingOutPlatform) {
        this.savingOutPlatform = savingOutPlatform;
    }

    public double getInsuranceOutPlatform() {
        return insuranceOutPlatform;
    }

    public void setInsuranceOutPlatform(double insuranceOutPlatform) {
        this.insuranceOutPlatform = insuranceOutPlatform;
    }

    public void setStocksInPlatform(double stocksInPlatform) {
        this.stocksInPlatform = stocksInPlatform;
    }

    public void setQdiiInPlatform(double qdiiInPlatform) {
        this.qdiiInPlatform = qdiiInPlatform;
    }

    public void setGoldInPlatform(double goldInPlatform) {
        this.goldInPlatform = goldInPlatform;
    }

    public void setBondInPlatform(double bondInPlatform) {
        this.bondInPlatform = bondInPlatform;
    }

    public double getInvestInPlatform() {
        return stocksInPlatform + qdiiInPlatform + goldInPlatform + bondInPlatform;
    }

    public double getInvestOutPlatform() {
        return investOutPlatform;
    }

    public void setInvestOutPlatform(double investOutPlatform) {
        this.investOutPlatform = investOutPlatform;
    }

}