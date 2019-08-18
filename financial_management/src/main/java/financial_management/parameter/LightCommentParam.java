package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/17
 */
public class LightCommentParam {
    private Long commentId;
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

    public LightCommentParam() {
    }

    public LightCommentParam(Long commentId, Long userId) {
        this.commentId = commentId;
        this.userId = userId;
    }
}
