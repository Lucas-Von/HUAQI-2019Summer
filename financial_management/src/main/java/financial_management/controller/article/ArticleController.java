package financial_management.controller.article;

import financial_management.bl.article.ArticleService;
import financial_management.parameter.ArticleParam;
import financial_management.vo.ArticleSimpleInfoVO;
import financial_management.vo.ArticleVO;
import financial_management.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @PostMapping("/add")
    public ResponseEntity<String> addArticle(@RequestBody ArticleParam articleParam){
        return ResponseEntity.ok().body("添加成功！");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateArticle(@RequestBody ArticleParam articleParam){
        return ResponseEntity.ok().body("修改成功！");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteArticle(@RequestParam Long articleId){
        return ResponseEntity.ok().body("删除成功！");
    }

    @GetMapping("/get")
    public ResponseEntity<ArticleVO> getSimpleArticle(@RequestParam Long articleId, @RequestParam Long userId){
        CommentVO commentVO = new CommentVO((long) 1,"好文章","xyh",3,true,new java.sql.Timestamp(System.currentTimeMillis()));
        List<CommentVO> commentVOS = new ArrayList<>();
        commentVOS.add(commentVO);
        ArticleVO articleVO = new ArticleVO("这是标题",true,"这是内容",commentVOS);
        return ResponseEntity.ok().body(articleVO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ArticleSimpleInfoVO> getAllArticles(){
        return ResponseEntity.ok().body(new ArticleSimpleInfoVO((long) 1, "标题", "摘要", false));
    }
}
