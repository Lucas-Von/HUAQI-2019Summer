package financial_management.controller.message;

import financial_management.bl.message.MessageService;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/message/")
public class MessageController {
    @Autowired
    @Qualifier(value = "messageServiceImpl")
    private MessageService messageService;

    @GetMapping("get/{ID}")
    public BasicResponse getMessagesByUser(@PathVariable Long ID) {
        return messageService.getMessagesByUser(ID);
    }

    @GetMapping("get/{ID}/type/{type}")
    public BasicResponse getMessagesByUser(@PathVariable Long ID, @PathVariable int type) {
        return messageService.getMessagesByUser(ID, type);
    }

    @GetMapping("get/{ID}/type/{type}/{page}")
    public BasicResponse getMessagesByUser(@PathVariable Long ID, @PathVariable int type, @PathVariable int page) {
        return messageService.getMessagesByUser(ID, type, page);
    }

    @GetMapping("getNew")
    public BasicResponse getNewMessageByUser(@RequestParam Long ID) {
        return messageService.getNewMessageByUser(ID);
    }

    @PostMapping("hasRead")
    public BasicResponse readNewMessage(@RequestParam Long userID, @RequestParam int type) {
        return messageService.readNewMessages(userID, type);
    }

    @DeleteMapping("del/{ID}")
    public BasicResponse delMessageByMessageID(@PathVariable Long ID) {
        return messageService.removeMessageByMessageID(ID);
    }

}
