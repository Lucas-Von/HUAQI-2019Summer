package financial_management.data.user;

import financial_management.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xyh
 * @date 2019/08/16
 */
@Mapper
public interface UserMapper {
    /**
     * 判断邮箱是否已经被注册
     * @param email
     * @return
     */
    boolean ifExistEmail(@Param("email") String email);

    /**
     * 判断身份证号是否已经被绑定
     * @param identityNum
     * @return
     */
    boolean ifExistIdentityNum(@Param("identityNum") String identityNum);

    /**
     * 插入一个User对象
     * @param userPO
     */
    void insert(UserPO userPO);

    /**
     * 通过邮箱查找用户
     * @param email
     * @return
     */
    UserPO selectUserByEmail(@Param("email") String email);

    /**
     * 更新用户的昵称信息
     * @param userId
     * @param username
     */
    void updateUsername(@Param("userId") Long userId, @Param("username") String username);

    /**
     * 更新用户的邮箱信息
     * @param userId
     * @param email
     */
    void updateEmail(@Param("userId") Long userId, @Param("email") String email);

    /**
     * 更新用户的手机号信息
     * @param userId
     * @param phoneNum
     */
    void updatePhoneNum(@Param("userId") Long userId, @Param("phoneNum") String phoneNum);

    /**
     * 更新用户的密码信息
     * @param userId
     * @param password
     */
    void updatePassword(@Param("userId") Long userId, @Param("password") String password);

    /**
     * 获取所有的User对象
     * @return
     */
    List<UserPO> selectAllUsers();

    /**
     * 获取某一User对象
     * @param userId
     * @return
     */
    UserPO selectSimpleUser(@Param("userId") Long userId);
}