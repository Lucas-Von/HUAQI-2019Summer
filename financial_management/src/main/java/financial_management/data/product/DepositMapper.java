package financial_management.data.product;

import com.sun.org.apache.xpath.internal.operations.Bool;
import financial_management.entity.DepositProductPO;
import financial_management.entity.MyDepoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 19:38
 * @Version 1.0
 **/
@Repository
@Mapper
public interface DepositMapper {
    /**
     * 用户添加一储蓄产品
     * @param myDepoPO
     */
    void insertMyProduct(MyDepoPO myDepoPO);

    /**
     * 用户更新一储蓄产品
     * @param myDepoPO
     */
    void updateMyProduct(MyDepoPO myDepoPO);

    /**
     * 用户删除一储蓄产品
     * @param id
     */
    void deleteMyProduct(@Param("id") Long id);

    /**
     * 更新用户某一储蓄产品的占比
     * @param id
     * @param proportion
     */
    void updateProportion(@Param("id") Long id, @Param("proportion") Double proportion);

    /**
     * 查看用户拥有的储蓄产品
     * @param userId
     * @return
     */
    List<MyDepoPO> selectMyProduct(@Param("userId") Long userId);

    /**
     * 获得一个用户储蓄产品的总金额
     * @param userId
     * @return
     */
    Double selectMyProductAmount(@Param("userId") Long userId);

    /**
     * 根据ID获得一储蓄产品
     * @param id
     * @return
     */
    MyDepoPO selectSimpleMyProduct(@Param("id") Long id);

    /**
     * 判断一储蓄产品是否存在
     * @param id
     * @return
     */
    Boolean ifExistMyProduct(@Param("id") Long id);

//    List<DepositProductPO> selectAllProducts();
//
//    List<MyDepoPO> selectSelfProducts(Long userId);
//
//    DepositProductPO selectProductByName(String name);
}
