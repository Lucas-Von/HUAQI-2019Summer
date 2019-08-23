package financial_management.service.property.estate;

import financial_management.bl.property.EstateService;
import financial_management.data.property.EstateMapper;
import financial_management.entity.property.DepositPO;
import financial_management.entity.property.EstatePO;
import financial_management.entity.property.FortunePO;
import financial_management.entity.property.InvestPO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/20 20:36
 */
@Service
public class EstateServiceImpl implements EstateService, EstateServiceForBl {

    @Autowired
    private EstateMapper estateMapper;

    /**
     * 获取用户资产概况
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getPropertyByUser(Long userId) {
        try {
            EstatePO estatePO = estateMapper.getPropertyByUser(userId);
            InvestOfEstateVO investOfEstateVO = new InvestOfEstateVO(estatePO.getStocksInPlatform(), estatePO.getStocksOutPlatform(), estatePO.getGoldInPlatform(), estatePO.getGoldOutPlatform(), estatePO.getBondInPlatform(), estatePO.getBondOutPlatform());
            EstateVO estateVO = new EstateVO(estatePO.getFundsInPlatform(), estatePO.getFundsOutPlatform(), estatePO.getSavingInPlatform(), estatePO.getSavingOutPlatform(), estatePO.getInsuranceInPlatform(), estatePO.getInsuranceOutPlatform(), investOfEstateVO);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, estateVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
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
            double totalIncome = estateMapper.getTotalIncome(userId);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, totalIncome);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户昨日收益
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getNewlyIncome(Long userId) {
        try {
            double newlyIncome = estateMapper.getTotalIncome(userId);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, newlyIncome);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户储蓄产品列表
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getDepositList(Long userId) {
        try {
            List<DepositPO> depositPOList = estateMapper.getDepositList(userId);
            List<DepositVO> depositVOList = new ArrayList<>();
            double accTotal = 0;
            for (DepositPO depositPO : depositPOList) {
                accTotal += depositPO.getMoney();
            }
            final double total = accTotal;
            depositPOList.stream().forEach(deposit -> {
                DepositVO depositVO = new DepositVO(deposit.getName(), deposit.getMoney(), total, deposit.getAnnualizedRate(), deposit.getExpirationDate());
                depositVOList.add(depositVO);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, depositVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户指定资产类型信息列表
     *
     * @param userId, assetType
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
                    subEstateVO = new SubEstateVO(totalAsset, estatePO.getSavingInPlatform(), estatePO.getSavingOutPlatform());
                    break;
                case "insurance":
                    subEstateVO = new SubEstateVO(totalAsset, estatePO.getInsuranceInPlatform(), estatePO.getInsuranceOutPlatform());
                    break;
                case "investment":
                    double investInPlatform = estatePO.getStocksInPlatform() + estatePO.getGoldInPlatform() + estatePO.getBondInPlatform();
                    double investOutPlatform = estatePO.getStocksOutPlatform() + estatePO.getGoldOutPlatform() + estatePO.getBondOutPlatform();
                    subEstateVO = new SubEstateVO(totalAsset, investInPlatform, investOutPlatform);
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
     * 获取用户自注册起所有月份的资产列表
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getMonthlyProList(Long userId) {
        try {
            FortunePO fortunePO = estateMapper.getMonthlyProList(userId);
            FortuneVO fortuneVO = new FortuneVO(fortunePO.getDate(), fortunePO.getFunds(), fortunePO.getSaving(), fortunePO.getInsurance(), fortunePO.getStocks(), fortunePO.getGold(), fortunePO.getBond());
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, fortuneVO);
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
            InvestPO investPO = estateMapper.getMonthlyInvList(userId);
            InvestVO investVO = new InvestVO(investPO.getDate(), investPO.getStocks(), investPO.getGold(), investPO.getBond());
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, investVO);
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
            FortunePO fortunePO = estateMapper.getDailyProList(userId);
            FortuneVO fortuneVO = new FortuneVO(fortunePO.getDate(), fortunePO.getFunds(), fortunePO.getSaving(), fortunePO.getInsurance(), fortunePO.getStocks(), fortunePO.getGold(), fortunePO.getBond());
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, fortuneVO);
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
            InvestPO investPO = estateMapper.getDailyInvList(userId);
            InvestVO investVO = new InvestVO(investPO.getDate(), investPO.getStocks(), investPO.getGold(), investPO.getBond());
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, investVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
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
            return estatePO.getFundsInPlatform() + estatePO.getFundsOutPlatform() + estatePO.getSavingInPlatform() + estatePO.getSavingOutPlatform()
                    + estatePO.getInsuranceInPlatform() + estatePO.getInsuranceOutPlatform() + estatePO.getStocksInPlatform() + estatePO.getStocksOutPlatform()
                    + estatePO.getGoldInPlatform() + estatePO.getGoldOutPlatform() + estatePO.getBondInPlatform() + estatePO.getBondOutPlatform();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
