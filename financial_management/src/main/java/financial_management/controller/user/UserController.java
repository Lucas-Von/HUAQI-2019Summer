package financial_management.controller.user;

import financial_management.bl.user.UserService;
import financial_management.parameter.user.UserEmailParam;
import financial_management.parameter.user.UserLoginParam;
import financial_management.parameter.user.UserParam;
import financial_management.parameter.user.UserPasswordParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.user.UserSimpleInfoVO;
import financial_management.vo.user.UserVO;
import financial_management.vo.user.UsernameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/16
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BasicResponse register(@RequestBody UserParam userParam){
        return userService.register(userParam);
    }

    @PostMapping("/login/email")
    public BasicResponse loginByEmail(@RequestBody UserLoginParam userLoginParam){
        return userService.loginByEmail(userLoginParam);
    }

    @PostMapping("/update/username")
    public BasicResponse updateUsername(@RequestParam String username, HttpServletRequest request){
        return userService.updateUsername(username, jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/update/email")
    public BasicResponse updateEmail(@RequestBody UserEmailParam userEmailParam){
        return userService.updateEmail(userEmailParam);
    }

    @PostMapping("/update/phone")
    public BasicResponse updatePhoneNum(@RequestParam String phoneNum, HttpServletRequest request){
        return userService.updatePhoneNum(phoneNum, jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/update/password/id")
    public BasicResponse updatePasswordByUserId(@RequestParam String password, HttpServletRequest request){
        return userService.updatePasswordByUserId(password, jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/update/password/email")
    public BasicResponse updatePasswordByEmail(@RequestBody UserPasswordParam userPasswordParam){
        return userService.updatePasswordByEmail(userPasswordParam);
    }

    @PostMapping("/apply/email")
    public BasicResponse applyForUpdateEmail(@RequestParam String email){
        return userService.applyForUpdateEmail(email);
    }

    @PostMapping("/apply/password")
    public BasicResponse applyForUpdatePassword(@RequestParam String email){
        return userService.applyForUpdatePassword(email);
    }

    @GetMapping("/get")
    public BasicResponse getSimpleUser(HttpServletRequest request){
        return userService.getSimpleUser(jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("/getAll")
    public BasicResponse getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/collections/get")
    public BasicResponse getCollections(HttpServletRequest request){
        return userService.getCollections(jwtUtil.getIdFromRequest(request));
    }

    @PostMapping("/activate")
    public BasicResponse activate(@RequestParam String email){
        return userService.activate(email);
    }

    @PostMapping("/update/photo")
    public BasicResponse updateProfilePhoto(@RequestParam String profilePhoto, HttpServletRequest request){
        return userService.updateProfilePhoto(profilePhoto,jwtUtil.getIdFromRequest(request));
    }

    @GetMapping("/search/email")
    public BasicResponse searchUserByEmail(@RequestParam String email){
        return userService.searchUserByEmail(email);
    }

    @GetMapping("/search/identityNum")
    public BasicResponse searchUserByIdentityNum(@RequestParam String identityNum){
        return userService.searchUserByIdentityNum(identityNum);
    }

    @GetMapping("/search/username")
    public BasicResponse searchUserByUsername(@RequestParam String username){
        return userService.searchUserByUsername(username);
    }

    @GetMapping("/amount")
    public BasicResponse getUserAmount(){
        return userService.getUserAmount();
    }
}
