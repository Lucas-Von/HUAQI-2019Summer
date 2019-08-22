package financial_management.service.property.estate;

import financial_management.bl.property.EstateService;
import financial_management.data.property.EstateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param userId
     * @return
     */
    public ResponseVO getPropertyByUser(Long userId) {
        try {
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("失败");
        }
    }

}
