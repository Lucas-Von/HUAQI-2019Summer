package financial_management.bl.article;

import financial_management.parameter.article.ArticleParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.article.ArticleVO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
public interface ArticleService {
    /**
     * 添加文章（管理员）
     * @param articleParam
     * @return
     */
    BasicResponse addArticle(ArticleParam articleParam);

    /**
     * 修改文章（管理员）
     * @param articleParam
     * @return
     */
    BasicResponse updateArticle(ArticleParam articleParam);

    /**
     * 删除文章（管理员）
     * @param articleId
     * @return
     */
    BasicResponse deleteArticle(Long articleId);

    /**
     * 获取一篇文章的全部信息
     * @param articleId
     * @return
     */
    BasicResponse getSimpleArticle(Long articleId, Long userId);

    /**
     * 获取所有文章基本信息
     * @return
     */
    BasicResponse getAllArticles(Integer category, Integer type, Long userId);

    /**
     * 给一篇文章的浏览量+1
     * @param articleId
     * @return
     */
    BasicResponse addPageviews(Long articleId);

    /**
     * 未登录用户获取所有文章基本信息
     * @param category
     * @param type
     * @return
     */
    BasicResponse getAllArticlesWithoutLogin(Integer category, Integer type);

    /**
     * 未登录用户获取一篇文章的全部信息
     * @param articleId
     * @return
     */
    BasicResponse getArticleWithoutLogin(Long articleId);

    /**
     * 按时间获取所有文章（管理员）
     * @return
     */
    BasicResponse getAllArticlesByAdmin();

    /**
     * 查看文章内容（管理员）
     * @param articleId
     * @return
     */
    BasicResponse getArticleByAdmin(Long articleId);

    /**
     * 按照类型搜索文章（管理员）
     * @param category
     * @return
     */
    BasicResponse searchArticlesByCategory(Integer category);

    /**
     * 按照标题搜索文章（管理员）
     * @param title
     * @return
     */
    BasicResponse searchArticlesByTitle(String title);

    /**
     * 按照时间搜索文章（管理员）
     * @param time
     * @return
     */
    BasicResponse searchArticlesByTime(Date time);

    /**
     * 按照关键词搜索文章（管理员）
     * @param tags
     * @return
     */
    BasicResponse searchArticlesByTags(String tags);


    /**
     * 获得一篇文章的所有评论（管理员）
     * @param articleId
     * @return
     */
    BasicResponse getAllComments(Long articleId);
}