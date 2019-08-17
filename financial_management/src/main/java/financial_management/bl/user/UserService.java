package financial_management.bl.user;

import financial_management.parameter.*;
import financial_management.vo.ArticleSimpleInfoVO;
import financial_management.vo.UserSimpleInfoVO;
import financial_management.vo.UserVO;
import financial_management.vo.UsernameVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/16
 */
public interface UserService {
    /**
     * 用户注册
     * @return
     */
    ResponseEntity<String> register(UserParam userParam);

    /**
     * 用户通过邮箱登录
     * @param userLoginParam
     * @return
     */
    ResponseEntity<UsernameVO> loginByEmail(UserLoginParam userLoginParam);

    /**
     * 修改用户昵称
     * @param username
     * @param userId
     * @return
     */
    ResponseEntity<String> updateUsername(String username, Long userId);

    /**
     * 修改用户邮箱（需要验证是否重复）
     * @param userEmailParam
     * @return
     */
    ResponseEntity<String> updateEmail(UserEmailParam userEmailParam);

    /**
     * 修改用户手机号
     * @param phoneNum
     * @param userId
     * @return
     */
    ResponseEntity<String> updatePhoneNum(String phoneNum, Long userId);

    /**
     * 通过userId修改用户的密码
     * @param userId
     * @param password
     * @return
     */
    ResponseEntity<String> updatePasswordByUserId(String password, Long userId);

    /**
     * 通过邮箱修改用户的密码
     * @param userPasswordParam
     * @return
     */
    ResponseEntity<String> updatePasswordByEmail(UserPasswordParam userPasswordParam);

    /**
     * 用户申请修改邮箱
     * @param email
     * @return
     */
    ResponseEntity<String> applyForUpdateEmail(String email);

    /**
     * 用户申请找回密码
     * @param email
     * @return
     */
    ResponseEntity<String> applyForUpdatePassword(String email);

    /**
     * 获取一个用户的基本信息
     * @param userId
     * @return
     */
    ResponseEntity<UserSimpleInfoVO> getSimpleUser(Long userId);

    /**
     * 获取所有用户的基本信息
     * @return
     */
    ResponseEntity<List<UserVO>> getAllUsers();

    /**
     * 获取用户所有收藏的⽂章
     * @param userId
     * @return
     */
    ResponseEntity<List<ArticleSimpleInfoVO>> getCollections(Long userId);

    /**
     * 激活账号
     * @param email
     * @return
     */
    ResponseEntity<String> activate(String email);
}
