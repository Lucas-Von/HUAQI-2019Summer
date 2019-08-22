package financial_management.bl.user;

import financial_management.parameter.user.UserEmailParam;
import financial_management.parameter.user.UserLoginParam;
import financial_management.parameter.user.UserParam;
import financial_management.parameter.user.UserPasswordParam;
import financial_management.vo.BasicResponse;
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
    BasicResponse register(UserParam userParam);

    /**
     * 用户通过邮箱登录
     * @param userLoginParam
     * @return
     */
    BasicResponse loginByEmail(UserLoginParam userLoginParam);

    /**
     * 修改用户昵称
     * @param username
     * @param userId
     * @return
     */
    BasicResponse updateUsername(String username, Long userId);

    /**
     * 修改用户邮箱（需要验证是否重复）
     * @param userEmailParam
     * @return
     */
    BasicResponse updateEmail(UserEmailParam userEmailParam);

    /**
     * 修改用户手机号
     * @param phoneNum
     * @param userId
     * @return
     */
    BasicResponse updatePhoneNum(String phoneNum, Long userId);

    /**
     * 通过userId修改用户的密码
     * @param userId
     * @param password
     * @return
     */
    BasicResponse updatePasswordByUserId(String password, Long userId);

    /**
     * 通过邮箱修改用户的密码
     * @param userPasswordParam
     * @return
     */
    BasicResponse updatePasswordByEmail(UserPasswordParam userPasswordParam);

    /**
     * 用户申请修改邮箱
     * @param email
     * @return
     */
    BasicResponse applyForUpdateEmail(String email);

    /**
     * 用户申请找回密码
     * @param email
     * @return
     */
    BasicResponse applyForUpdatePassword(String email);

    /**
     * 获取一个用户的基本信息
     * @param userId
     * @return
     */
    BasicResponse getSimpleUser(Long userId);

    /**
     * 获取所有用户的基本信息（弃用）
     * @return
     */
    BasicResponse getAllUsers();

    /**
     * 获取用户所有收藏的⽂章
     * @param userId
     * @return
     */
    BasicResponse getCollections(Long userId);

    /**
     * 激活账号
     * @param email
     * @return
     */
    BasicResponse activate(String email);

    /**
     * 修改用户头像
     * @param profilePhoto
     * @param userId
     * @return
     */
    BasicResponse updateProfilePhoto(String profilePhoto, Long userId);

    /**
     * 按照邮箱搜索指定用户
     * @param email
     * @return
     */
    BasicResponse searchUserByEmail(String email);

    /**
     * 按照身份证号搜索指定用户
     * @param identityNum
     * @return
     */
    BasicResponse searchUserByIdentityNum(String identityNum);

    /**
     * 按照昵称模糊搜索符合条件的用户
     * @param username
     * @return
     */
    BasicResponse searchUserByUsername(String username);

    /**
     * 获得所有用户的的数量
     * @return
     */
    BasicResponse getUserAmount();

    /**
     * 判断能否修改邮箱
     * @param email
     * @return
     */
    BasicResponse ifChangedEmail(String email);

    /**
     * 判断能否修改密码
     * @param email
     * @return
     */
    BasicResponse ifChangedPassword(String email);
}
