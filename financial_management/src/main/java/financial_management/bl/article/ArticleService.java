package financial_management.bl.article;

import financial_management.parameter.article.ArticleParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.article.ArticleVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param articleParam
     * @return
     */
    BasicResponse addArticle(ArticleParam articleParam);

    /**
     * 修改文章
     * @param articleParam
     * @return
     */
    BasicResponse updateArticle(ArticleParam articleParam);

    /**
     * 删除文章
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
}
