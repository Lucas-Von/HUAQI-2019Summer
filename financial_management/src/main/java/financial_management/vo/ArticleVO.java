package financial_management.vo;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class ArticleVO {
    private String title;
    private boolean collected;
    private String content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentVO> comments) {
        this.comments = comments;
    }

    public ArticleVO() {
    }

    public ArticleVO(String title, boolean collected, String content, List<CommentVO> comments) {
        this.title = title;
        this.collected = collected;
        this.content = content;
        this.comments = comments;
    }
}
