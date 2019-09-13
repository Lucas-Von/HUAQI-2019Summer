package financial_management.util.PyInvoke.PyParam.stock;

import financial_management.util.PyInvoke.PyParam.PyParam;

public class StockParam extends PyParam {
    private String fromDate;

    public StockParam(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
}
