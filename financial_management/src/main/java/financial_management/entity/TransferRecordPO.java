package financial_management.entity;

import java.util.Date;

public class TransferRecordPO{
    //调仓记录ID
    private Long ID;

    //调仓创建时间
    private Date createTime;

    //调仓完成时间
    private Date completeTime;

    private Integer goldTotal;

    private Integer goldDelta;

    private Integer bondTotal;

    private Integer bondDelta;

    private Integer stockTotal;

    private Integer stockDelta;

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

    public Integer getGoldTotal() {
        return goldTotal;
    }

    public void setGoldTotal(Integer goldTotal) {
        this.goldTotal = goldTotal;
    }

    public Integer getGoldDelta() {
        return goldDelta;
    }

    public void setGoldDelta(Integer goldDelta) {
        this.goldDelta = goldDelta;
    }

    public Integer getBondTotal() {
        return bondTotal;
    }

    public void setBondTotal(Integer bondTotal) {
        this.bondTotal = bondTotal;
    }

    public Integer getBondDelta() {
        return bondDelta;
    }

    public void setBondDelta(Integer bondDelta) {
        this.bondDelta = bondDelta;
    }

    public Integer getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(Integer stockTotal) {
        this.stockTotal = stockTotal;
    }

    public Integer getStockDelta() {
        return stockDelta;
    }

    public void setStockDelta(Integer stockDelta) {
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