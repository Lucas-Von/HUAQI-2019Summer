package financial_management.entity.bond;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/29 10:38
 * @Version 1.0
 **/
public class BondAndFundPO {

    String bondName;
    String bondCode;
    Float investProportion;
    Float quantity;
    Float amount;
    Float price;

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public Float getInvestProportion() {
        return investProportion;
    }

    public void setInvestProportion(Float investProportion) {
        this.investProportion = investProportion;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
