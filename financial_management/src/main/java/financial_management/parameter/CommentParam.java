package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class CommentParam {
    private Long articleId;
    private Long userId;
    private String content;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentParam() {
    }

    public CommentParam(Long articleId, Long userId, String content) {
        this.articleId = articleId;
        this.userId = userId;
        this.content = content;
    }
}
