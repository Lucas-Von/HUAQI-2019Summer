package financial_management.service.user;

import financial_management.entity.UserPO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    public UserPO getUser(){
        UserPO po = new UserPO();
        po.setUserId(200L);
        po.setUsername("fucker");
        po.setPassword("123456");
        return po;
    }


}
