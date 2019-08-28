package financial_management.data.product;

import financial_management.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/21 14:30
 * @Version 1.0
 **/
@Mapper
@Repository
public interface GoldMapper {

    List<GoldPO> selectAllGold();

    List<MyGoldPO> selectSelfGold(Long userId);

    int insertMyGold(MyGoldPO po);

    GoldPO selectGoldByCode(String code);

    GoldPO selectById(Long Id);
}
