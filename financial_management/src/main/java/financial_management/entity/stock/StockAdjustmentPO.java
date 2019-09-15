package financial_management.entity.stock;

import financial_management.util.PyInvoke.PyResponse.stock.StockAdjustment;

public class StockAdjustmentPO extends StockAdjustment {
    private Long userID;

    private Long transID;

    public StockAdjustmentPO() {

    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getTransID() {
        return transID;
    }

    public void setTransID(Long transID) {
        this.transID = transID;
    }

    public StockAdjustmentPO(StockAdjustment adjustment) {
        this.setCode(adjustment.getCode());
        this.setComplete_amount(adjustment.getComplete_amount());
        this.setFee(adjustment.getFee());
        this.setOrder_amount(adjustment.getOrder_amount());
        this.setOrder_time(adjustment.getOrder_time());
        this.setPrice(adjustment.getPrice());
        this.setState_message(adjustment.getState_message());
        this.setTotal(adjustment.getTotal());
    }

    @Override
    public String toString() {
        return "StockAdjustmentPO{" +
                "userID=" + userID +
                ", transID=" + transID +
                "} " + super.toString();
    }
}
