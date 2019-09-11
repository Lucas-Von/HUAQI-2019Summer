package financial_management.vo.product;

import financial_management.entity.MyInsPO;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:14
 * @Version 1.0
 **/
public class MyInsuranceVO {

    Long id;
    String name;
    String insurant;
    String type;
    Double amount;
    Double insured;
    Date endtime;

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
}
