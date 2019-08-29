package financial_management.controller.user;

import financial_management.bl.user.UserService;
import financial_management.entity.ArticlePO;
import financial_management.entity.UserPO;
import financial_management.parameter.user.UserEmailParam;
import financial_management.parameter.user.UserLoginParam;
import financial_management.parameter.user.UserParam;
import financial_management.parameter.user.UserPasswordParam;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.user.UserSimpleInfoVO;
import financial_management.vo.user.UserVO;
import financial_management.vo.user.UsernameVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/login/email")
    public BasicResponse loginByEmail(@RequestBody UserLoginParam userLoginParam){
        UsernameVO usernameVO = new UsernameVO();
        usernameVO.setUsername("xyhhh");
        usernameVO.setToken(jwtUtil.generateToken(1 + ""));
        usernameVO.setProfilePhoto("https://i.loli.net/2019/08/14/mUZcISHpWrx1aPM.jpg");
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, usernameVO);
    }

    @PostMapping("/update/username")
    public BasicResponse updateUsername(@RequestParam String username, HttpServletRequest request){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/update/email")
    public BasicResponse updateEmail(@RequestBody UserEmailParam userEmailParam){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/update/phone")
    public BasicResponse updatePhoneNum(@RequestParam String phoneNum, HttpServletRequest request){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/update/password/id")
    public BasicResponse updatePasswordByUserId(@RequestParam String password, HttpServletRequest request){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/update/password/email")
    public BasicResponse updatePasswordByEmail(@RequestBody UserPasswordParam userPasswordParam){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/apply/email")
    public BasicResponse applyForUpdateEmail(@RequestParam String email){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/apply/password")
    public BasicResponse applyForUpdatePassword(@RequestParam String email){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @GetMapping("/get")
    public BasicResponse getSimpleUser(HttpServletRequest request){
        UserPO userPO = new UserPO("xyhhh", "320684199809070018", "xyh", "153604998@qq.com", "9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc", "xxx");
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userPO.getUserVO());
    }

    @GetMapping("/getAll")
    public BasicResponse getAllUsers(){
        List<UserPO> userPOList = new ArrayList<>();
        UserPO userPO1 = new UserPO("xyhhh", "320684199809070018", "xyh", "153604998@qq.com", "9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc", "xxx");
        UserPO userPO2 = new UserPO("xxyhhh", "320684199809070019", "xxyh", "153604998@qq.comm", null, null);
        userPOList.add(userPO1);
        userPOList.add(userPO2);
        List<UserSimpleInfoVO> userVOList = new ArrayList<>();
        for (int i = 0; i < userPOList.size(); i++) {
            userVOList.add(userPOList.get(i).getUserSimpleInfoVO());
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userVOList);
    }

    @GetMapping("/collections/get")
    public BasicResponse getCollections(HttpServletRequest request){
        List<ArticleSimpleInfoVO> articleSimpleInfoVOS = new ArrayList<>();
        ArticleSimpleInfoVO articleSimpleInfoVO1 = new ArticleSimpleInfoVO(1L, "标题1", "摘要1", 5587L, new Timestamp(new Date().getTime()), "金融");
        articleSimpleInfoVO1.setCollected(true);
        ArticleSimpleInfoVO articleSimpleInfoVO2 = new ArticleSimpleInfoVO(2L, "标题2", "摘要2", 8888L, new Timestamp(new Date().getTime()), "科技");
        articleSimpleInfoVO2.setCollected(true);
        articleSimpleInfoVOS.add(articleSimpleInfoVO1);
        articleSimpleInfoVOS.add(articleSimpleInfoVO2);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, articleSimpleInfoVOS);
    }

    @PostMapping("/activate")
    public BasicResponse activate(@RequestParam String email){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @PostMapping("/update/photo")
    public BasicResponse updateProfilePhoto(@RequestParam String profilePhoto, HttpServletRequest request){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @GetMapping("/search/email")
    public BasicResponse searchUserByEmail(@RequestParam String email){
        UserPO userPO = new UserPO("xyhhh", "320684199809070018", "xyh", "153604998@qq.com", "9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc", "xxx");
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userPO.getUserVO());
    }

    @GetMapping("/search/identityNum")
    public BasicResponse searchUserByIdentityNum(@RequestParam String identityNum){
        UserPO userPO = new UserPO("xyhhh", "320684199809070018", "xyh", "153604998@qq.com", "9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc", "xxx");
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userPO.getUserVO());
    }

    @GetMapping("/search/username")
    public BasicResponse searchUserByUsername(@RequestParam String username){
        List<UserPO> userPOList = new ArrayList<>();
        UserPO userPO1 = new UserPO("xyhhh", "320684199809070018", "xyh", "153604998@qq.com", "9276cb69284bd987716dec93e9e26235e37a2d444934f16bc45baf8991490652a57f5adbbb5d07cabaf86a970528db6470a1604ccc0dd3d5c004cca9dc417bdc", "xxx");
        UserPO userPO2 = new UserPO("xxyhhh", "320684199809070019", "xxyh", "153604998@qq.comm", null, null);
        userPOList.add(userPO1);
        userPOList.add(userPO2);
        if (userPOList.size() != 0) {
            List<UserSimpleInfoVO> userSimpleInfoVOS = new ArrayList<>();
            for (int i = 0; i < userPOList.size(); i++) {
                userSimpleInfoVOS.add(userPOList.get(i).getUserSimpleInfoVO());
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, userSimpleInfoVOS);
        } else {
            return new BasicResponse(ResponseStatus.STATUS_USER_NOT_EXIST);
        }
    }

    @GetMapping("/amount")
    public BasicResponse getUserAmount(){
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, 142857L);
    }

    @GetMapping("/ifChanged/email")
    public BasicResponse ifChangedEmail(@RequestParam String email){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @GetMapping("/ifChanged/password")
    public BasicResponse ifChangedPassword(@RequestParam String email){
        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }
}
