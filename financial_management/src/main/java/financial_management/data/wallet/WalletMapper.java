package financial_management.data.wallet;

import financial_management.entity.CardPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 14:30
 * @Version 1.0
 **/
@Mapper
@Repository
public interface WalletMapper {

    Integer insertCard(CardPO po);

    Integer exist(Long userId);

    String selectCardId(Long userId);
}
