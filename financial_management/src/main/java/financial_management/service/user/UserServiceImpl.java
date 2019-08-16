package financial_management.service.user;

import financial_management.bl.user.UserService;
import financial_management.data.user.UserMapper;
import financial_management.entity.UserPO;
import financial_management.parameter.*;
import financial_management.util.SendEmail;
import financial_management.vo.ArticleSimpleInfoVO;
import financial_management.vo.UserSimpleInfoVO;
import financial_management.vo.UserVO;
import financial_management.vo.UsernameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<String> register(UserParam userParam){
        String error = "";
        String email = userParam.getEmail();
        String identityNum = userParam.getIdentityNum();
        if(userMapper.ifExistEmail(email)){
            error = "该邮箱已被注册！";
        }
        if(userMapper.ifExistIdentityNum(identityNum)){
            if(error.equals("")){
                error = "该身份证号已被绑定！";
            }else {
                error = error + "；该身份证号已被绑定！";
            }
        }
        if(error.equals("")){
            UserPO userPO = userParam.getUserPo();
            userMapper.insert(userPO);

            // 发送邮件
            StringBuffer sb = new StringBuffer("点击下面链接激活账号，10分钟内生效，否则需要重新注册账号，链接只能使用一次，请尽快激活！</br>");
            sb.append("<a href=\"http://localhost:8080/springmvc/user/register?action=activate&email=");
            sb.append(email);
            sb.append("\">http://localhost:8080/springmvc/user/register?action=activate&email=");
            sb.append(email);
            sb.append("</a>");

            SendEmail.send(email, sb.toString());

            return ResponseEntity.ok().body("注册成功！");
        }else {
            return ResponseEntity.status(201).body(error);
        }
    }

    @Override
    public ResponseEntity<UsernameVO> loginByEmail(UserLoginParam userLoginParam){
        UserPO userPO = userMapper.selectUserByEmail(userLoginParam.getEmail());
        if(userPO.getPassword().equals(userLoginParam.getPassword())){
            UsernameVO usernameVO = new UsernameVO(userPO.getUserId(),userPO.getUsername());
            return ResponseEntity.ok().body(usernameVO);
        }else {
            return ResponseEntity.status(201).build();
        }
    }

    @Override
    public ResponseEntity<String> updateUsername(UsernameParam usernameParam){
        if(userMapper.ifExist(usernameParam.getUserId())) {
            userMapper.updateUsername(usernameParam.getUserId(), usernameParam.getUsername());
            return ResponseEntity.ok().body("更新用户昵称成功！");
        }else {
            return ResponseEntity.status(201).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updateEmail(UserEmailParam userEmailParam){
        if(userMapper.ifExist(userEmailParam.getUserId())) {
            if(userMapper.ifExistEmail(userEmailParam.getEmail())) {
                userMapper.updateEmail(userEmailParam.getUserId(), userEmailParam.getEmail());
                return ResponseEntity.ok().body("更新用户邮箱成功！");
            }else {
                return ResponseEntity.status(201).body("该邮箱已被注册！");
            }
        }else {
            return ResponseEntity.status(201).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updatePhoneNum(UserPhoneNumParam userPhoneNumParam){
        if(userMapper.ifExist(userPhoneNumParam.getUserId())) {
            userMapper.updatePhoneNum(userPhoneNumParam.getUserId(), userPhoneNumParam.getPhoneNum());
            return ResponseEntity.ok().body("更新用户手机号成功！");
        }else {
            return ResponseEntity.status(201).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> updatePassword(UserPasswordParam userPasswordParam){
        if(userMapper.ifExist(userPasswordParam.getUserId())) {
            userMapper.updatePassword(userPasswordParam.getUserId(), userPasswordParam.getPassword());
            return ResponseEntity.ok().body("更新用户密码成功！");
        }else {
            return ResponseEntity.status(201).body("该用户不存在！");
        }
    }

    @Override
    public ResponseEntity<String> applyForUpdateEmail(UserEmailParam userEmailParam){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<String> applyForUpdatePassword(UserEmailParam userEmailParam){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<UserSimpleInfoVO> getSimpleUser(Long userId){
        UserPO userPO = userMapper.selectSimpleUser(userId);
        return ResponseEntity.ok().body(userPO.getUserSimpleInfoVO());
    }

    @Override
    public ResponseEntity<List<UserVO>> getAllUsers(){
        List<UserPO> userPOList = userMapper.selectAllUsers();
        List<UserVO> userVOList = new ArrayList<>();
        for(int i=0;i<userPOList.size();i++){
            userVOList.add(userPOList.get(i).getUserVO());
        }
        return ResponseEntity.ok().body(userVOList);
    }

    @Override
    public ResponseEntity<List<ArticleSimpleInfoVO>> getCollections(Long userId){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<String> activate(String email){
        if(userMapper.ifExistEmail(email)) {
            UserPO userPO = userMapper.selectUserByEmail(email);
            if(userPO.getStatus() == 0) {
                userMapper.updateStatus(userPO.getUserId(), 1);
                return ResponseEntity.ok().body("账号已成功激活！");
            }else {
                return ResponseEntity.status(201).body("您的账号已经被激活，请勿重复操作！");
            }
        }else {
            return ResponseEntity.status(201).body("该邮箱不存在！");
        }
    }
}
