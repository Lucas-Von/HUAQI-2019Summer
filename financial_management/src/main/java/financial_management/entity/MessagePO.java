package financial_management.entity;

import java.sql.Date;

public class MessagePO {
    //消息ID
    private Long ID;

    //消息发送时间
    private Date time;

    //消息接收用户ID
    private Long userID;

    //消息类型
    private Integer type;

    //消息内容
    private String content;

    //消息是否已读
    private Boolean isRead;

    //消息是否被标识为删除
    private Boolean isDelete;

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}