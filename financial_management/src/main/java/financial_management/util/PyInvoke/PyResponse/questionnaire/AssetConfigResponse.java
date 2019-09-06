package financial_management.util.PyInvoke.PyResponse.questionnaire;

/**
 * @author lt
 * @date 2019/08/31 21:07
 */
public class AssetConfigResponse {

    /**
     * 股票部分投资权重
     */
    private double weight_1;

    /**
     * 股指部分投资权重
     */
    private double weight_2;

    /**
     * 黄金部分投资权重
     */
    private double weight_0;

    /**
     * 债券部分投资权重
     */
    private double weight_3;

    /**
     * 投资组合整体波动率
     */
    private double vol;

    /**
     * 投资组合整体收益率
     */
    private double earnings;

    /**
     * 投资组合风险等级
     */
    private int label;

    public AssetConfigResponse(double weight_1, double weight_2, double weight_0, double weight_3, double vol, double earnings, int label) {
        this.weight_1 = weight_1;
        this.weight_2 = weight_2;
        this.weight_0 = weight_0;
        this.weight_3 = weight_3;
        this.vol = vol;
        this.earnings = earnings;
        this.label = label;
    }

    public AssetConfigResponse() {

    }

    public double getWeight_1() {
        return weight_1;
    }

    public void setWeight_1(double weight_1) {
        this.weight_1 = weight_1;
    }

    public double getWeight_2() {
        return weight_2;
    }

    public void setWeight_2(double weight_2) {
        this.weight_2 = weight_2;
    }

    public double getWeight_0() {
        return weight_0;
    }

    public void setWeight_0(double weight_0) {
        this.weight_0 = weight_0;
    }

    public double getWeight_3() {
        return weight_3;
    }

    public void setWeight_3(double weight_3) {
        this.weight_3 = weight_3;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

}
