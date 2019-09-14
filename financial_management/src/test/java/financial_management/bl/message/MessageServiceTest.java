package financial_management.bl.message;

import financial_management.FinancialManagementApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinancialManagementApplication.class)
public class MessageServiceTest {

    @Autowired
    @Qualifier("messageServiceImpl")
    private MessageService messageService;

    @Test
    public void getMessagesByUserAndType_normal(){
        messageService.getMessagesByUser(1L,1);
    }
}
