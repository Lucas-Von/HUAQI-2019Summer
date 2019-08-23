package financial_management.parameter.property;

/**
 * @author lt
 * @date 2019/08/23 02:41
 */
public class RecAllocParam {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 推荐现金比例
     */
    private double fundsRate;

    /**
     * 推荐储蓄比例
     */
    private double savingRate;

    /**
     * 推荐保险比例
     */
    private double insuranceRate;

    /**
     * 推荐投资比例
     */
    private double investRate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getFundsRate() {
        return fundsRate;
    }

    public void setFundsRate(double fundsRate) {
        this.fundsRate = fundsRate;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public void setSavingRate(double savingRate) {
        this.savingRate = savingRate;
    }

    public double getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(double insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public double getInvestRate() {
        return investRate;
    }

    public void setInvestRate(double investRate) {
        this.investRate = investRate;
    }

}
