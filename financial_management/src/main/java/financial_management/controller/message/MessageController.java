package financial_management.controller.message;

import financial_management.bl.message.MessageService;
import financial_management.entity.Response;
import financial_management.vo.message.MessageVO;
import financial_management.vo.message.NewMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/message/")
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @GetMapping("get/{ID}")
    public ResponseEntity<?> getMessagesByUser(@PathVariable Long ID) {
        Response<List<MessageVO>> response = messageService.getMessagesByUser(ID);
        return judge(response);
    }

    @GetMapping("get/{ID}/type/{type}")
    public ResponseEntity<?> getMessagesByUser(@PathVariable Long ID, @PathVariable int type) {
        Response<List<MessageVO>> response = messageService.getMessagesByUser(ID, type);
        return judge(response);
    }

    @GetMapping("get/{ID}/type/{type}/{page}")
    public ResponseEntity<?> getMessagesByUser(@PathVariable Long ID, @PathVariable int type, @PathVariable int page) {
        Response<List<MessageVO>> response = messageService.getMessagesByUser(ID, type, page);
        return judge(response);
    }

    @GetMapping("getNew")
    public ResponseEntity<?> getNewMessageByUser(@RequestParam Long ID){
        Response<List<NewMessageVO>> response = messageService.getNewMessageByUser(ID);
        return judge(response);
    }

    @PostMapping("hasRead")
    public ResponseEntity<?> readNewMessage(@RequestParam Long userID,@RequestParam int type){
        Response<?> response = messageService.readNewMessages(userID,type);
        return judge(response);
    }

    @DeleteMapping("del/{ID}")
    public ResponseEntity<?> delMessageByMessageID(@PathVariable Long ID){
        Response<?> response = messageService.removeMessageByMessageID(ID);
        return judge(response);
    }

    private static ResponseEntity judge(Response response) {
        if (response.isSuccess()) {
            return ResponseEntity.ok(response.getContent());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getMessage());
        }
    }
}
