package financial_management.controller.property;

import financial_management.bl.property.QuestionnaireService;
import financial_management.entity.property.QuestionnairePO;
import financial_management.parameter.property.QuestionnaireParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lt
 * @date 2019/08/18 18:33
 */
@CrossOrigin
@RestController
@RequestMapping("/property")
public class QuestionnaireController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/questionnaire/judge")
    public BasicResponse hasQuestionnaire(HttpServletRequest request) {
        return new BasicResponse(ResponseStatus.STATUS_QUESTIONNAIRE_EXIST);
    }

    @GetMapping("/questionnaire/view")
    public BasicResponse viewQuestionnaire() {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new QuestionnairePO().getVO());
    }

    @PostMapping("/questionnaire/add")
    public BasicResponse addQuestionnaire(@RequestBody QuestionnaireParam questionnaireParam) {
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

}
