package financial_management.controller.user;

import financial_management.bl.user.UserService;
import financial_management.parameter.*;
import financial_management.vo.ArticleSimpleInfoVO;
import financial_management.vo.UserSimpleInfoVO;
import financial_management.vo.UserVO;
import financial_management.vo.UsernameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserParam userParam){
        return userService.register(userParam);
    }

    @PostMapping("/login/email")
    public ResponseEntity<UsernameVO> loginByEmail(@RequestBody UserLoginParam userLoginParam){
        return userService.loginByEmail(userLoginParam);
    }

    @PostMapping("/update/username")
    public ResponseEntity<String> updateUsername(@RequestBody UsernameParam usernameParam){
        return userService.updateUsername(usernameParam);
    }

    @PostMapping("/update/email")
    public ResponseEntity<String> updateEmail(@RequestBody UserEmailParam userEmailParam){
        return userService.updateEmail(userEmailParam);
    }

    @PostMapping("/update/phone")
    public ResponseEntity<String> updatePhoneNum(@RequestBody UserPhoneNumParam userPhoneNumParam){
        return userService.updatePhoneNum(userPhoneNumParam);
    }

    @PostMapping("/update/password")
    public ResponseEntity<String> updatePassword(@RequestBody UserPasswordParam userPasswordParam){
        return userService.updatePassword(userPasswordParam);
    }

    @PostMapping("/apply/email")
    public ResponseEntity<String> applyForUpdateEmail(@RequestBody UserEmailParam userEmailParam){
        return userService.applyForUpdateEmail(userEmailParam);
    }

    @PostMapping("apply/password")
    public ResponseEntity<String> applyForUpdatePassword(@RequestBody UserEmailParam userEmailParam){
        return userService.applyForUpdatePassword(userEmailParam);
    }

    @GetMapping("/get")
    public ResponseEntity<UserSimpleInfoVO> getSimpleUser(@RequestParam Long userId){
        return userService.getSimpleUser(userId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserVO>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/collections/get")
    public ResponseEntity<List<ArticleSimpleInfoVO>> getCollections(Long userId){
        return userService.getCollections(userId);
    }

    @GetMapping("/activate")
    public ResponseEntity<String> activate(@RequestParam String email){
        return userService.activate(email);
    }
}
