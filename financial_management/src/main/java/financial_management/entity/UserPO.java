package financial_management.entity;

import financial_management.vo.UserSimpleInfoVO;
import financial_management.vo.UserVO;

import java.sql.Timestamp;

public class UserPO {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 昵称
     */
    private String username;
    /**
     * 身份证号
     */
    private String identityNum;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phoneNum;
    /**
     * 密码
     */
    private String password;
    /**
     * 登录权限控制
     */
    private String perms;
    /**
     * 状态 0为未激活，1为已激活
     */
    private Integer status = 0;
    /**
     * 注册时间
     */
    private Timestamp time;
    /**
     * 用户头像URL
     */
    private String profilePhoto;

   public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public UserSimpleInfoVO getUserSimpleInfoVO(){
        return new UserSimpleInfoVO(userId,username,identityNum,email);
    }

    public UserVO getUserVO(){
        return new UserVO(userId,
                username,
                identityNum,
                name,
                email,
                phoneNum,
                profilePhoto);
    }

    public UserPO() {
    }

    public UserPO(String username,
                  String identityNum,
                  String name,
                  String email,
                  String password,
                  String profilePhoto) {
        this.username = username;
        this.identityNum = identityNum;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }
}
