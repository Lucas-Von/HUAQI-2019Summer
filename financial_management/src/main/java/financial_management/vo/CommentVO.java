package financial_management.vo;

import java.sql.Timestamp;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class CommentVO {
    private Long commentId;
    private String content;
    private String username;
    private Integer light;  // 点赞数
    private boolean lighted;
    private Timestamp time;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public boolean isLighted() {
        return lighted;
    }

    public void setLighted(boolean lighted) {
        this.lighted = lighted;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public CommentVO() {
    }

    public CommentVO(Long commentId,
                     String content,
                     String username,
                     Integer light,
                     boolean lighted,
                     Timestamp time) {
        this.commentId = commentId;
        this.content = content;
        this.username = username;
        this.light = light;
        this.lighted = lighted;
        this.time = time;
    }
}
