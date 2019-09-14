package financial_management.util.PyInvoke.PyParam.stock;

import financial_management.util.PyInvoke.PyParam.PyParam;

public class StockParam extends PyParam {
    private String fromDate;

    private boolean wantBefore;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public boolean isWantBefore() {
        return wantBefore;
    }

    public void setWantBefore(boolean wantBefore) {
        this.wantBefore = wantBefore;
    }

    public StockParam(String fromDate, boolean wantBefore) {
        this.fromDate = fromDate;
        this.wantBefore = wantBefore;
    }
}
