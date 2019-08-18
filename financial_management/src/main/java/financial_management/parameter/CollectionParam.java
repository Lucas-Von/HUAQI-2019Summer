package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class CollectionParam {
    private Long articleId;
    private Long userId;

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

    public CollectionParam() {
    }

    public CollectionParam(Long articleId, Long userId) {
        this.articleId = articleId;
        this.userId = userId;
    }
}