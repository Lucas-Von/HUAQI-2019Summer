package financial_management.controller.property;

import financial_management.bl.property.QuestionnaireService;
import financial_management.parameter.QuestionnaireParam;
import financial_management.vo.QuestionnaireVO;
import financial_management.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lt
 * @date 2019/08/18 18:33
 */
@RestController
@RequestMapping("/property")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/questionnaire/view")
    public ResponseVO viewQuestionnaireById(Long userId){
        return questionnaireService.viewQuestionnaire(userId);
    }

    @PostMapping("/questionnaire/add")
    public ResponseVO addQuestionnaire(Long userId, @RequestBody QuestionnaireParam questionnaireParam){
        return questionnaireService.addQuestionnaire(userId, questionnaireParam);
    }

}
