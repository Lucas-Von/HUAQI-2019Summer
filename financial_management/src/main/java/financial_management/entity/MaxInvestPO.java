package financial_management.entity;

import java.util.Date;

public class MaxInvestPO {
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

    public MaxInvestPO(Long userID, String type, Float max, Date date) {
        this.userID = userID;
        this.type = type;
        this.max = max;
        this.date = date;
    }

    public MaxInvestPO() {
    }
}
