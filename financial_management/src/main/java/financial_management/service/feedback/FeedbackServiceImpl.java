package financial_management.service.feedback;

import financial_management.bl.feedback.FeedbackService;
import financial_management.parameter.feedback.FeedbackParam;
import financial_management.parameter.feedback.SolveParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.feedback.FeedbackVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public BasicResponse<?> postFeedback(FeedbackParam feedbackParam) {
        return null;
    }

    @Override
    public BasicResponse<?> solveFeedback(long ID, SolveParam solveParam) {
        return null;
    }

    @Override
    public BasicResponse<List<FeedbackVO>> getAllFeedback() {
        return null;
    }

    @Override
    public BasicResponse<FeedbackVO> getFeedbackBy(long ID) {
        return null;
    }

    @Override
    public BasicResponse<Integer> getAmountOfUnsolve() {
        return null;
    }
}
