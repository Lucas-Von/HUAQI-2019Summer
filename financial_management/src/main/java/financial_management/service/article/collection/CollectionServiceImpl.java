package financial_management.service.article.collection;

import financial_management.bl.article.CollectionService;
import financial_management.data.article.CollectionMapper;
import financial_management.entity.CollectionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
@Service
public class CollectionServiceImpl implements CollectionService, CollectionServiceForBl {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResponseEntity<String> addCollection(Long articleId, Long userId){
        if(collectionMapper.ifCollected(userId,articleId)){
            return ResponseEntity.status(403).body("该文章已被收藏！");
        }else {
            CollectionPO collectionPO = new CollectionPO();
            collectionPO.setUserId(userId);
            collectionPO.setArticleId(articleId);
            collectionMapper.insertCollection(collectionPO);
            return ResponseEntity.ok().body("收藏成功！");
        }
    }

    @Override
    public ResponseEntity<String> deleteCollection(Long articleId, Long userId){
        if(collectionMapper.ifCollected(userId,articleId)){
            CollectionPO collectionPO = new CollectionPO();
            collectionPO.setUserId(userId);
            collectionPO.setArticleId(articleId);
            collectionMapper.deleteCollection(collectionPO);
            return ResponseEntity.ok().body("取消收藏成功！");
        }else {
            return ResponseEntity.status(403).body("该文章未被收藏！");
        }
    }

    @Override
    public boolean ifCollected(Long userId, Long articleId) {
        return collectionMapper.ifCollected(userId, articleId);
    }

    @Override
    public List<Long> getCollections(Long userId) {
        return collectionMapper.getCollections(userId);
    }
}
