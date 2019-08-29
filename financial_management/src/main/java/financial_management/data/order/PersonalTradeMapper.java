package financial_management.data.order;

import financial_management.entity.PersonalTradePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PersonalTradeMapper {
    List<PersonalTradePO> selectByUserID(@Param("userID") Long userID);

    PersonalTradePO selectByID(@Param("ID") Long ID);

    Long insert(PersonalTradePO personalTradePO);

    Integer update(PersonalTradePO personalTradePO);
}
