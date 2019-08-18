package financial_management.entity;

public class ArticlePO {
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;
    /**
     * 类别
     */
    private Integer category;
    /**
     * 关键词（用逗号分隔）
     */
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public ArticlePO() {
    }

    public ArticlePO(String title,
                     String summary,
                     String content,
                     Integer category,
                     String tags) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.category = category;
        this.tags = tags;
    }
}
