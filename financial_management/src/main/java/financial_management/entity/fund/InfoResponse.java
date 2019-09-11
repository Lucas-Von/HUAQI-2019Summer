package financial_management.entity.fund;

import financial_management.entity.bond.InfoRateString;

public class InfoResponse {
    Float accumulated_earning;
    Float balance;
    Float last_revenue;
    InfoRateString info_display;


    public InfoRateString getInfo_display() {
        return info_display;
    }

    public void setInfo_display(InfoRateString info_display) {
        this.info_display = info_display;
    }

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

    public Float getLast_revenue() {
        return last_revenue;
    }

    public void setLast_revenue(Float last_revenue) {
        this.last_revenue = last_revenue;
    }
}
