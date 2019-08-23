package financial_management.service.message.impl;

import financial_management.bl.message.MessageService;
import financial_management.data.message.MessageMapper;
import financial_management.entity.MessagePO;
import financial_management.entity.Response;
import financial_management.vo.message.MessageVO;
import financial_management.vo.message.NewMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Response<List<MessageVO>> getMessagesByUser(Long ID) {
        List<MessagePO> messages = messageMapper.selectByUserID(ID);
        List<MessageVO> vos = new ArrayList<>(messages.size());
        for (MessagePO messagePO:messages){
            vos.add(new MessageVO(messagePO));
        }
        return null;
    }

    @Override
    public Response<List<MessageVO>> getMessagesByUser(Long ID, int type) {
        return null;
    }

    @Override
    public Response<List<MessageVO>> getMessagesByUser(Long ID, int type, int page) {
        return null;
    }

    @Override
    public Response<List<NewMessageVO>> getNewMessageByUser(Long ID) {
        return null;
    }

    @Override
    public Response<?> readNewMessages(Long userID, int type) {
        return null;
    }

    @Override
    public Response<?> removeMessageByMessageID(Long ID) {
        return null;
    }
}
