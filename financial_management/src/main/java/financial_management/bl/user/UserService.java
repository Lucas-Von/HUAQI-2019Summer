package financial_management.bl.user;

import financial_management.parameter.*;
import financial_management.vo.article.ArticleSimpleInfoVO;
import financial_management.vo.user.UserSimpleInfoVO;
import financial_management.vo.user.UserVO;
import financial_management.vo.user.UsernameVO;
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
    ResponseEntity<UserVO> getSimpleUser(Long userId);

    /**
     * 获取所有用户的基本信息（弃用）
     * @return
     */
    ResponseEntity<List<UserSimpleInfoVO>> getAllUsers();

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

    /**
     * 修改用户头像
     * @param profilePhoto
     * @param userId
     * @return
     */
    ResponseEntity<String> updateProfilePhoto(String profilePhoto, Long userId);

    /**
     * 按照邮箱搜索指定用户
     * @param email
     * @return
     */
    ResponseEntity<UserVO> searchUserByEmail(String email);

    /**
     * 按照身份证号搜索指定用户
     * @param identityNum
     * @return
     */
    ResponseEntity<UserVO> searchUserByIdentityNum(String identityNum);

    /**
     * 按照昵称模糊搜索符合条件的用户
     * @param username
     * @return
     */
    ResponseEntity<List<UserSimpleInfoVO>> searchUserByUsername(String username);
}
