package financial_management.data.message;

import financial_management.entity.MessagePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    List<MessagePO> selectByUserID(@Param("userID") Long userID);

    List<MessagePO> selectByUserIDandType(@Param("userID") Long userID, @Param("type") Integer type);

    List<MessagePO> selectByUserIDandTypeAndPage(
            @Param("userID") Long userID, @Param("type") Integer type, @Param("page") Integer page);

    MessagePO selectLatestMessageByTypeAndUserID(@Param("type") Integer type, @Param("userID") Long userID);

    Integer selectAmountOfUnreadByTypeAndUserID(@Param("type") Integer type, @Param("userID") Long userID);

    Integer insertMessage(MessagePO message);

    Integer readMessageByTypeAndUserID(@Param("type") Integer type, @Param("userID") Long userID);

    List<MessagePO> deleteMessage(@Param("ID") Long ID);
}
