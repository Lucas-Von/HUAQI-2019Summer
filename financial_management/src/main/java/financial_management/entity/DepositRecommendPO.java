package financial_management.entity;

import java.util.Date;

/**
 * @author xyh
 * @date 2019/8/29
 */
public class DepositRecommendPO {
    /**
     * 推荐储蓄产品ID
     */
    private Long id;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 认购币种
     */
    private String currency;
    /**
     * 产品信息
     */
    private String information;
    /**
     * 预期年化收益率
     */
    private Double rate;
    /**
     * 开始日
     */
    private Date startTime;
    /**
     * 到期日
     */
    private Date endTime;
    /**
     * 起投金额
     */
    private Double startAmount;
    /**
     * 风险等级
     */
    private Integer riskLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(Double startAmount) {
        this.startAmount = startAmount;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public DepositRecommendPO() {
    }

    public DepositRecommendPO(Long id,
                              String name,
                              String currency,
                              String information,
                              Double rate,
                              Date startTime,
                              Date endTime,
                              Double startAmount,
                              Integer riskLevel) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.information = information;
        this.rate = rate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startAmount = startAmount;
        this.riskLevel = riskLevel;
    }
}
