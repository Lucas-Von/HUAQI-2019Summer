package financial_management.service.property.estate;

import financial_management.bl.property.EstateService;
import financial_management.data.property.EstateMapper;
import financial_management.entity.DepositPO;
import financial_management.entity.EstatePO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.DepositVO;
import financial_management.vo.property.EstateVO;
import financial_management.vo.property.InvestOfEstateVO;
import financial_management.vo.property.SubEstateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/20 20:36
 */
@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    private EstateMapper estateMapper;

    /**
     * 获取用户资产概况
     *
     * @param userId
     * @return
     */
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
    public BasicResponse getAssetInfoList(Long userId, String assetType) {
        try {
            EstatePO estatePO = estateMapper.getPropertyByUser(userId);
            double total = estatePO.getFundsInPlatform() + estatePO.getFundsOutPlatform() + estatePO.getSavingInPlatform() + estatePO.getSavingOutPlatform()
                    + estatePO.getInsuranceInPlatform() + estatePO.getInsuranceOutPlatform() + estatePO.getStocksInPlatform() + estatePO.getStocksOutPlatform()
                    + estatePO.getGoldInPlatform() + estatePO.getGoldOutPlatform() + estatePO.getBondInPlatform() + estatePO.getBondOutPlatform();
            SubEstateVO subEstateVO = new SubEstateVO();
            switch (assetType) {
                case "funds":
                    subEstateVO = new SubEstateVO(total, estatePO.getFundsInPlatform(), estatePO.getFundsOutPlatform());
                    break;
                case "saving":
                    subEstateVO = new SubEstateVO(total, estatePO.getSavingInPlatform(), estatePO.getSavingOutPlatform());
                    break;
                case "insurance":
                    subEstateVO = new SubEstateVO(total, estatePO.getInsuranceInPlatform(), estatePO.getInsuranceOutPlatform());
                    break;
                case "investment":
                    double investInPlatform = estatePO.getStocksInPlatform() + estatePO.getGoldInPlatform() + estatePO.getBondInPlatform();
                    double investOutPlatform = estatePO.getStocksOutPlatform() + estatePO.getGoldOutPlatform() + estatePO.getBondOutPlatform();
                    subEstateVO = new SubEstateVO(total, investInPlatform, investOutPlatform);
                default:
                    break;
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, subEstateVO);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

}
