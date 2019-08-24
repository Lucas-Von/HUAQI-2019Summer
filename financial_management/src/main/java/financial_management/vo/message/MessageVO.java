package financial_management.vo.message;

import financial_management.entity.MessagePO;

import java.util.Date;

public class MessageVO {
    private Long ID;
    private Date time;
    private Long userID;
    private Integer type;
    private String content;
    private Boolean readed;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    public MessageVO(Long ID, Date time, Long userID, Integer type, String content, Boolean readed) {
        this.ID = ID;
        this.time = time;
        this.userID = userID;
        this.type = type;
        this.content = content;
        this.readed = readed;
    }

    public MessageVO(MessagePO po) {
        this.ID = po.getID();
        this.time = po.getTime();
        this.userID = po.getUserID();
        this.type = po.getType();
        this.content = po.getContent();
        this.readed = po.getIsRead();
    }
}
