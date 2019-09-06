package financial_management.service.property.manage;

import financial_management.bl.property.ManageService;
import financial_management.data.property.ManageMapper;
import financial_management.entity.property.RecAllocPO;
import financial_management.parameter.property.RecAllocParam;
import financial_management.service.property.estate.EstateServiceForBl;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.property.RecAllocVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lt
 * @date 2019/08/23 00:54
 */
@Service
public class ManageServiceImpl implements ManageService, ManageServiceForBl {

    @Autowired
    private ManageMapper manageMapper;

    @Autowired
    private EstateServiceForBl estateServiceForBl;

    /**
     * 获取所有用户推荐资产配置列表
     *
     * @param adminId
     * @date 2019/08/23 00:56
     */
    @Override
    public BasicResponse getRecAllocList(Long adminId) {
        try {
            boolean isAdmin = manageMapper.isAdmin(adminId);
            if (isAdmin) {
                List<RecAllocPO> recAllocPOList = manageMapper.getRecAllocList();
                List<RecAllocVO> recAllocVOList = new ArrayList<>();
                recAllocPOList.stream().forEach(recAllocPO -> {
                    RecAllocVO recAllocVO = new RecAllocVO(recAllocPO.getUserId(), recAllocPO.getName(), recAllocPO.getIdentityNum(), recAllocPO.getNick(), recAllocPO.getEmail(), estateServiceForBl.getTotalAsset(recAllocPO.getUserId()), recAllocPO.getFundsRate(), recAllocPO.getSavingRate(), recAllocPO.getInsuranceRate(), recAllocPO.getInvestRate());
                    recAllocVOList.add(recAllocVO);
                });
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, recAllocVOList);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_MANAGE_NOT_ADMIN);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 验证用户的管理员身份
     *
     * @param adminId
     * @return
     */
    @Override
    public boolean isAdmin(Long adminId) {
        try {
            return manageMapper.isAdmin(adminId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断是否已记录用户的推荐资产配置
     *
     * @param userId
     * @return
     */
    @Override
    public boolean ifExistRecAlloc(Long userId) {
        try {
            return manageMapper.ifExistRecAlloc(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户推荐资产配置
     *
     * @param userId
     * @return
     */
    @Override
    public BasicResponse getRecAlloc(Long userId) {
        try {
            if (ifExistRecAlloc(userId)) {
                RecAllocPO recAllocPO = getRecAllocPO(userId);
                RecAllocVO recAllocVO = new RecAllocVO(recAllocPO.getUserId(), recAllocPO.getName(), recAllocPO.getIdentityNum(), recAllocPO.getNick(), recAllocPO.getEmail(), estateServiceForBl.getTotalAsset(recAllocPO.getUserId()), recAllocPO.getFundsRate(), recAllocPO.getSavingRate(), recAllocPO.getInsuranceRate(), recAllocPO.getInvestRate());
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, recAllocVO);
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_RECOMMEND_ALLOCATION_NOT_EXIST, new RecAllocVO());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 修改指定用户推荐资产配置
     *
     * @param recAllocParam
     * @return
     */
    @Override
    public BasicResponse editRecAlloc(RecAllocParam recAllocParam) {
        try {
            manageMapper.editRecAlloc(recAllocParam);
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    /**
     * 获取用户推荐资产配置的PO
     *
     * @param userId
     * @return
     */
    @Override
    public RecAllocPO getRecAllocPO(Long userId) {
        try {
            return manageMapper.getRecAlloc(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new RecAllocPO();
        }
    }

}
