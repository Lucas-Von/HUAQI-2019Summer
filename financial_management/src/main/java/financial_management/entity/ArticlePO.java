package financial_management.entity;

import financial_management.vo.article.ArticleAdminVO;
import financial_management.vo.article.ArticleSimpleAdminVO;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.article.ArticleVO;

import java.sql.Timestamp;

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
     * 内容（md格式）
     */
    private String mdContent;
    /**
     * 内容（html格式）
     */
    private String htmlContent;
    /**
     * 类别
     */
    private Integer category;
    /**
     * 关键词（用逗号分隔）
     */
    private String tags;
    /**
     * 浏览量
     */
    private Long pageviews;
    /**
     * 最近更新时间
     */
    private Timestamp time;

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

    public ArticleVO getArticleVO(){
        return new ArticleVO(title, mdContent, htmlContent, pageviews, time, tags);
    }

    public ArticleSimpleInfoVO getArticleSimpleInfoVO(){
        return new ArticleSimpleInfoVO(articleId, title, summary, pageviews, time, tags);
    }

    public ArticleAdminVO getArticleAdminVO(){
        return new ArticleAdminVO(title, summary, mdContent, htmlContent,category, time, tags);
    }

    public ArticleSimpleAdminVO getArticleSimpleAdminVO(){
        return new ArticleSimpleAdminVO(articleId, title, summary, pageviews, time, tags, category);
    }

    public ArticlePO() {
    }

    public ArticlePO(String title,
                     String summary,
                     String mdContent,
                     String htmlContent,
                     Integer category,
                     String tags) {
        this.title = title;
        this.summary = summary;
        this.mdContent = mdContent;
        this.htmlContent = htmlContent;
        this.category = category;
        this.tags = tags;
    }
}
