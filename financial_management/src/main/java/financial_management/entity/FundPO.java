package financial_management.entity;

import java.util.Date;

/**
 * @Description 基金类
 * @Author 233loser
 * @Date 2019/8/13 20:55
 * @Version 1.0
 **/

public class FundPO {

    /**
     * @Description //基金名称
     **/
    String name;

    /**
     * @Author jyh
     * @Description //七日年化收益率
     **/
    Float rate;

    /**
     * @Author jyh
     * @Description //更新时间
     **/
    Date time;

    public FundPO(String name, Float rate, Date time) {
        this.name = name;
        this.rate = rate;
        this.time = time;
    }
}
