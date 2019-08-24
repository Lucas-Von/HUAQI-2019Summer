package financial_management.vo.order;

import java.util.Date;

public class TransferRecordVO {
    private long ID;
    private Date createTime;
    private Date completeTime;
    private int goldTotal;
    private int goldDelta;
    private int bondTotal;
    private int bondDelta;
    private int stockTotal;
    private int stockDelta;
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

    public int getGoldTotal() {
        return goldTotal;
    }

    public void setGoldTotal(int goldTotal) {
        this.goldTotal = goldTotal;
    }

    public int getGoldDelta() {
        return goldDelta;
    }

    public void setGoldDelta(int goldDelta) {
        this.goldDelta = goldDelta;
    }

    public int getBondTotal() {
        return bondTotal;
    }

    public void setBondTotal(int bondTotal) {
        this.bondTotal = bondTotal;
    }

    public int getBondDelta() {
        return bondDelta;
    }

    public void setBondDelta(int bondDelta) {
        this.bondDelta = bondDelta;
    }

    public int getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public int getStockDelta() {
        return stockDelta;
    }

    public void setStockDelta(int stockDelta) {
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

    public TransferRecordVO(long ID, Date createTime, Date completeTime, int goldTotal, int goldDelta, int bondTotal, int bondDelta, int stockTotal, int stockDelta, long userID, int status) {
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
