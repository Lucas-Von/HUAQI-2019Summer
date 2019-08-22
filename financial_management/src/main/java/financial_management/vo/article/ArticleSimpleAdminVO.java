package financial_management.vo.article;

import java.sql.Timestamp;

/**
 * @author xyh
 * @date 2019/8/22
 */
public class ArticleSimpleAdminVO {
    private Long articleId;
    private String title;
    private String summary;
    private Long pageviews;
    private Timestamp time;
    private String tags;
    private int category;
    private Long collections;

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Long getCollections() {
        return collections;
    }

    public void setCollections(Long collections) {
        this.collections = collections;
    }

    public ArticleSimpleAdminVO() {
    }

    public ArticleSimpleAdminVO(Long articleId,
                                String title,
                                String summary,
                                Long pageviews,
                                Timestamp time,
                                String tags,
                                int category) {
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
        this.pageviews = pageviews;
        this.time = time;
        this.tags = tags;
        this.category = category;
    }

    public ArticleSimpleAdminVO(Long articleId,
                                String title,
                                String summary,
                                Long pageviews,
                                Timestamp time,
                                String tags,
                                int category,
                                Long collections) {
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
        this.pageviews = pageviews;
        this.time = time;
        this.tags = tags;
        this.category = category;
        this.collections = collections;
    }
}
