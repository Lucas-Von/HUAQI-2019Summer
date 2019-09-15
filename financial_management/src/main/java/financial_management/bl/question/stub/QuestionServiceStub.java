package financial_management.bl.question.stub;

import financial_management.bl.question.QuestionService;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.SingletonStringParam;
import financial_management.util.PyInvoke.PyResponse.QAPair;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceStub implements QuestionService {
    @Override
    public BasicResponse<String> answer(String question, Long userID) {
        BasicResponse<String> response;
        List<Object> result = PyInvoke.invoke(PyFunc.QA, new SingletonStringParam(question), QAPair.class);
        if (result == null || result.size() == 0) {
            response = new BasicResponse<>(ResponseStatus.STATUS_ANSWER_FAIL, null);
        } else {
            List<QAPair> qaPairs = new ArrayList<>(result.size());
            for (Object o : result) {
                qaPairs.add((QAPair) o);
            }
            if (qaPairs.size() == 1) {
                response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, qaPairs.get(0).getA());
            } else {
                String prob = "你是不是想问这些问题：\n" + qaPairs.stream().map(QAPair::getQ).collect(Collectors.joining("\n"));
                response = new BasicResponse<>(ResponseStatus.STATUS_MULTIPLE_ANSWER, prob);
            }
        }
        return response;
    }
}
