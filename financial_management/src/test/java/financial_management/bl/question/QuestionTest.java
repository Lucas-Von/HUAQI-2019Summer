package financial_management.bl.question;


import financial_management.FinancialManagementApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class QuestionTest {
    @Autowired
    private QuestionService questionService;

    @Test
    public void answer_normal(){
        questionService.answer("股票",1L);
    }
}
