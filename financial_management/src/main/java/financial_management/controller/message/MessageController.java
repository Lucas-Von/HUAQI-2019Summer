package financial_management.controller.message;

import financial_management.bl.message.MessageService;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public BasicResponse<?> getMessagesByUser(HttpServletRequest request) {
        return messageService.getMessagesByUser(jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("get/{type}")
    public BasicResponse<?> getMessagesByUser(HttpServletRequest request, @PathVariable int type) {
        return messageService.getMessagesByUser(jwtUtil.getIdFromRequest(request), type);
    }

    @GetMapping("get/{type}/{page}")
    public BasicResponse<?> getMessagesByUser(HttpServletRequest request, @PathVariable int type, @PathVariable int page) {
        return messageService.getMessagesByUser(jwtUtil.getIdFromRequest(request), type, page);
    }

    @GetMapping("getNew")
    public BasicResponse<?> getNewMessageByUser(HttpServletRequest request) {
        return messageService.getNewMessageByUser(jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("hasRead")
    public BasicResponse<?> readNewMessage(HttpServletRequest request, @RequestParam int type) {
        return messageService.readNewMessages(jwtUtil.getIdFromRequest(request), type);
    }

    @DeleteMapping("del/{ID}")
    public BasicResponse<?> delMessageByMessageID(@PathVariable Long ID) {
        return messageService.removeMessageByMessageID(ID);
    }

}
