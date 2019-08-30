package financial_management.data.product;

import financial_management.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

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
     * 判断一个用户是否配置过黄金
     * @param userId
     * @return
     */
    boolean ifExistSelfGold(@Param("userId") Long userId);

    /**
     * 插入用户当前黄金配置信息
     * @param myGoldPO
     */
    void insertSelfGold(MyGoldPO myGoldPO);

    /**
     * 修改用户当前黄金配置信息
     * @param myGoldPO
     */
    void updateSelfGold(MyGoldPO myGoldPO);

    /**
     * 获得一个用户当前黄金配置信息
     * @param userId
     * @return
     */
    List<MyGoldPO> selectSelfGold(@Param("userId") Long userId);

    /**
     * 更新一个用户的黄金收益
     * @param userId
     * @param profit
     */
    void updateGoldProfit(@Param("userId") Long userId, @Param("profit") Double profit);

    int insertMyGold(MyGoldPO po);

    GoldPO selectGoldByCode(String code);

    GoldPO selectById(Long Id);

    List<GoldPO> selectAllGold();
}
