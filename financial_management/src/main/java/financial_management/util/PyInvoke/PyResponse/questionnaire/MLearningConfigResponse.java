package financial_management.util.PyInvoke.PyResponse.questionnaire;

/**
 * @author lt
 * @date 2019/08/31 17:18
 */
public class MLearningConfigResponse {

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

    public MLearningConfigResponse(int invest_analysis_tag, double volatility, double yield) {
        String analysis;
        switch (invest_analysis_tag) {
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
        this.invest_analysis_tag = analysis;
        this.volatility = volatility;
        this.yield = yield;
    }

    public MLearningConfigResponse() {

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

}
