package financial_management.vo.order;

import financial_management.entity.TradeRecordPO;

import java.util.Date;

public class TradeRecordVO {
    private long ID;
    private long transID;
    private Date createTime;
    private Date completeTime;
    private String product;
    private String type;
    private int pcode;
    private float amount;
    private float price;
    private float total;
    private long userID;
    private int status;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getTransID() {
        return transID;
    }

    public void setTransID(long transID) {
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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

    public TradeRecordVO() {
    }

    public TradeRecordVO(TradeRecordPO po) {
        ID = po.getID();
        transID = po.getTransID();
        createTime = po.getCreateTime();
        completeTime = po.getCompleteTime();
        pcode = po.getCode();
        amount = po.getAmount();
        price = po.getPrice();
        total = po.getTotal();
        userID = po.getUserID();
    }

    public TradeRecordVO(long ID, long transID, Date createTime, Date completeTime, String product, String type, int pcode, float amount, float price, float total, long userID, int status) {
        this.ID = ID;
        this.transID = transID;
        this.createTime = createTime;
        this.completeTime = completeTime;
        this.product = product;
        this.type = type;
        this.pcode = pcode;
        this.amount = amount;
        this.price = price;
        this.total = total;
        this.userID = userID;
        this.status = status;
    }
}
