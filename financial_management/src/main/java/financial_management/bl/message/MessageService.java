package financial_management.bl.message;

import financial_management.entity.Response;
import financial_management.vo.message.MessageVO;
import financial_management.vo.message.NewMessageVO;

import java.util.List;

public interface MessageService {
    Response<List<MessageVO>> getMessagesByUser(Long ID);

    Response<List<MessageVO>> getMessagesByUser(Long ID,int type);

    Response<List<MessageVO>> getMessagesByUser(Long ID,int type,int page);

    Response<List<NewMessageVO>> getNewMessageByUser(Long ID);

    Response<?> readNewMessages(Long userID,int type);

    Response<?> removeMessageByMessageID(Long ID);

    //TODO postMessageToUserBy
}
