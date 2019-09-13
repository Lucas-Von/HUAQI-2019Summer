package financial_management.service.product;

import financial_management.bl.order.OrderService;
import financial_management.bl.product.FundService;
import financial_management.bl.product.ProductService4User;
import financial_management.bl.wallet.FundService4Wallet;
import financial_management.data.product.FundMapper;
import financial_management.entity.FundPO;
import financial_management.entity.MyFundPO;
import financial_management.entity.fund.InfoParam;
import financial_management.entity.fund.InfoRatesResponse;
import financial_management.entity.fund.InfoResponse;
import financial_management.service.order.impl.OrderServiceImpl;
import financial_management.util.DateConverterUtil;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.product.FundBasicVO;
import financial_management.vo.product.FundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    OrderServiceImpl orderService;

    //充钱
    @Override
    public void IncreaseCapital(Long userId, Double cost) {
        MyFundPO po = mapper.selectSelfFund(userId);
        po.setUpdateTime(DateConverterUtil.moveForwardByDay(new Date(),0));
        po.setBalance(po.getBalance()+cost.floatValue());
        mapper.updateSelfFund(po);
        addRecord(userId,cost);
    }

    //支出
    @Override
    public void DecreaseCapital(Long userId, Double cost) {
        MyFundPO po = mapper.selectSelfFund(userId);
        po.setUpdateTime(DateConverterUtil.moveForwardByDay(new Date(),0));
        po.setBalance(po.getBalance()-cost.floatValue());
        mapper.updateSelfFund(po);
        addRecord(userId,-cost);

    }

    @Override
    public Double checkBalance(Long userId) {
        MyFundPO po = mapper.selectSelfFund(userId);
        return po.getBalance().doubleValue();
    }

    //设置支付密码
    @Override
    public void setPayPassword(Long userId, String password) {
        mapper.updateSelfPassword(userId,password);
    }

    //核对支付密码
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

    @Override
    public BasicResponse getMoreTraceInfo() {
        FundPO po = mapper.selectFund();
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,po);
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

    public void dailyUpdate(){
        List<MyFundPO> funds = mapper.selectAllFunds();
        FundPO fundPlat = mapper.selectFund();

        for(int i = 0;i<funds.size();i++){
            Optional<Float> balance = Optional.ofNullable(funds.get(i).getBalance());
            Float trueBalance = balance.orElse(0F);
            Optional<Float> earn = Optional.ofNullable(funds.get(i).getAccuringAmount());
            Float earnAmount = balance.orElse(0F);
            PyParam param = new InfoParam(earnAmount,trueBalance);

            List<Object> invokeResult = PyInvoke.invoke(PyFunc.CASH_DAILY_ADJUSTMENT, param, InfoResponse.class);
            List<InfoResponse> list = new ArrayList<>();
            for (Object object : invokeResult){
                list.add((InfoResponse) object);
            }
            InfoResponse response = list.get(0);
            //更新用户数据
            mapper.updateAccuringAndBalance(response.getBalance(),response.getAccumulated_earning(),funds.get(i).getUserId(),response.getLast_revenue());
            InfoRatesResponse rates = new InfoRatesResponse(response.getInfo_display());
            fundPlat.setSevenAnnualized(rates.getSeven_days_annualized_return());
            fundPlat.setFourteenAnnualized(rates.getFourteen_days_annualized_return());
            fundPlat.setTwentyeightAnnualized(rates.getTwentyseven_days_annualized_return());
            fundPlat.setThirtyYieldRate(rates.getThirty_days_yield_rate());
            fundPlat.setNintyYieldRate(rates.getNinety_days_yield_rate());
            fundPlat.setSinceYieldRate(rates.getYield_rate_since_establishment());
            mapper.updateFund(fundPlat);
        }


    }

    public void addRecord(Long userId,Double cost){
        PersonalTradeVO vo = new PersonalTradeVO();
        vo.setUserID(userId);
        vo.setCreateTime(new Date());
        vo.setType(OrderService.Type.FUND);
        vo.setAmount(cost.floatValue());
        vo.setTotal(cost.floatValue());
        vo.setFee(0F);
        vo.setPrice(0F);
        vo.setCompleteTime(new Date());
        vo.setTransID(0L);
        ProductVO4Order order = new ProductVO4Order();
        order.setpID(-233L);
        order.setName("null");
        order.setCode("xxx");
        vo.setProduct(order);
        vo.setStatus(1);
        System.out.println(orderService.addPersonalTradeRecord(vo,false).getStatus().msg);

    }
}
