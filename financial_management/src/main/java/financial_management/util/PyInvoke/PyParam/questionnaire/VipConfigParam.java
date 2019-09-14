package financial_management.util.PyInvoke.PyParam.questionnaire;

import financial_management.util.PyInvoke.PyParam.PyParam;

/**
 * @author lt
 * @date 2019/09/14 15:26
 */
public class VipConfigParam extends PyParam {

    /**
     * 未付欠款
     */
    private double unpaid_arrears;

    /**
     * 上期应还欠款
     */
    private double previous_arrears_due;

    /**
     * 信用额度
     */
    private double line_of_credit;

    /**
     * 预提现金额度
     */
    private double cash_advance;

    /**
     * 上次付款额
     */
    private double last_payment;

    /**
     * 最低到期付款额
     */
    private double minimum_due_payment;

    /**
     * 存款额
     */
    private double deposit;

    public VipConfigParam(double unpaid_arrears, double previous_arrears_due, double line_of_credit, double cash_advance, double last_payment, double minimum_due_payment, double deposit) {
        this.unpaid_arrears = unpaid_arrears;
        this.previous_arrears_due = previous_arrears_due;
        this.line_of_credit = line_of_credit;
        this.cash_advance = cash_advance;
        this.last_payment = last_payment;
        this.minimum_due_payment = minimum_due_payment;
        this.deposit = deposit;
    }

    public VipConfigParam() {

    }

    public double getUnpaid_arrears() {
        return unpaid_arrears;
    }

    public void setUnpaid_arrears(double unpaid_arrears) {
        this.unpaid_arrears = unpaid_arrears;
    }

    public double getPrevious_arrears_due() {
        return previous_arrears_due;
    }

    public void setPrevious_arrears_due(double previous_arrears_due) {
        this.previous_arrears_due = previous_arrears_due;
    }

    public double getLine_of_credit() {
        return line_of_credit;
    }

    public void setLine_of_credit(double line_of_credit) {
        this.line_of_credit = line_of_credit;
    }

    public double getCash_advance() {
        return cash_advance;
    }

    public void setCash_advance(double cash_advance) {
        this.cash_advance = cash_advance;
    }

    public double getLast_payment() {
        return last_payment;
    }

    public void setLast_payment(double last_payment) {
        this.last_payment = last_payment;
    }

    public double getMinimum_due_payment() {
        return minimum_due_payment;
    }

    public void setMinimum_due_payment(double minimum_due_payment) {
        this.minimum_due_payment = minimum_due_payment;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

}