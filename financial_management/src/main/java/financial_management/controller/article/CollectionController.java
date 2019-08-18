package financial_management.controller.article;

import financial_management.bl.article.CollectionService;
import financial_management.parameter.CollectionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author xyh
 * @date 2019/8/18
 */
@RestController
@RequestMapping("/article/collection")
public class CollectionController {

    @PostMapping("/add")
    public ResponseEntity<String> addCollection(@RequestBody CollectionParam collectionParam){
        return ResponseEntity.ok().body("添加成功");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCollection(@RequestBody CollectionParam collectionParam){
        return ResponseEntity.ok().body("取消成功");
    }
}
