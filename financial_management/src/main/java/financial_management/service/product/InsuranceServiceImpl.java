//package financial_management.service.product;
//
//import financial_management.bl.product.InsuranceService;
//import financial_management.data.product.InsuranceMapper;
//import financial_management.entity.DepositProductPO;
//import financial_management.entity.InsProductPO;
//import financial_management.entity.MyInsPO;
//import financial_management.util.DateConverterUtil;
//import financial_management.vo.BasicResponse;
//import financial_management.vo.ResponseStatus;
//import financial_management.vo.order.ProductVO4Order;
//import financial_management.vo.product.InsRecProductVO;
//import financial_management.vo.product.MyInsuranceVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * @Description TODO
// * @Author 233loser
// * @Date 2019/8/20 18:37
// * @Version 1.0
// **/
//@Service
//public class InsuranceServiceImpl implements InsuranceService {
//
//    @Autowired
//    InsuranceMapper mapper;
//
//    @Override
//    public List<MyInsuranceVO> getMyInsurance(Long userId) {
//        List<MyInsPO> myInsurances = mapper.selectSelfInsProducts(userId);
//        List<MyInsuranceVO> vos = new ArrayList<>();
//        if(myInsurances.size()>0) {
//            myInsurances.stream().forEach(o -> {
//                MyInsuranceVO vo = new MyInsuranceVO(o);
//                vos.add(vo);
//            });
//        }
//        return vos;
//    }
//
//    @Override
//    public List<InsRecProductVO> getAllInsProduct() {
//
//        List<InsProductPO> insProducts = mapper.selectAllInsProduct();
//        List<InsRecProductVO> vos = new ArrayList<>();
//
//        insProducts.stream().forEach(o->{
//            InsRecProductVO vo = new InsRecProductVO(o);
//            vos.add(vo);
//        });
//        return vos;
//    }
//
//    @Override
//    public BasicResponse purchase(Long userId, String name, String insurant) {
//        try {
//            InsProductPO po = mapper.selectProductByName(name);
//            MyInsPO myInsPO = new MyInsPO(userId, insurant, po.getId(), DateConverterUtil.moveForwardByDay(new Date(), po.getLength()), po.getPrice());
//            mapper.insertMyProduct(myInsPO);
//            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
//        }catch (NullPointerException e){
//            e.printStackTrace();
//            return new BasicResponse<>(ResponseStatus.STATUS_INSURANCEPRODUCT_UNFINED,null);
//        }
//    }
//
//    public ProductVO4Order getProduct(Long id){
//        List<InsProductPO> insurances = mapper.selectAllInsProduct();
//        for (InsProductPO i: insurances){
//            if (i.getId() == id){
//                ProductVO4Order vo = new ProductVO4Order();
//                vo.setCode(null);
//                vo.setpID(id);
//                vo.setName(i.getName());
//                return vo;
//            }
//        }
//        return getNullProduct();
//    }
//
//    public ProductVO4Order getNullProduct(){
//        ProductVO4Order vo = new ProductVO4Order();
//        vo.setName(null);
//        vo.setCode(null);
//        vo.setpID(null);
//        return vo;
//    }
//}
