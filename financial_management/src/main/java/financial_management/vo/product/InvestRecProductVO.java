package financial_management.vo.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 15:42
 * @Version 1.0
 **/
public class InvestRecProductVO {
    String name;
    String code;
    Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public InvestRecProductVO(String name, String code, Double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public InvestRecProductVO() {
    }
}
