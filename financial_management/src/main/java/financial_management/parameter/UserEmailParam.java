package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserEmailParam {
    private Long userId;
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEmailParam() {
    }

    public UserEmailParam(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }
}
