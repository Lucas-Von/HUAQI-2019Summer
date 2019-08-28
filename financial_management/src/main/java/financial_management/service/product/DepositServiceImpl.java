package financial_management.service.product;

import financial_management.bl.product.DepositService;
import financial_management.data.product.DepositMapper;
import financial_management.entity.DepositProductPO;
import financial_management.entity.MyDepoPO;
import financial_management.entity.property.DepositPO;
import financial_management.util.DateConverterUtil;
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
    DepositMapper mapper;

    @Override
    public List<MyDepositVO> getSelfDeposits(Long userId) {

        List<MyDepoPO> pos = mapper.selectSelfProducts(userId);
        List<MyDepositVO> myDeposits = new ArrayList<>();

        pos.stream().forEach(o->{
            MyDepositVO vo = new MyDepositVO(o.getName(),o.getType(),o.getAmount().doubleValue(),o.getRate(),o.getMaturity());
            myDeposits.add(vo);
        });
        return myDeposits;
    }

    @Override
    public List<DepRecProductVO> getAllDeposits() {

        List<DepositProductPO> depositProducts = mapper.selectAllProducts();
        List<DepRecProductVO> depositProductVOs = new ArrayList<>();

        depositProducts.stream().forEach(o->{
            DepRecProductVO vo = new DepRecProductVO(o.getName(),o.getLength(),o.getRate().doubleValue());
            depositProductVOs.add(vo);
        });
        return depositProductVOs;
    }

    @Override
    public boolean purchase(Long userId, String productName, Double amount) {

        DepositProductPO product = mapper.selectProductByName(productName);

        MyDepoPO po = new MyDepoPO();
        try {
            po.setUserId(userId);
            po.setProductId(product.getId());
            po.setAmount(amount.floatValue());
            po.setMaturity(DateConverterUtil.moveForwardByDay(new Date(), product.getLength()));

            mapper.insertMyProduct(po);
            return true;
        }
        catch (NullPointerException e){
            return false;
        }
    }

    public ProductVO4Order getProduct(Long id){
        List<DepositProductPO> deposits = mapper.selectAllProducts();
        for (DepositProductPO i: deposits){
            if (i.getId() == id){
                ProductVO4Order vo = new ProductVO4Order();
                vo.setCode(null);
                vo.setpID(id);
                vo.setName(i.getName());
                return vo;
            }
        }
        return getNullProduct();
    }

    public ProductVO4Order getNullProduct(){
        ProductVO4Order vo = new ProductVO4Order();
        vo.setName(null);
        vo.setCode(null);
        vo.setpID(null);
        return vo;
    }
}
