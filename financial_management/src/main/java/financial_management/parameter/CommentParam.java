package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class CommentParam {
    private Long articleId;
    private String content;

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

    public CommentParam() {
    }

    public CommentParam(Long articleId, String content) {
        this.articleId = articleId;;
        this.content = content;
    }
}
