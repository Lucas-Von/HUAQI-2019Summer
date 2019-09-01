package financial_management.bl.question;

import financial_management.vo.BasicResponse;

public interface QuestionService {
    public BasicResponse<String> answer(String question, Long userID);
}
