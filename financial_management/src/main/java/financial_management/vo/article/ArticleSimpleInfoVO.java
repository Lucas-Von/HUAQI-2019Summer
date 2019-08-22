package financial_management.vo.article;

import java.sql.Timestamp;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class ArticleSimpleInfoVO {
    private Long articleId;
    private String title;
    private String summary;
    private boolean collected;
    private Long pageviews;
    private Timestamp time;
    private String tags;

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

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public Long getPageviews() {
        return pageviews;
    }

    public void setPageviews(Long pageviews) {
        this.pageviews = pageviews;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public ArticleSimpleInfoVO() {
    }

    public ArticleSimpleInfoVO(Long articleId,
                               String title,
                               String summary,
                               boolean collected,
                               Long pageviews,
                               Timestamp time,
                               String tags) {
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
        this.collected = collected;
        this.pageviews = pageviews;
        this.time = time;
        this.tags = tags;
    }
}
