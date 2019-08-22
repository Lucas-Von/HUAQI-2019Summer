package financial_management.vo.product;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:22
 * @Version 1.0
 **/
public class MyDepositVO {

    String name;
    String type;
    Double amount;
    Double rate;
    Date endtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public MyDepositVO(String name,  String type, Double amount, Double rate, Date endtime) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.rate = rate;
        this.endtime = endtime;
    }

    public MyDepositVO() {
    }


}
