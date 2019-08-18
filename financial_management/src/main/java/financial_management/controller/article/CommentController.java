package financial_management.controller.article;

import financial_management.bl.article.CommentService;
import financial_management.parameter.CommentParam;
import financial_management.parameter.LightCommentParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author xyh
 * @date 2019/8/18
 */
@RestController
@RequestMapping("/article/comment")
public class CommentController {

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody CommentParam commentParam){
        return ResponseEntity.ok().body("添加成功");
    }

    @PostMapping("/light")
    public ResponseEntity<String> lightComment(@RequestBody LightCommentParam lightCommentParam){
        return ResponseEntity.ok().body("点赞成功");
    }

    @PostMapping("/unlight")
    public ResponseEntity<String> unlightComment(@RequestBody LightCommentParam lightCommentParam){
        return ResponseEntity.ok().body("取消点赞成功");
    }

    @PostMapping("/report")
    public ResponseEntity<String> reportComment(@RequestParam Long commentId){
        return ResponseEntity.ok().body("举报成功");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteComment(@RequestParam Long commentId){
        return ResponseEntity.ok().body("删除成功");
    }
}
