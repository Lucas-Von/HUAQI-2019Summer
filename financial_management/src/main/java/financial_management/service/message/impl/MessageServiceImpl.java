package financial_management.service.message.impl;

import financial_management.bl.message.MessageService;
import financial_management.data.message.MessageMapper;
import financial_management.entity.MessagePO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
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
    public BasicResponse<List<MessageVO>> getMessagesByUser(Long ID) {
        List<MessagePO> messages = messageMapper.selectByUserID(ID);
        for (MessagePO po : messages) {
            System.out.println(po.getTime());
        }
        return getListBasicResponseOnSuccess(messages);
    }

    @Override
    public BasicResponse<List<MessageVO>> getMessagesByUser(Long ID, int type) {
        List<MessagePO> messages = messageMapper.selectByUserIDandType(ID, type);
        return getListBasicResponseOnSuccess(messages);
    }

    @Override
    public BasicResponse<List<MessageVO>> getMessagesByUser(Long ID, int type, int page) {
        List<MessagePO> messages = messageMapper.selectByUserIDandTypeAndPage(ID, type, page);
        return getListBasicResponseOnSuccess(messages);
    }

    private static BasicResponse<List<MessageVO>> getListBasicResponseOnSuccess(List<MessagePO> messages) {
        BasicResponse<List<MessageVO>> response;
        List<MessageVO> vos = new ArrayList<>(messages.size());
        for (MessagePO messagePO : messages) {
            vos.add(new MessageVO(messagePO));
        }
        response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
        return response;
    }

    @Override
    public BasicResponse<List<NewMessageVO>> getNewMessageByUser(Long ID) {
        int typeAmount = 4;
        List<NewMessageVO> newMessages = new ArrayList<>(typeAmount);
        for (int type = 1; type <= typeAmount; type++) {
            NewMessageVO vo = new NewMessageVO();
            vo.setType(type);
            vo.setUnreadAmount(messageMapper.selectAmountOfUnreadByTypeAndUserID(type, ID));
            MessagePO po = messageMapper.selectLatestMessageByTypeAndUserID(type, ID);
            vo.setLatest(po==null?"没有最新消息":po.getContent());
            newMessages.add(vo);
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, newMessages);
    }

    @Override
    public BasicResponse<?> readNewMessages(Long userID, int type) {
        messageMapper.readMessageByTypeAndUserID(type, userID);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @Override
    public BasicResponse<?> removeMessageByMessageID(Long ID) {
        if (messageMapper.deleteMessage(ID)==1) {
            return new BasicResponse<>(ResponseStatus.STATUS_MESSAGE_DELETE_SUCCESS, null);
        } else {
            return new BasicResponse<>(ResponseStatus.STATUS_MESSAGE_DELETE_FAIL, null);
        }
    }

    @Override
    public BasicResponse<?> postMessageToUserBy(MessageVO messageVO) {
        MessagePO po = assembleMessagePO(messageVO);
        po.setID(null);
        po.setIsDelete(false);
        long id = messageMapper.insertMessage(po);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,id);
    }

    private static MessagePO assembleMessagePO(MessageVO messageVO){
        MessagePO messagePO = new MessagePO();
        messagePO.setID(messageVO.getID());
        messagePO.setTime(messageVO.getTime());
        messagePO.setContent(messageVO.getContent());
        messagePO.setType(messageVO.getType());
        messagePO.setIsRead(messageVO.getReaded());
        return messagePO;
    }
}
