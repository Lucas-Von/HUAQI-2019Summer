package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/13 14:30
 */
public class EstateVO {

    /**
     * 用户资产总额
     */
    private double totalAsset;

    /**
     * 用户平台内现金数额
     */
    private double fundsInPlatform;

    /**
     * 用户平台外现金数额
     */
    private double fundsOutPlatform;

    /**
     * 用户平台内储蓄数额
     */
    private double savingInPlatform;

    /**
     * 用户平台外储蓄数额
     */
    private double savingOutPlatform;

    /**
     * 用户平台内保险数额
     */
    private double insuranceInPlatform;

    /**
     * 用户平台外保险数额
     */
    private double insuranceOutPlatform;

    /**
     * 用户平台内投资数额
     */
    private double investInPlatform;

    /**
     * 用户平台外投资数额
     */
    private double investOutPlatform;

    public EstateVO(double fundsInPlatform, double fundsOutPlatform, double savingInPlatform, double savingOutPlatform, double insuranceInPlatform, double insuranceOutPlatform, double stocksInPlatform, double stocksOutPlatform, double qdiiInPlatform, double qdiiOutPlatform, double goldInPlatform, double goldOutPlatform, double bondInPlatform, double bondOutPlatform) {
        this.fundsInPlatform = fundsInPlatform;
        this.fundsOutPlatform = fundsOutPlatform;
        this.savingInPlatform = savingInPlatform;
        this.savingOutPlatform = savingOutPlatform;
        this.insuranceInPlatform = insuranceInPlatform;
        this.insuranceOutPlatform = insuranceOutPlatform;
        this.investInPlatform = stocksInPlatform + qdiiInPlatform + goldInPlatform + bondInPlatform;
        this.investOutPlatform = stocksOutPlatform + qdiiOutPlatform + goldOutPlatform + bondOutPlatform;
        this.totalAsset = fundsInPlatform + fundsOutPlatform + savingInPlatform + savingOutPlatform + insuranceInPlatform + insuranceOutPlatform + stocksInPlatform + stocksOutPlatform + qdiiInPlatform + qdiiOutPlatform + goldInPlatform + goldOutPlatform + bondInPlatform + bondOutPlatform;
    }

    public EstateVO() {

    }

    public double getTotalAsset() {
        return totalAsset;
    }

    public double getFundsInPlatform() {
        return fundsInPlatform;
    }

    public double getFundsOutPlatform() {
        return fundsOutPlatform;
    }

    public double getSavingInPlatform() {
        return savingInPlatform;
    }

    public double getSavingOutPlatform() {
        return savingOutPlatform;
    }

    public double getInsuranceInPlatform() {
        return insuranceInPlatform;
    }

    public double getInsuranceOutPlatform() {
        return insuranceOutPlatform;
    }

    public double getInvestInPlatform() {
        return investInPlatform;
    }

    public double getInvestOutPlatform() {
        return investOutPlatform;
    }

}
