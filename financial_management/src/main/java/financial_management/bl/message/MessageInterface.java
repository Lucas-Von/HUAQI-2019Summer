package financial_management.bl.message;

import financial_management.vo.BasicResponse;

public interface MessageInterface {
    BasicResponse<?> postMessageToUserBy(Long userID, String content);
}
