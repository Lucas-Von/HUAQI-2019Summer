package financial_management.service.product;

import financial_management.bl.product.InsuranceService;
import financial_management.data.product.InsuranceMapper;
import financial_management.entity.InsProductPO;
import financial_management.entity.MyInsPO;
import financial_management.util.DateConverterUtil;
import financial_management.vo.product.InsRecProductVO;
import financial_management.vo.product.MyInsuranceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 18:37
 * @Version 1.0
 **/
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    InsuranceMapper mapper;

    @Override
    public List<MyInsuranceVO> getMyInsurance(Long userId) {
        List<MyInsPO> myInsurances = mapper.selectSelfInsProducts(userId);
        List<MyInsuranceVO> vos = new ArrayList<>();
        if(myInsurances.size()>0) {
            myInsurances.stream().forEach(o -> {
                MyInsuranceVO vo = new MyInsuranceVO(o);
                vos.add(vo);
            });
        }
        return vos;
    }

    @Override
    public List<InsRecProductVO> getAllInsProduct() {

        List<InsProductPO> insProducts = mapper.selectAllInsProduct();
        List<InsRecProductVO> vos = new ArrayList<>();

        insProducts.stream().forEach(o->{
            InsRecProductVO vo = new InsRecProductVO(o);
            vos.add(vo);
        });
        return vos;
    }

    @Override
    public void purchase(Long userId, String name, String insurant) {
        InsProductPO po =mapper.selectProductByName(name);
        MyInsPO myInsPO = new MyInsPO(userId,insurant,po.getId(), DateConverterUtil.moveForwardByDay(new Date(),po.getLength()),po.getPrice());
        mapper.insertMyProduct(myInsPO);
    }
}
