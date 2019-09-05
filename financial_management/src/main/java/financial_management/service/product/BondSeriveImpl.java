package financial_management.service.product;

import financial_management.bl.order.OrderService;
import financial_management.data.product.BondFundMapper;
import financial_management.entity.bond.*;
import financial_management.util.PyInvoke.PyParam.bond.*;
import financial_management.service.product.bond.BondServiceForBl;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.PlatformTradeVO;
import financial_management.vo.order.ProductVO4Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class BondSeriveImpl implements BondServiceForBl {

    @Qualifier("orderServiceImpl")
    @Autowired
    OrderService orderService;

    @Autowired
    BondFundMapper mapper;

    //TODO 是否需要修改名称
    String nationalDebtName = "国债";
    String corporationDebtName = "企业债";

    @Override
    public Double getAmountByUser(Long userId) {
        UserBondPO national = mapper.selectUserBond(userId,nationalDebtName);
        UserBondPO corpor = mapper.selectUserBond(userId,corporationDebtName);

        BondFoundationPO nationalFund = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporateFund = mapper.selectBondFundByName(corporationDebtName);

        return (nationalFund.getFundUnitValue().doubleValue()*national.getFundShare().doubleValue()+corporateFund.getFundUnitValue().doubleValue()*corpor.getFundShare().doubleValue());
    }

    //方法一：用户首次购买
    public void firstPurchase(Long userId, Double expectRate, Float amount) {
        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporate = mapper.selectBondFundByName(corporationDebtName);
        //  TODO vo里有点小问题
        First_PurchaseVO vo = new First_PurchaseVO();
        vo.setExpected_rate(expectRate.floatValue());
        vo.setAmount_change(amount);
        //国债累计购买
        Optional<Float> nationalPurchase = Optional.ofNullable(national.getDebtSum());
        Float natSum = nationalPurchase.orElse(0.0F);
        vo.setPlatform_accelerate_national(natSum);
        //企业债累计购买
        Optional<Float> corPurchase = Optional.ofNullable(corporate.getDebtSum());
        Float corporSum = corPurchase.orElse(0.0F);
        vo.setPlatform_accelerate_corporate(corporSum);

        //收益率如何更新?每日更新
        vo.setYieldrate_national(national.getExpectReturnRate());
        vo.setYieldrate_corporate(corporate.getExpectReturnRate());
        List<Float> res = mapper.selectRateList().getList();
        vo.setCommission_rate(res);

        //TODO 接函数

        First_PurchasePO po = new First_PurchasePO();
        //更新国债、企业债投资比例
        if (mapper.selectUserBond(userId, nationalDebtName) == null || mapper.selectUserBond(userId, corporationDebtName) == null) {
            mapper.insertvestRateByName(nationalDebtName, po.getProp_national(), userId, new Timestamp(po.getTrans_time().getTime()));
            mapper.insertvestRateByName(corporationDebtName, po.getProp_corporate(), userId, new Timestamp(po.getTrans_time().getTime()));
        } else {
            mapper.updateInvestRateByName(nationalDebtName, po.getProp_national(), userId);
            mapper.updateInvestRateByName(corporationDebtName, po.getProp_corporate(), userId);
        }
        //更新累计购买
        Optional<Float> sumNation = Optional.ofNullable(national.getDebtSum());
        Optional<Float> sumCorpor = Optional.ofNullable(corporate.getDebtSum());
        Float nationPurchase = sumNation.orElse(0.0F);
        Float corporPurchase = sumCorpor.orElse(0.0F);
        mapper.updateSumPurchaseByName(nationPurchase + po.getPlatform_accelerate_national(), nationalDebtName);
        mapper.updateSumPurchaseByName(corporPurchase + po.getAmountchange_corporate(), corporationDebtName);

        //组成国债交易记录
        PersonalTradeVO tradeRecord_Nation = new PersonalTradeVO();
        ProductVO4Order productNational = new ProductVO4Order();
        productNational.setName(nationalDebtName);
        tradeRecord_Nation.setProduct(productNational);
        tradeRecord_Nation.setCreateTime(po.getTrans_time());
        tradeRecord_Nation.setUserID(userId);
        tradeRecord_Nation.setFee(po.getAmountchange_national());
        tradeRecord_Nation.setType(OrderService.Type.BOND);
        //0是卖 1是买
        tradeRecord_Nation.setTotal(po.getSign() == 0 ? -po.getAmountchange_national() : po.getAmountchange_national());
        orderService.addPersonalTradeRecord(tradeRecord_Nation, false);

        //组成企业债购买记录
        PersonalTradeVO tradeRecord_Corpor = new PersonalTradeVO();
        ProductVO4Order productVO4Order = new ProductVO4Order();
        productVO4Order.setName(corporationDebtName);
        tradeRecord_Corpor.setProduct(productVO4Order);
        tradeRecord_Corpor.setCreateTime(po.getTrans_time());
        tradeRecord_Corpor.setUserID(userId);
        tradeRecord_Corpor.setFee(po.getAmountchange_corporate());
        tradeRecord_Corpor.setType(OrderService.Type.BOND);
        //0是卖 1是买
        tradeRecord_Corpor.setTotal(po.getSign() == 0 ? -po.getAmountchange_corporate() : po.getAmountchange_corporate());
        orderService.addPersonalTradeRecord(tradeRecord_Corpor, false);

        //更新用户持有的份额
        mapper.updateUserFundShare(userId, po.getAmountchange_national(), nationalDebtName);
        mapper.updateUserFundShare(userId, po.getAmountchange_corporate(), corporationDebtName);
    }


    //方法二：用户调仓
    public void adjustWarehouse(Long userId, Float amount) {
        BondPlatformPO platformPO = mapper.selectBondPlatform();
        AdjuestmentVO vo = new AdjuestmentVO();
        //用户两种基金比例
        UserBondPO national = mapper.selectUserBond(userId, nationalDebtName);
        vo.setProp_national(national.getBondProportion());
        UserBondPO corporation = mapper.selectUserBond(userId, corporationDebtName);
        vo.setProp_corporate(corporation.getBondProportion());
        //用户投资数额变化
        vo.setAmount_change(amount);
        vo.setFund_cash(platformPO.getResidualAssets());
        List<Float> res = mapper.selectRateList().getList();
        vo.setCommission_rate(res);
        //累计购买
        BondFoundationPO nationalDebt = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporationDebt = mapper.selectBondFundByName(corporationDebtName);
        vo.setPlatform_accelerate_corporate(corporationDebt.getDebtSum());
        vo.setPlatform_accelerate_national(nationalDebt.getDebtSum());

        //TODO 接Adjustment
        AdjuestmentPO po = new AdjuestmentPO();
        //调整总份额
        Optional<Float> sumNation = Optional.ofNullable(nationalDebt.getDebtSum());
        Optional<Float> sumCorpor = Optional.ofNullable(corporationDebt.getDebtSum());
        Float nationPurchase = sumNation.orElse(0.0F);
        Float corporPurchase = sumCorpor.orElse(0.0F);
        mapper.updateSumPurchaseByName(nationPurchase + po.getPlatform_accelerate_national(), nationalDebtName);
        mapper.updateSumPurchaseByName(corporPurchase + po.getAmountchange_corporate(), corporationDebtName);

        //组成国债交易记录
        PersonalTradeVO tradeRecord_Nation = new PersonalTradeVO();
        //设置基金名
        ProductVO4Order productNational = new ProductVO4Order();
        productNational.setName(nationalDebtName);
        tradeRecord_Nation.setProduct(productNational);
        tradeRecord_Nation.setCreateTime(po.getTrans_time());
        tradeRecord_Nation.setUserID(userId);
        tradeRecord_Nation.setFee(po.getAmountchange_national());
        tradeRecord_Nation.setType(OrderService.Type.BOND);
        //0是卖 1是买
        tradeRecord_Nation.setTotal(po.getSign() == 0 ? -po.getAmountchange_national() : po.getAmountchange_national());
        orderService.addPersonalTradeRecord(tradeRecord_Nation, false);

        //组成企业债购买记录
        PersonalTradeVO tradeRecord_Corpor = new PersonalTradeVO();
        //我只要设置基金名字 我不管是什么
        ProductVO4Order productVO4Order = new ProductVO4Order();
        productVO4Order.setName(corporationDebtName);
        tradeRecord_Corpor.setProduct(productVO4Order);

        tradeRecord_Corpor.setCreateTime(po.getTrans_time());
        tradeRecord_Corpor.setUserID(userId);
        tradeRecord_Corpor.setFee(po.getAmountchange_corporate());
        tradeRecord_Corpor.setType(OrderService.Type.BOND);
        //0是卖 1是买
        tradeRecord_Corpor.setTotal(po.getSign() == 0 ? -po.getAmountchange_corporate() : po.getAmountchange_corporate());
        orderService.addPersonalTradeRecord(tradeRecord_Corpor, false);

        //更新用户持有的份额
        Float nationShare = mapper.selectUserBond(userId, nationalDebtName).getFundShare();
        Float corporShare = mapper.selectUserBond(userId, corporationDebtName).getFundShare();
        nationShare += po.getSign() == 0 ? -po.getAmountchange_national() : po.getAmountchange_national();
        corporShare += po.getSign() == 0 ? -po.getAmountchange_corporate() : po.getAmountchange_corporate();
        mapper.updateUserFundShare(userId, nationShare, nationalDebtName);
        mapper.updateUserFundShare(userId, corporShare, corporationDebtName);
    }

    //方法三：平台每日购买
    public void dailyPurchase() {
        Daily_PurchaseVO vo = new Daily_PurchaseVO();

        //设置资产和剩余现金资产
        BondPlatformPO platform = mapper.selectBondPlatform();
        //TODO 两者如何更新
        vo.setFund_bonds(platform.getBondAssets());
        vo.setFund_cash(platform.getResidualAssets());
        List<Float> res = mapper.selectRateList().getList();

        //设置购买份额
        BondFoundationPO nation = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);

        vo.setPlatform_accelerate_national(nation.getDebtSum());
        vo.setPlatform_accelerate_corporate(corporation.getDebtSum());

        //设置基金持有股票
        List<BondAndFundPO> nationBonds = mapper.selectAllBondAndFund(nation.getId());
        List<BondAndFundPO> corporBonds = mapper.selectAllBondAndFund(corporation.getId());
        //设置
        List<BondsInfo> nationBondsInfo = new ArrayList<>();
        nationBonds.stream().forEach(o -> {
            BondsInfo info = new BondsInfo();
            info.setAmount(o.getAmount());
            info.setQuantity(o.getQuantity().intValue());
            info.setCode(o.getBondCode());
            info.setProduct(nationalDebtName);
            info.setProportion(o.getInvestProportion());
            nationBondsInfo.add(info);
        });
        List<BondsInfo> corporBondsInfo = new ArrayList<>();
        corporBonds.stream().forEach(o -> {
            BondsInfo info = new BondsInfo();
            info.setAmount(o.getAmount());
            info.setQuantity(o.getQuantity().intValue());
            info.setCode(o.getBondCode());
            info.setProduct(nationalDebtName);
            info.setProportion(o.getInvestProportion());
            corporBondsInfo.add(info);
        });
        vo.setBonds_info_national(nationBondsInfo);
        vo.setBonds_info_corporate(corporBondsInfo);

        //TODO DailyPurchase

        DailyPurchasePO po = new DailyPurchasePO();
        //先更新数据库里的债券信息
        List<NewBond> bondsNational = po.getPrice_list_national();
        List<NewBond> bondsCorporate = po.getPrice_list_corporate();
        for (int j = 0; j < bondsNational.size(); j++) {
            //原本没有这个债券
            if (mapper.selectBondByCode(bondsNational.get(j).getFund_code()) == null) {
                mapper.insertBond(bondsNational.get(j).getFund_code(), bondsNational.get(j).getFund_price());
            } else {
                //更新价格
                mapper.updateBondPriceByCode(bondsNational.get(j).getFund_code(), bondsNational.get(j).getFund_price());
            }
        }
        for (int j = 0; j < bondsCorporate.size(); j++) {
            //原本没有这个债券
            if (mapper.selectBondByCode(bondsCorporate.get(j).getFund_code()) == null) {
                mapper.insertBond(bondsCorporate.get(j).getFund_code(), bondsCorporate.get(j).getFund_price());
            } else {
                //更新价格
                mapper.updateBondPriceByCode(bondsCorporate.get(j).getFund_code(), bondsCorporate.get(j).getFund_price());
            }
        }
        //更新剩余现金资产和债券资产
        mapper.updateBondPlatform(po.getFund_cash(), po.getFund_bonds());
        //更新累计购买份额,全设0
        mapper.deletePurchaseRecord();

        //基金对债券更新持有份额，先全部删除，然后插入
        mapper.deleteBondAndFund(nation.getId());
        mapper.deleteBondAndFund(corporation.getId());
        po.getBonds_info_national().stream().forEach(o -> {
            List<BondPO> bonds = mapper.selectAllBond();
            for (int i = 0; i < bonds.size(); i++) {
                if (bonds.get(i).getCode().equals(o.getCode())) {
                    mapper.insertBondAndFund(nation.getId(), bonds.get(i).getId(), o.getProportion(), o.getQuantity().floatValue());
                    break;
                }
            }
        });
        po.getBonds_info_corporate().stream().forEach(o -> {
            List<BondPO> bonds = mapper.selectAllBond();
            for (int i = 0; i < bonds.size(); i++) {
                if (bonds.get(i).getCode().equals(o.getCode())) {
                    mapper.insertBondAndFund(corporation.getId(), bonds.get(i).getId(), o.getProportion(), o.getQuantity().floatValue());
                    break;
                }
            }
        });
        //更新交易记录
        po.getTrans_record_corporate().stream().forEach(o -> {
            PlatformTradeVO record = new PlatformTradeVO();
            if (o.getSign() == 0) {
                //说明是卖出
                record.setRealTotal(-o.getPurchase_amount());
                record.setRealTotal(-o.getPurchase_amount());
            } else {
                record.setTotal(o.getPurchase_amount());
                record.setRealTotal(o.getPurchase_amount());
            }
            record.setProduct(o.getCode());
            record.setTime(o.getTime());
            orderService.addPlatformTradeRecord(record);
        });
        po.getTrans_record_national().stream().forEach(o -> {
            PlatformTradeVO record = new PlatformTradeVO();
            if (o.getSign() == 0) {
                //说明是卖出
                record.setRealTotal(-o.getPurchase_amount());
                record.setRealTotal(-o.getPurchase_amount());
            } else {
                record.setTotal(o.getPurchase_amount());
                record.setRealTotal(o.getPurchase_amount());
            }
            record.setAmount(o.getQuantity());
            record.setProduct(o.getCode());
            record.setTime(o.getTime());
            orderService.addPlatformTradeRecord(record);
        });

        //用户个人信息
        List<PersonalTradeVO> list = orderService.getTodaysPersonalTradeRecord(OrderService.Type.BOND).getData();
        Float nationalShare = nation.getFundShare();
        Float corporateShare = corporation.getFundShare();
        for (int i = 0; i < list.size(); i++) {
            PersonalTradeVO o = list.get(i);
            //如果不成功找东哥问问
            String fundName = o.getProduct().getName();
            BondFoundationPO fund = mapper.selectBondFundByName(fundName);
            //TODO 变化金额是否已经包括手续费在内
            //获取用户对于的资产
            UserBondPO user = mapper.selectUserBond(o.getUserID(), fundName);
            //卖出
            if (o.getAmount() < 0) {
                Float shares = user.getFundShare();
                //因为是负的
                shares += o.getAmount() / fund.getFundUnitValue();
                //更新用户的份额
                mapper.updateUserFundShare(o.getUserID(), shares, fundName);
                //更新总份额
                if (fundName.equals(nationalDebtName)) {
                    nationalShare += o.getAmount() / fund.getFundUnitValue();
                } else {
                    corporateShare += o.getAmount() / fund.getFundUnitValue();
                }
            } else {
                Float shares = user.getFundShare();
                //因为是负的
                shares += (o.getAmount() - o.getFee()) / fund.getFundUnitValue();
                //更新用户的份额
                mapper.updateUserFundShare(o.getUserID(), shares, fundName);
                //更新总份额
                if (fundName.equals(nationalDebtName)) {
                    nationalShare += (o.getAmount() - o.getFee()) / fund.getFundUnitValue();
                } else {
                    corporateShare += (o.getAmount() - o.getFee()) / fund.getFundUnitValue();
                }
            }
        }
        mapper.updateTotalShare(nationalDebtName, nationalShare);
        mapper.updateTotalShare(corporationDebtName, corporateShare);

    }

    //    方法四：每日更新：
    public void dailyUpdate() {
        //函数9
        //更新基金规模
        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
        List<BondAndFundPO> bondsAndFund = mapper.selectAllBondAndFund(national.getId());
        Float sumNational = 0.0F;
        //国债规模更新
        for (int i = 0; i < bondsAndFund.size(); i++) {
            sumNational += bondsAndFund.get(i).getQuantity() * bondsAndFund.get(i).getPrice();
        }
        mapper.updateFundScale(sumNational, nationalDebtName);
        //企业债规模更新
        BondFoundationPO corporate = mapper.selectBondFundByName(corporationDebtName);
        List<BondAndFundPO> bondsFund = mapper.selectAllBondAndFund(corporate.getId());
        Float sumCorporate = 0.0F;
        for (int i = 0; i < bondsFund.size(); i++) {
            sumCorporate += bondsFund.get(i).getQuantity() * bondsFund.get(i).getPrice();
        }
        mapper.updateFundScale(sumCorporate, corporationDebtName);

        //更新单位净值
        mapper.updateBondFundNetWorthy(sumNational / national.getFundShare(), nationalDebtName);
        //更新单位净值
        mapper.updateBondFundNetWorthy(sumCorporate / corporate.getFundShare(), corporationDebtName);

        //更新收益率，方便的出7/30/90
        mapper.insertRateLog(national.getId(), sumNational / national.getFundShare(), new Date());
        mapper.insertRateLog(corporate.getId(), sumCorporate / corporate.getFundShare(), new Date());
    }

    //    //方法五：指数维护
    public void exponent(String fundName) {
        IndexVO vo = new IndexVO();
        BondFoundationPO fund4Nation = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO fund4Corpor = mapper.selectBondFundByName(corporationDebtName);
        List<BondAndFundPO> bonds4National = mapper.selectAllBondAndFund(fund4Nation.getId());
        List<BondAndFundPO> bonds4Corporate = mapper.selectAllBondAndFund(fund4Corpor.getId());

        //初始化老的债券信息;
        List<BondsInfo> bondsInfoNation = new ArrayList<>();
        List<BondsInfo> bondsInfoCorporation = new ArrayList<>();
        bonds4National.stream().forEach(o -> {
            BondsInfo info = new BondsInfo();
            info.setAmount(o.getAmount());
            info.setCode(o.getBondCode());
            info.setProduct(nationalDebtName);
            info.setProportion(o.getInvestProportion());
            info.setQuantity(o.getQuantity().intValue());
            bondsInfoNation.add(info);
        });

        bonds4Corporate.stream().forEach(o -> {
            BondsInfo info = new BondsInfo();
            info.setAmount(o.getAmount());
            info.setCode(o.getBondCode());
            info.setProduct(nationalDebtName);
            info.setProportion(o.getInvestProportion());
            info.setQuantity(o.getQuantity().intValue());
            bondsInfoCorporation.add(info);
        });

        vo.setBonds_info_national(bondsInfoNation);
        vo.setBonds_info_corporate(bondsInfoCorporation);

        BondPlatformPO platform = mapper.selectBondPlatform();
        vo.setFund_bonds(platform.getBondAssets());
        vo.setFund_cash(platform.getHandlingFee());

        if (fundName.equals("国债")) {
            vo.setProduct_name(nationalDebtName);
        } else {
            vo.setProduct_name(corporationDebtName);
        }
        //TODO 读表
        vo.setNew_fund_info(new ArrayList<>());

        //设置规模
        vo.setSize_national(fund4Nation.getFundScale());
        vo.setSize_corporate(fund4Corpor.getFundScale());


        //TODO 接维护函数

        IndexPO po = new IndexPO();
        //更新债券资产和剩余现金
        mapper.updateBondPlatform(po.getFund_cash(), po.getFund_bonds());
        //更新交易记录
        po.getTrans_record().stream().forEach(o -> {
            PlatformTradeVO trade = new PlatformTradeVO();
            trade.setTotal(o.getPurchase_amount());
            trade.setRealTotal(o.getPurchase_amount());
            trade.setTime(o.getTime());
            trade.setProduct(o.getCode());
            trade.setAmount(o.getQuantity());
            orderService.addPlatformTradeRecord(trade);
        });
    }
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
//    public void selfRecord(Long userId ,Float nationalFund,Float corporateFund,Integer sign,Float rate){
//        Date time = new Date();
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
//=======
//        //更新fundAndBond
//>>>>>>> Stashed changes
//
//        Long id;
//        List<BondPO> pos = mapper.selectAllBond();
//        if(fundName.equals("国债")) {
//            id = fund4Nation.getId();
//            mapper.deleteBondAndFund(fund4Nation.getId());
//        }
//        else {
//            id = fund4Corpor.getId();
//            mapper.deleteBondAndFund(fund4Corpor.getId());;
//        }
//        po.getNew_fund_info().stream().forEach(o->{
//            //查找对应的fundid
//            for(int i = 0 ;i<pos.size();i++){
//                if(pos.get(i).getCode().equals(o.getCode())) {
//                    mapper.insertBondAndFund(id, pos.get(i).getId(), o.getProportion(), o.getQuantity().floatValue());
//                    break;
//                }
//            }
//        });
//        //接7
//    }

//    /**
//     * @Author jyh
//     * @Description //用户首次购买时调用
//     * 债券函数1
//     * 获取期望收益率
//     * @Date 15:09 2019/8/28
//     * @Param [expectRate, userId]
//     * @return void
//     **/
//    public void getFundProportion(Double expectRate,Long userId) {
//        //获取国债利率
//        Optional<Float> nationalDebt = Optional.ofNullable(mapper.selectExpectReturnRate(nationalDebtName));
//        Float nationalRate = nationalDebt.orElse(0.0F);
//        //获取企业债利率
//        Optional<Float> corporateDebt = Optional.ofNullable(mapper.selectExpectReturnRate(corporationDebtName));
//        Float corporateRate = corporateDebt.orElse(0.0F);
//
//        //TODO 输入expectRate,nationalRate,corporateRate调用py_函数1获取返回值，这边写驱动了
//
//        //获取国债企业债投资比例，假数据
//        Float nationalInvestRate = 50.0F;
//        Float corporateInvestRate = 50.0F;
//        //更新数据库中投资比例建议
//
//        //防御式编程我也是服了，首次购买insert，再次调整Update
//        if (mapper.selectUserBond(userId,nationalDebtName) == null ||mapper.selectUserBond(userId,corporationDebtName)==null) {
//            mapper.insertvestRateByName(nationalDebtName,nationalInvestRate,userId,new Timestamp(new Date().getTime()));
//            mapper.insertvestRateByName(corporationDebtName,corporateInvestRate,userId,new Timestamp(new Date().getTime()));
//        }
//        else {
//            mapper.updateInvestRateByName(nationalDebtName, nationalInvestRate, userId);
//            mapper.updateInvestRateByName(corporationDebtName, corporateInvestRate, userId);
//        }
//    }

//    /**
//     * @Author jyh
//     * @Description //用户首次购买/调仓时调用
//     * 函数2
//     *
//     * @Date 17:18 2019/8/28
//     * @Param
//     * @return
//     **/
//    public void selfFundPurchase(Float amount,Long userId){
//
//        UserBondPO national = mapper.selectUserBond(userId,nationalDebtName);
//        UserBondPO corporation = mapper.selectUserBond(userId,corporationDebtName);
//        BondFoundationPO nationalDebt = mapper.selectBondFundByName(nationalDebtName);
//        BondFoundationPO corporationDebt = mapper.selectBondFundByName(corporationDebtName);
//        BondPlatformPO platform = mapper.selectBondPlatform();
//
//        Float nationalVaryAmount = 231.0F;
//        Float corporateVaryAmount = 123.0F;
//        Integer isFirstPurchase = 0;
//        Integer purchaseSign = 0;
//        Float nationalSum=10.0F;
//        Float corporateSum = 10.0F;
//
//        //应该是累累计购买
//        Optional<Float> sumNation = Optional.ofNullable(nationalDebt.getDebtSum());
//        Optional<Float> sumCorpor = Optional.ofNullable(corporationDebt.getDebtSum());
//        Float nationPurchase = sumNation.orElse(0.0F);
//        Float corporPurchase = sumCorpor.orElse(0.0F);
//
//        //入库存储
//        mapper.updateSumPurchaseByName(nationPurchase+nationalSum,nationalDebtName);
//        mapper.updateSumPurchaseByName(corporPurchase+corporateSum,corporationDebtName);
//        //调用函数3
//        Float fee = getHandlingFee(amount,purchaseSign,isFirstPurchase,platform.getHandlingFee());
//
//        //调用函数4
////        selfRecord(userId,nationalVaryAmount,corporateVaryAmount,purchaseSign,fee);
//    }

//    /**
//     * @Author jyh
//     * @Description //用户首次购买时/调仓调用手续费
//     * 函数3
//     * @Date 18:31 2019/8/28
//     * @Param
//     * @return
//     **/
//    public Float getHandlingFee(Float amount,Integer purchaseSign,Integer isFirstPurchase,Float handlingRate){
//        BondFoundationPO nationalDebt = mapper.selectBondFundByName(nationalDebtName);
//        BondPlatformPO platform = mapper.selectBondPlatform();
//        //TODO 连函数3
//        Float handlingFee = 0.0F;
//        Float sum = 0.0F;
//        //TODO 连交易记录
//
//
//        mapper.updateRestProperty(sum);
//        //返回手续费
//        return handlingFee;
//    }
//
//    /**
//     * @Author jyh
//     * @Description //
//     *
//     * 函数4
//     * @Date 20:36 2019/8/29
//     * @Param
//     * @return
//     **/
//    public void selfRecord(Long userId ,Float nationalFund,Float corporateFund,Integer sign,Float rate){
//        Date time = new Date();
//        //TODO 接函数4
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
//        orderService.addPersonalTradeRecord(vo,false);
//
//    }


    /**
     * @Author jyh
     * @Description //平台每日更新时调用
     * 函数5
     * @Date 10:25 2019/8/29
     * @Param []
     * @return void
     **/
//    public void updatePrice(){
//        List<BondPO> bonds = mapper.selectAllBond();
//        for(int i = 0;i<bonds.size();i++){
//            //TODO 接函数5
//            Float value = 30.0F;
//            mapper.updateBondPrice(value,bonds.get(i).getId());
//        }
//    }

    /**
     * @Author jyh
     * @Description //平台每日购买时调用
     * 函数6
     * @Date 10:30 2019/8/29
     * @Param
     * @return
     **/
//    public void platformTransaction(){
//        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
//        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
//        List<BondAndFundPO> nationalBafs = mapper.selectAllBondAndFund(national.getId());
//        List<BondAndFundPO> corporationBafs = mapper.selectAllBondAndFund(corporation.getId());
//        //计算持有金额
//        BondAndFundPO[] nationalBAFs = nationalBafs.toArray(new BondAndFundPO[nationalBafs.size()]);
//        BondAndFundPO[] corporationBAFs = corporationBafs.toArray(new BondAndFundPO[corporationBafs.size()]);
//        for(int i = 0 ; i<nationalBAFs.length;i++){
//            BondAndFundPO po = nationalBAFs[i];
//            po.setAmount(po.getQuantity()*po.getPrice());
//            nationalBAFs[i] = po;
//        }
//        for(int i = 0 ; i<corporationBAFs.length;i++){
//            BondAndFundPO po = corporationBAFs[i];
//            po.setAmount(po.getQuantity()*po.getPrice());
//            nationalBAFs[i] = po;
//        }
//        //TODO 接函数6
//
//        Float restFee = 20.4F;
//        Float bondFee = 40.2F;
//        List<String> res =new ArrayList<>();
//        mapper.updateBondPlatform(restFee,bondFee);
//
//        mapper.deleteBondAndFund(national.getId());
//        //对每个新的基金进行插入
//        res.stream().forEach(o->{
//            mapper.insertBondAndFund(1L,1L,0.0F,0.0F);
//        });
//
//        mapper.deletePurchaseRecord();
//
//    }
    /**
     * @Author jyh
     * @Description //
     * 函数7
     * @Date 12:52 2019/8/30
     * @Param
     * @return
     **/
//    public void platFormTransation(){
//        //TODO 接函数7 函数有点奇怪啊
//        PlatformTradePO po = new PlatformTradePO();
//        po.setTotal(0.0F);
//        po.setTime(new Date());
//        po.setProduct("///神秘玩意");
//        PlatformTradeVO vo = new PlatformTradeVO(po);
//
//        orderService.addPlatfromTradeRecord(vo);
//    }
    /**
     * @Author jyh
     * @Description //单位净值计算
     * 函数8
     * @Date 13:58 2019/8/29
     * @Param
     * @return
     **/
//    public void netWorthy(){
//        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
//        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
//
//        //TODO 接函数8
//        Float nationalPrice = 0.0F;
//        Float corporationPrice = 0.0F;
//        //更新单位净值
//        mapper.updateBondFundNetWorthy(nationalPrice,nationalDebtName);
//        mapper.updateBondFundNetWorthy(corporationPrice,corporationDebtName);
//    }

    /**
     * @Author jyh
     * @Description //基金规模调整
     * 函数9
     * @Date 14:36 2019/8/29
     * @Param
     * @return
     **/
//    public void fundScale(){
//        //获取所有债权
//        List<BondPO> bonds = mapper.selectAllBond();
//        //获取两组基金
//        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
//        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
//        //获取基金对应的债券
//        List<BondAndFundPO> nationalBondAndFunds = mapper.selectAllBondAndFund(national.getId());
//        List<BondAndFundPO> corporateBondAndFund = mapper.selectAllBondAndFund(corporation.getId());
//        //更新债券资产
//        Float natScale = 0.0F;
//        Float corScale = 0.0F;
//        for (int i =0 ;i<nationalBondAndFunds.size();i++){
//            for(int j = 0;j < bonds.size();j++){
//                if(nationalBondAndFunds.get(i).getBondCode().equals(bonds.get(i).getCode())){
//                    natScale += nationalBondAndFunds.get(i).getAmount()*nationalBondAndFunds.get(i).getPrice();
//                    break;
//                }
//            }
//        }
//        for (int i =0 ;i<corporateBondAndFund.size();i++){
//            for(int j = 0;j < bonds.size();j++){
//                if(corporateBondAndFund.get(i).getBondCode().equals(bonds.get(i).getCode())){
//                    corScale += corporateBondAndFund.get(i).getAmount()*corporateBondAndFund.get(i).getPrice();
//                    break;
//                }
//            }
//        }
//        //TODO 接函数9
//        mapper.updateFundScale(natScale,nationalDebtName);
//        mapper.updateFundScale(corScale,corporationDebtName);
//
//    }

    /**
     * @Author jyh
     * @Description //函数10
     * @Date 16:44 2019/8/29
     * @Param
     * @return
     **/
//    public void shareUpdate(){
//        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
//        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
//        //TODO 接杨日东部分和py10
//        Float quantity = 0.0F;
//        Float totalQuantity = 0.0F;
//        //更新用户持有的数据，需要做个List
//        mapper.updateUserShare(1L,nationalDebtName,quantity);
//        mapper.updateUserShare(1L,corporationDebtName,quantity);
//
//        //更新总份额
//        mapper.updateTotalShare(nationalDebtName,totalQuantity);
//    }

    /**
     * @Author jyh
     * @Description //函数11
     * @Date 16:46 2019/8/29
     * @Param []
     * @return void
     **/
//    public void getPlatformRate(){
//        BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);
//        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);
//        //TODO 接函数11
//        Float seven = 0.0F;
//        Float thirty = 0.0F;
//        Float ninety = 0.0F;
//        mapper.updateReturnRate(seven,thirty,ninety);
//    }

    /**
     * @Author jyh
     * @Description //指数维护后操作
     * 13
     * @Date 16:48 2019/8/29
     * @Param
    **/
//    public void exponentAdjust(){
//        BondFoundationPO foundation = mapper.selectBondFundByName("指数基金");
//        List<BondAndFundPO> bonds = mapper.selectAllBondAndFund(foundation.getId());
//        //TODO 接函数13
//        Float restFee = 0.0F;
//        Float bondFee = 0.0F;
//        List<String> res =new ArrayList<>();
//        mapper.updateBondPlatform(restFee,bondFee);
//
//        mapper.deleteBondAndFund(1L);
//        //对每个新的基金进行插入
//        res.stream().forEach(o->{
//            mapper.insertBondAndFund(1L,1L,0.0F,0.0F);
//        });
//    }

