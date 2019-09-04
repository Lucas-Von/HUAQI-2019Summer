package financial_management.entity.bond;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/3 21:31
 * @Version 1.0
 **/
public class RateList {
    Float rate1;
    Float rate2;
    Float rate3;

    public Float getRate1() {
        return rate1;
    }

    public void setRate1(Float rate1) {
        this.rate1 = rate1;
    }

    public Float getRate2() {
        return rate2;
    }

    public void setRate2(Float rate2) {
        this.rate2 = rate2;
    }

    public Float getRate3() {
        return rate3;
    }

    public void setRate3(Float rate3) {
        this.rate3 = rate3;
    }

    public  List<Float> getList(){
        List<Float> res = new ArrayList<>();
        res.add(rate1);
        res.add(rate2);
        res.add(rate3);
        return res;
    }
}
