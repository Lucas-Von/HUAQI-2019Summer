package financial_management.service.user;

import java.util.List;

/**
 * @author xyh
 * @date 2019/8/18
 */
public interface UserServiceForBl {

    /**
     * 根据useId获得用户名
     *
     * @param userId
     * @return
     */
    String getUsername(Long userId);

    /**
     * 获取除管理员外的用户id列表
     *
     * @param
     * @return
     */
    List<Long> getUserIdList();

}
