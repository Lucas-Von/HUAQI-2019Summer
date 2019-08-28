package financial_management.service.property.income;

import financial_management.bl.property.IncomeService;
import financial_management.data.property.IncomeMapper;
import financial_management.entity.property.IncomePO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lt
 * @date 2019/08/25 20:25
 */
@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeMapper incomeMapper;

    /**
     * 获取平台所有用户近7/30/90天的收益率
     *
     * @param days
     * @return
     */
    @Override
    public BasicResponse getRecentProfitRate(int days) {
        try {
            IncomePO incomePO = incomeMapper.getRecentProfitRate(days);
            double profitRate = 0;
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, profitRate);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

}
