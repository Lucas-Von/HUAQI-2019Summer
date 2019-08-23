package financial_management.bl.article;

import financial_management.parameter.article.CommentParam;
import financial_management.vo.BasicResponse;
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
    BasicResponse addComment(CommentParam commentParam, Long userId);

    /**
     * 点赞一条评论
     * @param commentId
     * @param userId
     * @return
     */
    BasicResponse lightComment(Long commentId, Long userId);

    /**
     * 取消点赞一条评论
     * @param commentId
     * @param userId
     * @return
     */
    BasicResponse unlightComment(Long commentId, Long userId);

    /**
     * 举报一条评论（消息通知告诉管理员）
     * @param commentId
     * @return
     */
    BasicResponse reportComment(Long commentId);

    /**
     * 删除一条评论（管理员）
     * @param commentId
     * @return
     */
    BasicResponse deleteComment(Long commentId);
}
