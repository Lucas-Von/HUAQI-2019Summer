package financial_management.controller.article;

import financial_management.bl.article.ArticleService;
import financial_management.parameter.article.ArticleParam;
import financial_management.util.JwtUtil;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.article.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public ResponseEntity<String> addArticle(@RequestBody ArticleParam articleParam){
        return articleService.addArticle(articleParam);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateArticle(@RequestBody ArticleParam articleParam){
        return articleService.updateArticle(articleParam);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteArticle(@RequestParam Long articleId){
        return articleService.deleteArticle(articleId);
    }

    @GetMapping("/get")
    public ResponseEntity<ArticleVO> getSimpleArticle(@RequestParam Long articleId, HttpServletRequest request){
        return articleService.getSimpleArticle(articleId, jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ArticleSimpleInfoVO>> getAllArticles(@RequestParam Integer category, @RequestParam Integer type, HttpServletRequest request){
        return articleService.getAllArticles(category,type,jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/pageviews/add")
    public ResponseEntity<String> addPageviews(@RequestParam Long articleId){
        return articleService.addPageviews(articleId);
    }
}
