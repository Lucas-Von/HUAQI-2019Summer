package financial_management.vo;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserSimpleInfoVO {
    private Long userId;
    private String username;
    private String identityNum;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserSimpleInfoVO() {
    }

    public UserSimpleInfoVO(Long userId,
                            String username,
                            String identityNum,
                            String email) {
        this.userId = userId;
        this.username = username;
        this.identityNum = identityNum;
        this.email = email;
    }
}
