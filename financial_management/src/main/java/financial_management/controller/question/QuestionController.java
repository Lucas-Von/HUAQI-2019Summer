package financial_management.controller.question;

import financial_management.bl.question.QuestionService;
import financial_management.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question/")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("answer")
    public ResponseEntity<String> answer(@RequestParam String question){
        Response<String> response = questionService.answer(question);
        return ResponseEntity.ok("生存还是毁灭，这是一个问题");
    }
}
