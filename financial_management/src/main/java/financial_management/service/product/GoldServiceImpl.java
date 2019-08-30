package financial_management.service.product;

import financial_management.bl.product.GoldService;
import financial_management.data.product.GoldMapper;
import financial_management.vo.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyh
 * @date 2019/8/30
 */
@Service
public class GoldServiceImpl implements GoldService {
    @Autowired
    private GoldMapper goldMapper;

    @Override
    public BasicResponse buyGold(Double money, Long userId){
        return null;
    }

    @Override
    public BasicResponse sellGold(Double money, Long userId){
        return null;
    }

    @Override
    public BasicResponse getHistoryConfig(Long userId){
        return null;
    }

    @Override
    public BasicResponse getNowConfig(Long userId){
        return null;
    }
}
