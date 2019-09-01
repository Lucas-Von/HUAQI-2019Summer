package financial_management.controller.question;

import financial_management.bl.question.QuestionService;
import financial_management.entity.Response;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/question/")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("answer")
    public BasicResponse<String> answer(@RequestParam String question, HttpServletRequest request){
        return questionService.answer(question, jwtUtil.getIdFromRequest(request));
    }
}
