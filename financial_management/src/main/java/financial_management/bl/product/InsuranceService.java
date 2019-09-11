package financial_management.bl.product;

import financial_management.entity.insurance.SelfInsuranceProductPO;
import financial_management.vo.BasicResponse;
import financial_management.vo.product.InsRecProductVO;
import financial_management.vo.product.MyInsuranceVO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 16:58
 * @Version 1.0
 **/
public interface InsuranceService {

    public void Recommand(Long userId, Integer aWifeBirthday, Integer bHusbandBirthdat, Float cChildNumber, Float dElderNumber, Float eHusIncome, Float fWiftIncome, Float gCarprice, Float hConsumption);

    public BasicResponse getRecommands(Long userId);

    //查看个人数据
    public BasicResponse getSelfProducts(Long userId);

    //
    public BasicResponse deleteProduct(Long userId,Long productId);

    //
    public BasicResponse registerProduct(MyInsuranceVO vo ,Long userId);

    public BasicResponse update(MyInsuranceVO vo,Long userId);
}
