package financial_management.vo.product;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:14
 * @Version 1.0
 **/
public class MyInsuranceVO {

    String name;
    String insurant;
    String type;
    Double amount;
    Double insured;
    Date endtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsurant() {
        return insurant;
    }

    public void setInsurant(String insurant) {
        this.insurant = insurant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInsured() {
        return insured;
    }

    public void setInsured(Double insured) {
        this.insured = insured;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public MyInsuranceVO(String name, String insurant, String type, Double amount, Double insured, Date endtime) {
        this.name = name;
        this.insurant = insurant;
        this.type = type;
        this.amount = amount;
        this.insured = insured;
        this.endtime = endtime;
    }

    public MyInsuranceVO() {
    }
}
