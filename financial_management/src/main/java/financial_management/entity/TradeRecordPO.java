package financial_management.entity;

import java.util.Date;

public class TradeRecordPO{
    //交易记录ID
    private Long ID;

    //从属调仓记录ID
    private Long transID;

    //交易创建时间
    private Date createTime;

    //交易完成时间
    private Date completeTime;

    //产品类型
    private Integer type;

    //产品代码
    private Integer code;

    //交易份额或数量
    private Float amount;

    //交易时产品每份价格
    private Float price;

    //交易订单总价
    private Float total;

    //交易用户ID
    private Long userID;

    //交易订单状态
    private Integer status;

    //是否为用户手动交易
    private Boolean isCustomize;

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public Long getTransID() {
        return transID;
    }

    public void setTransID(Long transID) {
        this.transID = transID;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsCustomize() {
        return isCustomize;
    }

    public void setIsCustomize(Boolean isCustomize) {
        this.isCustomize = isCustomize;
    }
}