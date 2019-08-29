package financial_management.vo.order;

import financial_management.entity.MaxInvestPO;

import java.util.Date;

public class MaxInvestVO {
    private Long userID;
    private String type;
    private Float max;
    private Date date;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MaxInvestVO(MaxInvestPO po) {
        userID = po.getUserID();
        type = po.getType();
        max = po.getMax();
        date = po.getDate();
    }

    public MaxInvestVO(Long userID, String type, Float max, Date date) {
        this.userID = userID;
        this.type = type;
        this.max = max;
        this.date = date;
    }
}
