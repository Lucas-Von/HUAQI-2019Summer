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
     * 用户平台外储蓄数额
     */
    private double savingOutPlatform;

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

    public EstateVO(double fundsInPlatform, double fundsOutPlatform, double savingOutPlatform, double insuranceOutPlatform, double investInPlatform, double investOutPlatform) {
        this.fundsInPlatform = fundsInPlatform;
        this.fundsOutPlatform = fundsOutPlatform;
        this.savingOutPlatform = savingOutPlatform;
        this.insuranceOutPlatform = insuranceOutPlatform;
        this.investInPlatform = investInPlatform;
        this.investOutPlatform = investOutPlatform;
        this.totalAsset = fundsInPlatform + fundsOutPlatform + savingOutPlatform + investInPlatform + investOutPlatform;
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

    public double getSavingOutPlatform() {
        return savingOutPlatform;
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