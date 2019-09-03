package financial_management.vo.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/3 21:58
 * @Version 1.0
 **/
public class InvestmentBriefProductVO {
    String productName;
    Double investment;
    Double percentage;
    Double income;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getInvestment() {
        return investment;
    }

    public void setInvestment(Double investment) {
        this.investment = investment;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public InvestmentBriefProductVO(String productName, Double investment, Double sum, Double income) {
        this.productName = productName;
        this.investment = investment;
        this.percentage = investment/sum;
        this.income = income;
    }
}
