package financial_management.service.article;

import financial_management.entity.ArticlePO;

/**
 * @author xyh
 * @date 2019/8/18
 */
public interface ArticleServiceForBl {
    /**
     * 根据articleId获得一篇文章
     * @param articleId
     * @return
     */
    ArticlePO getArticle(Long articleId);
}
