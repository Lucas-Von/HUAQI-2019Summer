package financial_management.service.article;

import financial_management.bl.article.ArticleService;
import financial_management.data.article.ArticleMapper;
import financial_management.entity.ArticlePO;
import financial_management.entity.CommentPO;
import financial_management.parameter.article.ArticleParam;
import financial_management.service.article.collection.CollectionServiceForBl;
import financial_management.service.article.comment.CommentServiceForBl;
import financial_management.service.user.UserServiceForBl;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.article.*;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
@Service
public class ArticleServiceImpl implements ArticleService, ArticleServiceForBl {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CollectionServiceForBl collectionServiceForBl;
    @Autowired
    private CommentServiceForBl commentServiceForBl;
    @Autowired
    private UserServiceForBl userServiceForBl;

    @Override
    public BasicResponse addArticle(ArticleParam articleParam){
        try {
            articleMapper.insertArticle(articleParam.getArticlePO());
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updateArticle(ArticleParam articleParam){
        try {
            if (articleMapper.ifExist(articleParam.getArticleId())) {
                ArticlePO articlePO = articleParam.getArticlePO();
                articlePO.setArticleId(articleParam.getArticleId());
                articleMapper.updateArticle(articlePO);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse deleteArticle(Long articleId){
        try {
            if (articleMapper.ifExist(articleId)) {
                articleMapper.deleteArticle(articleId);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getSimpleArticle(Long articleId, Long userId){
        try {
            if (articleMapper.ifExist(articleId)) {
                ArticlePO articlePO = articleMapper.selectArticle(articleId);
                ArticleVO articleVO = articlePO.getArticleVO();

                boolean collected = collectionServiceForBl.ifCollected(userId, articleId);
                articleVO.setCollected(collected);

                List<CommentPO> commentPOS = commentServiceForBl.getComments(articleId);
                List<CommentVO> commentVOS = new ArrayList<>();
                for (int i = 0; i < commentPOS.size(); i++) {
                    CommentPO commentPO = commentPOS.get(i);
                    CommentVO commentVO = new CommentVO();
                    commentVO.setCommentId(commentPO.getId());
                    commentVO.setContent(commentPO.getContent());
                    commentVO.setTime(commentPO.getTime());

                    Long commentUserId = commentPO.getUserId();
                    String username = userServiceForBl.getUsername(commentUserId);
                    commentVO.setUsername(username);

                    commentVO.setLight(commentServiceForBl.getLights(commentPO.getId()));
                    commentVO.setLighted(commentServiceForBl.ifLighted(userId, commentPO.getId()));

                    commentVOS.add(commentVO);
                }

                articleVO.setComments(commentVOS);
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleVO);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getAllArticles(Integer category,Integer type,Long userId){
        try {
            List<ArticlePO> articlePOS = new ArrayList<>();
            if (type == 1) {
                articlePOS = articleMapper.selectAllArticlesByTime(category);
            } else if (type == 2) {
                articlePOS = articleMapper.selectAllArticlesByPageviews(category);
            }
            List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
            for (int i = 0; i < articlePOS.size(); i++) {
                ArticlePO articlePO = articlePOS.get(i);
                ArticleSimpleInfoVO articleSimpleInfoVO = articlePO.getArticleSimpleInfoVO();

                articleSimpleInfoVO.setCollected(collectionServiceForBl.ifCollected(userId, articlePO.getArticleId()));
                articleSimpleInfoVOS.add(articleSimpleInfoVO);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleInfoVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse addPageviews(Long articleId){
        try {
            if (articleMapper.ifExist(articleId)) {
                articleMapper.addPageviews(articleId);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getAllComments(Long articleId){
        try {
            if (articleMapper.ifExist(articleId)) {
                List<CommentPO> commentPOS = commentServiceForBl.getComments(articleId);
                List<CommentVO> commentVOS = new ArrayList<>();
                for (int i = 0; i < commentPOS.size(); i++) {
                    CommentPO commentPO = commentPOS.get(i);
                    CommentVO commentVO = new CommentVO();
                    commentVO.setCommentId(commentPO.getId());
                    commentVO.setContent(commentPO.getContent());
                    commentVO.setTime(commentPO.getTime());

                    Long commentUserId = commentPO.getUserId();
                    String username = userServiceForBl.getUsername(commentUserId);
                    commentVO.setUsername(username);

                    commentVO.setLight(commentServiceForBl.getLights(commentPO.getId()));

                    commentVOS.add(commentVO);
                }
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, commentVOS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getAllArticlesWithoutLogin(Integer category, Integer type){
        try {
            List<ArticlePO> articlePOS = new ArrayList<>();
            if (type == 1) {
                articlePOS = articleMapper.selectAllArticlesByTime(category);
            } else if (type == 2) {
                articlePOS = articleMapper.selectAllArticlesByPageviews(category);
            }
            List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
            for (int i = 0; i < articlePOS.size(); i++) {
                ArticlePO articlePO = articlePOS.get(i);
                ArticleSimpleInfoVO articleSimpleInfoVO = articlePO.getArticleSimpleInfoVO();
                articleSimpleInfoVOS.add(articleSimpleInfoVO);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleInfoVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getArticleWithoutLogin(Long articleId){
        try {
            if (articleMapper.ifExist(articleId)) {
                ArticlePO articlePO = articleMapper.selectArticle(articleId);
                ArticleVO articleVO = articlePO.getArticleVO();

                List<CommentPO> commentPOS = commentServiceForBl.getComments(articleId);
                List<CommentVO> commentVOS = new ArrayList<>();
                for (int i = 0; i < commentPOS.size(); i++) {
                    CommentPO commentPO = commentPOS.get(i);
                    CommentVO commentVO = new CommentVO();
                    commentVO.setCommentId(commentPO.getId());
                    commentVO.setContent(commentPO.getContent());
                    commentVO.setTime(commentPO.getTime());

                    Long commentUserId = commentPO.getUserId();
                    String username = userServiceForBl.getUsername(commentUserId);
                    commentVO.setUsername(username);

                    commentVO.setLight(commentServiceForBl.getLights(commentPO.getId()));

                    commentVOS.add(commentVO);
                }

                articleVO.setComments(commentVOS);
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleVO);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getAllArticlesByAdmin(){
        try {
            List<ArticlePO> articlePOS = articleMapper.selectAllArticlesByTimeByAdmin();
            List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
            for (int i = 0; i < articlePOS.size(); i++) {
                ArticlePO articlePO = articlePOS.get(i);
                ArticleSimpleAdminVO articleSimpleAdminVO = articlePO.getArticleSimpleAdminVO();
                articleSimpleAdminVO.setCollections(collectionServiceForBl.getCollectionAmount(articlePO.getArticleId()));

                articleSimpleAdminVOS.add(articleSimpleAdminVO);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getArticleByAdmin(Long articleId){
        try {
            if (articleMapper.ifExist(articleId)) {
                ArticlePO articlePO = articleMapper.selectArticle(articleId);
                ArticleAdminVO articleAdminVO = articlePO.getArticleAdminVO();
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleAdminVO);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse searchArticlesByCategory(Integer category){
        try {
            List<ArticlePO> articlePOS = articleMapper.selectAllArticlesByTime(category);
            List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
            for (int i = 0; i < articlePOS.size(); i++) {
                ArticlePO articlePO = articlePOS.get(i);
                ArticleSimpleAdminVO articleSimpleAdminVO = articlePO.getArticleSimpleAdminVO();
                articleSimpleAdminVO.setCollections(collectionServiceForBl.getCollectionAmount(articlePO.getArticleId()));

                articleSimpleAdminVOS.add(articleSimpleAdminVO);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse searchArticlesByTitle(String title){
        try {
            List<ArticlePO> articlePOS = articleMapper.selectArticleByTitle(title);
            List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
            for (int i = 0; i < articlePOS.size(); i++) {
                ArticlePO articlePO = articlePOS.get(i);
                ArticleSimpleAdminVO articleSimpleAdminVO = articlePO.getArticleSimpleAdminVO();
                articleSimpleAdminVO.setCollections(collectionServiceForBl.getCollectionAmount(articlePO.getArticleId()));

                articleSimpleAdminVOS.add(articleSimpleAdminVO);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse searchArticlesByTime(Date time){
        try {
            List<ArticlePO> articlePOS = articleMapper.selectAllArticlesByTimeByAdmin();
            List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
            for (int i = 0; i < articlePOS.size(); i++) {
                ArticlePO articlePO = articlePOS.get(i);
                Timestamp articleTime = articlePO.getTime();
                Date articleDate = articleTime;
                articleDate = new Date(articleTime.getTime());
                // 判断是否是同一天
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(time);
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(articleDate);
                if (isSameDay(cal1, cal2)) {
                    ArticleSimpleAdminVO articleSimpleAdminVO = articlePO.getArticleSimpleAdminVO();
                    articleSimpleAdminVO.setCollections(collectionServiceForBl.getCollectionAmount(articlePO.getArticleId()));

                    articleSimpleAdminVOS.add(articleSimpleAdminVO);
                }
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse searchArticlesByTags(String tags){
        try {
            List<ArticlePO> articlePOS = articleMapper.selectArticleByTags(tags);
            List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
            for (int i = 0; i < articlePOS.size(); i++) {
                ArticlePO articlePO = articlePOS.get(i);
                ArticleSimpleAdminVO articleSimpleAdminVO = articlePO.getArticleSimpleAdminVO();
                articleSimpleAdminVO.setCollections(collectionServiceForBl.getCollectionAmount(articlePO.getArticleId()));

                articleSimpleAdminVOS.add(articleSimpleAdminVO);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public ArticlePO getArticle(Long articleId) {
        return articleMapper.selectArticle(articleId);
    }

    /**
     * 判断两个日期是否相同
     * @param cal1
     * @param cal2
     * @return
     */
    private boolean isSameDay(Calendar cal1, Calendar cal2) {
        if(cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }
}
