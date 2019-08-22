package financial_management.bl.article;

import financial_management.vo.BasicResponse;
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
    BasicResponse addCollection(Long articleId, Long userId);

    /**
     * 取消收藏
     * @param articleId
     * @param userId
     * @return
     */
    BasicResponse deleteCollection(Long articleId, Long userId);
}
