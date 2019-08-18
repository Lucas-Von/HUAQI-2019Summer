package financial_management.entity;

import financial_management.vo.AssetsVO;
import financial_management.vo.PreferVO;
import financial_management.vo.QuestionnaireVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lt
 * @date 2019/08/13 15:00
 */
public class QuestionnairePO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 现金
     */
    private int funds;

    /**
     * 储蓄
     */
    private int saving;

    /**
     * 保险
     */
    private int insurance;

    /**
     * 股票
     */
    private int stocks;

    /**
     * 黄金
     */
    private int gold;

    /**
     * 债券
     */
    private int bond;

    /**
     * 投资偏好列表
     */
    private List<PreferPO> preferList;

    public QuestionnairePO() {

    }

    public QuestionnaireVO getVO() {
        QuestionnaireVO vo = new QuestionnaireVO();
        vo.setUserId(userId);
        AssetsVO avo = new AssetsVO();
        avo.setFunds(funds);
        avo.setSaving(saving);
        avo.setInsurance(insurance);
        avo.setStocks(stocks);
        avo.setGold(gold);
        avo.setBond(bond);
        vo.setPreferList(preferList.stream().map(prefer -> {
            PreferVO pvo = new PreferVO();
            pvo.setQuestion(prefer.getQuestion());
            pvo.setAnswer(prefer.getAnswer());
            return pvo;
        }).collect(Collectors.toList()));
        return vo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getBond() {
        return bond;
    }

    public void setBond(int bond) {
        this.bond = bond;
    }

    public List<PreferPO> getPreferList() {
        return preferList;
    }

    public void setPreferList(List<PreferPO> preferList) {
        this.preferList = preferList;
    }
}
