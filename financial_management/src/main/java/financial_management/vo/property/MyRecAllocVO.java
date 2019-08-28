package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/25 20:05
 */
public class MyRecAllocVO {

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

    public MyRecAllocVO(double fundsRate, double savingRate, double insuranceRate, double investRate) {
        this.fundsRate = fundsRate;
        this.savingRate = savingRate;
        this.insuranceRate = insuranceRate;
        this.investRate = investRate;
    }

    public MyRecAllocVO() {

    }

    public double getFundsRate() {
        return fundsRate;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public double getInsuranceRate() {
        return insuranceRate;
    }

    public double getInvestRate() {
        return investRate;
    }

}
