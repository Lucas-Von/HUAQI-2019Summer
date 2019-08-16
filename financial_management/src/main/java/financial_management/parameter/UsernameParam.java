package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UsernameParam {
    private Long userId;
    private String username;

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

    public UsernameParam() {
    }

    public UsernameParam(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
