package financial_management.vo.property;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/17 17:00
 */
public class QuestionnaireVO {

    /**
     * 问题
     */
    private List<Question> questionList;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList() {
        questionList = new ArrayList<>();
        Question question1 = new Question();
        String topic = "你计划中的投资时间是多久?";
        ArrayList<String> answerList = new ArrayList<>();
        answerList.add("A.1～3个月(短期)");
        answerList.add("B.3～6个月(中期)");
        answerList.add("C.6～12个月(中长期或长期)");
        answerList.add("D.1年以上");
        question1.setQuestion(topic);
        question1.setAnswers(answerList);
        questionList.add(question1);
    }

    private static class Question {

        /**
         * 问题
         */
        private String question;

        /**
         * 选项
         */
        private ArrayList<String> answers;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public ArrayList<String> getAnswers() {
            return answers;
        }

        public void setAnswers(ArrayList<String> answers) {
            this.answers = answers;
        }

    }

}
