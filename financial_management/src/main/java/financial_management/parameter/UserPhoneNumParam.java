package financial_management.parameter;

/**
 * @author xyh
 * @date 2019/8/16
 */
public class UserPhoneNumParam {
    private Long userId;
    private String phoneNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public UserPhoneNumParam() {
    }

    public UserPhoneNumParam(Long userId, String phoneNum) {
        this.userId = userId;
        this.phoneNum = phoneNum;
    }
}
