package financial_management.vo.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/14 13:44
 * @Version 1.0
 **/
public class UserBondVO {
    String fundName;
    Float price;
    Float quantity;
    Float totalAmount;
    Double returnRate;
    Float proportion;

    public Float getProportion() {
        return proportion;
    }

    public void setProportion(Float proportion) {
        this.proportion = proportion;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(Double returnRate) {
        this.returnRate = returnRate;
    }
}
