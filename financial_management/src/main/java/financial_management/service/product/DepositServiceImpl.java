package financial_management.service.product;

import financial_management.bl.product.DepositService;
import financial_management.data.product.DepositMapper;
import financial_management.entity.DepositProductPO;
import financial_management.entity.MyDepoPO;
import financial_management.entity.property.DepositPO;
import financial_management.parameter.product.SelfDepositParam;
import financial_management.util.DateConverterUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.product.DepRecProductVO;
import financial_management.vo.product.FundBasicVO;
import financial_management.vo.product.FundVO;
import financial_management.vo.product.MyDepositVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 18:36
 * @Version 1.0
 **/
@Service
public class DepositServiceImpl implements DepositService {
    @Autowired
    private DepositMapper depositMapper;

    @Override
    public BasicResponse getSelfDeposits(Long userId) {
        try {
            List<MyDepoPO> pos = depositMapper.selectMyProduct(userId);
            List<MyDepositVO> myDeposits = new ArrayList<>();
            pos.forEach(o -> {
                MyDepositVO vo = o.getMyDepositVO();
                myDeposits.add(vo);
            });
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, myDeposits);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse addSelfDeposit(SelfDepositParam selfDepositParam, Long userId){
        try {
            MyDepoPO myDepoPO = selfDepositParam.getMyDepoPO();
            myDepoPO.setUserId(userId);
            depositMapper.insertMyProduct(myDepoPO);
            updateProportion(userId);
            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse updateSelfDeposit(SelfDepositParam selfDepositParam){
        try {
            if(depositMapper.ifExistMyProduct(selfDepositParam.getId())) {
                MyDepoPO myDepoPO = selfDepositParam.getMyDepoPO();
                myDepoPO.setId(selfDepositParam.getId());
                depositMapper.updateMyProduct(myDepoPO);
                myDepoPO = depositMapper.selectSimpleMyProduct(selfDepositParam.getId());
                updateProportion(myDepoPO.getUserId());
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            }else {
                return new BasicResponse(ResponseStatus.STATUS_DEPOSITPRODUCT_UNFINED);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse deleteSelfDeposit(Long id){
        try {
            if(depositMapper.ifExistMyProduct(id)) {
                MyDepoPO myDepoPO = depositMapper.selectSimpleMyProduct(id);
                depositMapper.deleteMyProduct(id);
                updateProportion(myDepoPO.getUserId());
                return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
            }else {
                return new BasicResponse(ResponseStatus.STATUS_DEPOSITPRODUCT_UNFINED);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public List<DepRecProductVO> getAllDeposits() {

//        List<DepositProductPO> depositProducts = depositMapper.selectAllProducts();
//        List<DepRecProductVO> depositProductVOs = new ArrayList<>();
//
//        depositProducts.stream().forEach(o->{
//            DepRecProductVO vo = new DepRecProductVO(o.getName(),o.getLength(),o.getRate().doubleValue());
//            depositProductVOs.add(vo);
//        });
//        return depositProductVOs;
        return null;
    }

    @Override
    public boolean purchase(Long userId, String productName, Double amount) {

//        DepositProductPO product = depositMapper.selectProductByName(productName);

        MyDepoPO po = new MyDepoPO();
        try {
            po.setUserId(userId);
            po.setAmount(amount);
//            po.setMaturity(DateConverterUtil.moveForwardByDay(new Date(), product.getLength()));
            depositMapper.insertMyProduct(po);
            return true;
        }
        catch (NullPointerException e){
            return false;
        }
    }

    public ProductVO4Order getProduct(Long id){
//        List<DepositProductPO> deposits = depositMapper.selectAllProducts();
//        for (DepositProductPO i: deposits){
//            if (i.getId() == id){
//                ProductVO4Order vo = new ProductVO4Order();
//                vo.setCode(null);
//                vo.setpID(id);
//                vo.setName(i.getName());
//                return vo;
//            }
//        }
        return getNullProduct();
    }

    public ProductVO4Order getNullProduct(){
        ProductVO4Order vo = new ProductVO4Order();
        vo.setName(null);
        vo.setCode(null);
        vo.setpID(null);
        return vo;
    }

    private void updateProportion(Long userId){
        Double allAmount = depositMapper.selectMyProductAmount(userId);
        List<MyDepoPO> myDepoPOS = depositMapper.selectMyProduct(userId);
        for(int i=0;i<myDepoPOS.size();i++){
            MyDepoPO myDepoPO = myDepoPOS.get(i);
            Double proportion = myDepoPO.getAmount() / allAmount;
            depositMapper.updateProportion(myDepoPO.getId(),proportion);
        }
    }
}
