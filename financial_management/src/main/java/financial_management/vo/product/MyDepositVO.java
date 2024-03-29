package financial_management.vo.product;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:22
 * @Version 1.0
 **/
public class MyDepositVO {
    private Long id;
    private String name;
    private String type;
    private Double amount;
    private Double rate;
    private String endtime;
    private Double proportion;

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

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public MyDepositVO() {
    }

    public MyDepositVO(Long id,
                       String name,
                       String type,
                       Double amount,
                       Double rate,
                       String endtime,
                       Double proportion) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.rate = rate;
        this.endtime = endtime;
        this.proportion = proportion;
    }
}
