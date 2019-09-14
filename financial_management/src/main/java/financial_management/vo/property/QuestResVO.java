package financial_management.vo.property;

/**
 * @author lt
 * @date 2019/09/14 21:11
 */
public class QuestResVO {

    /**
     * 会员等级
     */
    private int vipLevel;

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
        this.vipLevel = vipLevel;
        this.investPrefer = investPrefer;
        this.totalYield = totalYield;
        this.questResWithInvRateVO = questResWithInvRateVO;
    }

    public QuestResVO() {

    }

    public int getVipLevel() {
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