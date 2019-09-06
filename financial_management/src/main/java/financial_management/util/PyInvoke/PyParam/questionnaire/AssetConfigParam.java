package financial_management.util.PyInvoke.PyParam.questionnaire;

import financial_management.util.PyInvoke.PyParam.PyParam;

/**
 * @author lt
 * @date 2019/08/31 17:51
 */
public class AssetConfigParam extends PyParam {

    /**
     * 收益率要求
     */
    private double yield;

    /**
     * 投资偏好
     */
    private int prefer_label;

    public AssetConfigParam(double yield, int prefer_label) {
        this.yield = yield;
        this.prefer_label = prefer_label;
    }

    public AssetConfigParam() {

    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public int getPrefer_label() {
        return prefer_label;
    }

    public void setPrefer_label(int prefer_label) {
        this.prefer_label = prefer_label;
    }

}