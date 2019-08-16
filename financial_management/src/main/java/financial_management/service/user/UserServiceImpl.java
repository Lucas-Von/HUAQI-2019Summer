package financial_management.service.user;

import financial_management.bl.user.UserService;
import financial_management.data.user.UserMapper;
import financial_management.parameter.*;
import financial_management.vo.ArticleSimpleInfoVO;
import financial_management.vo.UserSimpleInfoVO;
import financial_management.vo.UserVO;
import financial_management.vo.UsernameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        // TODO
        String email = userParam.getEmail();
        if(userMapper.ifExistEmail(email)){
            return ResponseEntity.status(201).body("该邮箱已存在！");
        }
        return null;
    }

    @Override
    public ResponseEntity<UsernameVO> loginByEmail(UserLoginParam userLoginParam){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<String> updateUsername(UsernameParam usernameParam){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<String> updateEmail(UserEmailParam userEmailParam){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<String> updatePhoneNum(UserPhoneNumParam userPhoneNumParam){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<String> updatePassword(UserPasswordParam userPasswordParam){
        // TODO

        return null;
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
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<List<UserVO>> getAllUsers(){
        // TODO

        return null;
    }

    @Override
    public ResponseEntity<List<ArticleSimpleInfoVO>> getCollections(Long userId){
        // TODO

        return null;
    }
}
