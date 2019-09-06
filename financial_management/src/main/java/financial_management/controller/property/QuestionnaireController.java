package financial_management.controller.property;

import financial_management.bl.property.QuestionnaireService;
import financial_management.parameter.property.QuestionnaireParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
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

    @GetMapping(value = "/questionnaire/view")
    public BasicResponse viewQuestionnaire() {
        return questionnaireService.viewQuestionnaire();
    }

    @PostMapping(value = "/questionnaire/set")
    public BasicResponse setQuestionnaire(@RequestBody QuestionnaireParam questionnaireParam) {
        return questionnaireService.setQuestionnaire(questionnaireParam);
    }

    @GetMapping(value = "/questionnaire/getInvestPrefer")
    public BasicResponse getInvestPrefer(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return questionnaireService.getInvestPrefer(userId);
    }

    @GetMapping(value = "/questionnaire/editExpectedYield")
    public BasicResponse editExpectedYield(HttpServletRequest request, @RequestParam double expectedYield) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return questionnaireService.editExpectedYield(userId, expectedYield);
    }

    @GetMapping(value = "/questionnaire/getExpectedYield")
    public BasicResponse getExpectedYield(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return questionnaireService.getExpectedYield(userId);
    }

}
