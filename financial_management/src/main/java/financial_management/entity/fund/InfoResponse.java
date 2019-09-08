package financial_management.entity.fund;

public class InfoResponse {
    Float accumulate;
    Float balance;
    Float last_revenue;

    public Float getAccumulate() {
        return accumulate;
    }

    public void setAccumulate(Float accumulate) {
        this.accumulate = accumulate;
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
