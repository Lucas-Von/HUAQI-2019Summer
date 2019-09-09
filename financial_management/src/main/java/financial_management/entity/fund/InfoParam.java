package financial_management.entity.fund;

import financial_management.util.PyInvoke.PyParam.PyParam;

public class InfoParam extends PyParam {
    Float accumulated_earning;
    Float balance;

    public Float getAccumulated_earning() {
        return accumulated_earning;
    }

    public void setAccumulated_earning(Float accumulated_earning) {
        this.accumulated_earning = accumulated_earning;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public InfoParam(Float accumulated_earning, Float balance) {
        this.accumulated_earning = accumulated_earning;
        this.balance = balance;
    }
}
