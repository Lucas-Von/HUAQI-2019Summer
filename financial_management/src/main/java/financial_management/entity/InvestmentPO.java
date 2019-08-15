package financial_management.entity;

import java.util.List;

/**
 * @Description 用户持有的投资类
 * @Author 233loser
 * @Date 2019/8/14 12:57
 * @Version 1.0
 **/
public class InvestmentPO {

    /**
     * @Description //用户ID
     */
    Long userId;

    /**
     * @Description //投资的总额
     **/
    Float amount;

    /**
     * @Description //所占总额的百分比
     **/
    Float percentage;

    /**
     * @Author jyh
     * @Description //用户的股票(国内、国外)、黄金、债券 在这个类中不入库
     **/
    List<MyStockPO> domStocks;

    List<MyStockPO> forStocks;

    List<MyGoldPO> gold;

    List<MyBondPO> bonds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public List<MyStockPO> getDomStocks() {
        return domStocks;
    }

    public void setDomStocks(List<MyStockPO> domStocks) {
        this.domStocks = domStocks;
    }

    public List<MyStockPO> getForStocks() {
        return forStocks;
    }

    public void setForStocks(List<MyStockPO> forStocks) {
        this.forStocks = forStocks;
    }

    public List<MyGoldPO> getGold() {
        return gold;
    }

    public void setGold(List<MyGoldPO> gold) {
        this.gold = gold;
    }

    public List<MyBondPO> getBonds() {
        return bonds;
    }

    public void setBonds(List<MyBondPO> bonds) {
        this.bonds = bonds;
    }
}
