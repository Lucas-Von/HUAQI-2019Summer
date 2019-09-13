package financial_management.bl.message;

import financial_management.vo.BasicResponse;
import financial_management.vo.message.MessageVO;
import financial_management.vo.message.NewMessageVO;

import java.util.List;

public interface MessageService {
    BasicResponse<List<? extends MessageVO>> getMessagesByUser(Long ID);

    BasicResponse<List<? extends MessageVO>> getMessagesByUser(Long ID, int type);

    BasicResponse<List<? extends MessageVO>> getMessagesByUser(Long ID, int type, int page);

    BasicResponse<List<NewMessageVO>> getNewMessageByUser(Long ID);

    BasicResponse<?> readNewMessages(Long userID, int type);

    BasicResponse<?> readNewMessage(Long userID, Long messageID);

    void readTransferMessage(long transID) throws Exception;

    BasicResponse<?> removeMessageByMessageID(Long ID);
}
