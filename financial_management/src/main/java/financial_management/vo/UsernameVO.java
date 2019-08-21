package financial_management.vo;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UsernameVO {
    private String token;
    private String username;
    private String profilePhoto;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public UsernameVO() {
    }

    public UsernameVO(String token, String username, String profilePhoto) {
        this.token = token;
        this.username = username;
        this.profilePhoto = profilePhoto;
    }
}
