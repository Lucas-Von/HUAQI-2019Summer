package financial_management.entity;

/**
 * @author lt
 * @date 2019/08/13 15:20
 */
public class PreferPO {

    /**
     * 问卷中的问题
     */
    private String question;

    /**
     * 用户的解答
     */
    private String answer;

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
