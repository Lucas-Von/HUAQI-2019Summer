package financial_management.vo;

import financial_management.entity.PreferPO;

/**
 * @author lt
 * @date 2019/08/17 16:10
 */
public class PreferVO {

    /**
     * 问题
     */
    private String question;

    /**
     * 答案
     */
    private String answer;

    public PreferVO(PreferPO prefer) {
        this.question = prefer.getQuestion();
        this.answer = prefer.getAnswer();
    }

    public PreferVO() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
