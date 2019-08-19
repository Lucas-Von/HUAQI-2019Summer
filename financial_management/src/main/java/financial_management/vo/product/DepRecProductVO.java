package financial_management.vo.product;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:39
 * @Version 1.0
 **/
public class DepRecProductVO {

    String name;
    Integer time;
    Double rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public DepRecProductVO(String name, Integer time, Double rate) {
        this.name = name;
        this.time = time;
        this.rate = rate;
    }
}
