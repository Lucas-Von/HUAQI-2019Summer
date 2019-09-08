package financial_management.entity;

import java.util.Date;

public class TransferRecordPO{
    //调仓记录ID
    private Long ID;

    //调仓创建时间
    private Date createTime;

    //调仓完成时间
    private Date completeTime;

    //调仓用户ID
    private Long userID;

    //调仓状态
    private Integer status;

    //是否已经过用户确认
    private Boolean isChecked;

    //用户是否否决调仓
    private Boolean isDenied;

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

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public Boolean getDenied() {
        return isDenied;
    }

    public void setDenied(Boolean denied) {
        isDenied = denied;
    }

    public Boolean getCustomize() {
        return isCustomize;
    }

    public void setCustomize(Boolean customize) {
        isCustomize = customize;
    }

    public Boolean getIsCustomize() {
        return isCustomize;
    }

    public void setIsCustomize(Boolean isCustomize) {
        this.isCustomize = isCustomize;
    }

    public TransferRecordPO() {
    }

    public TransferRecordPO(Date createTime, Long userID, Boolean isCustomize) {
        this.createTime = createTime;
        this.userID = userID;
        this.isCustomize = isCustomize;
    }

    @Override
    public String toString() {
        return "TransferRecordPO{" +
                "ID=" + ID +
                ", createTime=" + createTime +
                ", completeTime=" + completeTime +
                ", userID=" + userID +
                ", status=" + status +
                ", isChecked=" + isChecked +
                ", isDenied=" + isDenied +
                ", isCustomize=" + isCustomize +
                '}';
    }
}