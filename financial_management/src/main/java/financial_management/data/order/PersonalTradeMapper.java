package financial_management.data.order;

import financial_management.entity.PersonalTradePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface PersonalTradeMapper {
    List<PersonalTradePO> selectByUserID(@Param("userID") Long userID);

    List<PersonalTradePO> selectByUserIDAndType
            (@Param("userID") Long userID, @Param("type") String type, @Param("date") Date noLaterThanDate);

    List<PersonalTradePO> selectByDate(@Param("date") Date date, @Param("type") String type);

    PersonalTradePO selectByID(@Param("ID") Long ID);

    Float selectSum(@Param("userID") Long userID, @Param("type") String type, @Param("date") Date date);

    Integer insert(PersonalTradePO personalTradePO);

    Integer update(PersonalTradePO personalTradePO);
}
