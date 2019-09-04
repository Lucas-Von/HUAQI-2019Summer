package financial_management.bl.property;

import financial_management.vo.BasicResponse;

/**
 * @author lt
 * @date 2019/09/03 19:26
 */
public interface IncomeService {

    /**
     * 获取用户累计收益
     *
     * @param userId
     * @return
     */
    BasicResponse getTotalIncome(Long userId);


    /**
     * 获取用户最新收益
     *
     * @param userId
     * @return
     */
    BasicResponse getNewlyIncome(Long userId);

    /**
     * 获取平台所有用户最近days天的累计投资收益率列表
     *
     * @param days
     * @return
     */
    BasicResponse getIncomeRateList(int days);

    /**
     * 获取平台所有用户最新的投资收益率
     *
     * @param
     * @return
     */
    BasicResponse getAveNewlyRate();

    /**
     * 获取平台所有用户累计的投资收益率
     *
     * @param
     * @return
     */
    BasicResponse getAveTotalRate();

}