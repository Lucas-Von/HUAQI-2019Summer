package financial_management.controller.feedback;

import financial_management.bl.feedback.FeedbackService;
import financial_management.parameter.feedback.FeedbackParam;
import financial_management.parameter.feedback.SolveParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.feedback.FeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/all")
    public BasicResponse<List<FeedbackVO>> getAll(HttpServletRequest request) {
        long reqUserID = jwtUtil.getIdFromRequest(request);
        if (reqUserID == 0) {
            return feedbackService.getAllFeedback();
        } else {
            return feedbackService.getAllFeedback(reqUserID);
        }
    }

    @GetMapping("/all/{ID}")
    public BasicResponse<FeedbackVO> getBy(@PathVariable long ID) {
        return feedbackService.getFeedbackBy(ID);
    }

    @PostMapping("")
    public BasicResponse<?> postFeedback(@RequestBody FeedbackParam feedbackParam, HttpServletRequest request) {
        return feedbackService.postFeedback(feedbackParam,jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/{ID}")
    public BasicResponse<?> solve(@PathVariable long ID, @RequestBody SolveParam solveParam) {
        return feedbackService.solveFeedback(ID, solveParam);
    }

    @GetMapping("/unsolve/count")
    public BasicResponse<Integer> getUnsolveCount(){
        return feedbackService.getAmountOfUnsolve();
    }
}
