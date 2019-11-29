package financial_management.service.property.estate;

import financial_management.bl.property.EstateService;
import financial_management.data.property.EstateMapper;
import financial_management.entity.property.*;
import financial_management.service.property.income.IncomeServiceForBl;
import financial_management.service.property.manage.ManageServiceForBl;
import financial_management.service.property.questionnaire.QuestionnaireServiceForBl;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/20 20:36
 */
@Service
public class EstateServiceImpl implements EstateService, EstateServiceForBl {

    @Autowired
    private EstateMapper estateMapper;

    @Autowired
    private IncomeServiceForBl incomeServiceForBl;

    @Autowired
    private ManageServiceForBl manageServiceForBl;

    @Autowired
    private QuestionnaireServiceForBl questionnaireServiceForBl;

    /**
     * 获取用户资产概况
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getOverviewByUser(Long userId) {
        try {
            OverviewVO overviewVO = new OverviewVO(questionnaireServiceForBl.getRecordDate(userId), getFortuneUpdateTime(userId), questionnaireServiceForBl.getOriginAsset(userId), getTotalAsset(userId));
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, overviewVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户资产记录
     *
     * @param userId
     * @returnn
     */
    @Override
    public BasicResponse getPropertyByUser(Long userId) {
        try {
            if (ifExistOutRecord(userId)) {
                EstatePO estatePO = estateMapper.getPropertyByUser(userId);
                EstateVO estateVO = new EstateVO(estatePO.getFundsInPlatform(), estatePO.getFundsOutPlatform(), estatePO.getSavingOutPlatform(), estatePO.getInsuranceOutPlatform(), estatePO.getInvestInPlatform(), estatePO.getInvestOutPlatform());
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, estateVO);
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_PROPERTY_RECORD_NOT_EXIST, new EstateVO(-1, -1, -1, -1, -1, -1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取资产上次更新时间
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getFortuneUpdateTimeByUser(Long userId) {
        try {
            if (ifExistFortuneRecord(userId)) {
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, getFortuneUpdateTime(userId));
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_FORTUNE_RECORD_NOT_EXIST, new Date());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户指定资产类型信息列表
     *
     * @param userId
     * @param assetType
     * @return
     */
    @Override
    public BasicResponse getAssetInfoList(Long userId, String assetType) {
        try {
            EstatePO estatePO = estateMapper.getPropertyByUser(userId);
            double totalAsset = getTotalAsset(userId);
            SubEstateVO subEstateVO = new SubEstateVO();
            switch (assetType) {
                case "funds":
                    subEstateVO = new SubEstateVO(totalAsset, estatePO.getFundsInPlatform(), estatePO.getFundsOutPlatform());
                    break;
                case "saving":
                    subEstateVO = new SubEstateVO(totalAsset, -1, estatePO.getSavingOutPlatform());
                    break;
                case "insurance":
                    subEstateVO = new SubEstateVO(totalAsset, -1, estatePO.getInsuranceOutPlatform());
                    break;
                case "investment":
                    subEstateVO = new SubEstateVO(totalAsset, estatePO.getInvestInPlatform(), estatePO.getInvestOutPlatform());
                default:
                    break;
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subEstateVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户的各项投资持仓情况
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getSubInvPosition(Long userId) {
        try {
            SubInvestPO subInvestPO = estateMapper.getSubInvInfo(userId);
            SubInvestVO stocksPosition = new SubInvestVO("stocks", subInvestPO.getStocks(), subInvestPO.getInvest(), incomeServiceForBl.getTotalStocksIncome(userId), incomeServiceForBl.getNewlyStocksIncome(userId));
            SubInvestVO qdiiPosition = new SubInvestVO("qdii", subInvestPO.getQdii(), subInvestPO.getInvest(), incomeServiceForBl.getTotalQdiiIncome(userId), incomeServiceForBl.getNewlyQdiiIncome(userId));
            SubInvestVO goldPosition = new SubInvestVO("gold", subInvestPO.getGold(), subInvestPO.getInvest(), incomeServiceForBl.getTotalGoldIncome(userId), incomeServiceForBl.getNewlyGoldIncome(userId));
            SubInvestVO bondPosition = new SubInvestVO("bond", subInvestPO.getBond(), subInvestPO.getInvest(), incomeServiceForBl.getTotalBondIncome(userId), incomeServiceForBl.getNewlyBondIncome(userId));
            List<SubInvestVO> subInvestVOList = Arrays.asList(stocksPosition, qdiiPosition, goldPosition, bondPosition);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subInvestVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户自注册起所有月份的资产列表
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getMonthlyProList(Long userId) {
        try {
            List<FortunePO> monthlyFortunePOList = estateMapper.getMonthlyProList(userId);
            List<FortuneVO> monthlyFortuneVOList = new ArrayList<>();
            monthlyFortunePOList.stream().forEach(monthlyFortunePO -> {
                FortuneVO monthlyFortuneVO = new FortuneVO(monthlyFortunePO.getRecordDate(), monthlyFortunePO.getFunds(), monthlyFortunePO.getSaving(), monthlyFortunePO.getInsurance(), monthlyFortunePO.getStocks(), monthlyFortunePO.getQdii(), monthlyFortunePO.getGold(), monthlyFortunePO.getBond());
                monthlyFortuneVOList.add(monthlyFortuneVO);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, monthlyFortuneVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户自注册起所有月份的投资列表
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getMonthlyInvList(Long userId) {
        try {
            List<InvestPO> monthlyInvestPOList = estateMapper.getMonthlyInvList(userId);
            List<InvestVO> monthlyInvestVOList = new ArrayList<>();
            monthlyInvestPOList.stream().forEach(monthlyInvestPO -> {
                InvestVO monthlyInvestVO = new InvestVO(monthlyInvestPO.getRecordDate(), monthlyInvestPO.getStocks(), monthlyInvestPO.getQdii(), monthlyInvestPO.getGold(), monthlyInvestPO.getBond());
                monthlyInvestVOList.add(monthlyInvestVO);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, monthlyInvestVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户最近30天的资产列表
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getDailyProList(Long userId) {
        try {
            List<FortunePO> dailyFortunePOList = estateMapper.getDailyProList(userId);
            List<FortuneVO> dailyFortuneVOList = new ArrayList<>();
            dailyFortunePOList.stream().forEach(dailyFortunePO -> {
                FortuneVO dailyFortuneVO = new FortuneVO(dailyFortunePO.getRecordDate(), dailyFortunePO.getFunds(), dailyFortunePO.getSaving(), dailyFortunePO.getInsurance(), dailyFortunePO.getStocks(), dailyFortunePO.getQdii(), dailyFortunePO.getGold(), dailyFortunePO.getBond());
                dailyFortuneVOList.add(dailyFortuneVO);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, dailyFortuneVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户最近30天的投资列表
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getDailyInvList(Long userId) {
        try {
            List<InvestPO> dailyInvestPOList = estateMapper.getDailyInvList(userId);
            List<InvestVO> dailyInvestVOList = new ArrayList<>();
            dailyInvestPOList.stream().forEach(dailyInvestPO -> {
                InvestVO dailyInvestVO = new InvestVO(dailyInvestPO.getRecordDate(), dailyInvestPO.getStocks(), dailyInvestPO.getQdii(), dailyInvestPO.getGold(), dailyInvestPO.getBond());
                dailyInvestVOList.add(dailyInvestVO);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, dailyInvestVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户自注册起每天的资产列表
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getCompleteProList(Long userId) {
        try {
            List<FortunePO> completeFortunePOList = estateMapper.getCompleteProList(userId);
            List<FortuneVO> completeFortuneVOList = new ArrayList<>();
            completeFortunePOList.stream().forEach(completeFortunePO -> {
                FortuneVO dailyFortuneVO = new FortuneVO(completeFortunePO.getRecordDate(), completeFortunePO.getFunds(), completeFortunePO.getSaving(), completeFortunePO.getInsurance(), completeFortunePO.getStocks(), completeFortunePO.getQdii(), completeFortunePO.getGold(), completeFortunePO.getBond());
                completeFortuneVOList.add(dailyFortuneVO);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, completeFortuneVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 判断该用户是否已完善资产信息
     *
     * @param userId
     * @reutrn
     */
    @Override
    public BasicResponse hasImproveInfo(Long userId) {
        try {
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, ifExistOutRecord(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, false);
        }
    }

    /**
     * 获取用户自身的推荐资产配置
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getMyRecAlloc(Long userId) {
        try {
            if (manageServiceForBl.ifExistRecAlloc(userId)) {
                RecAllocPO recAllocPO = manageServiceForBl.getRecAllocPO(userId);
                MyRecAllocVO myRecAllocVO = new MyRecAllocVO(recAllocPO.getFundsRate(), recAllocPO.getSavingRate(), recAllocPO.getInsuranceRate(), recAllocPO.getInvestRate());
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, myRecAllocVO);
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_RECOMMEND_ALLOCATION_NOT_EXIST, new MyRecAllocVO(-1, -1, -1, -1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 设定用户的平台外现金数额
     *
     * @param userId
     * @param fundsOutPlatform
     * @return
     */
    @Override
    public BasicResponse setFundsOutPlatform(Long userId, double fundsOutPlatform) {
        try {
            if (ifExistOutRecord(userId)) {
                estateMapper.updateOutFundsRecord(userId, fundsOutPlatform);
            } else {
                estateMapper.insertOutFundsRecord(userId, fundsOutPlatform);
            }
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 删除用户的平台外现金数额【修改该值为0】
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse delFundsOutPlatform(Long userId) {
        try {
            if (ifExistOutRecord(userId)) {
                estateMapper.delOutFundsRecord(userId);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_FUNDS_OUT_PLATFORM_NOT_EXIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看用户的平台外现金数额
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getFundsOutPlatform(Long userId) {
        try {
            double fundsOutPlatform = 0;
            if (ifExistOutRecord(userId)) fundsOutPlatform = estateMapper.getOutFundsRecord(userId);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, fundsOutPlatform);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 设定用户的平台外投资数额
     *
     * @param userId
     * @param investOutPlatform
     * @return
     */
    @Override
    public BasicResponse setInvestOutPlatform(Long userId, double investOutPlatform) {
        try {
            if (!ifExistOutRecord(userId)) {
                estateMapper.insertOutInvestRecord(userId, investOutPlatform);
            } else {
                estateMapper.updateOutInvestRecord(userId, investOutPlatform);
            }
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 删除用户的平台外投资数额【修改该值为0】
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse delInvestOutPlatform(Long userId) {
        try {
            if (ifExistOutRecord(userId)) {
                estateMapper.delOutInvestRecord(userId);
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_INVEST_OUT_PLATFORM_NOT_EXIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 查看用户的平台外投资数额
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getInvestOutPlatform(Long userId) {
        try {
            double investOutPlatform = 0;
            if (ifExistOutRecord(userId)) investOutPlatform = estateMapper.getOutInvestRecord(userId);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, investOutPlatform);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 判断平台外现金&投资表中是否存在该用户的记录
     *
     * @param userId
     * @reutrn
     */
    public boolean ifExistOutRecord(Long userId) {
        try {
            return estateMapper.ifExistOutRecord(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断资产变更表中是否存在该用户的记录
     *
     * @param userId
     * @reutrn
     */
    public boolean ifExistFortuneRecord(Long userId) {
        try {
            return estateMapper.ifExistFortuneRecord(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取资产上次更新时间
     *
     * @param userId
     * @return
     */
    @Override
    public Date getFortuneUpdateTime(Long userId) {
        try {
            return estateMapper.getFortuneUpdateTime(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 计算用户总资产
     *
     * @param userId
     * @return
     */
    @Override
    public double getTotalAsset(Long userId) {
        try {
            EstatePO estatePO = estateMapper.getPropertyByUser(userId);
            return estatePO.getFundsInPlatform() + estatePO.getFundsOutPlatform() + estatePO.getSavingOutPlatform() + estatePO.getInsuranceOutPlatform() + estatePO.getInvestInPlatform() + estatePO.getInvestOutPlatform();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}