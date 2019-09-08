package financial_management.service.product.insurance;

import financial_management.bl.product.InsuranceService;
import financial_management.data.product.InsuranceMapper;
import financial_management.entity.insurance.*;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.ProductVO4Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsuranceFinServiceImpl  implements InsuranceService {

    @Autowired
    InsuranceMapper mapper;

    //首次推荐
    public void Recommand(Long userId, Integer aWifeBirthday, Integer bHusbandBirthdat, Float cChildNumber, Float dElderNumber, Float eHusIncome, Float fWiftIncome, Float gCarprice, Float hConsumption){
        //首先要删除上次推荐结果
        mapper.deleteInsuranceRecommnad(userId);
        //获取本次推荐的结果
        PyParam pyParam = new RecommandInsuranceParam(aWifeBirthday,bHusbandBirthdat,cChildNumber,dElderNumber,eHusIncome,fWiftIncome,gCarprice,hConsumption);
        List<Object> invokeResult = PyInvoke.invoke(PyFunc.INSURANCE_RECOMMEND, pyParam, RecommandWrapperResponse.class);
        List<RecommandWrapperResponse> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((RecommandWrapperResponse) object);
        }
        List<RecommandInsuranceResponse> response = list.get(0).getResponseList();
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
    public BasicResponse getRecommands(Long userId){
        List<InsuranceRecommandPO> husband = new ArrayList<>();
        List<InsuranceRecommandPO> wife  = new ArrayList<>();
        List<InsuranceRecommandPO> childOne = new ArrayList<>();
        List<InsuranceRecommandPO> childTwo = new ArrayList<>();
        List<InsuranceRecommandPO> childThree = new ArrayList<>();
        List<InsuranceRecommandPO> childFour = new ArrayList<>();
        List<InsuranceRecommandPO> elderOne = new ArrayList<>();
        List<InsuranceRecommandPO> elderTwo = new ArrayList<>();
        List<InsuranceRecommandPO> elderThree = new ArrayList<>();
        List<InsuranceRecommandPO> elderFour = new ArrayList<>();
        List<InsuranceRecommandPO> wholeFamily = new ArrayList<>();
        List<InsuranceRecommandPO>whole =  mapper.selectInsuranceRecommand(userId);

        for(int i = 0; i<whole.size();i++){
            InsuranceRecommandPO po = whole.get(i);
            switch (po.getRole()){
                case "husband": husband.add(po);break;
                case "wife" : wife.add(po);break;
                case "child_1":childOne.add(po);break;
                case "child_2":childTwo.add(po);break;
                case "child_3":childThree.add(po);break;
                case "child_4":childFour.add(po);break;
                case "old_1":elderOne.add(po);break;
                case "old_2":elderTwo.add(po);break;
                case "old_3":elderThree.add(po);break;
                case "old_4":elderFour.add(po);break;
                case "whole family": wholeFamily.add(po);break;
            }
        }

        InsRecommandVO vo = new InsRecommandVO(husband,wife,childOne,childTwo,childThree,childFour,elderOne, elderTwo,elderThree,elderFour,wholeFamily);

        return new BasicResponse(ResponseStatus.STATUS_SUCCESS,vo);
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
