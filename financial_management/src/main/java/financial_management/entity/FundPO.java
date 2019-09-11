package financial_management.entity;

import java.util.Date;

/**
 * @Description 基金类
 * @Author 233loser
 * @Date 2019/8/13 20:55
 * @Version 1.0
 **/

public class FundPO {

    /**
     * @Description //基金名称
     **/
    String name;

    /**
     * @Author jyh
     * @Description //更新时间
     **/
    Date time;

    Float sevenAnnualized;

    Float fourteenAnnualized;

    Float twentyeightAnnualized;

    Float thirtyYieldRate;

    Float nintyYieldRate;

    Float sinceYieldRate;

    public Float getSevenAnnualized() {
        return sevenAnnualized;
    }

    public Float getFourteenAnnualized() {
        return fourteenAnnualized;
    }

    public Float getTwentyeightAnnualized() {
        return twentyeightAnnualized;
    }

    public Float getThirtyYieldRate() {
        return thirtyYieldRate;
    }

    public Float getNintyYieldRate() {
        return nintyYieldRate;
    }

    public Float getSinceYieldRate() {
        return sinceYieldRate;
    }

    public void setSevenAnnualized(Float sevenAnnualized) {
        this.sevenAnnualized = sevenAnnualized;
    }

    public void setFourteenAnnualized(Float fourteenAnnualized) {
        this.fourteenAnnualized = fourteenAnnualized;
    }

    public void setTwentyeightAnnualized(Float twentyeightAnnualized) {
        this.twentyeightAnnualized = twentyeightAnnualized;
    }

    public void setThirtyYieldRate(Float thirtyYieldRate) {
        this.thirtyYieldRate = thirtyYieldRate;
    }

    public void setNintyYieldRate(Float nintyYieldRate) {
        this.nintyYieldRate = nintyYieldRate;
    }

    public void setSinceYieldRate(Float sinceYieldRate) {
        this.sinceYieldRate = sinceYieldRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public FundPO(String name, Date time, Float sevenAnnualized, Float fourteenAnnualized, Float twentyeightAnnualized, Float thirtyYieldRate, Float nintyYieldRate, Float sinceYieldRate) {
        this.name = name;
        this.time = time;
        this.sevenAnnualized = sevenAnnualized;
        this.fourteenAnnualized = fourteenAnnualized;
        this.twentyeightAnnualized = twentyeightAnnualized;
        this.thirtyYieldRate = thirtyYieldRate;
        this.nintyYieldRate = nintyYieldRate;
        this.sinceYieldRate = sinceYieldRate;
    }

    public FundPO() {
    }
}
