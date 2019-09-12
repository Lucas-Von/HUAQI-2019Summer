package financial_management.entity.bond;

public class InfoRateString {
    String seven_days_annualized_return;
    String fourteen_days_annualized_return;
    String twentyseven_days_annualized_return;
    String thirty_days_yield_rate;
    String ninety_days_yield_rate;
    String yield_rate_since_establishment;

    public String getSeven_days_annualized_return() {
        return seven_days_annualized_return;
    }

    public void setSeven_days_annualized_return(String seven_days_annualized_return) {
        this.seven_days_annualized_return = seven_days_annualized_return;
    }

    public String getFourteen_days_annualized_return() {
        return fourteen_days_annualized_return;
    }

    public void setFourteen_days_annualized_return(String fourteen_days_annualized_return) {
        this.fourteen_days_annualized_return = fourteen_days_annualized_return;
    }

    public String getTwentyseven_days_annualized_return() {
        return twentyseven_days_annualized_return;
    }

    public void setTwentyseven_days_annualized_return(String twentyseven_days_annualized_return) {
        this.twentyseven_days_annualized_return = twentyseven_days_annualized_return;
    }

    public String getThirty_days_yield_rate() {
        return thirty_days_yield_rate;
    }

    public void setThirty_days_yield_rate(String thirty_days_yield_rate) {
        this.thirty_days_yield_rate = thirty_days_yield_rate;
    }

    public String getNinety_days_yield_rate() {
        return ninety_days_yield_rate;
    }

    public void setNinety_days_yield_rate(String ninety_days_yield_rate) {
        this.ninety_days_yield_rate = ninety_days_yield_rate;
    }

    public String getYield_rate_since_establishment() {
        return yield_rate_since_establishment;
    }

    public void setYield_rate_since_establishment(String yield_rate_since_establishment) {
        this.yield_rate_since_establishment = yield_rate_since_establishment;
    }
}
