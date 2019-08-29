package financial_management.parameter.property;

import java.util.Date;

public class QuestionnaireParam {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 现金
     */
    private double funds;

    /**
     * 储蓄
     */
    private double saving;

    /**
     * 保险
     */
    private double insurance;

    /**
     * 股票
     */
    private double stocks;

    /**
     * 黄金
     */
    private double gold;

    /**
     * 债券
     */
    private double bond;

    /**
     * 用户的回答
     */
    private String answer;

    /**
     * 第一次填写问卷的时间
     */
    private Date recordTime;

    /**
     * 第一份问卷的资产总额
     */
    private double originAssets;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getStocks() {
        return stocks;
    }

    public void setStocks(double stocks) {
        this.stocks = stocks;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getBond() {
        return bond;
    }

    public void setBond(double bond) {
        this.bond = bond;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public double getOriginAssets() {
        return this.funds + this.saving + this.insurance + this.stocks + this.gold + this.bond;
    }
}
