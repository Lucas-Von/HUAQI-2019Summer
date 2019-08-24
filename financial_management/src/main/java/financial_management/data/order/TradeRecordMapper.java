package financial_management.data.order;

import financial_management.entity.TradeRecordPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TradeRecordMapper {
    List<TradeRecordPO> selectByUserID(@Param("userID") Long userID);

    TradeRecordPO selectByID(@Param("ID") Long ID);

    Long insert(TradeRecordPO tradeRecordPO);

    Integer update(TradeRecordPO tradeRecordPO);
}
