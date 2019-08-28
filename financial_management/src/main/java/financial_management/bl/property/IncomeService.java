package financial_management.bl.property;

import financial_management.vo.BasicResponse;

/**
 * @author lt
 * @date 2019/08/25 20:14
 */
public interface IncomeService {

    /**
     * 获取平台所有用户近7/30/90天的收益率
     *
     * @param days
     * @return
     */
    BasicResponse getRecentProfitRate(int days);

}
