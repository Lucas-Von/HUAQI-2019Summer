package financial_management.bl.property;

import financial_management.parameter.property.RecAllocParam;
import financial_management.vo.BasicResponse;
import org.apache.ibatis.annotations.Param;

/**
 * @author lt
 * @date 2019/08/23 00:21
 */
public interface ManageService {

    /**
     * 查看所有用户推荐资产配置
     *
     * @param adminId
     * @return
     */
    BasicResponse getRecAllocList(@Param("adminId") Long adminId);

    /**
     * 获取指定用户推荐资产配置
     *
     * @param userId
     * @return
     */
    BasicResponse getRecAlloc(Long userId);

    /**
     * 修改指定用户推荐资产配置
     *
     * @param recAllocParam
     * @return
     */
    BasicResponse editRecAlloc(RecAllocParam recAllocParam);

}
