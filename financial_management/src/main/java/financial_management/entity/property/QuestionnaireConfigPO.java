package financial_management.entity.property;

/**
 * @author lt
 * @version 1.0
 * @description 问卷分析结果
 * @date 2019/08/31 17:34
 */
public class QuestionnaireConfigPO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户投资偏好
     */
    private String invest_prefer;

    /**
     * 现金部分比例
     */
    private double funds_rate;

    /**
     * 保险部分比例
     */
    private double insurance_rate;

    /**
     * 储蓄部分比例
     */
    private double saving_rate;

    /**
     * 投资部分比例
     */
    private double invest_rate;

    /**
     * 最小金融脆弱性
     */
    private double min_finance_fragility;

    /**
     * 股票部分投资权重
     */
    private double stocks_rate;

    /**
     * 股指部分投资权重
     */
    private double qdii_rate;

    /**
     * 黄金部分投资权重
     */
    private double gold_rate;

    /**
     * 债券部分投资权重
     */
    private double bond_rate;

    /**
     * 投资组合整体波动率
     */
    private double total_volatility;

    /**
     * 投资组合整体收益率
     */
    private double total_yield;

    /**
     * 投资组合风险等级
     */
    private int total_risk_level;

    public QuestionnaireConfigPO(Long userId, int prefer_label, double funds_rate, double insurance_rate, double saving_rate, double invest_rate, double min_finance_fragility, double stocks_rate, double qdii_rate, double gold_rate, double bond_rate, double total_volatility, double total_yield, int total_risk_level) {
        this.userId = userId;
        this.funds_rate = funds_rate;
        this.insurance_rate = insurance_rate;
        this.saving_rate = saving_rate;
        this.invest_rate = invest_rate;
        this.min_finance_fragility = min_finance_fragility;
        this.stocks_rate = stocks_rate;
        this.qdii_rate = qdii_rate;
        this.gold_rate = gold_rate;
        this.bond_rate = bond_rate;
        this.total_volatility = total_volatility;
        this.total_yield = total_yield;
        this.total_risk_level = total_risk_level;

        String analysis;
        switch (prefer_label) {
            case 1:
                analysis = "保守型";
                break;
            case 2:
                analysis = "稳健保守型";
                break;
            case 3:
                analysis = "稳健型";
                break;
            case 4:
                analysis = "稳健进取型";
                break;
            case 5:
                analysis = "进取型";
                break;
            default:
                analysis = "未知类型";
        }
        this.invest_prefer = analysis;
    }

    public QuestionnaireConfigPO() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getInvest_prefer() {
        return invest_prefer;
    }

    public void setInvest_prefer(int prefer_label) {
        String analysis;
        switch (prefer_label) {
            case 1:
                analysis = "保守型";
                break;
            case 2:
                analysis = "稳健保守型";
                break;
            case 3:
                analysis = "稳健型";
                break;
            case 4:
                analysis = "稳健进取型";
                break;
            case 5:
                analysis = "进取型";
                break;
            default:
                analysis = "未知类型";
        }
        this.invest_prefer = analysis;
    }

    public double getFunds_rate() {
        return funds_rate;
    }

    public void setFunds_rate(double funds_rate) {
        this.funds_rate = funds_rate;
    }

    public double getInsurance_rate() {
        return insurance_rate;
    }

    public void setInsurance_rate(double insurance_rate) {
        this.insurance_rate = insurance_rate;
    }

    public double getSaving_rate() {
        return saving_rate;
    }

    public void setSaving_rate(double saving_rate) {
        this.saving_rate = saving_rate;
    }

    public double getInvest_rate() {
        return invest_rate;
    }

    public void setInvest_rate(double invest_rate) {
        this.invest_rate = invest_rate;
    }

    public double getMin_finance_fragility() {
        return min_finance_fragility;
    }

    public void setMin_finance_fragility(double min_finance_fragility) {
        this.min_finance_fragility = min_finance_fragility;
    }

    public double getStocks_rate() {
        return stocks_rate;
    }

    public void setStocks_rate(double stocks_rate) {
        this.stocks_rate = stocks_rate;
    }

    public double getQdii_rate() {
        return qdii_rate;
    }

    public void setQdii_rate(double qdii_rate) {
        this.qdii_rate = qdii_rate;
    }

    public double getGold_rate() {
        return gold_rate;
    }

    public void setGold_rate(double gold_rate) {
        this.gold_rate = gold_rate;
    }

    public double getBond_rate() {
        return bond_rate;
    }

    public void setBond_rate(double bond_rate) {
        this.bond_rate = bond_rate;
    }

    public double getTotal_volatility() {
        return total_volatility;
    }

    public void setTotal_volatility(double total_volatility) {
        this.total_volatility = total_volatility;
    }

    public double getTotal_yield() {
        return total_yield;
    }

    public void setTotal_yield(double total_yield) {
        this.total_yield = total_yield;
    }

    public int getTotal_risk_level() {
        return total_risk_level;
    }

    public void setTotal_risk_level(int total_risk_level) {
        this.total_risk_level = total_risk_level;
    }

}
