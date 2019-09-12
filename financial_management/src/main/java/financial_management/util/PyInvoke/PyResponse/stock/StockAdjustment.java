package financial_management.util.PyInvoke.PyResponse.stock;

public class StockAdjustment {
    private Float order_time;
    private String code;
    private String state_message;
    private Integer order_amount;
    private Integer complete_amount;
    private Float fee;
    private Float total;
    private Float price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getComplete_amount() {
        return complete_amount;
    }

    public void setComplete_amount(Integer complete_amount) {
        this.complete_amount = complete_amount;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Float order_time) {
        this.order_time = order_time;
    }

    public String getState_message() {
        return state_message;
    }

    public void setState_message(String state_message) {
        this.state_message = state_message;
    }

    public Integer getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(Integer order_amount) {
        this.order_amount = order_amount;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public StockAdjustment() {
    }

    public StockAdjustment(Float order_time, String code, String state_message, Integer order_amount, Integer complete_amount, Float fee, Float total, Float price) {
        this.order_time = order_time;
        this.code = code;
        this.state_message = state_message;
        this.order_amount = order_amount;
        this.complete_amount = complete_amount;
        this.fee = fee;
        this.total = total;
        this.price = price;
    }

    @Override
    public String toString() {
        return "StockAdjustment{" +
                "order_time=" + order_time +
                ", code='" + code + '\'' +
                ", state_message='" + state_message + '\'' +
                ", order_amount=" + order_amount +
                ", complete_amount=" + complete_amount +
                ", fee=" + fee +
                ", total=" + total +
                ", price=" + price +
                '}';
    }
}
