package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/22 22:43
 */
public class SubEstateVO {

    /**
     * 用户的该类型资产数额
     */
    private double subEstate;

    /**
     * 该类型资产平台内数额
     */
    private double subEstateInPlatform;

    /**
     * 该类型资产平台外数额
     */
    private double subEstateOutPlatform;

    /**
     * 该类型资产占总资产的比例
     */
    private double rate;

    public SubEstateVO(double total, double subEstateInPlatform, double subEstateOutPlatform) {
        this.subEstate = subEstateInPlatform + subEstateOutPlatform;
        this.subEstateInPlatform = subEstateInPlatform;
        this.subEstateOutPlatform = subEstateOutPlatform;
        if (total == 0) {
            this.rate = 0;
        } else {
            this.rate = (subEstateInPlatform + subEstateOutPlatform) / total;
        }
    }

    public SubEstateVO() {

    }

    public double getSubEstate() {
        return subEstate;
    }

    public double getSubEstateInPlatform() {
        return subEstateInPlatform;
    }

    public double getSubEstateOutPlatform() {
        return subEstateOutPlatform;
    }

    public double getRate() {
        return rate;
    }

}