package financial_management.vo.article;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class ArticleVO {
    private String title;
    private boolean collected;
    private String mdContent;
    private String htmlContent;
    private Long pageviews;
    private Timestamp time;
    private String tags;
    private List<CommentVO> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
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

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
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

    public ArticleVO() {
    }

    public ArticleVO(String title,
                     String mdContent,
                     String htmlContent,
                     Long pageviews,
                     Timestamp time,
                     String tags) {
        this.title = title;
        this.mdContent = mdContent;
        this.htmlContent = htmlContent;
        this.pageviews = pageviews;
        this.time = time;
        this.tags = tags;
    }

    public ArticleVO(String title,
                     boolean collected,
                     String mdContent,
                     String htmlContent,
                     Long pageviews,
                     Timestamp time,
                     String tags,
                     List<CommentVO> comments) {
        this.title = title;
        this.collected = collected;
        this.mdContent = mdContent;
        this.htmlContent = htmlContent;
        this.pageviews = pageviews;
        this.time = time;
        this.tags = tags;
        this.comments = comments;
    }
}
