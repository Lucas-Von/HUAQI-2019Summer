package financial_management.data.article;

import financial_management.entity.CollectionPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/17
 */
@Repository
@Mapper
public interface CollectionMapper {
    /**
     * 添加一条收藏记录
     * @param collectionPO
     */
    void insertCollection(CollectionPO collectionPO);

    /**
     * 删除一条收藏记录
     * @param collectionPO
     */
    void deleteCollection(CollectionPO collectionPO);

    /**
     * 查看一篇文章是否被该用户收藏
     * @param userId
     * @param articleId
     * @return
     */
    boolean ifCollected(@Param("userId") Long userId, @Param("articleId") Long articleId);

    /**
     * 获得一个用户所有收藏的文章
     * @param userId
     * @return
     */
    List<Long> getCollections(@Param("userId") Long userId);

    /**
     * 获得一篇文章的总收藏数
     * @param articleId
     * @return
     */
    Long getCollectionAmount(@Param("articleId") Long articleId);
}
