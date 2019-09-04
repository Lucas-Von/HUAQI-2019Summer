package financial_management.data.property;

import financial_management.entity.property.RecAllocPO;
import financial_management.parameter.property.RecAllocParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lt
 * @date 2019/08/23 00:54
 */
@Repository
@Mapper
public interface ManageMapper {

    /**
     * 验证用户的管理员身份
     *
     * @param adminId
     * @return
     */
    boolean isAdmin(@Param("adminId") Long adminId);

    /**
     * 获取所有用户推荐资产配置列表
     *
     * @param
     * @return
     */
    List<RecAllocPO> getRecAllocList();

    /**
     * 获取指定用户推荐资产配置
     *
     * @param userId
     * @return
     */
    RecAllocPO getRecAlloc(@Param("userId") Long userId);

    /**
     * 修改指定用户推荐资产配置
     *
     * @param recAllocParam
     * @return
     */
    void editRecAlloc(RecAllocParam recAllocParam);

}