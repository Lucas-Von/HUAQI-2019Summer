package financial_management.service.property.manage;

import financial_management.entity.property.RecAllocPO;
import financial_management.vo.BasicResponse;

/**
 * @author lt
 * @date 2019/08/23 01:03
 */
public interface ManageServiceForBl {

    /**
     * 验证用户的管理员身份
     *
     * @param adminId
     * @return
     */
    boolean isAdmin(Long adminId);

    /**
     * 判断是否已记录用户的推荐资产配置
     *
     * @param userId
     * @return
     */
    boolean ifExistRecAlloc(Long userId);

    /**
     * 获取用户推荐资产配置
     *
     * @param userId
     * @return
     */
    RecAllocPO getRecAllocPO(Long userId);

}
