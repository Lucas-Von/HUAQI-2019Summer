package financial_management.data.order;

import financial_management.entity.MaxInvestPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MaxInvestMapper {
    MaxInvestPO selectByUserID(@Param("userID") Long userID);

    MaxInvestPO selectByUserIDAndType(@Param("userID") Long userID,@Param("type") String type);

    void insert(MaxInvestPO maxInvestPO);

    Integer update(MaxInvestPO maxInvestPO);
}
