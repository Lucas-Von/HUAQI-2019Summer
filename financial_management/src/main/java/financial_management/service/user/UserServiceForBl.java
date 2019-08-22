package financial_management.service.user;

/**
 * @author xyh
 * @date 2019/8/18
 */
public interface UserServiceForBl {
    /**
     * 根据useId获得用户名
     * @param userId
     * @return
     */
    String getUsername(Long userId);
}
