package financial_management.data.product;

import financial_management.entity.bond.BondPO;
import financial_management.entity.MyBondPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/21 16:47
 * @Version 1.0
 **/
@Repository
@Mapper
public interface BondMapper {

    List<BondPO> selectAllBond();

    List<MyBondPO> selectSelfBond(Long userId);

    int insertMyBond(MyBondPO po);

    BondPO selectBondByCode(String code);

    BondPO selectBondById(Long id);
}
