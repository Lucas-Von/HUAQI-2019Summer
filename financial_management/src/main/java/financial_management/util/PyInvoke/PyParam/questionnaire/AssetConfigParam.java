package financial_management.util.PyInvoke.PyParam.questionnaire;

import financial_management.util.PyInvoke.PyParam.PyParam;

/**
 * @author lt
 * @date 2019/08/31 17:51
 */
public class AssetConfigParam extends PyParam {

    /**
     * 波动率要求
     */
    private double volatility;

    /**
     * 收益率要求
     */
    private double yield;

    public AssetConfigParam(double volatility, double yield) {
        this.volatility = volatility;
        this.yield = yield;
    }

    public AssetConfigParam() {

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