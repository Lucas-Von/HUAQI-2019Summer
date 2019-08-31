package financial_management.service.message.impl;

import financial_management.bl.message.MessageInterface;
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
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService, MessageInterface {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public BasicResponse<List<MessageVO>> getMessagesByUser(Long ID) {
        List<MessagePO> messages = messageMapper.selectByUserID(ID);
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
            vo.setLatest(po == null ? "没有最新消息" : po.getContent());
            newMessages.add(vo);
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, newMessages);
    }

    @Override
    public BasicResponse<?> readNewMessages(Long userID, int type) {
        try {
            int read = messageMapper.readMessageByTypeAndUserID(type, userID);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, read);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }
    }

    @Override
    public BasicResponse<?> readNewMessage(Long userID, Long messageID) {
        if (messageMapper.readMessageByMessageID(messageID) == 1) {
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, messageID);
        } else {
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }
    }

    @Override
    public BasicResponse<?> removeMessageByMessageID(Long ID) {
        if (messageMapper.deleteMessage(ID) == 1) {
            return new BasicResponse<>(ResponseStatus.STATUS_MESSAGE_DELETE_SUCCESS, null);
        } else {
            return new BasicResponse<>(ResponseStatus.STATUS_MESSAGE_DELETE_FAIL, null);
        }
    }

    @Deprecated
    @Override
    public BasicResponse<?> postMessageToUserBy(Long userID, String content) {
        MessagePO po = new MessagePO();
        po.setTime(new Date());
        po.setUserID(userID);
        po.setContent(content);
        po.setIsRead(false);
        po.setIsDelete(false);
        int insert = messageMapper.insertMessage(po);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @Override
    public BasicResponse<?> postMessageToUserBy(Long userID, String content, MsgType msgType) {
        MessagePO po = new MessagePO();
        po.setTime(new Date());
        po.setUserID(userID);
        po.setContent(content);
        po.setType(msgType.getType());
        po.setIsRead(false);
        po.setIsDelete(false);
        try {
            int insert = messageMapper.insertMessage(po);
            if (insert == 1) {
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, po.getID());
            } else {
                return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }
    }
}
