package financial_management.bl.feedback;

import financial_management.parameter.feedback.FeedbackParam;
import financial_management.parameter.feedback.SolveParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.feedback.FeedbackVO;

import java.util.List;

public interface FeedbackService {
    BasicResponse<?> postFeedback(FeedbackParam feedbackParam);

    BasicResponse<?> solveFeedback(long ID, SolveParam solveParam);

    BasicResponse<List<FeedbackVO>> getAllFeedback();

    BasicResponse<FeedbackVO> getFeedbackBy(long ID);

    BasicResponse<Integer> getAmountOfUnsolve();
}
