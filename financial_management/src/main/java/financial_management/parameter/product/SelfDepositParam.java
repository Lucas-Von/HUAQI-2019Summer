package financial_management.parameter.product;

import financial_management.entity.MyDepoPO;

import java.util.Date;

/**
 * @author xyh
 * @date 2019/8/28
 */
public class SelfDepositParam {
    private Long id;
    private String name;
    private Double amount;
    private Double rate;
    private Date endtime;

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

    public MyDepoPO getMyDepoPO(){
        return new MyDepoPO(amount,name, rate, endtime);
    }

    public SelfDepositParam() {
    }

    public SelfDepositParam(Long id,
                            String name,
                            Double amount,
                            Double rate,
                            Date endtime) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.rate = rate;
        this.endtime = endtime;
    }
}
