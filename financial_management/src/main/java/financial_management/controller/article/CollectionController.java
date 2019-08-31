package financial_management.controller.article;

import financial_management.bl.article.CollectionService;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
@CrossOrigin
@RestController
@RequestMapping("/article")
public class CollectionController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CollectionService collectionService;

    @PostMapping("/collection/add")
    public BasicResponse addCollection(@RequestParam Long articleId, HttpServletRequest request){
        return collectionService.addCollection(articleId, jwtUtil.getIdFromRequest(request));
    }

    @DeleteMapping("/collection/delete")
    public BasicResponse deleteCollection(@RequestParam Long articleId, HttpServletRequest request){
        return collectionService.deleteCollection(articleId, jwtUtil.getIdFromRequest(request));
    }

    @DeleteMapping("/collections/delete")
    public BasicResponse deleteCollections(@RequestParam List<Long> articleIds, HttpServletRequest request){
        return collectionService.deleteCollections(articleIds, jwtUtil.getIdFromRequest(request));
    }
}
