package financial_management.vo.article;

import java.sql.Timestamp;

/**
 * @author xyh
 * @date 2019/8/22
 */
public class ArticleAdminVO {
    private String title;
    private String summary;
    private String mdContent;
    private String htmlContent;
    private int category;
    private Timestamp time;
    private String tags;

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

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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

    public ArticleAdminVO() {
    }

    public ArticleAdminVO(String title,
                          String summary,
                          String mdContent,
                          String htmlContent,
                          int category,
                          Timestamp time,
                          String tags) {
        this.title = title;
        this.summary = summary;
        this.mdContent = mdContent;
        this.htmlContent = htmlContent;
        this.category = category;
        this.time = time;
        this.tags = tags;
    }
}
