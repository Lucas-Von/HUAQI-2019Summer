package financial_management.data.product;

import financial_management.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    /**
     * 插入一条黄金历史配置信息
     * @param goldHistoryConfigPO
     */
    void insertGoldHistoryConfig(GoldHistoryConfigPO goldHistoryConfigPO);

    /**
     * 获得一个用户所有的黄金历史配置信息
     * @param userId
     * @return
     */
    List<GoldHistoryConfigPO> selectGoldHistoryConfig(@Param("userId") Long userId);

    /**
     * 插入用户当前黄金配置信息
     * @param myDepoPO
     */
    void insertSelfGold(MyDepoPO myDepoPO);

    /**
     * 修改用户当前黄金配置信息
     * @param myDepoPO
     */
    void updateSelfGold(MyDepoPO myDepoPO);

    /**
     * 获得一个用户当前黄金配置信息
     * @param userId
     * @return
     */
    List<MyGoldPO> selectSelfGold(@Param("userId") Long userId);

    int insertMyGold(MyGoldPO po);

    GoldPO selectGoldByCode(String code);

    GoldPO selectById(Long Id);

    List<GoldPO> selectAllGold();
}
