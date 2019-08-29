package financial_management.vo.product;

import java.util.Date;

/**
 * @author xyh
 * @date 2019/8/29
 */
public class DepositRecommendVO {
    private Long id;
    private String name;
    private String currency;
    private String information;
    private Double rate;
    private Date startTime;
    private Date endTime;
    private Double startAmount;
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

    public DepositRecommendVO() {
    }

    public DepositRecommendVO(Long id,
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
