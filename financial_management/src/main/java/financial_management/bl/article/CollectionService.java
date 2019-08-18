package financial_management.bl.article;

import org.springframework.http.ResponseEntity;

/**
 * @author xyh
 * @date 2019/8/17
 */
public interface CollectionService {
    /**
     * 添加收藏
     * @param articleId
     * @param userId
     * @return
     */
    ResponseEntity<String> addCollection(Long articleId, Long userId);

    /**
     * 取消收藏
     * @param articleId
     * @param userId
     * @return
     */
    ResponseEntity<String> deleteCollection(Long articleId, Long userId);
}
