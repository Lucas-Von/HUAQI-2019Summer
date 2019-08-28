package financial_management.bl.question;

import financial_management.entity.Response;

public interface QuestionService {
    public Response<String> answer(String question);
}
