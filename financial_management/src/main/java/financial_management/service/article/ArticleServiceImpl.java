package financial_management.service.article;

import financial_management.bl.article.ArticleService;
import financial_management.data.article.ArticleMapper;
import financial_management.entity.ArticlePO;
import financial_management.entity.CommentPO;
import financial_management.parameter.article.ArticleParam;
import financial_management.service.article.collection.CollectionServiceForBl;
import financial_management.service.article.comment.CommentServiceForBl;
import financial_management.service.user.UserServiceForBl;
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
    public ResponseEntity<String> addArticle(ArticleParam articleParam){
        articleMapper.insertArticle(articleParam.getArticlePO());
        return ResponseEntity.ok().body("插入文章成功！");
    }

    @Override
    public ResponseEntity<String> updateArticle(ArticleParam articleParam){
        if(articleMapper.ifExist(articleParam.getArticleId())) {
            ArticlePO articlePO = articleParam.getArticlePO();
            articlePO.setArticleId(articleParam.getArticleId());
            articleMapper.updateArticle(articlePO);
            return ResponseEntity.ok().body("修改文章成功！");
        }else {
            return ResponseEntity.status(403).body("该文章不存在！");
        }
    }

    @Override
    public ResponseEntity<String> deleteArticle(Long articleId){
        if(articleMapper.ifExist(articleId)){
            articleMapper.deleteArticle(articleId);
            return ResponseEntity.ok().body("删除文章成功！");
        }else {
            return ResponseEntity.status(403).body("该文章不存在！");
        }
    }

    @Override
    public ResponseEntity<ArticleVO> getSimpleArticle(Long articleId, Long userId){
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
            return ResponseEntity.ok().body(articleVO);
        }else {
            return ResponseEntity.status(403).build();
        }
    }

    @Override
    public ResponseEntity<List<ArticleSimpleInfoVO>> getAllArticles(Integer category,Integer type,Long userId){
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
        return ResponseEntity.ok().body(articleSimpleInfoVOS);
    }

    @Override
    public ResponseEntity<String> addPageviews(Long articleId){
        if(articleMapper.ifExist(articleId)){
            articleMapper.addPageviews(articleId);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ArticlePO getArticle(Long articleId) {
        return articleMapper.selectArticle(articleId);
    }
}
