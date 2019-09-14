package financial_management.parameter.bond;

import java.util.Date;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/5 23:55
 * @Version 1.0
 **/
public class ReturnRateVO {
    Date date;
    Double value;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ReturnRateVO(Date date, Double value) {
        this.date = date;
        this.value = value;
    }
}
