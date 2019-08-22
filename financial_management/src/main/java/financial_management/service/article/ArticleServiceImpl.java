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
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.article.ArticleVO;
import financial_management.vo.article.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        articleMapper.insertArticle(articleParam.getArticlePO());
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @Override
    public BasicResponse updateArticle(ArticleParam articleParam){
        if(articleMapper.ifExist(articleParam.getArticleId())) {
            ArticlePO articlePO = articleParam.getArticlePO();
            articlePO.setArticleId(articleParam.getArticleId());
            articleMapper.updateArticle(articlePO);
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }else {
            return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
        }
    }

    @Override
    public BasicResponse deleteArticle(Long articleId){
        if(articleMapper.ifExist(articleId)){
            articleMapper.deleteArticle(articleId);
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }else {
            return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
        }
    }

    @Override
    public BasicResponse getSimpleArticle(Long articleId, Long userId){
        if(articleMapper.ifExist(articleId)){
            ArticlePO articlePO = articleMapper.selectArticle(articleId);
            ArticleVO articleVO = new ArticleVO();
            articleVO.setTitle(articlePO.getTitle());
            articleVO.setMdContent(articlePO.getMdContent());
            articleVO.setHtmlContent(articlePO.getHtmlContent());
            articleVO.setPageviews(articlePO.getPageviews());
            articleVO.setTime(articlePO.getTime());
            articleVO.setTags(articlePO.getTags());

            boolean collected = collectionServiceForBl.ifCollected(userId,articleId);
            articleVO.setCollected(collected);

            List<CommentPO> commentPOS = commentServiceForBl.getComments(articleId);
            List<CommentVO> commentVOS = new ArrayList<>();
            for(int i=0;i<commentPOS.size();i++){
                CommentPO commentPO = commentPOS.get(i);
                CommentVO commentVO = new CommentVO();
                commentVO.setCommentId(commentPO.getId());
                commentVO.setContent(commentPO.getContent());
                commentVO.setTime(commentPO.getTime());

                Long commentUserId = commentPO.getUserId();
                String username = userServiceForBl.getUsername(commentUserId);
                commentVO.setUsername(username);

                commentVO.setLight(commentServiceForBl.getLights(commentPO.getId()));
                commentVO.setLighted(commentServiceForBl.ifLighted(userId,commentPO.getId()));

                commentVOS.add(commentVO);
            }

            articleVO.setComments(commentVOS);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleVO);
        }else {
            return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
        }
    }

    @Override
    public BasicResponse getAllArticles(Integer category,Integer type,Long userId){
        List<ArticlePO> articlePOS = new ArrayList<>();
        if(type == 1){
            articlePOS = articleMapper.selectAllArticlesByTime(category);
        }else if(type == 2){
            articlePOS = articleMapper.selectAllArticlesByPageviews(category);
        }
        List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
        for(int i=0;i<articlePOS.size();i++){
            ArticlePO articlePO = articlePOS.get(i);
            ArticleSimpleInfoVO articleSimpleInfoVO = new ArticleSimpleInfoVO();
            articleSimpleInfoVO.setArticleId(articlePO.getArticleId());
            articleSimpleInfoVO.setSummary(articlePO.getSummary());
            articleSimpleInfoVO.setTitle(articlePO.getTitle());
            articleSimpleInfoVO.setPageviews(articlePO.getPageviews());
            articleSimpleInfoVO.setTime(articlePO.getTime());
            articleSimpleInfoVO.setTags(articlePO.getTags());

            articleSimpleInfoVO.setCollected(collectionServiceForBl.ifCollected(userId, articlePO.getArticleId()));
            articleSimpleInfoVOS.add(articleSimpleInfoVO);
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleInfoVOS);
    }

    @Override
    public BasicResponse addPageviews(Long articleId){
        if(articleMapper.ifExist(articleId)){
            articleMapper.addPageviews(articleId);
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }else {
            return new BasicResponse(ResponseStatus.STATUS_ARTICLE_NOT_EXIST);
        }
    }

    @Override
    public ArticlePO getArticle(Long articleId) {
        return articleMapper.selectArticle(articleId);
    }
}
