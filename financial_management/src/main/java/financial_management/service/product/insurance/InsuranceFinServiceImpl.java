package financial_management.service.product.insurance;

import financial_management.bl.product.ProductService4Order;
import financial_management.data.product.InsuranceMapper;
import financial_management.entity.insurance.InsuranceRecommandPO;
import financial_management.entity.insurance.RecommandInsuranceParam;
import financial_management.entity.insurance.RecommandInsuranceResponse;
import financial_management.entity.insurance.SelfInsuranceProductPO;
import financial_management.vo.order.ProductVO4Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsuranceFinServiceImpl {

    @Autowired
    InsuranceMapper mapper;

    //首次推荐
    public void Recommand(Long userId,Float aWifeBirthday, Float bHusbandBirthdat, Float cChildNumber, Float dElderNumber, Float eHusIncome, Float fWiftIncome, Float gCarprice, Float hConsumption){
        //首先要删除上次推荐结果
        mapper.deleteInsuranceRecommnad(userId);
        //获取本次推荐的结果
        RecommandInsuranceParam vo = new RecommandInsuranceParam(aWifeBirthday,bHusbandBirthdat,cChildNumber,dElderNumber,eHusIncome,fWiftIncome,gCarprice,hConsumption);
        //TODO 接商院系
        List<RecommandInsuranceResponse> response = new ArrayList<>();
        for(int i = 0;i< response.size();i++){
            InsuranceRecommandPO po = new InsuranceRecommandPO();
            po.setUserId(userId);
            po.setInsurance_amount(response.get(i).getInsurance_amount());
            po.setInsurance_premiun(response.get(i).getInsurance_premiun());
            po.setKind(response.get(i).getKind());
            po.setRole(response.get(i).getRole());
            mapper.insertInsuranceRecommand(po);
        }
    }
    //查看推荐保险建议
    public List<InsuranceRecommandPO> getRecommands(Long userId){
        return mapper.selectInsuranceRecommand(userId);
    }
    //登记已买保险
    public void registerProduct(SelfInsuranceProductPO po){
        mapper.insertInsuranceProduct(po);
    }

    //查看已登记的保险，待检验
    public List<SelfInsuranceProductPO> getRegisted(Long userId){
        List<SelfInsuranceProductPO> selfProducts= mapper.selectInsuranceProductById(userId);
        //lambda表达式过滤
        List<SelfInsuranceProductPO> result = selfProducts.stream().filter(product->
            product.getMaturity().after(new Date())).collect(Collectors.toList());

        List<SelfInsuranceProductPO> toDel = selfProducts.stream().filter(product->
                product.getMaturity().before(new Date())).collect(Collectors.toList());

        for(int i =0;i<toDel.size();i++){
            mapper.deleteInsuranceProduct(toDel.get(i).getUserId(),toDel.get(i).getName(),toDel.get(i).getMaturity());
        }

        return result;
    }

    //我们不卖保险。

    public ProductVO4Order getProducts(Long id, String type) {
        ProductVO4Order order = new ProductVO4Order();
        order.setName(null);
        order.setCode(null);
        order.setpID(null);
        return order;
    }

    public Float getAmount(Long userId){
        Optional<Float> sum = Optional.ofNullable(mapper.sumAmount(userId));
        Float result = sum.orElse(0F);
        return result;
    }
}
