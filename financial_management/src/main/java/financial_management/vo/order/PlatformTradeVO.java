package financial_management.vo.order;

import financial_management.entity.PlatformTradePO;

import java.util.Date;

public class PlatformTradeVO {
    private Long ID;
    private Date time;
    private String product;
    private Integer amount;
    private Float price;
    private Float total;
    //realTotal是净值
    private Float realTotal;
    private Integer status;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(Float realTotal) {
        this.realTotal = realTotal;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PlatformTradeVO(PlatformTradePO po) {
        ID = po.getID();
        time = po.getTime();
        product = po.getProduct();
        amount = po.getAmount();
        price = po.getPrice();
        total = po.getTotal();
        realTotal = po.getRealTotal();
        status = po.getStatus();
    }

    public PlatformTradeVO() {
    }
}
