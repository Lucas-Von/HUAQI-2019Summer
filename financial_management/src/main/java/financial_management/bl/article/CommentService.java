package financial_management.bl.article;

import financial_management.parameter.CommentParam;
import org.springframework.http.ResponseEntity;

/**
 * @author xyh
 * @date 2019/8/17
 */
public interface CommentService {
    /**
     * 添加评论
     * @param commentParam
     * @return
     */
    ResponseEntity<String> addComment(CommentParam commentParam, Long userId);

    /**
     * 点赞一条评论
     * @param commentId
     * @param userId
     * @return
     */
    ResponseEntity<String> lightComment(Long commentId, Long userId);

    /**
     * 取消点赞一条评论
     * @param commentId
     * @param userId
     * @return
     */
    ResponseEntity<String> unlightComment(Long commentId, Long userId);

    /**
     * 举报一条评论（消息通知告诉管理员）
     * @param commentId
     * @return
     */
    ResponseEntity<String> reportComment(Long commentId);

    /**
     * 删除一条评论
     * @param commentId
     * @return
     */
    ResponseEntity<String> deleteComment(Long commentId);
}
