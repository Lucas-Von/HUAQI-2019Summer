package financial_management.entity;

import financial_management.vo.product.OverseasBondRecommendVO;

/**
 * @author xyh
 * @date 2019/9/8
 */
public class OverseasBondRecommendPO {
    private Long id;
    /**
     * 债券代码
     */
    private String code;
    /**
     * 票息率
     */
    private String rate;
    /**
     * 到期日
     */
    private String endTime;
    /**
     * 最低申购赎回额
     */
    private String redemption;
    /**
     * 债券类别
     */
    private String bondType;
    /**
     * 投资币种
     */
    private String currency;
    /**
     * 发行机构
     */
    private String mechanism;
    /**
     * 配息频率
     */
    private String frequency;
    /**
     * 穆迪标普评级
     */
    private String rating;
    /**
     * 资产类别
     */
    private String assetsType;
    /**
     * 申购费率（一次性）
     */
    private String subscriptionRate;
    /**
     * 提前赎回费
     */
    private String earlyRedemptionFee;
    /**
     * 服务费
     */
    private String serviceFee;
    /**
     * 风险等级评级（从1到5，对应投资偏好的保守型—稳健保守型—稳健型—稳健进取型—进取型）
     */
    private Integer riskRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRedemption() {
        return redemption;
    }

    public void setRedemption(String redemption) {
        this.redemption = redemption;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType;
    }

    public String getSubscriptionRate() {
        return subscriptionRate;
    }

    public void setSubscriptionRate(String subscriptionRate) {
        this.subscriptionRate = subscriptionRate;
    }

    public String getEarlyRedemptionFee() {
        return earlyRedemptionFee;
    }

    public void setEarlyRedemptionFee(String earlyRedemptionFee) {
        this.earlyRedemptionFee = earlyRedemptionFee;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(Integer riskRating) {
        this.riskRating = riskRating;
    }

    public OverseasBondRecommendVO getOverseasBondRecommendVO(){
        return new OverseasBondRecommendVO(id, code, rate, endTime, redemption, bondType, currency, mechanism, frequency, rating, assetsType, subscriptionRate, earlyRedemptionFee, serviceFee);
    }

    public OverseasBondRecommendPO() {
    }

    public OverseasBondRecommendPO(String code,
                                   String rate,
                                   String endTime,
                                   String redemption,
                                   String bondType,
                                   String currency,
                                   String mechanism,
                                   String frequency,
                                   String rating,
                                   String assetsType,
                                   String subscriptionRate,
                                   String earlyRedemptionFee,
                                   String serviceFee,
                                   Integer riskRating) {
        this.code = code;
        this.rate = rate;
        this.endTime = endTime;
        this.redemption = redemption;
        this.bondType = bondType;
        this.currency = currency;
        this.mechanism = mechanism;
        this.frequency = frequency;
        this.rating = rating;
        this.assetsType = assetsType;
        this.subscriptionRate = subscriptionRate;
        this.earlyRedemptionFee = earlyRedemptionFee;
        this.serviceFee = serviceFee;
        this.riskRating = riskRating;
    }
}
