package financial_management.controller.message;

import financial_management.bl.message.MessageService;
import financial_management.entity.MessagePO;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.message.MessageVO;
import financial_management.vo.message.NewMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/message/")
public class MessageController {
    @Autowired
    @Qualifier(value = "messageServiceImpl")
    private MessageService messageService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("get")
    public BasicResponse getMessagesByUser(HttpServletRequest request) {
        List<MessageVO> vos = new ArrayList<>();
        MessagePO messagePO1 = new MessagePO();
        messagePO1.setID(1L);
        messagePO1.setTime(new Date());
        messagePO1.setUserID(5L);
        messagePO1.setType(1);
        messagePO1.setContent("尊敬的用户，您的账户有新的调仓操作，请确认");
        messagePO1.setIsRead(true);
        messagePO1.setIsDelete(false);
        MessageVO messageVO1 = new MessageVO(messagePO1);
        MessagePO messagePO2 = new MessagePO();
        messagePO2.setID(2L);
        messagePO2.setTime(new Date());
        messagePO2.setUserID(1L);
        messagePO2.setType(4);
        messagePO2.setContent("尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区");
        messagePO2.setIsRead(false);
        messagePO2.setIsDelete(false);
        MessageVO messageVO2 = new MessageVO(messagePO2);
        vos.add(messageVO1);
        vos.add(messageVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @GetMapping("get/{type}")
    public BasicResponse getMessagesByUser(HttpServletRequest request, @PathVariable int type) {
        List<MessageVO> vos = new ArrayList<>();
        MessagePO messagePO1 = new MessagePO();
        messagePO1.setID(1L);
        messagePO1.setTime(new Date());
        messagePO1.setUserID(5L);
        messagePO1.setType(1);
        messagePO1.setContent("尊敬的用户，您的账户有新的调仓操作，请确认");
        messagePO1.setIsRead(true);
        messagePO1.setIsDelete(false);
        MessageVO messageVO1 = new MessageVO(messagePO1);
        MessagePO messagePO2 = new MessagePO();
        messagePO2.setID(2L);
        messagePO2.setTime(new Date());
        messagePO2.setUserID(1L);
        messagePO2.setType(4);
        messagePO2.setContent("尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区");
        messagePO2.setIsRead(false);
        messagePO2.setIsDelete(false);
        MessageVO messageVO2 = new MessageVO(messagePO2);
        vos.add(messageVO1);
        vos.add(messageVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @GetMapping("get/{type}/{page}")
    public BasicResponse getMessagesByUser(HttpServletRequest request, @PathVariable int type, @PathVariable int page) {
        List<MessageVO> vos = new ArrayList<>();
        MessagePO messagePO1 = new MessagePO();
        messagePO1.setID(1L);
        messagePO1.setTime(new Date());
        messagePO1.setUserID(5L);
        messagePO1.setType(1);
        messagePO1.setContent("尊敬的用户，您的账户有新的调仓操作，请确认");
        messagePO1.setIsRead(true);
        messagePO1.setIsDelete(false);
        MessageVO messageVO1 = new MessageVO(messagePO1);
        MessagePO messagePO2 = new MessagePO();
        messagePO2.setID(2L);
        messagePO2.setTime(new Date());
        messagePO2.setUserID(1L);
        messagePO2.setType(4);
        messagePO2.setContent("尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区");
        messagePO2.setIsRead(false);
        messagePO2.setIsDelete(false);
        MessageVO messageVO2 = new MessageVO(messagePO2);
        vos.add(messageVO1);
        vos.add(messageVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @GetMapping("getNew")
    public BasicResponse getNewMessageByUser(HttpServletRequest request) {
        List<NewMessageVO> newMessages = new ArrayList<>(4);
        NewMessageVO vo1 = new NewMessageVO();
        vo1.setType(1);
        vo1.setUnreadAmount(2);
        vo1.setLatest("尊敬的用户，您的账户有新的调仓操作，请确认");
        NewMessageVO vo2 = new NewMessageVO();
        vo2.setType(2);
        vo2.setUnreadAmount(3);
        vo2.setLatest("尊敬的用户，您的问题反馈有新的答复：对面酒桶一直进我野区，他为什么要去塔里啊？下路一直叫我去，我怎么去啊？对面打野一直进我野区");
        NewMessageVO vo3 = new NewMessageVO();
        vo3.setType(3);
        vo3.setUnreadAmount(0);
        vo3.setLatest("没有最新消息");
        NewMessageVO vo4 = new NewMessageVO();
        vo4.setType(4);
        vo4.setUnreadAmount(1);
        vo4.setLatest("文章：《标题1》下的评论：“评论？？？”被一举报，请去确认情况是否属实！");
        newMessages.add(vo1);
        newMessages.add(vo2);
        newMessages.add(vo3);
        newMessages.add(vo4);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, newMessages);
    }

    @PostMapping("hasRead")
    public BasicResponse readNewMessage(HttpServletRequest request, @RequestParam int type) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
    }

    @DeleteMapping("del/{ID}")
    public BasicResponse delMessageByMessageID(@PathVariable Long ID) {
        return new BasicResponse<>(ResponseStatus.STATUS_MESSAGE_DELETE_SUCCESS, null);
    }

}
