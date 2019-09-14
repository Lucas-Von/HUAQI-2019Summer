package financial_management.vo.product;

import financial_management.entity.stock.MyQDIIPO;
import financial_management.entity.stock.MyStockPO;
import financial_management.util.ArithmeticUtil;

public class MyStockVO {
    private String code;
    private String name;
    private float latestPrice;
    private float amount;
    private float total;
    private float profit;

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

    public float getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(float latestPrice) {
        this.latestPrice = latestPrice;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public MyStockVO(MyStockPO po) {
        code = po.getCode();
        latestPrice = po.getHoldPrice();
        amount = po.getHoldAmount();
        total = po.getHoldTotal();
        profit = po.getProfit();
    }

    public MyStockVO(MyQDIIPO po){
        code = po.getCode();
        latestPrice = po.getHoldPrice();
        amount = ArithmeticUtil.divide(po.getHoldTotal(),po.getHoldPrice());
        total = po.getHoldTotal();
        profit = po.getProfit();
    }
}
