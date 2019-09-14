package financial_management.util.PyInvoke.PyResponse.questionnaire;

/**
 * @author lt
 * @date 2019/09/14 19:22
 */
public class VipConfigResponse {

    /**
     * 会员等级
     */
    private int vip_level;

    public VipConfigResponse(int vip_level) {
        this.vip_level = vip_level;
    }

    public VipConfigResponse() {

    }

    public int getVip_level() {
        return vip_level;
    }

    public void setVip_level(int vip_level) {
        this.vip_level = vip_level;
    }

}