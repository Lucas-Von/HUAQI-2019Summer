package financial_management.controller.property;

import financial_management.bl.property.QuestionnaireService;
import financial_management.parameter.property.NVipQuestionnaireParam;
import financial_management.parameter.property.VipQuestionnaireParam;
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

    @GetMapping(value = "/questionnaire/judge")
    public BasicResponse hasQuestionnaire(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return questionnaireService.hasQuestionnaire(userId);
    }

    @GetMapping(value = "/questionnaire/view")
    public BasicResponse viewQuestionnaire() {
        return questionnaireService.viewQuestionnaire();
    }

    @PostMapping(value = "/questionnaire/set/vip")
    public BasicResponse setVipQuestionnaire(HttpServletRequest request, @RequestBody VipQuestionnaireParam vipQuestionnaireParam) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return questionnaireService.setVipQuestionnaire(userId, vipQuestionnaireParam);
    }

    @PostMapping(value = "/questionnaire/set/unVip")
    public BasicResponse setNVipQuestionnaire(HttpServletRequest request, @RequestBody NVipQuestionnaireParam nVipQuestionnaireParam) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return questionnaireService.setNVipQuestionnaire(userId, nVipQuestionnaireParam);
    }

    @GetMapping(value = "/questionnaire/getInvestPrefer")
    public BasicResponse getInvestPrefer(HttpServletRequest request) {
        Long userId = jwtUtil.getIdFromRequest(request);
        return questionnaireService.getInvestPrefer(userId);
    }

    @PostMapping(value = "/questionnaire/editExpectedYield")
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