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
import financial_management.vo.property.IncomeRateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static financial_management.bl.order.OrderService.Type.*;

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
            // e.printStackTrace();
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
            // e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取平台所有用户最近days天的累计投资收益率列表
     *
     * @param days
     * @return
     */
    @Override
    public BasicResponse getIncomeRateList(int days) {
        try {
            List<IncomeRateVO> incomeRateList = new ArrayList<>();
            List<Date> dateList = getDateList(getDateBefore(days), new Date());
            dateList.stream().forEach(date -> {
                IncomeRateVO incomeRateVO = new IncomeRateVO(date, getSomeDayAveTotalRate(date));
                incomeRateList.add(incomeRateVO);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, incomeRateList);
        } catch (Exception e) {
            // e.printStackTrace();
            List<Double> errRateList = new ArrayList<>();
            for (int i = 0; i < days; i++) errRateList.add(0.0);
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, errRateList);
        }
    }

    /**
     * 获取特定日期平台所有用户累计的投资收益率
     *
     * @param date
     * @return
     */
    public double getSomeDayAveTotalRate(Date date) {
        try {
            List<Long> userIdList = userServiceForBl.getUserIdList();
            double sumTotalRate = 0;
            for (Long userId : userIdList) {
                sumTotalRate += getSomeDayTotalInvestRate(userId, date);
            }
            return sumTotalRate / userIdList.size();
        } catch (Exception e) {
            // e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取特定日期用户累计的投资收益率
     *
     * @param userId
     * @param date
     * @return
     */
    public double getSomeDayTotalInvestRate(Long userId, Date date) {
        try {
            TotalIncomePO totalIncomePO = new TotalIncomePO();
            if (isToday(date, new Date())) {
                totalIncomePO = incomeMapper.getTotalInvestRate(userId);
            } else {
                totalIncomePO = incomeMapper.getSomeDayTotalInvestRate(userId, date);
            }
            double sumMaxInvest = orderService.getMaxInvestBy(userId, FORSTOCK, date) + orderService.getMaxInvestBy(userId, DOMSTOCK, date) + orderService.getMaxInvestBy(userId, GOLD, date) + orderService.getMaxInvestBy(userId, BOND, date);
            double totalStocksIncome = totalIncomePO.getTotalStocks() - orderService.getInvestBy(userId, "FORSTOCK", date);
            double totalQdiiIncome = totalIncomePO.getTotalQdii() - orderService.getInvestBy(userId, "DOMSTOCK", date);
            double totalGoldIncome = totalIncomePO.getTotalGold() - orderService.getInvestBy(userId, "GOLD", date);
            double totalBondIncome = totalIncomePO.getTotalBond() - orderService.getInvestBy(userId, "BOND", date);
            return (totalStocksIncome + totalQdiiIncome + totalGoldIncome + totalBondIncome) / sumMaxInvest;
        } catch (Exception e) {
            // e.printStackTrace();
            return 0;
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
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
            // e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取债券的days日收益率
     *
     * @param bondId
     * @param days
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
     * @param bondId
     * @param days
     * @return
     */
    public boolean ifExistDaysBondLog(Long bondId, int days) {
        return incomeMapper.ifExistDaysBondLog(bondId, days);
    }

    /**
     * 获取days天前的日期
     *
     * @param days
     * @return
     */
    public static Date getDateBefore(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1 * days);
        return cal.getTime();
    }

    /**
     * 获取某段时间内的所有日期
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<Date> getDateList(Date beginDate, Date endDate) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(beginDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        while (true) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            if (endDate.after(cal.getTime())) {
                dateList.add(cal.getTime());
            } else {
                break;
            }
        }
        return dateList;
    }

    /**
     * 判断两日期是否为同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    private boolean isToday(Date date1, Date date2) throws ParseException {
        if (date2 == null) date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = format.format(date2);
        Date today = format.parse(todayStr);
        if ((today.getTime() - date1.getTime()) <= 0) {
            return true;
        } else {
            return false;
        }
    }

}