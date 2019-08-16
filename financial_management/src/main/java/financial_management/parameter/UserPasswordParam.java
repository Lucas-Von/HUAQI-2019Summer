package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserPasswordParam {
    private Long userId;
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserPasswordParam() {
    }

    public UserPasswordParam(Long userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
