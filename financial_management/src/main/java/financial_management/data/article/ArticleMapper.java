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
     * 按照时间获得所有文章的全部信息
     * @param category
     * @return
     */
    List<ArticlePO> selectAllArticlesByTime(@Param("category") Integer category);

    /**
     * 按照浏览量获得所有文章的全部信息
     * @param category
     * @return
     */
    List<ArticlePO> selectAllArticlesByPageviews(@Param("category") Integer category);

    /**
     * 按照时间获得所有文章的全部信息
     * @return
     */
    List<ArticlePO> selectAllArticlesByTimeByAdmin();

    /**
     * 判断一篇文章是否存在
     * @param articleId
     * @return
     */
    boolean ifExist(@Param("articleId") Long articleId);

    /**
     * 给一篇文章的浏览量+1
     * @param articleId
     */
    void addPageviews(@Param("articleId") Long articleId);

    /**
     * 按照标题搜索文章
     * @param title
     * @return
     */
    List<ArticlePO> selectArticleByTitle(@Param("title") String title);

    /**
     * 按照标题搜索文章
     * @param tags
     * @return
     */
    List<ArticlePO> selectArticleByTags(@Param("tags") String tags);
}
