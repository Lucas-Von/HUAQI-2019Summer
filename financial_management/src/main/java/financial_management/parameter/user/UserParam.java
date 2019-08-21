package financial_management.parameter.user;

import financial_management.entity.UserPO;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserParam {
    private String username;
    private String identityNum;
    private String name;
    private String email;
    private String phoneNum;
    private String password;
    private String profilePhoto = "https://i.loli.net/2019/08/14/mUZcISHpWrx1aPM.jpg";

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

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public UserPO getUserPo(){
        return new UserPO(username,
                identityNum,
                name,
                email,
                password,
                profilePhoto);
    }

    public UserParam() {
    }

    public UserParam(String username,
                     String identityNum,
                     String name,
                     String email,
                     String phoneNum,
                     String password,
                     String profilePhoto) {
        this.username = username;
        this.identityNum = identityNum;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }
}
