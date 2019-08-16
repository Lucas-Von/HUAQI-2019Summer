package financial_management.service.user;

import financial_management.bl.user.UserService;
import financial_management.data.user.UserMapper;
import financial_management.parameter.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2019/08/16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<String> register(UserParam userParam){
        String email = userParam.getEmail();
        if(userMapper.ifExistEmail(email)){
            return ResponseEntity.status(201).body("该邮箱已存在！");
        }
        return null;
    }
}
