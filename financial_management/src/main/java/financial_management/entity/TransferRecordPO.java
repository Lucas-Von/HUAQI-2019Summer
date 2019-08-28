package financial_management.entity;

import java.util.Date;

public class TransferRecordPO{
    //调仓记录ID
    private Long ID;

    //调仓创建时间
    private Date createTime;

    //调仓完成时间
    private Date completeTime;

    private Float goldTotal;

    private Float goldDelta;

    private Float bondTotal;

    private Float bondDelta;

    private Float stockTotal;

    private Float stockDelta;

    //调仓用户ID
    private Long userID;

    //调仓状态
    private Integer status;

    //是否为用户手动调仓
    private Boolean isCustomize;

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
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

    public Float getGoldTotal() {
        return goldTotal;
    }

    public void setGoldTotal(Float goldTotal) {
        this.goldTotal = goldTotal;
    }

    public Float getGoldDelta() {
        return goldDelta;
    }

    public void setGoldDelta(Float goldDelta) {
        this.goldDelta = goldDelta;
    }

    public Float getBondTotal() {
        return bondTotal;
    }

    public void setBondTotal(Float bondTotal) {
        this.bondTotal = bondTotal;
    }

    public Float getBondDelta() {
        return bondDelta;
    }

    public void setBondDelta(Float bondDelta) {
        this.bondDelta = bondDelta;
    }

    public Float getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(Float stockTotal) {
        this.stockTotal = stockTotal;
    }

    public Float getStockDelta() {
        return stockDelta;
    }

    public void setStockDelta(Float stockDelta) {
        this.stockDelta = stockDelta;
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