package financial_management.vo.product;

import financial_management.entity.FundPO;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/18 16:12
 * @Version 1.0
 **/
public class FundBasicVO {

    String name;
    Double rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public FundBasicVO() {
    }
    public FundBasicVO(FundPO po) {
        this.name = po.getName();
        this.rate = po.getRate().doubleValue();
    }
}
