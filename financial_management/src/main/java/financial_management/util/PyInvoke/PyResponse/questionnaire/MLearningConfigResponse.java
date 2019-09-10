package financial_management.util.PyInvoke.PyResponse.questionnaire;

/**
 * @author lt
 * @date 2019/08/31 17:18
 */
public class MLearningConfigResponse {

    /**
     * 用户投资分析标签
     */
    private int preferLabel;

    public MLearningConfigResponse(int preferLabel) {
        this.preferLabel = preferLabel;
    }

    public MLearningConfigResponse() {

    }

    public int getPreferLabel() {
        return preferLabel;
    }

    public void setPreferLabel(int preferLabel) {
        this.preferLabel = preferLabel;
    }

}
