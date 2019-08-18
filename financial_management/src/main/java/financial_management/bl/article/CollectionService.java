package financial_management.bl.article;

import financial_management.parameter.CollectionParam;
import org.springframework.http.ResponseEntity;

/**
 * @author xyh
 * @date 2019/8/17
 */
public interface CollectionService {
    /**
     * 添加收藏
     * @param collectionParam
     * @return
     */
    ResponseEntity<String> addCollection(CollectionParam collectionParam);

    /**
     * 取消收藏
     * @param collectionParam
     * @return
     */
    ResponseEntity<String> deleteCollection(CollectionParam collectionParam);
}
