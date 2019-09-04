package financial_management.entity.bond.transferPython;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/31 20:28
 * @Version 1.0
 **/
public class BondsInfo {
    String product;
    String code;
    Float proportion;
    Float amount;
    //应该是份额
    Integer quantity;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getProportion() {
        return proportion;
    }

    public void setProportion(Float proportion) {
        this.proportion = proportion;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
