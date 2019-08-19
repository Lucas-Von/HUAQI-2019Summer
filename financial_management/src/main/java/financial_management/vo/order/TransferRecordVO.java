package financial_management.vo.order;

import java.util.Date;
import java.util.List;

public class TransferRecordVO {
    private long ID;
    private Date createTime;
    private Date completeTime;
    private String sellType;
    private String buyType;
    private List<TradeRecordVO> sellList;
    private List<TradeRecordVO> buyList;
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

    public String getSellType() {
        return sellType;
    }

    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public List<TradeRecordVO> getSellList() {
        return sellList;
    }

    public void setSellList(List<TradeRecordVO> sellList) {
        this.sellList = sellList;
    }

    public List<TradeRecordVO> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<TradeRecordVO> buyList) {
        this.buyList = buyList;
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

    public TransferRecordVO(long ID, Date createTime, Date completeTime, String sellType, String buyType, List<TradeRecordVO> sellList, List<TradeRecordVO> buyList, long userID, int status) {
        this.ID = ID;
        this.createTime = createTime;
        this.completeTime = completeTime;
        this.sellType = sellType;
        this.buyType = buyType;
        this.sellList = sellList;
        this.buyList = buyList;
        this.userID = userID;
        this.status = status;
    }
}
