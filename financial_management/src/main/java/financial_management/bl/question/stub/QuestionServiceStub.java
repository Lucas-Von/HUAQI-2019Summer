package financial_management.bl.question.stub;

import financial_management.bl.question.QuestionService;
import financial_management.entity.Response;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceStub implements QuestionService {
    @Override
    public Response<String> answer(String question) {
        return new Response<>(true,200,null,"我什么都不知道哦~");
    }
}
