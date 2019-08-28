package financial_management.service.article.comment;

import financial_management.bl.article.CommentService;
import financial_management.bl.message.MessageInterface;
import financial_management.data.article.CommentMapper;
import financial_management.entity.ArticlePO;
import financial_management.entity.CommentPO;
import financial_management.entity.LightPO;
import financial_management.parameter.article.CommentParam;
import financial_management.service.article.ArticleServiceForBl;
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
public class CommentServiceImpl implements CommentService, CommentServiceForBl {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleServiceForBl articleServiceForBl;

    @Autowired
    private MessageInterface messageInterface;

    @Override
    public BasicResponse addComment(CommentParam commentParam, Long userId){
        try {
            CommentPO commentPO = new CommentPO();
            commentPO.setArticleId(commentParam.getArticleId());
            commentPO.setContent(commentParam.getContent());
            commentPO.setUserId(userId);
            commentMapper.insertComment(commentPO);
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse lightComment(Long commentId, Long userId){
        try {
            if (commentMapper.ifExist(commentId)) {
                if (commentMapper.ifLighted(userId, commentId)) {
                    return new BasicResponse(ResponseStatus.STATUS_COMMENT_LIGHTED);
                } else {
                    LightPO lightPO = new LightPO(commentId, userId);
                    commentMapper.lightComment(lightPO);
                    return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
                }
            } else {
                return new BasicResponse(ResponseStatus.STATUS_COMMENT_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse unlightComment(Long commentId, Long userId){
        try {
            if (commentMapper.ifExist(commentId)) {
                if (commentMapper.ifLighted(userId, commentId)) {
                    LightPO lightPO = new LightPO(commentId, userId);
                    commentMapper.unlightComment(lightPO);
                    return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
                } else {
                    return new BasicResponse(ResponseStatus.STATUS_COMMENT_NOT_LIGHTED);
                }
            } else {
                return new BasicResponse(ResponseStatus.STATUS_COMMENT_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse reportComment(Long commentId){
        try {
            if (commentMapper.ifExist(commentId)) {
                CommentPO commentPO = commentMapper.selectComment(commentId);
                Long articleId = commentPO.getArticleId();
                ArticlePO articlePO = articleServiceForBl.getArticle(articleId);
                String title = articlePO.getTitle();
                String commentContent = commentPO.getContent();
                String postContent = "文章：《" + title + "》下的评论：“" + commentContent + "”被一举报，请去确认情况是否属实！";
                messageInterface.postMessageToUserBy((long) 0, postContent);
                System.out.println(postContent);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_COMMENT_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse deleteComment(Long commentId){
        try {
            if (commentMapper.ifExist(commentId)) {
                commentMapper.deleteComment(commentId);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_COMMENT_NOT_EXIST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public List<CommentPO> getComments(Long articleId) {
        return commentMapper.selectComments(articleId);
    }

    @Override
    public Integer getLights(Long commentId) {
        return commentMapper.selectLights(commentId);
    }

    @Override
    public boolean ifLighted(Long userId, Long commentId) {
        return commentMapper.ifLighted(userId,commentId);
    }
}
