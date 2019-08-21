package financial_management.bl.property;

import financial_management.vo.ResponseVO;

/**
 * @author lt
 * @date 2019/08/20 16:47
 */
public interface PropertyService {

    /**
     * 获取用户资产概况
     * @param userId
     * @return
     */
    ResponseVO getPropertyByUser(Long userId);
}
