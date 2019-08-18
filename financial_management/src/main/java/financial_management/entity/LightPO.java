package financial_management.entity;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class LightPO {
    /**
     * 评论ID
     */
    private Long commentId;
    /**
     * 点赞的用户ID
     */
    private Long userId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LightPO() {
    }

    public LightPO(Long commentId, Long userId) {
        this.commentId = commentId;
        this.userId = userId;
    }
}
