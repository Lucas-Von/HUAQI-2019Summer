package financial_management.entity;

/**
 * @Description 黄金商品实体类
 * @Author 233loser
 * @Date 2019/8/14 12:51
 * @Version 1.0
 **/
public class GoldPO {
    Long id;
    /**
     * @Description //名称
     **/
    String name;

    /**
     * @Description //黄金代码
     **/
    String code;

    /**
     * @Description //最新价格
     **/
    Float latestPrice;

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

    public Float getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(Float latestPrice) {
        this.latestPrice = latestPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
