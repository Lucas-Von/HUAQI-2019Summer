package financial_management.parameter;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class ArticleParam {
    private Long articleId;
    private String title;
    private String summary;
    private String content;
    private Integer category;
    private List<String> tags;

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public ArticleParam() {
    }

    public ArticleParam(Long articleId,
                        String title,
                        String summary,
                        String content,
                        Integer category,
                        List<String> tags) {
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.category = category;
        this.tags = tags;
    }
}
