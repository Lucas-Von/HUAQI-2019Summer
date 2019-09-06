package financial_management.util.PyInvoke.PyResponse.questionnaire;

/**
 * @author lt
 * @date 2019/08/31 17:18
 */
public class MLearningConfigResponse {

    /**
     * 用户投资分析标签
     */
    private int prefer_label;

    public MLearningConfigResponse(int prefer_label) {
        this.prefer_label = prefer_label;
    }

    public MLearningConfigResponse() {

    }

    public int getPrefer_label() {
        return prefer_label;
    }

    public void setPrefer_label(int prefer_label) {
        this.prefer_label = prefer_label;
    }

}
