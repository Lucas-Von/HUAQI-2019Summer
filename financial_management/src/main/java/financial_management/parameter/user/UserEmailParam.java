package financial_management.parameter.user;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserEmailParam {
    private String oldEmail;
    private String newEmail;

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public UserEmailParam() {
    }

    public UserEmailParam(String oldEmail, String newEmail) {
        this.oldEmail = oldEmail;
        this.newEmail = newEmail;
    }
}
