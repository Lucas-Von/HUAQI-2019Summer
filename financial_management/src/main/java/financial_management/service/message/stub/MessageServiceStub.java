package financial_management.service.message.stub;

import financial_management.bl.message.MessageService;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.message.MessageVO;
import financial_management.vo.message.NewMessageVO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageServiceStub implements MessageService {
    private MessageVO m1;
    private MessageVO m2;
    private MessageVO m3;
    private NewMessageVO nm1;
    private NewMessageVO nm2;
    private NewMessageVO nm3;

    {
        m1 = new MessageVO((long) 1, new Date(), (long) 1, 1, "调仓消息", false);
        m2 = new MessageVO((long) 2, new Date(), (long) 1, 2, "系统消息", false);
        m3 = new MessageVO((long) 3, new Date(), (long) 1, 3, "文章互动消息", false);
        nm1 = new NewMessageVO(1, "调仓消息", 1);
        nm2 = new NewMessageVO(2, "系统消息", 1);
        nm3 = new NewMessageVO(3, "文章互动消息", 1);
    }

    @Override
    public BasicResponse<List<MessageVO>> getMessagesByUser(Long ID) {
        BasicResponse<List<MessageVO>> response;
        if (ID == 1) {
            List<MessageVO> list = new ArrayList<>(Arrays.asList(m1, m2, m3));
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, list);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_USER_NOT_EXIST, null);
        }
        return response;
    }

    @Override
    public BasicResponse<List<MessageVO>> getMessagesByUser(Long ID, int type) {
        BasicResponse<List<MessageVO>> response;
        if (ID == 1) {
            if (type == 1) {
                response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, Collections.singletonList(m1));
            } else if (type == 2) {
                response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, Collections.singletonList(m2));
            } else if (type == 3) {
                response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, Collections.singletonList(m3));
            } else {
                response = new BasicResponse<>(ResponseStatus.STATUS_WRONG_MESSAGE_TYPE, null);
            }
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_USER_NOT_EXIST, null);
        }
        return response;
    }

    @Override
    public BasicResponse<List<MessageVO>> getMessagesByUser(Long ID, int type, int page) {
        return getMessagesByUser(ID, type);
    }

    @Override
    public BasicResponse<List<NewMessageVO>> getNewMessageByUser(Long ID) {
        BasicResponse<List<NewMessageVO>> response;
        if (ID == 1) {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, Arrays.asList(nm1, nm2, nm3));
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_USER_NOT_EXIST, null);
        }
        return response;
    }

    @Override
    public BasicResponse<?> readNewMessages(Long userID, int type) {
        return null;
    }

    @Override
    public BasicResponse<?> readNewMessage(Long userID, Long messageID) {
        return null;
    }

    @Override
    public void readTransferMessage(long transID) throws Exception {

    }

    @Override
    public BasicResponse<?> removeMessageByMessageID(Long ID) {
        return null;
    }
}
