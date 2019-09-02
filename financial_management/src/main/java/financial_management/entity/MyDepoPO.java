package financial_management.entity;

import financial_management.vo.product.MyDepositVO;

import java.util.Date;

/**
 * @Description 用户储蓄产品实体类
 * @Author 233loser
 * @Date 2019/8/14 13:20
 * @Version 1.0
 **/
public class MyDepoPO {
    /**
     * @Description //产品Id
     **/
    private Long id;
    /**
     * @Description //用户Id
     **/
    private Long userId;
    /**
     * @Description //类型（0表示平台内，1表示平台外）
     **/
    private Integer type = 1;
    /**
     * @Description //持有额度
     **/
    private Double amount;
    /**
     * @Description //名称，不入库，由productID sql加载
     **/
    private String name;
    /**
     * @Description //利率
     **/
    private Double rate;
    /**
    * @Description //到期时间
     **/
    private Date endtime;
    /**
     * @Description //占比
     **/
    private Double proportion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public MyDepositVO getMyDepositVO(){
        String stringType = "";
        if(type == 0){
            stringType = "平台内持有";
        }else {
            stringType = "平台外持有";
        }
        return new MyDepositVO(id, name, stringType, amount, rate, endtime, proportion);
    }

    public MyDepoPO() {
    }

    public MyDepoPO(Double amount,
                    String name,
                    Double rate,
                    Date endtime) {
        this.amount = amount;
        this.name = name;
        this.rate = rate;
        this.endtime = endtime;
    }

    public MyDepoPO(Long id,
                    Long userId,
                    Integer type,
                    Double amount,
                    String name,
                    Double rate,
                    Date endtime,
                    Double proportion) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.amount = amount;
        this.name = name;
        this.rate = rate;
        this.endtime = endtime;
        this.proportion = proportion;
    }
}
