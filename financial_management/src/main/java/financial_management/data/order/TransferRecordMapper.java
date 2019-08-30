package financial_management.data.order;

import financial_management.entity.TransferRecordPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransferRecordMapper {
    List<TransferRecordPO> selectByUserID(@Param("userID") Long userID);

    TransferRecordPO selectByID(@Param("ID") Long ID);

    Integer insert(TransferRecordPO transferRecordPO);

    Integer update(TransferRecordPO transferRecordPO);
}
