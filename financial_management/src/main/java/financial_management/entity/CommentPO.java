package financial_management.entity;

import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/14 13:25
 * @Version 1.0
 **/
public class CommentPO {

    /**
     * @Description //评论Id
     **/
    Long id;
    /**
     * @Description //用户Id
     **/
    Long userId;

    /**
     * @Description //用户名（不入库。前端调用的时候由sql语句动态加载）
     **/
    String userName;
    /**
     * @Author jyh
     * @Description //文章ID
     **/
    Long articleId;

    /**
     * @Description //文本内容
     **/
    String content;

    /**
     * 评论时间
     */
    private Timestamp time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
