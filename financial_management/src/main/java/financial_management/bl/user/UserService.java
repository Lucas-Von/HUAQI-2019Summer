package financial_management.bl.user;

import financial_management.parameter.UserParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2019/08/16
 */
public interface UserService {
    /**
     * 用户注册
     * @return
     */
    ResponseEntity<String> register(UserParam userParam);
}
