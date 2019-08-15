package financial_management.entity;

import java.sql.Date;

public class TransferRecordPO{
    //调仓记录ID
    private Long ID;

    //调仓创建时间
    private Date createTime;

    //调仓完成时间
    private Date completeTime;

    //减持类型
    private Integer sellType;

    //增持类型
    private Integer buyType;

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

    public Integer getSellType() {
        return sellType;
    }

    public void setSellType(Integer sellType) {
        this.sellType = sellType;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
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