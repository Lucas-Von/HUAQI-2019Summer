package financial_management.bl.question.stub;

import financial_management.bl.question.QuestionService;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceStub implements QuestionService {
    @Override
    public BasicResponse<String> answer(String question, Long userID) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, "我什么都不知道哦~");
    }
}
