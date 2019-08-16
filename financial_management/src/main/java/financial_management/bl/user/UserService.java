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
     * 修改用户的昵称
     * @param usernameParam
     * @return
     */
    ResponseEntity<String> updateUsername(UsernameParam usernameParam);

    /**
     * 修改用户邮箱（需要验证是否重复）
     * @param userEmailParam
     * @return
     */
    ResponseEntity<String> updateEmail(UserEmailParam userEmailParam);

    /**
     * 修改用户手机号（需要验证是否重复）
     * @param userPhoneNumParam
     * @return
     */
    ResponseEntity<String> updatePhoneNum(UserPhoneNumParam userPhoneNumParam);

    /**
     * 修改用户的密码
     * @param userPasswordParam
     * @return
     */
    ResponseEntity<String> updatePassword(UserPasswordParam userPasswordParam);

    /**
     * 用户申请修改邮箱
     * @param userEmailParam
     * @return
     */
    ResponseEntity<String> applyForUpdateEmail(UserEmailParam userEmailParam);

    /**
     * 用户申请找回密码
     * @param userEmailParam
     * @return
     */
    ResponseEntity<String> applyForUpdatePassword(UserEmailParam userEmailParam);

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
