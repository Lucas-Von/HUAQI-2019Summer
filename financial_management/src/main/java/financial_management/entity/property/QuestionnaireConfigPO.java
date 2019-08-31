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
     * 用户投资分析标签
     */
    private String invest_analysis_tag;

    /**
     * 波动率要求
     */
    private double volatility;

    /**
     * 收益率要求
     */
    private double yield;

    /**
     * 保险部分权重
     */
    private double insurance_rate;

    /**
     * 现金部分权重
     */
    private double funds_rate;

    /**
     * 储蓄部分权重
     */
    private double saving_rate;

    /**
     * 投资部分权重
     */
    private double investment_rate;

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
     * 整体波动率
     */
    private double total_volatility;

    /**
     * 整体收益率
     */
    private double total_yield;

    /**
     * 整体风险等级
     */
    private String total_risk_level;

    public QuestionnaireConfigPO(Long userId, String invest_analysis_tag, double volatility, double yield, double insurance_rate, double funds_rate, double saving_rate, double investment_rate, double stocks_rate, double qdii_rate, double gold_rate, double bond_rate, double total_volatility, double total_yield, String total_risk_level) {
        this.userId = userId;
        this.invest_analysis_tag = invest_analysis_tag;
        this.volatility = volatility;
        this.yield = yield;
        this.insurance_rate = insurance_rate;
        this.funds_rate = funds_rate;
        this.saving_rate = saving_rate;
        this.investment_rate = investment_rate;
        this.stocks_rate = stocks_rate;
        this.qdii_rate = qdii_rate;
        this.gold_rate = gold_rate;
        this.bond_rate = bond_rate;
        this.total_volatility = total_volatility;
        this.total_yield = total_yield;
        this.total_risk_level = total_risk_level;
    }

    public QuestionnaireConfigPO() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getInvest_analysis_tag() {
        return invest_analysis_tag;
    }

    public void setInvest_analysis_tag(String invest_analysis_tag) {
        this.invest_analysis_tag = invest_analysis_tag;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public double getInsurance_rate() {
        return insurance_rate;
    }

    public void setInsurance_rate(double insurance_rate) {
        this.insurance_rate = insurance_rate;
    }

    public double getFunds_rate() {
        return funds_rate;
    }

    public void setFunds_rate(double funds_rate) {
        this.funds_rate = funds_rate;
    }

    public double getSaving_rate() {
        return saving_rate;
    }

    public void setSaving_rate(double saving_rate) {
        this.saving_rate = saving_rate;
    }

    public double getInvestment_rate() {
        return investment_rate;
    }

    public void setInvestment_rate(double investment_rate) {
        this.investment_rate = investment_rate;
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

    public String getTotal_risk_level() {
        return total_risk_level;
    }

    public void setTotal_risk_level(String total_risk_level) {
        this.total_risk_level = total_risk_level;
    }

}
