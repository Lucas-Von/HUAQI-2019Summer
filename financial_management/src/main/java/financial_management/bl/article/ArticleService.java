package financial_management.bl.article;

import financial_management.parameter.ArticleParam;
import financial_management.vo.ArticleSimpleInfoVO;
import financial_management.vo.ArticleVO;
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
    ResponseEntity<String> addArticle(ArticleParam articleParam);

    /**
     * 修改文章
     * @param articleParam
     * @return
     */
    ResponseEntity<String> updateArticle(ArticleParam articleParam);

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    ResponseEntity<String> deleteArticle(Long articleId);

    /**
     * 获取一篇文章的全部信息
     * @param articleId
     * @return
     */
    ResponseEntity<ArticleVO> getSimpleArticle(Long articleId, Long userId);

    /**
     * 获取所有文章基本信息
     * @return
     */
    ResponseEntity<List<ArticleSimpleInfoVO>> getAllArticles(Integer category, Long userId);
}
