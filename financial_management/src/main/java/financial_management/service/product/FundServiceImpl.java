package financial_management.service.product;

import financial_management.bl.product.FundService;
import financial_management.bl.product.ProductService4User;
import financial_management.bl.wallet.FundService4Wallet;
import financial_management.data.product.FundMapper;
import financial_management.entity.DepositProductPO;
import financial_management.entity.FundPO;
import financial_management.entity.MyFundPO;
import financial_management.util.DateConverterUtil;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.product.FundBasicVO;
import financial_management.vo.product.FundVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 16:03
 * @Version 1.0
 **/
@Service
public class FundServiceImpl implements FundService4Wallet, FundService, ProductService4User {
    @Autowired
    FundMapper mapper;

    @Override
    public void IncreaseCapital(Long userId, Long cost) {
        MyFundPO po = mapper.selectSelfFund(userId);
        po.setUpdateTime(DateConverterUtil.moveForwardByDay(new Date(),0));
        po.setBalance(po.getBalance()+cost.floatValue());
        mapper.updateSelfFund(po);
    }

    @Override
    public void DecreaseCapital(Long userId, Long cost) {
        MyFundPO po = mapper.selectSelfFund(userId);
        po.setUpdateTime(DateConverterUtil.moveForwardByDay(new Date(),0));
        po.setBalance(po.getBalance()-cost.floatValue());
        mapper.updateSelfFund(po);
    }

    @Override
    public Double checkBalance(Long userId) {
        MyFundPO po = mapper.selectSelfFund(userId);
        return po.getBalance().doubleValue();
    }

    @Override
    public void setPayPassword(Long userId, String password) {
        mapper.updateSelfPassword(userId,password);
    }

    @Override
    public boolean checkPayPassword(Long userId, String paypassword) {
        MyFundPO po = mapper.selectSelfFund(userId);
        //防止未设置
        Optional<String> thePassword = Optional.ofNullable(po.getPayPassword());
        String exactPassword = thePassword.orElse("");
        return exactPassword.equals(paypassword);
    }

    @Override
    public FundVO getFund(Long userId) {
        MyFundPO po = mapper.selectSelfFund(userId);
        FundPO fund = mapper.selectFund();
        return new FundVO(po,fund);

    }

    @Override
    public FundBasicVO getBasicFund() {
        FundPO po = mapper.selectFund();
        return new FundBasicVO(po);
    }

    @Override
    public boolean generateFund(Long userId) {
        mapper.insertNewFund(userId,0.0F);
        return true;
    }

    public ProductVO4Order getProduct(Long id){
        FundPO fundPO = mapper.selectFund();
        if(fundPO == null){
            return getNullProduct();
        }
        ProductVO4Order vo = new ProductVO4Order();
        vo.setName(fundPO.getName());
        vo.setpID(null);
        vo.setCode(null);
        return vo;
    }

    public ProductVO4Order getNullProduct(){
        ProductVO4Order vo = new ProductVO4Order();
        vo.setName(null);
        vo.setCode(null);
        vo.setpID(null);
        return vo;
    }
}