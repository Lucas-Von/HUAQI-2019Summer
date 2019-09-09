package financial_management.entity;

import java.util.Date;

public class PersonalTradePO {
    //交易记录ID
    private Long ID;

    //从属调仓记录ID
    private Long transID;

    //交易创建时间
    private Date createTime;

    //交易完成时间
    private Date completeTime;

    //产品类型
    private String type;

    //产品代码
    private Long productID;

    //交易份额或数量
    private Float amount;

    //交易时产品每份价格
    private Float price;

    //交易手续费
    private Float fee;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
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

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
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

    @Override
    public String toString() {
        return "PersonalTradePO{" +
                "ID=" + ID +
                ", transID=" + transID +
                ", createTime=" + createTime +
                ", completeTime=" + completeTime +
                ", type='" + type + '\'' +
                ", productID=" + productID +
                ", amount=" + amount +
                ", price=" + price +
                ", fee=" + fee +
                ", total=" + total +
                ", userID=" + userID +
                ", status=" + status +
                ", isCustomize=" + isCustomize +
                '}';
    }
}