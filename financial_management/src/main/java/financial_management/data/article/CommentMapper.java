package financial_management.data.article;

import financial_management.entity.CommentPO;
import financial_management.entity.LightPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
@Repository
@Mapper
public interface CommentMapper {
    /**
     * 添加一条评论
     * @param commentPO
     */
    void insertComment(CommentPO commentPO);

    /**
     * 删除一条评论
     * @param commentId
     */
    void deleteComment(@Param("commentId") Long commentId);

    /**
     * 获得一篇文章的所有评论
     * @param articleId
     * @return
     */
    List<CommentPO> selectComments(@Param("articleId") Long articleId);

    /**
     * 点赞一条评论
     * @param lightPO
     */
    void lightComment(LightPO lightPO);

    /**
     * 取消点赞一条评论
     * @param lightPO
     */
    void unlightComment(LightPO lightPO);

    /**
     * 查看一条评论是否被该用户点赞
     * @param userId
     * @param commentId
     * @return
     */
    boolean ifLighted(@Param("userId") Long userId, @Param("commentId") Long commentId);

    /**
     * 查看一条评论的总点赞数
     * @param commentId
     * @return
     */
    Integer selectLights(@Param("commentId") Long commentId);

    /**
     * 判断一条评论是否存在
     * @param commentId
     * @return
     */
    boolean ifExist(@Param("commentId") Long commentId);

    /**
     * 获得一条评论
     * @param commentId
     * @return
     */
    CommentPO selectComment(@Param("commentId") Long commentId);
}
