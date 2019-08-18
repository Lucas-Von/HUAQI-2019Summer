package financial_management.controller.article;

import financial_management.bl.article.CollectionService;
import financial_management.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xyh
 * @date 2019/8/18
 */
@RestController
@RequestMapping("/article/collection")
public class CollectionController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CollectionService collectionService;

    @PostMapping("/add")
    public ResponseEntity<String> addCollection(@RequestParam Long articleId, HttpServletRequest request){
        return collectionService.addCollection(articleId, jwtUtil.getIdFromRequest(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCollection(@RequestParam Long articleId, HttpServletRequest request){
        return collectionService.deleteCollection(articleId, jwtUtil.getIdFromRequest(request));
    }
}
