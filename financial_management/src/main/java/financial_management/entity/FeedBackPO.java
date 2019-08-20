package financial_management.entity;

import java.sql.Date;

public class FeedBackPO {
    private Long ID;
    private String title;
    private Integer type;
    private String detail;
    private Date createTime;
    private Long userID;
    private String phone;
    private String QQ;
    private String email;
    private Boolean solved;
    private Long solverID;
    private Date solve_time;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

    public Long getSolverID() {
        return solverID;
    }

    public void setSolverID(Long solverID) {
        this.solverID = solverID;
    }

    public Date getSolve_time() {
        return solve_time;
    }

    public void setSolve_time(Date solve_time) {
        this.solve_time = solve_time;
    }
}
