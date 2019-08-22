package financial_management.controller.article;

import financial_management.bl.article.CommentService;
import financial_management.parameter.article.CommentParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xyh
 * @date 2019/8/18
 */
@CrossOrigin
@RestController
@RequestMapping("/article/comment")
public class CommentController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public BasicResponse addComment(@RequestBody CommentParam commentParam, HttpServletRequest request) {
        return commentService.addComment(commentParam, jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/light")
    public BasicResponse lightComment(@RequestParam Long commentId, HttpServletRequest request){
        return commentService.lightComment(commentId, jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/unlight")
    public BasicResponse unlightComment(@RequestParam Long commentId, HttpServletRequest request){
        return commentService.unlightComment(commentId, jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/report")
    public BasicResponse reportComment(@RequestParam Long commentId){
        return commentService.reportComment(commentId);
    }

    @DeleteMapping("/delete")
    public BasicResponse deleteComment(@RequestParam Long commentId){
        return commentService.deleteComment(commentId);
    }
}
