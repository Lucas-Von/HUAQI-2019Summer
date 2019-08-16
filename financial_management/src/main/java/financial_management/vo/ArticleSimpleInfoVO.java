package financial_management.vo;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class ArticleSimpleInfoVO {
    private Long articleId;
    private String title;
    private String summary;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArticleSimpleInfoVO() {
    }

    public ArticleSimpleInfoVO(Long articleId, String title, String summary) {
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
    }
}
