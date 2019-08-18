package financial_management.data.article;

import financial_management.entity.ArticlePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
@Mapper
public interface ArticleMapper {
    /**
     * 插入一篇文章
     * @param articlePO
     */
    void insertArticle(ArticlePO articlePO);

    /**
     * 修改一篇文章
     * @param articlePO
     */
    void updateArticle(ArticlePO articlePO);

    /**
     * 删除一篇文章
     * @param articleId
     */
    void deleteArticle(@Param("articleId") Long articleId);

    /**
     * 获得一篇文章的全部信息
     * @param articleId
     * @return
     */
    ArticlePO selectArticle(@Param("articleId") Long articleId);

    /**
     * 获得所有文章的全部信息
     * @return
     */
    List<ArticlePO> selectAllArticles(@Param("category") Integer category);

    /**
     * 判断一篇文章是否存在
     * @param articleId
     * @return
     */
    boolean ifExist(@Param("articleId") Long articleId);
}
