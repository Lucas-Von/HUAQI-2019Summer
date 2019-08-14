package financial_management.entity;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/14 13:28
 * @Version 1.0
 **/
public class CollectionPO {
    /**
     * @Author jyh
     * @Description //用户ID
     **/
    Long userId;

    /**
     * @Author jyh
     * @Description //文章ID
     **/
    Long articleId;

    /**
     * @Author jyh
     * @Description //文章标题（不入库。前端调用的时候由sql语句动态加载）
     **/
    String articleTitle;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}
