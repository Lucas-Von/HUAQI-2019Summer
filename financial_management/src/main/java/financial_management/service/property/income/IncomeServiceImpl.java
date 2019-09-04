package financial_management.service.property.income;

import financial_management.bl.order.OrderService;
import financial_management.bl.property.IncomeService;
import financial_management.data.property.IncomeMapper;
import financial_management.entity.property.BondIncomePO;
import financial_management.entity.property.RecentInvPO;
import financial_management.entity.property.TotalIncomePO;
import financial_management.service.user.UserServiceForBl;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lt
 * @date 2019/09/03 19:49
 */
@Service
public class IncomeServiceImpl implements IncomeService, IncomeServiceForBl {

    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    private UserServiceForBl userServiceForBl;

    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    /**
     * 获取用户最新收益
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getNewlyIncome(Long userId) {
        try {
            RecentInvPO recentInvPO = incomeMapper.getNewlyIncome(userId);
            double current = recentInvPO.getCurrentStocks() + recentInvPO.getCurrentQdii() + recentInvPO.getCurrentGold() + recentInvPO.getCurrentBond();
            double yesterday = recentInvPO.getYesterdayStocks() + recentInvPO.getYesterdayQdii() + recentInvPO.getYesterdayGold() + recentInvPO.getYesterdayBond();
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, current - yesterday);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.STATUS_NEWLY_RECORD_NOT_EXIST);
        }
    }

    /**
     * 获取用户累计收益
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getTotalIncome(Long userId) {
        try {
            double totalIncome = incomeMapper.getTotalIncome(userId);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, totalIncome);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取平台所有用户最新的投资收益率
     *
     * @param
     * @return
     */
    @Override
    public BasicResponse getAveNewlyRate() {
        try {
            List<Long> userIdList = userServiceForBl.getUserIdList();
            double sumNewlyRate = 0;
            for (Long userId : userIdList) {
                sumNewlyRate += getNewlyInvestRate(userId);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, sumNewlyRate / userIdList.size());
        } catch (Exception e) {
            return new BasicResponse(ResponseStatus.STATUS_NEWLY_RECORD_NOT_EXIST);
        }
    }

    /**
     * 获取用户最新的投资收益率
     *
     * @param userId
     * @return
     */
    @Override
    public double getNewlyInvestRate(Long userId) {
        try {
            RecentInvPO recentInvPO = incomeMapper.getNewlyIncome(userId);
            double lastDayInvAsset = recentInvPO.getYesterdayStocks() + recentInvPO.getYesterdayQdii() + recentInvPO.getYesterdayGold() + recentInvPO.getYesterdayBond();
            double todayInject = orderService.getInvestBy(userId, "FORSTOCK", new Date()) + orderService.getInvestBy(userId, "DOMSTOCK", new Date()) + orderService.getInvestBy(userId, "GOLD", new Date()) + orderService.getInvestBy(userId, "BOND", new Date());
            double investAssetBothDays = lastDayInvAsset + todayInject;
            double newlyStocksIncome = recentInvPO.getCurrentStocks() - recentInvPO.getYesterdayStocks();
            double newlyQdiiIncome = recentInvPO.getCurrentQdii() - recentInvPO.getYesterdayQdii();
            double newlyGoldIncome = recentInvPO.getCurrentGold() - recentInvPO.getYesterdayGold();
            double newlyBondIncome = recentInvPO.getCurrentBond() - recentInvPO.getYesterdayBond();
            return (newlyStocksIncome + newlyQdiiIncome + newlyGoldIncome + newlyBondIncome) / investAssetBothDays;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户最新的股票收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getNewlyStocksIncome(Long userId) {
        try {
            RecentInvPO recentInvPO = incomeMapper.getNewlyIncome(userId);
            return recentInvPO.getCurrentStocks() - recentInvPO.getYesterdayStocks();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户最新的股指收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getNewlyQdiiIncome(Long userId) {
        try {
            RecentInvPO recentInvPO = incomeMapper.getNewlyIncome(userId);
            return recentInvPO.getCurrentQdii() - recentInvPO.getYesterdayQdii();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户最新的黄金收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getNewlyGoldIncome(Long userId) {
        try {
            RecentInvPO recentInvPO = incomeMapper.getNewlyIncome(userId);
            return recentInvPO.getCurrentGold() - recentInvPO.getYesterdayGold();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户最新的债券收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getNewlyBondIncome(Long userId) {
        try {
            RecentInvPO recentInvPO = incomeMapper.getNewlyIncome(userId);
            return recentInvPO.getCurrentBond() - recentInvPO.getYesterdayBond();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取平台所有用户累计的投资收益率
     *
     * @param
     * @return
     */
    @Override
    public BasicResponse getAveTotalRate() {
        try {
            List<Long> userIdList = userServiceForBl.getUserIdList();
            double sumTotalRate = 0;
            for (Long userId : userIdList) {
                sumTotalRate += getTotalInvestRate(userId);
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, sumTotalRate / userIdList.size());
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户累计的投资收益率
     *
     * @param userId
     * @return
     */
    @Override
    public double getTotalInvestRate(Long userId) {
        try {
            TotalIncomePO totalIncomePO = incomeMapper.getTotalInvestRate(userId);
            double sumMaxInvest = orderService.getMaxInvestBy(userId, "FORSTOCK") + orderService.getMaxInvestBy(userId, "DOMSTOCK") + orderService.getMaxInvestBy(userId, "GOLD") + orderService.getMaxInvestBy(userId, "BOND");
            double totalStocksIncome = totalIncomePO.getTotalStocks() - orderService.getInvestBy(userId, "FORSTOCK", null);
            double totalQdiiIncome = totalIncomePO.getTotalQdii() - orderService.getInvestBy(userId, "DOMSTOCK", null);
            double totalGoldIncome = totalIncomePO.getTotalGold() - orderService.getInvestBy(userId, "GOLD", null);
            double totalBondIncome = totalIncomePO.getTotalBond() - orderService.getInvestBy(userId, "BOND", null);
            return (totalStocksIncome + totalQdiiIncome + totalGoldIncome + totalBondIncome) / sumMaxInvest;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户累计的股票收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getTotalStocksIncome(Long userId) {
        try {
            TotalIncomePO totalIncomePO = incomeMapper.getTotalInvestRate(userId);
            return totalIncomePO.getTotalStocks() - orderService.getInvestBy(userId, "FORSTOCK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户累计的股指收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getTotalQdiiIncome(Long userId) {
        try {
            TotalIncomePO totalIncomePO = incomeMapper.getTotalInvestRate(userId);
            return totalIncomePO.getTotalQdii() - orderService.getInvestBy(userId, "DOMSTOCK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户累计的黄金收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getTotalGoldIncome(Long userId) {
        try {
            TotalIncomePO totalIncomePO = incomeMapper.getTotalInvestRate(userId);
            return totalIncomePO.getTotalGold() - orderService.getInvestBy(userId, "GOLD", null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取用户累计的债券收益
     *
     * @param userId
     * @return
     */
    @Override
    public double getTotalBondIncome(Long userId) {
        try {
            TotalIncomePO totalIncomePO = incomeMapper.getTotalInvestRate(userId);
            return totalIncomePO.getTotalBond() - orderService.getInvestBy(userId, "BOND", null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取债券的days日收益率
     *
     * @param bondId, days
     * @return
     */
    @Override
    public double getBondProfitOfDays(Long bondId, int days) {
        if (ifExistDaysBondLog(bondId, days)) {
            BondIncomePO bondIncomePO = incomeMapper.getBondProfitOfDays(bondId, days);
            return bondIncomePO.getTodayNetWorth() / bondIncomePO.getBeforeDaysNetWorth() - 1;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否存在days天的债券收益记录
     *
     * @param bondId, days
     * @return
     */
    public boolean ifExistDaysBondLog(Long bondId, int days) {
        return incomeMapper.ifExistDaysBondLog(bondId, days);
    }

}