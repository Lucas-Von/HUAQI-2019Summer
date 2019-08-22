package financial_management.entity;

/**
 * @author lt
 * @date 2019/08/13 14:25
 */
public class EstatePO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户平台内现金数额
     */
    private int fundsInPlatform;

    /**
     * 用户平台外现金数额
     */
    private int fundsOutPlatform;

    /**
     * 用户平台内储蓄数额
     */
    private int savingInPlatform;

    /**
     * 用户平台外储蓄数额
     */
    private int savingOutPlatform;

    /**
     * 用户平台内保险数额
     */
    private int insuranceInPlatform;

    /**
     * 用户平台外保险数额
     */
    private int insuranceOutPlatform;

    /**
     * 用户平台内股票数额
     */
    private int stocksInPlatform;

    /**
     * 用户平台外股票数额
     */
    private int stocksOutPlatform;

    /**
     * 用户平台内黄金数额
     */
    private int goldInPlatform;

    /**
     * 用户平台外黄金数额
     */
    private int goldOutPlatform;

    /**
     * 用户平台内债券数额
     */
    private int bondInPlatform;

    /**
     * 用户平台外债券数额
     */
    private int bondOutPlatform;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getFundsInPlatform() {
        return fundsInPlatform;
    }

    public void setFundsInPlatform(int fundsInPlatform) {
        this.fundsInPlatform = fundsInPlatform;
    }

    public int getFundsOutPlatform() {
        return fundsOutPlatform;
    }

    public void setFundsOutPlatform(int fundsOutPlatform) {
        this.fundsOutPlatform = fundsOutPlatform;
    }

    public int getSavingInPlatform() {
        return savingInPlatform;
    }

    public void setSavingInPlatform(int savingInPlatform) {
        this.savingInPlatform = savingInPlatform;
    }

    public int getSavingOutPlatform() {
        return savingOutPlatform;
    }

    public void setSavingOutPlatform(int savingOutPlatform) {
        this.savingOutPlatform = savingOutPlatform;
    }

    public int getInsuranceInPlatform() {
        return insuranceInPlatform;
    }

    public void setInsuranceInPlatform(int insuranceInPlatform) {
        this.insuranceInPlatform = insuranceInPlatform;
    }

    public int getInsuranceOutPlatform() {
        return insuranceOutPlatform;
    }

    public void setInsuranceOutPlatform(int insuranceOutPlatform) {
        this.insuranceOutPlatform = insuranceOutPlatform;
    }

    public int getStocksInPlatform() {
        return stocksInPlatform;
    }

    public void setStocksInPlatform(int stocksInPlatform) {
        this.stocksInPlatform = stocksInPlatform;
    }

    public int getStocksOutPlatform() {
        return stocksOutPlatform;
    }

    public void setStocksOutPlatform(int stocksOutPlatform) {
        this.stocksOutPlatform = stocksOutPlatform;
    }

    public int getGoldInPlatform() {
        return goldInPlatform;
    }

    public void setGoldInPlatform(int goldInPlatform) {
        this.goldInPlatform = goldInPlatform;
    }

    public int getGoldOutPlatform() {
        return goldOutPlatform;
    }

    public void setGoldOutPlatform(int goldOutPlatform) {
        this.goldOutPlatform = goldOutPlatform;
    }

    public int getBondInPlatform() {
        return bondInPlatform;
    }

    public void setBondInPlatform(int bondInPlatform) {
        this.bondInPlatform = bondInPlatform;
    }

    public int getBondOutPlatform() {
        return bondOutPlatform;
    }

    public void setBondOutPlatform(int bondOutPlatform) {
        this.bondOutPlatform = bondOutPlatform;
    }
}
