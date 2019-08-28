package financial_management.parameter.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xyh
 * @date 2019/8/22
 */
public class DateParam {
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public DateParam() {
    }

    public DateParam(Date time) {
        this.time = time;
    }
}
