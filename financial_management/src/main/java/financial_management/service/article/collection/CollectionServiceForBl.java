package financial_management.service.article.collection;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
public interface CollectionServiceForBl {
    /**
     * 判断一篇文章是否被该用户收藏
     * @param userId
     * @param articleId
     * @return
     */
    boolean ifCollected(Long userId, Long articleId);

    /**
     * 获得一个用户所有收藏的文章的ID
     * @param userId
     * @return
     */
    List<Long> getCollections(Long userId);

    /**
     * 获得一篇文章的总收藏数
     * @param articleId
     * @return
     */
    Long getCollectionAmount(Long articleId);
}
