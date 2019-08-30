package financial_management.data.order;

import financial_management.entity.PlatformTradePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PlatformTradeMapper {
    List<PlatformTradePO> selectAll();

    Integer insert(PlatformTradePO platformTradePO);
}
