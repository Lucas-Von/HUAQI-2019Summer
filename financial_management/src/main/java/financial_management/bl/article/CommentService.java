package financial_management.bl.article;

import financial_management.parameter.CommentParam;
import financial_management.parameter.LightCommentParam;
import org.apache.ibatis.annotations.Param;
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
    ResponseEntity<String> addComment(CommentParam commentParam);

    /**
     * 点赞一条评论
     * @param lightCommentParam
     * @return
     */
    ResponseEntity<String> lightComment(LightCommentParam lightCommentParam);

    /**
     * 取消点赞一条评论
     * @param lightCommentParam
     * @return
     */
    ResponseEntity<String> unlightComment(LightCommentParam lightCommentParam);

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
