package financial_management.util.PyInvoke.PyParam.stock;

import financial_management.util.PyInvoke.PyParam.PyParam;

public class StockAdjustParam extends PyParam {
    private Float targetAmount;
    private Float totalAmount;

    public StockAdjustParam(Float targetAmount, Float totalAmount) {
        this.targetAmount = targetAmount;
        this.totalAmount = totalAmount;
    }

    public Float getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Float targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
