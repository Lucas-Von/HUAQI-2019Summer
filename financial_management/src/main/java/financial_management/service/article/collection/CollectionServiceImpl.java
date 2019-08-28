package financial_management.service.article.collection;

import financial_management.bl.article.CollectionService;
import financial_management.data.article.CollectionMapper;
import financial_management.entity.CollectionPO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BasicResponse addCollection(Long articleId, Long userId){
        try {
            if (collectionMapper.ifCollected(userId, articleId)) {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_COLLECTED);
            } else {
                CollectionPO collectionPO = new CollectionPO();
                collectionPO.setUserId(userId);
                collectionPO.setArticleId(articleId);
                collectionMapper.insertCollection(collectionPO);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse deleteCollection(Long articleId, Long userId){
        try {
            if (collectionMapper.ifCollected(userId, articleId)) {
                CollectionPO collectionPO = new CollectionPO();
                collectionPO.setUserId(userId);
                collectionPO.setArticleId(articleId);
                collectionMapper.deleteCollection(collectionPO);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_COLLECTED);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
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

    @Override
    public Long getCollectionAmount(Long articleId){
        return collectionMapper.getCollectionAmount(articleId);
    }
}