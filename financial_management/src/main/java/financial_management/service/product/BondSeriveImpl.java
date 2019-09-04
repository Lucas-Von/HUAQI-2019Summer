package financial_management.service.product;

import financial_management.data.product.BondFundMapper;
import financial_management.entity.PlatformTradePO;
import financial_management.entity.product.*;
import financial_management.service.order.impl.OrderServiceImpl;
import financial_management.vo.order.PlatformTradeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Description 债券部分逻辑更新
 * @Author 233loser
 * @Date 2019/8/28 15:01
 * @Version 1.0
 **/
@Service
public class BondSeriveImpl {


    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    BondFundMapper mapper;

    //TODO 是否需要修改名称
    String nationalDebtName = "国债";
    String corporationDebtName = "企业债";

    //方法一：用户首次购买
    public void firstPurchase(Long userId,Double expectRate,Float amount){
        //函数1
        getFundProportion(expectRate,userId);

        selfFundPurchase(amount,userId);
    }

    //方法二：用户调仓
    public void adjustWarehouse(Long userId,Float amount){
        //函数2
        selfFundPurchase(amount,userId);
    }

    //方法三：平台每日购买
    public void dailyPurchase(){
        //调用函数5
        updatePrice();

        //调用函数6
        platformTransaction();

        //TODO 接函数7
        //调用函数10
        shareUpdate();

    }

    //方法四：每日更新：
    public void dailyUpdate(){
        //函数9
        fundScale();

        //函数8
        netWorthy();

    }
    //方法五：指数维护
    public void exponent(){
        exponentAdjust();
        
        //接7
    }

    /**
     * @Author jyh
     * @Description //用户首次购买时调用
     * 债券函数1
     * TODO 获取期望收益率
     * @Date 15:09 2019/8/28
     * @Param [expectRate, userId]
     * @return void
     **/
    public void getFundProportion(Double expectRate,Long userId) {
        //获取国债利率
        Optional<Float> nationalDebt = Optional.ofNullable(mapper.selectExpectReturnRate(nationalDebtName));
        Float nationalRate = nationalDebt.orElse(0.0F);
        //获取企业债利率
        Optional<Float> corporateDebt = Optional.ofNullable(mapper.selectExpectReturnRate(corporationDebtName));
        Float corporateRate = corporateDebt.orElse(0.0F);

        //TODO 输入expectRate,nationalRate,corporateRate调用py_函数1获取返回值，这边写驱动了

        //获取国债企业债投资比例，假数据
        Float nationalInvestRate = 50.0F;
        Float corporateInvestRate = 50.0F;
        //更新数据库中投资比例建议

        //防御式编程我也是服了，首次购买insert，再次调整Update
        if (mapper.selectUserBond(userId,nationalDebtName) == null ||mapper.selectUserBond(userId,corporationDebtName)==null) {
            mapper.insertvestRateByName(nationalDebtName,nationalInvestRate,userId,new Timestamp(new Date().getTime()));
            mapper.insertvestRateByName(corporationDebtName,corporateInvestRate,userId,new Timestamp(new Date().getTime()));
        }
        else {
            mapper.updateInvestRateByName(nationalDebtName, nationalInvestRate, userId);
            mapper.updateInvestRateByName(corporationDebtName, corporateInvestRate, userId);
        }
    }

    /**
     * @Author jyh
     * @Description //用户首次购买/调仓时调用
     * 函数2
     * TODO 获取债券基金变化金额
     * @Date 17:18 2019/8/28
     * @Param
     * @return
     **/
    public void selfFundPurchase(Float amount,Long userId){

        UserBondPO national = mapper.selectUserBond(userId,nationalDebtName);
        UserBondPO corporation = mapper.selectUserBond(userId,corporationDebtName);
        BondFoundationPO nationalDebt = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporationDebt = mapper.selectBondFundByName(corporationDebtName);
        BondPlatformPO platform = mapper.selectBondPlatform();
        //TODO 输入national和corporation的bondProportion。amount调用py_函数2获取返回值，这边写驱动了
        //TODO 获取返回值，调用函数3
        Float nationalVaryAmount = 231.0F;
        Float corporateVaryAmount = 123.0F;
        Integer isFirstPurchase = 0;
        Integer purchaseSign = 0;
        Float nationalSum=10.0F;
        Float corporateSum = 10.0F;

        //应该是累加累计购买
        Optional<Float> sumNation = Optional.ofNullable(nationalDebt.getDebtSum());
        Optional<Float> sumCorpor = Optional.ofNullable(corporationDebt.getDebtSum());
        Float nationPurchase = sumNation.orElse(0.0F);
        Float corporPurchase = sumCorpor.orElse(0.0F);

        //入库存储
        mapper.updateSumPurchaseByName(nationPurchase+nationalSum,nationalDebtName);
        mapper.updateSumPurchaseByName(corporPurchase+corporateSum,corporationDebtName);
        //调用函数3
        Float fee = getHandlingFee(amount,purchaseSign,isFirstPurchase,platform.getHandlingFee());

        //调用函数4
//        selfRecord(userId,nationalVaryAmount,corporateVaryAmount,purchaseSign,fee);
    }

    /**
     * @Author jyh
     * @Description //用户首次购买时/调仓调用手续费
     * 函数3
     * @Date 18:31 2019/8/28
     * @Param
     * @return
     **/
    public Float getHandlingFee(Float amount,Integer purchaseSign,Integer isFirstPurchase,Float handlingRate){
        BondFoundationPO nationalDebt = mapper.selectBondFundByName(nationalDebtName);
        BondPlatformPO platform = mapper.selectBondPlatform();
        //TODO 连函数3
        Float handlingFee = 0.0F;
        Float sum = 0.0F;
        //TODO 连交易记录


        mapper.updateRestProperty(sum);
        //返回手续费
        return handlingFee;
    }

    /**
     * @Author jyh
     * @Description //
     *
     * 函数4
     * @Date 20:36 2019/8/29
     * @Param
     * @return
     **/
    public void selfRecord(Long userId ,Float nationalFund,Float corporateFund,Integer sign,Float rate){
        Date time = new Date();
        //TODO 接函数4
//        Boolean tradeSign = false;
//        Float amount = 0.1F;
//        amount = tradeSign?-amount:amount;
//        //接东哥
//        PersonalTradeVO vo = new PersonalTradeVO();
//        //数量
//        vo.setTotal(amount);
//        //种类
//        vo.setType(PersonalTradeVO.Type.BOND);
//        //手续费
//        vo.setFee(0.0F);
//        //用户Id
//        vo.setUserID(userId);
//        //创建时间
//        vo.setCreateTime(new Date());
//        vo.setID(null);
//        vo.setAmount(null);
//        vo.setPrice(null);
//        orderService.addPersonalTradeRecord(vo,false);

    }


    /**
     * @Author jyh
     * @Description //平台每日更新时调用
     * 函数5
     * @Date 10:25 2019/8/29
     * @Param []
     * @return void
     **/
    public void updatePrice(){
        List<BondPO> bonds = mapper.selectAllBond();
        for(int i = 0;i<bonds.size();i++){
            //TODO 接函数5
            Float value = 30.0F;
            mapper.updateBondPrice(value,bonds.get(i).getId());
        }
    }
    
    /**
     * @Author jyh
     * @Description //平台每日购买时调用
     * 函数6
     * @Date 10:30 2019/8/29
     * @Param 
     * @return 
     **/
    public void platformTransaction(){
        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
        List<BondAndFundPO> nationalBafs = mapper.selectAllBondAndFund(national.getId());
        List<BondAndFundPO> corporationBafs = mapper.selectAllBondAndFund(corporation.getId());
        //计算持有金额
        BondAndFundPO[] nationalBAFs = nationalBafs.toArray(new BondAndFundPO[nationalBafs.size()]);
        BondAndFundPO[] corporationBAFs = corporationBafs.toArray(new BondAndFundPO[corporationBafs.size()]);
        for(int i = 0 ; i<nationalBAFs.length;i++){
            BondAndFundPO po = nationalBAFs[i];
            po.setAmount(po.getQuantity()*po.getPrice());
            nationalBAFs[i] = po;
        }
        for(int i = 0 ; i<corporationBAFs.length;i++){
            BondAndFundPO po = corporationBAFs[i];
            po.setAmount(po.getQuantity()*po.getPrice());
            nationalBAFs[i] = po;
        }
        //TODO 接函数6

        Float restFee = 20.4F;
        Float bondFee = 40.2F;
        List<String> res =new ArrayList<>();
        mapper.updateBondPlatform(restFee,bondFee);

        mapper.deleteBondAndFund(national.getId());
        //对每个新的基金进行插入
        res.stream().forEach(o->{
            mapper.insertBondAndFund(1L,1L,0.0F,0.0F);
        });

        mapper.deletePurchaseRecord();

    }
    /**
     * @Author jyh
     * @Description //
     * 函数7
     * @Date 12:52 2019/8/30
     * @Param
     * @return
     **/
    public void platFormTransation(){
        //TODO 接函数7 函数有点奇怪啊
        PlatformTradePO po = new PlatformTradePO();
        po.setTotal(0.0F);
        po.setTime(new Date());
        po.setProduct("///神秘玩意");
        PlatformTradeVO vo = new PlatformTradeVO(po);

        orderService.addPlatformTradeRecord(vo);
    }
    /**
     * @Author jyh
     * @Description //单位净值计算
     * 函数8
     * @Date 13:58 2019/8/29
     * @Param 
     * @return 
     **/
    public void netWorthy(){
        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);

        //TODO 接函数8
        Float nationalPrice = 0.0F;
        Float corporationPrice = 0.0F;
        //更新单位净值
        mapper.updateBondFundNetWorthy(nationalPrice,nationalDebtName);
        mapper.updateBondFundNetWorthy(corporationPrice,corporationDebtName);
    }
    
    /**
     * @Author jyh
     * @Description //基金规模调整
     * 函数9
     * @Date 14:36 2019/8/29
     * @Param 
     * @return 
     **/
    public void fundScale(){
        //获取所有债权
        List<BondPO> bonds = mapper.selectAllBond();
        //获取两组基金
        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
        //获取基金对应的债券
        List<BondAndFundPO> nationalBondAndFunds = mapper.selectAllBondAndFund(national.getId());
        List<BondAndFundPO> corporateBondAndFund = mapper.selectAllBondAndFund(corporation.getId());
        //更新债券资产
        Float natScale = 0.0F;
        Float corScale = 0.0F;
        for (int i =0 ;i<nationalBondAndFunds.size();i++){
            for(int j = 0;j < bonds.size();j++){
                if(nationalBondAndFunds.get(i).getBondCode().equals(bonds.get(i).getCode())){
                    natScale += nationalBondAndFunds.get(i).getAmount()*nationalBondAndFunds.get(i).getPrice();
                    break;
                }
            }
        }
        for (int i =0 ;i<corporateBondAndFund.size();i++){
            for(int j = 0;j < bonds.size();j++){
                if(corporateBondAndFund.get(i).getBondCode().equals(bonds.get(i).getCode())){
                    corScale += corporateBondAndFund.get(i).getAmount()*corporateBondAndFund.get(i).getPrice();
                    break;
                }
            }
        }
        //TODO 接函数9
        mapper.updateFundScale(natScale,nationalDebtName);
        mapper.updateFundScale(corScale,corporationDebtName);

    }

    /**
     * @Author jyh
     * @Description //函数10
     * @Date 16:44 2019/8/29
     * @Param
     * @return
     **/
    public void shareUpdate(){
        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
        //TODO 接杨日东部分和py10
        Float quantity = 0.0F;
        Float totalQuantity = 0.0F;
        //更新用户持有的数据，需要做个List
        mapper.updateUserShare(1L,nationalDebtName,quantity);
        mapper.updateUserShare(1L,corporationDebtName,quantity);

        //更新总份额
        mapper.updateTotalShare(nationalDebtName,totalQuantity);
    }

    /**
     * @Author jyh
     * @Description //函数11
     * @Date 16:46 2019/8/29
     * @Param []
     * @return void
     **/
    public void getPlatformRate(){
        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
        //TODO 接函数11
        Float seven = 0.0F;
        Float thirty = 0.0F;
        Float ninety = 0.0F;
        mapper.updateReturnRate(seven,thirty,ninety);
    }

    /**
     * @Author jyh
     * @Description //指数维护后操作
     * 13
     * @Date 16:48 2019/8/29
     * @Param
     * @return
     **/
    public void exponentAdjust(){
        BondFoundationPO foundation = mapper.selectBondFundByName("指数基金");
        List<BondAndFundPO> bonds = mapper.selectAllBondAndFund(foundation.getId());
        //TODO 接函数13
        Float restFee = 0.0F;
        Float bondFee = 0.0F;
        List<String> res =new ArrayList<>();
        mapper.updateBondPlatform(restFee,bondFee);

        mapper.deleteBondAndFund(1L);
        //对每个新的基金进行插入
        res.stream().forEach(o->{
            mapper.insertBondAndFund(1L,1L,0.0F,0.0F);
        });
    }
}
