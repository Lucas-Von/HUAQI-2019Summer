package financial_management.service.feedback;

import financial_management.bl.feedback.FeedbackService;
import financial_management.bl.message.MessageInterface;
import financial_management.data.feedback.FeedbackMapper;
import financial_management.entity.FeedBackPO;
import financial_management.parameter.feedback.FeedbackParam;
import financial_management.parameter.feedback.SolveParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.feedback.FeedbackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private MessageInterface messageInterface;

    @Override
    public BasicResponse<?> postFeedback(FeedbackParam feedbackParam) {
        FeedBackPO po = new FeedBackPO();
        po.setTitle(feedbackParam.getTitle());
        po.setType(feedbackParam.getType());
        po.setDetail(feedbackParam.getDetail());
        po.setUserID(feedbackParam.getUserID());
        po.setPhone(feedbackParam.getPhone());
        po.setQQ(feedbackParam.getQq());
        po.setEmail(feedbackParam.getEmail());
        long id = feedbackMapper.insert(po);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, id);
    }

    @Override
    public BasicResponse<?> solveFeedback(long ID, SolveParam solveParam) {
        FeedBackPO po = new FeedBackPO();
        po.setID(ID);
        po.setSolved(true);
        po.setSolverID(solveParam.getSolverID());
        po.setSolveTime(new Date());
        po.setSolveText(solveParam.getContent());
        int updated = feedbackMapper.update(po);
        if (updated == 1) {
            Long userID = feedbackMapper.selectByID(ID).getUserID();
            messageInterface.postMessageToUserBy(userID,"尊敬的用户，您的问题反馈有了新的答复: "+po.getSolveText());
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @Override
    public BasicResponse<List<FeedbackVO>> getAllFeedback() {
        List<FeedBackPO> pos = feedbackMapper.selectAll();
        List<FeedbackVO> vos = new ArrayList<>(pos.size());
        for (FeedBackPO po : pos) {
            vos.add(new FeedbackVO(po));
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @Override
    public BasicResponse<FeedbackVO> getFeedbackBy(long ID) {
        BasicResponse<FeedbackVO> response;
        FeedBackPO po = feedbackMapper.selectByID(ID);
        if (po == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_FEEDBACK_NOT_EXIST, null);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new FeedbackVO(po));
        }
        return response;
    }

    @Override
    public BasicResponse<Integer> getAmountOfUnsolve() {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, feedbackMapper.selectAmountOfUnsolve());
    }
}
