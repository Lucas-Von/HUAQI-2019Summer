package financial_management.parameter.product;

import financial_management.entity.OverseasBondRecommendPO;

/**
 * @author xyh
 * @date 2019/9/8
 */
public class OverseasBondRecommendParam {
    private Long id;
    private String code;
    private String rate;
    private String endTime;
    private String redemption;
    private String bondType;
    private String currency;
    private String mechanism;
    private String frequency;
    private String rating;
    private String assetsType;
    private String subscriptionRate;
    private String earlyRedemptionFee;
    private String serviceFee;
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

    public OverseasBondRecommendPO getOverseasBondRecommendPO(){
        return new OverseasBondRecommendPO(code,
                rate,
                endTime,
                redemption,
                bondType,
                currency,
                mechanism,
                frequency,
                rating,
                assetsType,
                subscriptionRate,
                earlyRedemptionFee,
                serviceFee,
                riskRating);
    }

    public OverseasBondRecommendParam() {
    }

    public OverseasBondRecommendParam(Long id,
                                      String code,
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
        this.id = id;
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