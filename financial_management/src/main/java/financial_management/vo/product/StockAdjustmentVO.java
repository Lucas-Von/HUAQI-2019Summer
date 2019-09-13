package financial_management.vo.product;

import financial_management.util.PyInvoke.PyResponse.stock.StockAdjustment;

public class StockAdjustmentVO {
    private String code;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(Integer order_amount) {
        this.order_amount = order_amount;
    }

    public Integer getComplete_amount() {
        return complete_amount;
    }

    public void setComplete_amount(Integer complete_amount) {
        this.complete_amount = complete_amount;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
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

    public StockAdjustmentVO(StockAdjustment adjustment) {
        code = adjustment.getCode();
        order_amount = adjustment.getOrder_amount();
        complete_amount = adjustment.getComplete_amount();
        price = adjustment.getPrice();
        fee = adjustment.getFee();
        total = adjustment.getTotal();
    }

    @Override
    public String toString() {
        return code
                + " " + name
                + " 拟交易份额：" + order_amount
                + " 实际交易份额：" + complete_amount
                + " 市价：" + price
                + " 手续费：" + fee
                + " 交易总金额：" + total;
    }
}
