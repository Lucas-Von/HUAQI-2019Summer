package financial_management.vo.order;

import financial_management.entity.TransferRecordPO;

import java.util.Date;

public class TransferRecordVO {
    private long ID;
    private Date createTime;
    private Date completeTime;
    private Float goldTotal;
    private Float goldDelta;
    private Float bondTotal;
    private Float bondDelta;
    private Float stockTotal;
    private Float stockDelta;
    private long userID;
    private int status;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public TransferRecordVO() {
    }

    public TransferRecordVO(TransferRecordPO po) {
        ID = po.getID();
        createTime = po.getCreateTime();
        completeTime = po.getCompleteTime();
        goldTotal = po.getGoldTotal();
        goldDelta = po.getGoldDelta();
        bondTotal = po.getBondTotal();
        bondDelta = po.getBondDelta();
        stockTotal = po.getStockTotal();
        stockDelta = po.getStockDelta();
        userID = po.getUserID();
        status = po.getStatus();
    }

    public TransferRecordVO(long ID, Date createTime, Date completeTime, Float goldTotal, Float goldDelta, Float bondTotal, Float bondDelta, Float stockTotal, Float stockDelta, long userID, int status) {
        this.ID = ID;
        this.createTime = createTime;
        this.completeTime = completeTime;
        this.goldTotal = goldTotal;
        this.goldDelta = goldDelta;
        this.bondTotal = bondTotal;
        this.bondDelta = bondDelta;
        this.stockTotal = stockTotal;
        this.stockDelta = stockDelta;
        this.userID = userID;
        this.status = status;
    }
}
