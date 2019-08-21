package financial_management.vo;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserVO {
    private Long userId;
    private String username;
    private String identityNum;
    private String name;
    private String email;
    private String phoneNum;
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

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public UserVO() {
    }

    public UserVO(Long userId,
                  String username,
                  String identityNum,
                  String name,
                  String email,
                  String phoneNum,
                  String profilePhoto) {
        this.userId = userId;
        this.username = username;
        this.identityNum = identityNum;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.profilePhoto = profilePhoto;
    }
}
