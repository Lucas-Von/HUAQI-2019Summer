package financial_management.data.feedback;

import financial_management.entity.FeedBackPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedbackMapper {
    List<FeedBackPO> selectAll();

    FeedBackPO selectByID(@Param("ID") Long ID);

    Integer selectAmountOfUnsolve();

    Integer insert(FeedBackPO feedBackPO);

    Integer update(FeedBackPO feedBackPO);
}
