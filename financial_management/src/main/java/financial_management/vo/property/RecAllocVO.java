package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/08/23 00:48
 */
public class RecAllocVO {

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
     * 推荐现金金额
     */
    private double fundsMoney;

    /**
     * 推荐储蓄比例
     */
    private double savingRate;

    /**
     * 推荐储蓄金额
     */
    private double savingMoney;

    /**
     * 推荐保险比例
     */
    private double insuranceRate;

    /**
     * 推荐保险金额
     */
    private double insuranceMoney;

    /**
     * 推荐投资比例
     */
    private double investRate;

    /**
     * 推荐投资金额
     */
    private double investMoney;

    public RecAllocVO(Long userId, String name, String identityNum, String nick, String email, double total, double fundsRate, double savingRate, double insuranceRate, double investRate) {
        this.userId = userId;
        this.name = name;
        this.identityNum = identityNum;
        this.nick = nick;
        this.email = email;
        this.fundsRate = fundsRate;
        this.fundsMoney = total * fundsRate;
        this.savingRate = savingRate;
        this.savingMoney = total * savingRate;
        this.insuranceRate = insuranceRate;
        this.insuranceMoney = total * insuranceRate;
        this.investRate = investRate;
        this.investMoney = total * investRate;
    }

    public RecAllocVO() {

    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public double getFundsRate() {
        return fundsRate;
    }

    public double getFundsMoney() {
        return fundsMoney;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public double getSavingMoney() {
        return savingMoney;
    }

    public double getInsuranceRate() {
        return insuranceRate;
    }

    public double getInsuranceMoney() {
        return insuranceMoney;
    }

    public double getInvestRate() {
        return investRate;
    }

    public double getInvestMoney() {
        return investMoney;
    }

}
