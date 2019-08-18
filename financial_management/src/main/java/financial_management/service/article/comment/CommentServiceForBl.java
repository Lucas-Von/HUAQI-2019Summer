package financial_management.service.article.comment;

import financial_management.entity.CommentPO;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
public interface CommentServiceForBl {
    /**
     * 获得一篇文章的所有评论
     * @param articleId
     * @return
     */
    List<CommentPO> getComments(Long articleId);

    /**
     * 获得一条评论的总点赞数
     * @param commentId
     * @return
     */
    Integer getLights(Long commentId);

    /**
     * 查看一条评论是否被该用户点赞
     * @param userId
     * @param commentId
     * @return
     */
    boolean ifLighted(Long userId, Long commentId);
}
