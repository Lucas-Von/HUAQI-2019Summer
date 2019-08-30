package financial_management.vo.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 15:14
 * @Version 1.0
 **/
public class InvestmentVO {

    String name;
    String type;
    String code;
    Double latestprice;
    Float amount;
    Double holdings;
    Double incomeamount;
    Double incomerate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getLatestprice() {
        return latestprice;
    }

    public void setLatestprice(Double latestprice) {
        this.latestprice = latestprice;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Double getHoldings() {
        return holdings;
    }

    public void setHoldings(Double holdings) {
        this.holdings = holdings;
    }

    public Double getIncomeamount() {
        return incomeamount;
    }

    public void setIncomeamount(Double incomeamount) {
        this.incomeamount = incomeamount;
    }

    public Double getIncomerate() {
        return incomerate;
    }

    public void setIncomerate(Double incomerate) {
        this.incomerate = incomerate;
    }

    public InvestmentVO() {
    }

    public InvestmentVO(String name, String type, String code, Double latestprice, Float amount, Double holdings, Double incomeamount, Double incomerate) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.latestprice = latestprice;
        this.amount = amount;
        this.holdings = holdings;
        this.incomeamount = incomeamount;
        this.incomerate = incomerate;
    }
}
