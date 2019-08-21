package financial_management.parameter.user;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserLoginParam {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginParam() {
    }

    public UserLoginParam(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
