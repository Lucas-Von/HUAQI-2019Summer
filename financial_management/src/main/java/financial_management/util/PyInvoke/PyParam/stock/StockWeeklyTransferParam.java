package financial_management.util.PyInvoke.PyParam.stock;

import financial_management.util.PyInvoke.PyParam.PyParam;

import java.util.List;

public class StockWeeklyTransferParam extends PyParam {
    private Float total;
    private List<List<Object>> hold;

    public StockWeeklyTransferParam(Float total, List<List<Object>> hold) {
        this.total = total;
        this.hold = hold;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<List<Object>> getHold() {
        return hold;
    }

    public void setHold(List<List<Object>> hold) {
        this.hold = hold;
    }
}
