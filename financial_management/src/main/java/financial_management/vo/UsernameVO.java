package financial_management.vo;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UsernameVO {
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

    public UsernameVO() {
    }

    public UsernameVO(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
