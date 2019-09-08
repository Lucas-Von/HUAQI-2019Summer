package financial_management.service.product.bond;

import financial_management.bl.order.OrderService;
import financial_management.data.product.BondFundMapper;
import financial_management.entity.bond.*;
import financial_management.util.PyInvoke.PyParam.bond.*;
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
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/3 22:04
 * @Version 1.0
 **/
public interface BondServiceForBl {
    Double getAmountByUser(Long userId);

    /**
     * @Description 债券部分逻辑更新
     * @Author 233loser
     * @Date 2019/8/28 15:01
     * @Version 1.0
     **/
    @Service
    class BondSeriveImpl implements BondServiceForBl {

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
}
