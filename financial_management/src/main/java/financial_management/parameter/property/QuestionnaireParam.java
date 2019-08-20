package financial_management.parameter.property;

public class QuestionnaireParam {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 现金
     */
    private int funds;

    /**
     * 储蓄
     */
    private int saving;

    /**
     * 保险
     */
    private int insurance;

    /**
     * 股票
     */
    private int stocks;

    /**
     * 黄金
     */
    private int gold;

    /**
     * 债券
     */
    private int bond;

    /**
     * 用户的回答
     */
    private String answer;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getBond() {
        return bond;
    }

    public void setBond(int bond) {
        this.bond = bond;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
