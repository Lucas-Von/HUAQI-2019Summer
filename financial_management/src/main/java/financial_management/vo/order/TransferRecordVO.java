package financial_management.vo.order;

import financial_management.entity.TransferRecordPO;

import java.util.Date;

public class TransferRecordVO {
    private long ID;
    private Date createTime;
    private Date completeTime;
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
        userID = po.getUserID();
        status = po.getStatus();
    }

    public TransferRecordVO(long ID, Date createTime, Date completeTime, long userID, int status) {
        this.ID = ID;
        this.createTime = createTime;
        this.completeTime = completeTime;
        this.userID = userID;
        this.status = status;
    }
}
