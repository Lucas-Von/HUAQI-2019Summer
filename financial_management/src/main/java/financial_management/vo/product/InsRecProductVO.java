package financial_management.vo.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:34
 * @Version 1.0
 **/
public class InsRecProductVO {
    String name;
    String type;
    Double amount;
    Double insured;
    Integer time;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInsured() {
        return insured;
    }

    public void setInsured(Double insured) {
        this.insured = insured;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public InsRecProductVO(String name, String type, Double amount, Double insured, Integer time) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.insured = insured;
        this.time = time;
    }
}
