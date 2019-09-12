package financial_management.entity.fund;

import financial_management.entity.bond.InfoRateString;

public class InfoRatesResponse {
    Float seven_days_annualized_return;
    Float fourteen_days_annualized_return;
    Float twentyseven_days_annualized_return;
    Float thirty_days_yield_rate;
    Float ninety_days_yield_rate;
    Float yield_rate_since_establishment;

    public Float getSeven_days_annualized_return() {
        return seven_days_annualized_return;
    }

    public void setSeven_days_annualized_return(Float seven_days_annualized_return) {
        this.seven_days_annualized_return = seven_days_annualized_return;
    }

    public Float getFourteen_days_annualized_return() {
        return fourteen_days_annualized_return;
    }

    public void setFourteen_days_annualized_return(Float fourteen_days_annualized_return) {
        this.fourteen_days_annualized_return = fourteen_days_annualized_return;
    }

    public Float getTwentyseven_days_annualized_return() {
        return twentyseven_days_annualized_return;
    }

    public void setTwentyseven_days_annualized_return(Float twentyseven_days_annualized_return) {
        this.twentyseven_days_annualized_return = twentyseven_days_annualized_return;
    }

    public Float getThirty_days_yield_rate() {
        return thirty_days_yield_rate;
    }

    public void setThirty_days_yield_rate(Float thirty_days_yield_rate) {
        this.thirty_days_yield_rate = thirty_days_yield_rate;
    }

    public Float getNinety_days_yield_rate() {
        return ninety_days_yield_rate;
    }

    public void setNinety_days_yield_rate(Float ninety_days_yield_rate) {
        this.ninety_days_yield_rate = ninety_days_yield_rate;
    }

    public Float getYield_rate_since_establishment() {
        return yield_rate_since_establishment;
    }

    public void setYield_rate_since_establishment(Float yield_rate_since_establishment) {
        this.yield_rate_since_establishment = yield_rate_since_establishment;
    }

    public InfoRatesResponse(Float seven_days_annualized_return, Float fourteen_days_annualized_return, Float twentyseven_days_annualized_return, Float thirty_days_yield_rate, Float ninety_days_yield_rate, Float yield_rate_since_establishment) {
        this.seven_days_annualized_return = seven_days_annualized_return;
        this.fourteen_days_annualized_return = fourteen_days_annualized_return;
        this.twentyseven_days_annualized_return = twentyseven_days_annualized_return;
        this.thirty_days_yield_rate = thirty_days_yield_rate;
        this.ninety_days_yield_rate = ninety_days_yield_rate;
        this.yield_rate_since_establishment = yield_rate_since_establishment;
    }

    public InfoRatesResponse() {
    }
    public InfoRatesResponse(InfoRateString string) {
        this.seven_days_annualized_return = trans(string.getSeven_days_annualized_return());
        this.fourteen_days_annualized_return = trans(string.getFourteen_days_annualized_return());
        this.twentyseven_days_annualized_return = trans(string.getTwentyseven_days_annualized_return());
        this.thirty_days_yield_rate = trans(string.getThirty_days_yield_rate());
        this.ninety_days_yield_rate = trans(string.getNinety_days_yield_rate());
        this.yield_rate_since_establishment = trans(string.getYield_rate_since_establishment());
    }

    public Float trans(String input){
        Double x = Float.valueOf(input.substring(0,input.length()-1))*0.01;
        return x.floatValue();
    }

}
