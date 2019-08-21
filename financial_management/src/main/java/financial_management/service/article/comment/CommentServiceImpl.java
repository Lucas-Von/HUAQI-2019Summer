package financial_management.service.article.comment;

import financial_management.bl.article.CommentService;
import financial_management.data.article.CommentMapper;
import financial_management.entity.CommentPO;
import financial_management.entity.LightPO;
import financial_management.parameter.article.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<String> addComment(CommentParam commentParam, Long userId){
        CommentPO commentPO = new CommentPO();
        commentPO.setArticleId(commentParam.getArticleId());
        commentPO.setContent(commentParam.getContent());
        commentPO.setUserId(userId);
        commentMapper.insertComment(commentPO);
        return ResponseEntity.ok().body("添加评论成功！");
    }

    @Override
    public ResponseEntity<String> lightComment(Long commentId, Long userId){
        if(commentMapper.ifExist(commentId)){
            if(commentMapper.ifLighted(userId,commentId)){
                return ResponseEntity.status(403).body("该评论已经被点赞！");
            }else {
                LightPO lightPO = new LightPO(commentId, userId);
                commentMapper.lightComment(lightPO);
                return ResponseEntity.ok().body("点赞成功！");
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> unlightComment(Long commentId, Long userId){
        if(commentMapper.ifExist(commentId)){
            if(commentMapper.ifLighted(userId,commentId)){
                LightPO lightPO = new LightPO(commentId, userId);
                commentMapper.unlightComment(lightPO);
                return ResponseEntity.ok().body("取消点赞成功！");
            }else {
                return ResponseEntity.status(403).body("该评论未被点赞！");
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> reportComment(Long commentId){
        if(commentMapper.ifExist(commentId)){
            // TODO
            // 调用发送信息给管理员发送举报评论的信息

            return ResponseEntity.ok().body("举报评论成功！");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteComment(Long commentId){
        if(commentMapper.ifExist(commentId)){
            commentMapper.deleteComment(commentId);
            return ResponseEntity.ok().body("删除评论成功！");
        }else {
            return ResponseEntity.notFound().build();
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
