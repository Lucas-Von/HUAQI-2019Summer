package financial_management.util.PyInvoke.PyResponse.questionnaire;

/**
 * @author lt
 * @date 2019/08/31 21:07
 */
public class AssetConfigResponse {

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

    public AssetConfigResponse(double stocks_rate, double qdii_rate, double gold_rate, double bond_rate, double total_volatility, double total_yield, int total_risk_level) {
        this.stocks_rate = stocks_rate;
        this.qdii_rate = qdii_rate;
        this.gold_rate = gold_rate;
        this.bond_rate = bond_rate;
        this.total_volatility = total_volatility;
        this.total_yield = total_yield;
        String risk_level;
        switch (total_risk_level) {
            case 1:
                risk_level = "保守型";
                break;
            case 2:
                risk_level = "稳健保守型";
                break;
            case 3:
                risk_level = "稳健型";
                break;
            case 4:
                risk_level = "稳健进取型";
                break;
            case 5:
                risk_level = "进取型";
                break;
            default:
                risk_level = "未知类型";
        }
        this.total_risk_level = risk_level;
    }

    public AssetConfigResponse() {

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
