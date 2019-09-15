package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/09/14 21:11
 */
public class QuestResVO {

    /**
     * 会员等级
     */
    private String vipLevel;

    /**
     * 投资偏好
     */
    private String investPrefer;

    /**
     * 预期投资收益率
     */
    private double totalYield;

    /**
     * 投资部分配置
     */
    private QuestResWithInvRateVO questResWithInvRateVO;

    public QuestResVO(int vipLevel, String investPrefer, double totalYield, QuestResWithInvRateVO questResWithInvRateVO) {
        switch (vipLevel) {
            case 0:
                this.vipLevel = "普通会员";
                break;
            case 1:
                this.vipLevel = "中级会员";
                break;
            case 2:
                this.vipLevel = "高级会员";
                break;
            default:
                this.vipLevel = "未知等级";
                break;
        }
        this.investPrefer = investPrefer;
        this.totalYield = totalYield;
        this.questResWithInvRateVO = questResWithInvRateVO;
    }

    public QuestResVO() {

    }

    public String getVipLevel() {
        return vipLevel;
    }

    public String getInvestPrefer() {
        return investPrefer;
    }

    public double getTotalYield() {
        return totalYield;
    }

    public QuestResWithInvRateVO getQuestResWithInvRateVO() {
        return questResWithInvRateVO;
    }

}