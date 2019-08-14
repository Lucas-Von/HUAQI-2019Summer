package financial_management.entity;

import javax.print.DocFlavor;

/**
 * @Description 储蓄产品
 * @Author 233loser
 * @Date 2019/8/14 13:08
 * @Version 1.0
 **/
public class DepositProductPO {
    Long id;
    /**
     * @Description //名称
     **/
    String name;

    /**
     * @Description //类别
     **/
    String type;

    /**
     * @Description //收益率
     **/
    Float rate;

    /**
     * @Description //时长（以天计）
     **/
    Integer length;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
