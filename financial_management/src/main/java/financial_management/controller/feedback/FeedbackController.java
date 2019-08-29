package financial_management.controller.feedback;

import financial_management.bl.feedback.FeedbackService;
import financial_management.entity.FeedBackPO;
import financial_management.parameter.feedback.FeedbackParam;
import financial_management.parameter.feedback.SolveParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.feedback.FeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/all")
    public BasicResponse<List<FeedbackVO>> getAll() {
        List<FeedbackVO> feedbackVOS = new ArrayList<>();
        FeedBackPO feedBackPO = new FeedBackPO();
        feedBackPO.setID(1L);
        feedBackPO.setTitle("为什么不开大？");
        feedBackPO.setType(1);
        feedBackPO.setDetail("喂，老板，他刚才又没开大；我没骂他，我上局就没骂他；这个人应该是思想出了问题");
        feedBackPO.setCreateTime(new Date());
        feedBackPO.setUserID(1L);
        feedBackPO.setPhone("15695293608");
        feedBackPO.setQQ("2508743897");
        feedBackPO.setEmail("153604998@qq.com");
        feedBackPO.setSolved(false);
        feedBackPO.setSolverID(0L);
        feedBackPO.setSolveTime(null);
        feedBackPO.setSolveText(null);
        FeedbackVO feedbackVO1 = new FeedbackVO(feedBackPO);
        feedBackPO.setSolved(true);
        feedBackPO.setSolverID(7L);
        feedBackPO.setSolveTime(new Date());
        feedBackPO.setSolveText("对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区");
        FeedbackVO feedbackVO2 = new FeedbackVO(feedBackPO);
        feedbackVOS.add(feedbackVO1);
        feedbackVOS.add(feedbackVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, feedbackVOS);
    }

    @GetMapping("/all/{ID}")
    public BasicResponse<FeedbackVO> getBy(@PathVariable long ID) {
        FeedBackPO feedBackPO = new FeedBackPO();
        feedBackPO.setID(1L);
        feedBackPO.setTitle("为什么不开大？");
        feedBackPO.setType(1);
        feedBackPO.setDetail("喂，老板，他刚才又没开大；我没骂他，我上局就没骂他；这个人应该是思想出了问题");
        feedBackPO.setCreateTime(new Date());
        feedBackPO.setUserID(1L);
        feedBackPO.setPhone("15695293608");
        feedBackPO.setQQ("2508743897");
        feedBackPO.setEmail("153604998@qq.com");
        feedBackPO.setSolved(true);
        feedBackPO.setSolverID(7L);
        feedBackPO.setSolveTime(new Date());
        feedBackPO.setSolveText("对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区");
        FeedbackVO feedbackVO = new FeedbackVO(feedBackPO);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, feedbackVO);
    }

    @PostMapping("")
    public BasicResponse postFeedback(@RequestBody FeedbackParam feedbackParam) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, 1L);
    }

    @PostMapping("/{ID}")
    public BasicResponse solve(@PathVariable long ID, @RequestBody SolveParam solveParam) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @GetMapping("/unsolve/count")
    public BasicResponse<Integer> getUnsolveCount(){
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, 5);
    }
}
