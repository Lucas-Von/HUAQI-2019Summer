package financial_management.bl.question;

import financial_management.vo.BasicResponse;

public interface QuestionService {
    BasicResponse<String> answer(String question, Long userID);
}
