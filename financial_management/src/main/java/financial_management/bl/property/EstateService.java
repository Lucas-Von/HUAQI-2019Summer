package financial_management.bl.property;

import org.apache.ibatis.annotations.Param;

/**
 * @author lt
 * @date 2019/08/20 16:47
 */
public interface EstateService {

    /**
     * 获取用户资产概况
     * @param userId
     * @return
     */
    ResponseVO getPropertyByUser(@Param("userId") Long userId);

}
