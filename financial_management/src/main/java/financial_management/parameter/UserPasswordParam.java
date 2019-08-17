package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserPasswordParam {
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

    public UserPasswordParam() {
    }

    public UserPasswordParam(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
