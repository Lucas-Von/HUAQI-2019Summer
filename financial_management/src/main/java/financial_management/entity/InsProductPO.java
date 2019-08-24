package financial_management.entity;

/**
 * @Description 保险产品的实体类
 * @Author 233loser
 * @Date 2019/8/14 12:59
 * @Version 1.0
 **/
public class InsProductPO {
    Long id;

    /**
     * @Description //产品名
     **/
    String name;

    /**
     * @Description //类别
     **/
    String type;

    /**
     * @Description //当前保费（购买金额）
     **/
    Float price;

    /**
     * @Description //当前最高保额
     **/
    Float compensation;

    /**
     * @Description //时间
     **/
    Integer length;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCompensation() {
        return compensation;
    }

    public void setCompensation(Float compensation) {
        this.compensation = compensation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
