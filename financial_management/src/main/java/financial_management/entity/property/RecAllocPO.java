package financial_management.entity.property;

/**
 * @author lt
 * @version 1.0
 * @description 用户推荐资产配置信息实体
 * @date 2019/08/23 00:37
 */
public class RecAllocPO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String identityNum;

    /**
     * 用户昵称
     */
    private String nick;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 推荐现金比例
     */
    private double fundsRate;

    /**
     * 推荐储蓄比例
     */
    private double savingRate;

    /**
     * 推荐保险比例
     */
    private double insuranceRate;

    /**
     * 推荐投资比例
     */
    private double investRate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getFundsRate() {
        return fundsRate;
    }

    public void setFundsRate(double fundsRate) {
        this.fundsRate = fundsRate;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public void setSavingRate(double savingRate) {
        this.savingRate = savingRate;
    }

    public double getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(double insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public double getInvestRate() {
        return investRate;
    }

    public void setInvestRate(double investRate) {
        this.investRate = investRate;
    }

}
