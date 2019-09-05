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
    Float value;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public ReturnRateVO(Date date, Float value) {
        this.date = date;
        this.value = value;
    }
}
