package financial_management.controller.article;

import financial_management.bl.article.ArticleService;
import financial_management.parameter.article.ArticleParam;
import financial_management.parameter.article.DateParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.article.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public BasicResponse addArticle(@RequestBody ArticleParam articleParam){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PutMapping("/update")
    public BasicResponse updateArticle(@RequestBody ArticleParam articleParam){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @DeleteMapping("/delete")
    public BasicResponse deleteArticle(@RequestParam Long articleId){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @GetMapping("/get")
    public BasicResponse getSimpleArticle(@RequestParam Long articleId, HttpServletRequest request){
        String title = "标题1";
        String mdContent = "aDSaaaa";
        String htmlContent = "153604998@qq.com";
        Long pageviews = 5L;
        Timestamp time = new Timestamp(new Date().getTime());
        String tags = "金融,理财";
        ArticleVO articleVO = new ArticleVO(title, mdContent, htmlContent, pageviews, time, tags);
        articleVO.setCollected(true);
        List<CommentVO> commentVOS = new ArrayList<>();
        CommentVO commentVO1 = new CommentVO(1L, "测试评论1", "鳕鱼", 888, true, new Timestamp(new Date().getTime()));
        CommentVO commentVO2 = new CommentVO(2L, "测试评论2", "薛老板", 666, true, new Timestamp(new Date().getTime()));
        commentVOS.add(commentVO1);
        commentVOS.add(commentVO2);
        articleVO.setComments(commentVOS);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleVO);
    }

    @GetMapping("/getAll")
    public BasicResponse getAllArticles(@RequestParam Integer category, @RequestParam Integer type, HttpServletRequest request){
        List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
        ArticleSimpleInfoVO articleSimpleInfoVO1 = new ArticleSimpleInfoVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融");
        ArticleSimpleInfoVO articleSimpleInfoVO2 = new ArticleSimpleInfoVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技");
        articleSimpleInfoVOS.add(articleSimpleInfoVO1);
        articleSimpleInfoVOS.add(articleSimpleInfoVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleInfoVOS);
    }

    @PostMapping("/pageviews/add")
    public BasicResponse addPageviews(@RequestParam Long articleId){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @GetMapping("/nologin/getAll")
    public BasicResponse getAllArticlesWithoutLogin(@RequestParam Integer category, @RequestParam Integer type){
        List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
        ArticleSimpleInfoVO articleSimpleInfoVO1 = new ArticleSimpleInfoVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融");
        ArticleSimpleInfoVO articleSimpleInfoVO2 = new ArticleSimpleInfoVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技");
        articleSimpleInfoVOS.add(articleSimpleInfoVO1);
        articleSimpleInfoVOS.add(articleSimpleInfoVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleInfoVOS);
    }

    @GetMapping("/nologin/get")
    public BasicResponse getArticleWithoutLogin(@RequestParam Long articleId){
        String title = "标题1";
        String mdContent = "aDSaaaa";
        String htmlContent = "153604998@qq.com";
        Long pageviews = 5L;
        Timestamp time = new Timestamp(new Date().getTime());
        String tags = "金融,理财";
        ArticleVO articleVO = new ArticleVO(title, mdContent, htmlContent, pageviews, time, tags);
        articleVO.setCollected(true);
        List<CommentVO> commentVOS = new ArrayList<>();
        CommentVO commentVO1 = new CommentVO(1L, "测试评论1", "鳕鱼", 888, true, new Timestamp(new Date().getTime()));
        CommentVO commentVO2 = new CommentVO(2L, "测试评论2", "薛老板", 666, true, new Timestamp(new Date().getTime()));
        commentVOS.add(commentVO1);
        commentVOS.add(commentVO2);
        articleVO.setComments(commentVOS);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleVO);
    }

    @GetMapping("/admin/getAll")
    public BasicResponse getAllArticlesByAdmin(){
        List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
        ArticleSimpleAdminVO articleSimpleAdminVO1 = new ArticleSimpleAdminVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融", 1);
        ArticleSimpleAdminVO articleSimpleAdminVO2 = new ArticleSimpleAdminVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技", 3);
        articleSimpleAdminVOS.add(articleSimpleAdminVO1);
        articleSimpleAdminVOS.add(articleSimpleAdminVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
    }

    @GetMapping("/admin/get")
    public BasicResponse getArticleByAdmin(@RequestParam Long articleId){
        String title = "标题1";
        String summary = "摘要1";
        String mdContent = "aDSaaaa";
        String htmlContent = "153604998@qq.com";
        Integer category = 5;
        Timestamp time = new Timestamp(new Date().getTime());
        String tags = "金融,理财";
        ArticleAdminVO articleAdminVO = new ArticleAdminVO(title, summary, mdContent, htmlContent,category, time, tags);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleAdminVO);
    }

    @GetMapping("/admin/search/category")
    public BasicResponse searchArticlesByCategory(@RequestParam Integer category){
        List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
        ArticleSimpleAdminVO articleSimpleAdminVO1 = new ArticleSimpleAdminVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融", 3);
        articleSimpleAdminVO1.setCollections(88L);
        ArticleSimpleAdminVO articleSimpleAdminVO2 = new ArticleSimpleAdminVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技", 5);
        articleSimpleAdminVO2.setCollections(66L);
        articleSimpleAdminVOS.add(articleSimpleAdminVO1);
        articleSimpleAdminVOS.add(articleSimpleAdminVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
    }

    @GetMapping("/admin/search/title")
    public BasicResponse searchArticlesByTitle(@RequestParam String title){
        List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
        ArticleSimpleAdminVO articleSimpleAdminVO1 = new ArticleSimpleAdminVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融", 3);
        articleSimpleAdminVO1.setCollections(88L);
        ArticleSimpleAdminVO articleSimpleAdminVO2 = new ArticleSimpleAdminVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技", 5);
        articleSimpleAdminVO2.setCollections(66L);
        articleSimpleAdminVOS.add(articleSimpleAdminVO1);
        articleSimpleAdminVOS.add(articleSimpleAdminVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
    }

    @PostMapping("/admin/search/time")
    public BasicResponse searchArticlesByTime(@RequestBody DateParam dateParam){
        List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
        ArticleSimpleAdminVO articleSimpleAdminVO1 = new ArticleSimpleAdminVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融", 3);
        articleSimpleAdminVO1.setCollections(88L);
        ArticleSimpleAdminVO articleSimpleAdminVO2 = new ArticleSimpleAdminVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技", 5);
        articleSimpleAdminVO2.setCollections(66L);
        articleSimpleAdminVOS.add(articleSimpleAdminVO1);
        articleSimpleAdminVOS.add(articleSimpleAdminVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
    }

    @GetMapping("/admin/search/tags")
    public BasicResponse searchArticlesByTags(@RequestParam String tags){
        List<ArticleSimpleAdminVO> articleSimpleAdminVOS = new ArrayList<>();
        ArticleSimpleAdminVO articleSimpleAdminVO1 = new ArticleSimpleAdminVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融", 3);
        articleSimpleAdminVO1.setCollections(88L);
        ArticleSimpleAdminVO articleSimpleAdminVO2 = new ArticleSimpleAdminVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技", 5);
        articleSimpleAdminVO2.setCollections(66L);
        articleSimpleAdminVOS.add(articleSimpleAdminVO1);
        articleSimpleAdminVOS.add(articleSimpleAdminVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleAdminVOS);
    }

    @GetMapping("/comment/admin/get")
    public BasicResponse getAllComments(Long articleId){
        List<CommentVO> commentVOS = new ArrayList<>();
        CommentVO commentVO1 = new CommentVO(1L, "测试评论1", "鳕鱼", 888, true, new Timestamp(new Date().getTime()));
        CommentVO commentVO2 = new CommentVO(2L, "测试评论2", "薛老板", 666, true, new Timestamp(new Date().getTime()));
        commentVOS.add(commentVO1);
        commentVOS.add(commentVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, commentVOS);
    }
}
