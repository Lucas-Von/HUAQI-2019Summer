package financial_management.data.product;

import financial_management.entity.InsProductPO;
import financial_management.entity.InsurancePO;
import financial_management.entity.MyInsPO;
import financial_management.entity.insurance.InsuranceRecommandPO;
import financial_management.entity.insurance.RecommandInsuranceResponse;
import financial_management.entity.insurance.SelfInsuranceProductPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 19:38
 * @Version 1.0
 **/

@Repository
@Mapper
public interface InsuranceMapper {
    //登记保险产品
    int insertInsuranceProduct(SelfInsuranceProductPO po);
    //删除过期商品
    int deleteInsuranceProduct(@Param("userId") Long userId,@Param("name")String productName,@Param("date") Date time);
    //返回已登记商品
    List<SelfInsuranceProductPO> selectInsuranceProductById(Long userId);
    //插入配置建议
    int insertInsuranceRecommand(InsuranceRecommandPO response);
    //删除配置建议
    int deleteInsuranceRecommnad(Long userId);
    //查看配置建议
    List<InsuranceRecommandPO> selectInsuranceRecommand(Long userId);

    Float sumAmount(Long userId);

    int deleteInsuranceProductById(@Param("userId") Long userId,@Param("productId")Long id);

    int updateInsuranceProduct(SelfInsuranceProductPO po);

}
