package financial_management.data.user;

import financial_management.entity.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/16
 */
@Repository
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
     * @param oldEmail
     * @param newEmail
     */
    void updateEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);

    /**
     * 更新用户的手机号信息
     * @param userId
     * @param phoneNum
     */
    void updatePhoneNum(@Param("userId") Long userId, @Param("phoneNum") String phoneNum);

    /**
     * 通过userId更新用户的密码信息
     * @param userId
     * @param password
     */
    void updatePasswordByUserId(@Param("userId") Long userId, @Param("password") String password);

    /**
     * 通过邮箱更新用户的密码信息
     * @param email
     * @param password
     */
    void updatePasswordByEmail(@Param("email") String email, @Param("password") String password);

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

    /**
     * 判断该用户是否存在
     * @param userId
     * @return
     */
    boolean ifExist(@Param("userId") Long userId);

    /**
     * 更新用户的状态
     * @param userId
     * @param status
     */
    void updateStatus(@Param("userId") Long userId, @Param("status") Integer status);

    /**
     * 更新用户的头像
     * @param userId
     * @param profilePhoto
     */
    void updateProfilePhoto(@Param("userId") Long userId, @Param("profilePhoto") String profilePhoto);

    /**
     * 通过身份证号查找用户
     * @return
     */
    UserPO selectUserByIdentityNum(@Param("identityNum") String identityNum);

    /**
     * 通过昵称模糊搜索符合条件的用户
     * @param username
     * @return
     */
    List<UserPO> selectUserByUsername(@Param("username") String username);

    /**
     * 获得所有用户的的数量
     * @return
     */
    Long getUserAmount();

    /**
     * 在能否修改邮箱表中插入一个用户
     * @param email
     */
    void insertIfChangedEmail(@Param("email") String email);

    /**
     * 判断能否修改邮箱表中是否包含该邮箱，如不包含则说明是无效链接
     * @param email
     * @return
     */
    boolean ifExistChangedEmail(@Param("email") String email);

    /**
     * 判断能否修改邮箱（1：可修改；2：已完成修改；3：超时）
     * @param email
     * @return
     */
    Integer ifChangedEmail(@Param("email") String email);

    /**
     * 修改能否修改邮箱表中用户的状态
     * @param email
     * @param status
     */
    void changeStatusInIfChangedEmail(@Param("email") String email, @Param("status") Integer status);

    /**
     * 定时判断是否有超过10分钟未修改邮箱，有则将状态变为3
     */
    @Scheduled(cron = "0/1 * * * * ?")
    void cleanIfChangedEmail();

    /**
     * 在能否修改密码表中插入一个用户
     * @param email
     */
    void insertIfChangedPassword(@Param("email") String email);

    /**
     * 判断能否修改密码表中是否包含该邮箱，如不包含则说明是无效链接
     * @param email
     * @return
     */
    boolean ifExistChangedPassword(@Param("email") String email);

    /**
     * 判断能否修改密码（1：可修改；2：已完成修改；3：超时）
     * @param email
     * @return
     */
    Integer ifChangedPassword(@Param("email") String email);

    /**
     * 修改能否修改密码表中用户的状态
     * @param email
     * @param status
     */
    void changeStatusInIfChangedPassword(@Param("email") String email, @Param("status") Integer status);

    /**
     * 定时判断是否有超过10分钟未修改密码，有则将状态变为3
     */
    @Scheduled(cron = "0/1 * * * * ?")
    void cleanIfChangedPassword();

    /**
     * 定时判断是否有超过10分钟未激活的账号，有则注销
     */
    @Scheduled(cron = "0/1 * * * * ?")
    void cleanInactive();
}