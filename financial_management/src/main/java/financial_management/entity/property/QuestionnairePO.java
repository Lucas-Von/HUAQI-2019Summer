package financial_management.entity.property;

import financial_management.vo.property.AssetsVO;
import financial_management.vo.property.QuestionnaireVO;

/**
 * @author lt
 * @version 1.0
 * @description 问卷实体
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
    private double funds;

    /**
     * 储蓄
     */
    private double saving;

    /**
     * 保险
     */
    private double insurance;

    /**
     * 股票
     */
    private double stocks;

    /**
     * 股指
     */
    private double qdii;

    /**
     * 黄金
     */
    private double gold;

    /**
     * 债券
     */
    private double bond;

    /**
     * 问题
     */
    private String question;

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
        avo.setQdii(qdii);
        avo.setGold(gold);
        avo.setBond(bond);
        vo.setAssetsVO(avo);
        vo.setQuestionList();
        return vo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getStocks() {
        return stocks;
    }

    public void setStocks(double stocks) {
        this.stocks = stocks;
    }

    public double getQdii() {
        return qdii;
    }

    public void setQdii(double qdii) {
        this.qdii = qdii;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getBond() {
        return bond;
    }

    public void setBond(double bond) {
        this.bond = bond;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
