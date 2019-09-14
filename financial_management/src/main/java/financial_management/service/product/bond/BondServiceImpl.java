package financial_management.service.product.bond;

import financial_management.bl.order.OrderService;
import financial_management.bl.product.BondService;
import financial_management.data.product.BondFundMapper;
import financial_management.entity.bond.*;
import financial_management.entity.insurance.BondObj;
import financial_management.parameter.bond.ReturnRateVO;
import financial_management.parameter.bond.bondFundInfoVO;
import financial_management.service.property.income.IncomeServiceForBl;
import financial_management.util.DateConverterUtil;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyParam.bond.*;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.PlatformTradeVO;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.product.BondFundInfoVO;
import financial_management.vo.product.UserBondVO;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
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
class BondServiceImpl implements BondServiceForBl, BondService {
    String filePath = "D:\\学习资料\\大二下\\花旗杯\\py\\";

    @Qualifier("orderServiceImpl")
    @Autowired
    OrderService orderService;

    @Autowired
    IncomeServiceForBl incomeServiceForBl;

    @Autowired
    BondFundMapper mapper;

    //TODO 是否需要修改名称
    String nationalDebtName = "national";
    String corporationDebtName = "corporate";

    @Override
    public Double getAmountByUser(Long userId) {
        UserBondPO national = mapper.selectUserBond(userId, nationalDebtName);
        UserBondPO corpor = mapper.selectUserBond(userId, corporationDebtName);

        BondFoundationPO nationalFund = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporateFund = mapper.selectBondFundByName(corporationDebtName);

        return (nationalFund.getFundUnitValue().doubleValue() * national.getFundShare().doubleValue() + corporateFund.getFundUnitValue().doubleValue() * corpor.getFundShare().doubleValue());
    }

    //方法一：用户首次购买
    public boolean firstPurchase(Long userId, Double expectRate, Float amount) {

        try {
            BondFoundationPO national = mapper.selectBondFundByName(nationalDebtName);

        BondFoundationPO corporate = mapper.selectBondFundByName(corporationDebtName);

        //国债累计购买
        Optional<Float> nationalPurchase = Optional.ofNullable(national.getDebtSum());
        Float natSum = nationalPurchase.orElse(0.0F);
        //企业债累计购买
        Optional<Float> corPurchase = Optional.ofNullable(corporate.getDebtSum());
        Float corporSum = corPurchase.orElse(0.0F);

        //收益率如何更新?每日更新

        List<Float> res = mapper.selectRateList().getList();
        BondPlatformPO platform = mapper.selectBondPlatform();


        PyParam pyParam = new First_PurchaseVO(expectRate.floatValue(), national.getExpectReturnRate(), corporate.getExpectReturnRate(), amount, national.getDebtSum(), corporate.getDebtSum(), res, platform.getResidualAssets());
        if (corporate.getExpectReturnRate().equals(national.getExpectReturnRate())) {
            pyParam = new First_PurchaseVO(expectRate.floatValue(), national.getExpectReturnRate() + 0.001f, corporate.getExpectReturnRate() - 0.001f, amount, national.getDebtSum(), corporate.getDebtSum(), res, platform.getResidualAssets());
        }


        List<Object> invokeResult = PyInvoke.invoke(PyFunc.BOND_FIRST_PURCHASE, pyParam, First_PurchasePO.class);
        List<First_PurchasePO> list = new ArrayList<>();
        for (Object object : invokeResult) {
            list.add((First_PurchasePO) object);
        }
        System.out.println(list.size());
        First_PurchasePO po = list.get(0);
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
        productNational.setpID(-1l);
        productNational.setCode("");
        tradeRecord_Nation.setTotal(po.getAmountchange_national());
        productNational.setName(nationalDebtName);
        tradeRecord_Nation.setProduct(productNational);
        tradeRecord_Nation.setCreateTime(po.getTrans_time());
        tradeRecord_Nation.setUserID(userId);
        tradeRecord_Nation.setFee(po.getCommission_amount_national());
        tradeRecord_Nation.setType(OrderService.Type.BOND);
        //0是卖 1是买
        tradeRecord_Nation.setAmount(po.getAmountchange_national());
        tradeRecord_Nation.setStatus(-1);
        tradeRecord_Nation.setTotal(po.getSign() == 0 ? -po.getAmountchange_national() : po.getAmountchange_national());
        orderService.addPersonalTradeRecord(tradeRecord_Nation, false);

        //组成企业债购买记录
        PersonalTradeVO tradeRecord_Corpor = new PersonalTradeVO();
        ProductVO4Order productVO4Order = new ProductVO4Order();
        productVO4Order.setName(corporationDebtName);
        productVO4Order.setpID(-1l);
        productVO4Order.setCode("");
        tradeRecord_Corpor.setTotal(po.getAmountchange_corporate());
        tradeRecord_Corpor.setAmount(po.getAmountchange_corporate());
        tradeRecord_Corpor.setProduct(productVO4Order);
        tradeRecord_Corpor.setCreateTime(po.getTrans_time());
        tradeRecord_Corpor.setUserID(userId);
        tradeRecord_Corpor.setFee(po.getCommission_amount_corporate());
        tradeRecord_Corpor.setType(OrderService.Type.BOND);
        tradeRecord_Corpor.setStatus(-1);
        //0是卖 1是买
        tradeRecord_Corpor.setTotal(po.getSign() == 0 ? -po.getAmountchange_corporate() : po.getAmountchange_corporate());
        orderService.addPersonalTradeRecord(tradeRecord_Corpor, false);

        //更新用户持有的份额
        mapper.updateUserFundShare(userId, po.getAmountchange_national(), nationalDebtName);
        mapper.updateUserFundShare(userId, po.getAmountchange_corporate(), corporationDebtName);
        mapper.updateUserInject(userId, po.getAmountchange_national().floatValue(), nationalDebtName);
        mapper.updateUserInject(userId, po.getAmountchange_corporate().floatValue(), nationalDebtName);
        return true;
    }catch (Exception e){
            return false;
        }

}

    //方法二：用户调仓
    public BasicResponse adjustWarehouse(Long userId, Float amount) {
        try {
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

            PyParam pyParam = new AdjuestmentVO(national.getBondProportion().floatValue(), corporation.getBondProportion().floatValue(), amount, nationalDebt.getDebtSum(), corporationDebt.getDebtSum(), res, platformPO.getResidualAssets());
            List<Object> invokeResult = PyInvoke.invoke(PyFunc.BOND_ADJUSTMENT, pyParam, AdjuestmentPO.class);
            List<AdjuestmentPO> list = new ArrayList<>();
            for (Object object : invokeResult) {
                list.add((AdjuestmentPO) object);
            }
            System.out.println(list.size());
            AdjuestmentPO po = list.get(0);
            //调整总份额
            Optional<Float> sumNation = Optional.ofNullable(nationalDebt.getDebtSum());
            Optional<Float> sumCorpor = Optional.ofNullable(corporationDebt.getDebtSum());
            Float nationPurchase = sumNation.orElse(0.0F);
            Float corporPurchase = sumCorpor.orElse(0.0F);


            //组成国债交易记录
            PersonalTradeVO tradeRecord_Nation = new PersonalTradeVO();
            //设置基金名
            ProductVO4Order productNational = new ProductVO4Order();
            productNational.setpID(-1l);
            productNational.setCode("");
            productNational.setName(nationalDebtName);
            tradeRecord_Nation.setProduct(productNational);
            tradeRecord_Nation.setCreateTime(po.getTrans_time());
            tradeRecord_Nation.setUserID(userId);
            tradeRecord_Nation.setFee(po.getCommission_amount_national());
            tradeRecord_Nation.setType(OrderService.Type.BOND);
            tradeRecord_Nation.setStatus(-1);
            //0是卖 1是买
            tradeRecord_Nation.setTotal(po.getAmountchange_national());
            tradeRecord_Nation.setAmount(po.getAmountchange_national());
            orderService.addPersonalTradeRecord(tradeRecord_Nation, false);

            //组成企业债购买记录
            PersonalTradeVO tradeRecord_Corpor = new PersonalTradeVO();
            //我只要设置基金名字 我不管是什么
            ProductVO4Order productVO4Order = new ProductVO4Order();
            productVO4Order.setName(corporationDebtName);
            productVO4Order.setCode("");
            productVO4Order.setpID(-1L);
            tradeRecord_Corpor.setProduct(productVO4Order);

            tradeRecord_Corpor.setCreateTime(po.getTrans_time());
            tradeRecord_Corpor.setUserID(userId);
            tradeRecord_Corpor.setFee(po.getCommission_amount_corporate());
            tradeRecord_Corpor.setType(OrderService.Type.BOND);
            //0是卖 1是买
            tradeRecord_Corpor.setStatus(-1);
            tradeRecord_Corpor.setTotal(po.getAmountchange_corporate());
            tradeRecord_Corpor.setAmount(po.getAmountchange_corporate());
            orderService.addPersonalTradeRecord(tradeRecord_Corpor, false);

            //更新用户持有的份额
            Float nationShare = mapper.selectUserBond(userId, nationalDebtName).getFundShare();
            Float corporShare = mapper.selectUserBond(userId, corporationDebtName).getFundShare();
            nationShare += nationalDebt.getDebtSum() - po.getPlatform_accelerate_national();
            corporShare += corporationDebt.getDebtSum() - po.getAmountchange_corporate();
            mapper.updateUserFundShare(userId, nationShare, nationalDebtName);
            mapper.updateUserFundShare(userId, corporShare, corporationDebtName);

            mapper.updateSumPurchaseByName(po.getPlatform_accelerate_national(), nationalDebtName);
            mapper.updateSumPurchaseByName(po.getPlatform_accelerate_corporate(), corporationDebtName);

            mapper.updateUserInject(userId, national.getInject() + po.getAmountchange_national().floatValue(), nationalDebtName);
            mapper.updateUserInject(userId, corporation.getInject() + po.getAmountchange_corporate().floatValue(), corporationDebtName);

            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,null);
        } catch (Exception e){
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR,null);
        }
    }

    //方法三：平台每日购买
    public void dailyPurchase() {

        //设置资产和剩余现金资产
        BondPlatformPO platform = mapper.selectBondPlatform();
        List<Float> res = mapper.selectRateList().getList();

        //设置购买份额
        BondFoundationPO nation = mapper.selectBondFundByName(nationalDebtName);
        BondFoundationPO corporation = mapper.selectBondFundByName(corporationDebtName);


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
            info.setProduct(corporationDebtName);
            info.setProportion(o.getInvestProportion());
            corporBondsInfo.add(info);
        });

        PyParam pyParam = new Daily_PurchaseVO(platform.getResidualAssets(),platform.getBondAssets(),nation.getDebtSum(),corporation.getDebtSum(),nationBondsInfo,corporBondsInfo);

        List<Object> invokeResult = PyInvoke.invoke(PyFunc.BOND_DAILY_PURCHASE, pyParam,DailyPurchasePO.class);
        List<DailyPurchasePO> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((DailyPurchasePO) object);
        }
        System.out.println(list.size());

        DailyPurchasePO po =list.get(0);
        //先更新数据库里的债券信息
        List<NewBond> bondsNational = po.getPrice_list_national();
        List<NewBond> bondsCorporate = po.getPrice_list_corporate();
        for (int j = 0; j < bondsNational.size(); j++) {
            //原本没有这个债券
            if (mapper.selectBondByCode(bondsNational.get(j).getCode()) == null) {
                mapper.insertBond(bondsNational.get(j).getCode(), bondsNational.get(j).getPrice());
            } else {
                //更新价格
                mapper.updateBondPriceByCode(bondsNational.get(j).getCode(), bondsNational.get(j).getPrice());
            }
        }
        for (int j = 0; j < bondsCorporate.size(); j++) {
            //原本没有这个债券
            if (mapper.selectBondByCode(bondsCorporate.get(j).getCode()) == null) {
                mapper.insertBond(bondsCorporate.get(j).getCode(), bondsCorporate.get(j).getPrice());
            } else {
                //更新价格
                mapper.updateBondPriceByCode(bondsCorporate.get(j).getCode(), bondsCorporate.get(j).getPrice());
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
            record.setAmount(o.getPurchase_quantity());
            record.setProduct(corporationDebtName+","+o.getCode());
            record.setTime(o.getTime());
            record.setPrice(-1F);
            record.setStatus(-1);
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
            record.setAmount(o.getPurchase_quantity());
            record.setProduct(nationalDebtName+","+o.getCode());
            record.setTime(o.getTime());
            record.setPrice(-1F);
            record.setStatus(-1);
            orderService.addPlatformTradeRecord(record);
        });

        //用户个人信息
        List<PersonalTradeVO> tradelist = orderService.getTodaysPersonalTradeRecord(OrderService.Type.BOND).getData();
        Float nationalShare = nation.getFundShare();
        Float corporateShare = corporation.getFundShare();
        for (int i = 0; i < tradelist.size(); i++) {
            PersonalTradeVO o = tradelist.get(i);
            //如果不成功找东哥问问
            String fundName = o.getProduct().getName();
            BondFoundationPO fund = mapper.selectBondFundByName(fundName);
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

        //更新单位净值


        //更新收益率，方便的出7/30/90
        if(national.getFundShare()!=0){
            mapper.updateBondFundNetWorthy(sumNational / national.getFundShare(), nationalDebtName);
            mapper.insertRateLog(national.getId(), sumNational / national.getFundShare(), new Date());
        }
        else {
            mapper.updateBondFundNetWorthy(sumNational , nationalDebtName);
            mapper.insertRateLog(national.getId(), sumNational , new Date());
        }
        if(corporate.getFundShare()!=0) {
            mapper.updateBondFundNetWorthy(sumCorporate / corporate.getFundShare(), corporationDebtName);
            mapper.insertRateLog(corporate.getId(), sumCorporate / corporate.getFundShare(), new Date());
        }
        else {
            mapper.updateBondFundNetWorthy(sumCorporate , corporationDebtName);
            mapper.insertRateLog(corporate.getId(), sumCorporate , new Date());
        }
        mapper.updateTime(new Date());
    }

    //    //方法五：指数维护
    public BasicResponse exponent(String fundName) {

        try {
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
                info.setProduct(corporationDebtName);
                info.setProportion(o.getInvestProportion());
                info.setQuantity(o.getQuantity().intValue());
                bondsInfoCorporation.add(info);
            });


            BondPlatformPO platform = mapper.selectBondPlatform();
            //初始化新的债券组合
            List<BondObj> objList = resetFund();
            List<NewFundInfo> newFundInfo = new ArrayList<>();
            int sign = 0;
            String finName;
            if (fundName.equals("national")) {
                mapper.deleteBondAndFund(fund4Nation.getId());
                finName = nationalDebtName;
                objList.stream().forEach(o -> {
                    if (o.getProduct().equals("国债") || o.getProduct().equals(nationalDebtName)) {
                        NewFundInfo info = new NewFundInfo();
                        info.setCode(o.getCode());
                        info.setProduct(nationalDebtName);
                        info.setProportion(o.getRate());
                        newFundInfo.add(info);
                    }
                });
            } else {
                sign = 1;
                mapper.deleteBondAndFund(fund4Corpor.getId());
                finName = corporationDebtName;
                objList.stream().forEach(o -> {
                    if (o.getProduct().equals("企业债") || o.getProduct().equals(corporationDebtName)) {
                        NewFundInfo info = new NewFundInfo();
                        info.setCode(o.getCode());
                        info.setProduct(corporationDebtName);
                        info.setProportion(o.getRate());
                        newFundInfo.add(info);
                    }
                });
            }


            PyParam pyParam = new IndexVO(finName, platform.getResidualAssets(), platform.getBondAssets(), bondsInfoNation, bondsInfoCorporation, fund4Nation.getFundScale(), fund4Corpor.getFundScale(), newFundInfo);
            List<Object> invokeResult = PyInvoke.invoke(PyFunc.BOND_INDEX_MAINTENANCE, pyParam, IndexPO.class);
            List<IndexPO> list = new ArrayList<>();
            for (Object object : invokeResult) {
                list.add((IndexPO) object);
            }
            System.out.println(list.size());

            IndexPO po = list.get(0);

            List<BondsInfo> infos = po.getNew_fund_info();
            long fundId = sign == 0 ? fund4Nation.getId() : fund4Corpor.getId();
            for (int i = 0; i < infos.size(); i++) {
                BondsInfo o = infos.get(i);
                long id = getBondId(o.getCode());
                if (id == -1) {
                    mapper.insertBond(o.getCode(), o.getAmount() / o.getQuantity());
                    id = getBondId(o.getCode());
                }

                mapper.insertBondAndFund(fundId, id, o.getProportion(), o.getQuantity().floatValue());
            }
            ;
            //更新债券资产和剩余现金
            mapper.updateBondPlatform(po.getFund_cash(), po.getFund_bonds());
            //更新交易记录
            for (int i = 0; i < po.getTrans_record().size(); i++) {
                TransPO o = po.getTrans_record().get(i);
                PlatformTradeVO trade = new PlatformTradeVO();
                trade.setTotal(o.getPurchase_amount());
                trade.setRealTotal(o.getPurchase_amount());
                trade.setTime(o.getTime());
                trade.setProduct(((IndexVO) pyParam).getProduct_name() + "," + o.getCode());
                trade.setAmount(o.getPurchase_quantity());
                trade.setStatus(-1);
                trade.setPrice(-1F);
                orderService.addPlatformTradeRecord(trade);
                dailyUpdate();
                mapper.updateTime(new Date());
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,null);
        }
        catch (Exception e){
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR,null);
        }
    }

    @Override
    public BasicResponse getFundInfo(String name) {
        BondFoundationPO foundation  = mapper.selectBondFundByName(name);
        List<NetWorthPO> worthList = mapper.getRateLogs(foundation.getId());
        List<BondAndFundPO> fundBonds = mapper.selectAllBondAndFund(foundation.getId());
        List<PlatformTradeVO> trades = orderService.getAllPlatformTradeRecord().getData();
        BondPlatformPO platform = mapper.selectBondPlatform();

        List<PlatformTradeVO> tradeList = new ArrayList<>();
        for(int i = 0;i<trades.size();i++){
            PlatformTradeVO vo = trades.get(i);
            vo.setProduct(vo.getProduct().split(",")[1]);
            tradeList.add(vo);
        }


        BondFundInfoVO vo = new BondFundInfoVO();
        vo.setTime(foundation.getUpdateTime());
        if(name.equals(nationalDebtName)){
            vo.setExponent("中证国债");
        }
        else{
            vo.setExponent("中证企业");
        }
        vo.setList(fundBonds);
        vo.setBondAmount(foundation.getFundScale());
        vo.setFundShare(foundation.getFundShare());
        vo.setFundScale(foundation.getFundScale()+platform.getResidualAssets());
        vo.setCashAmount(platform.getResidualAssets());
        vo.setNetWorths(worthList);
        vo.setTrades(tradeList);
        vo.setRateList(mapper.selectRateList().getList());
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vo);
    }

    public List<BondObj> resetFund() {
        String filePath = this.filePath;
        String fileName = "维护数据格式.xlsx";
        List<BondObj> list = new ArrayList<BondObj>();
        try {
            InputStream inputStream = new FileInputStream(new File(filePath + fileName));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i ++){
                Row row = sheet.getRow(i);
                row.getCell(0).setCellType(CellType.STRING);
                row.getCell(1).setCellType(CellType.STRING);
                row.getCell(2).setCellType(CellType.STRING);
                String product = row.getCell(0).getStringCellValue();
                String code = row.getCell(1).getStringCellValue();
                float rate = Float.parseFloat(row.getCell(2).getStringCellValue());
                BondObj bondObj = new BondObj(product, code, rate);
                list.add(bondObj);
            }
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long getBondId(String code){
        List<BondPO> bonds = mapper.selectAllBond();
        for (int i =0;i<bonds.size();i++){
            if (bonds.get(i).getCode().equals(code)){
                return bonds.get(i).getId();
            }
        }
        return -1;
    }

    @Override
    public BasicResponse userInfo(Long info){
        UserBondPO userNational=  mapper.selectUserBond(info,nationalDebtName);
        UserBondPO userCorporate = mapper.selectUserBond(info,corporationDebtName);
        List<UserBondVO> vo = new ArrayList<>();
        UserBondVO nation = new UserBondVO();
        nation.setFundName(nationalDebtName);
        nation.setPrice(userNational.getNetWorth());
        nation.setQuantity(userNational.getFundShare());
        nation.setReturnRate(userNational.getNetWorth()*userNational.getFundShare()-userNational.getInject().doubleValue());
        nation.setTotalAmount(userNational.getNetWorth()*userNational.getFundShare());
        vo.add(nation);

        UserBondVO corporation = new UserBondVO();
        corporation.setFundName(corporationDebtName);
        corporation.setPrice(userCorporate.getNetWorth());
        corporation.setQuantity(userCorporate.getFundShare());
        corporation.setReturnRate(userCorporate.getNetWorth()*userCorporate.getFundShare()-userCorporate.getInject().doubleValue());
        corporation.setTotalAmount(userCorporate.getNetWorth()*userCorporate.getFundShare());
        vo.add(corporation);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vo);
    }


    @Override
    public BasicResponse getInfo(String name) {

        List<BondsInfo> infos = new ArrayList<>();

        BondFoundationPO po = mapper.selectBondFundByName(name);
        List<BondAndFundPO> bonds = mapper.selectAllBondAndFund(po.getId());
        for(int i = 0;i<bonds.size();i++){
            BondAndFundPO bond =bonds.get(i);
            BondsInfo info = new BondsInfo();
            info.setCode(bond.getBondCode());
            try{
                info.setProduct(bond.getBondName());;
            }
            catch (Exception E){
                info.setProduct("\\\\");
            }
            info.setAmount(bond.getAmount());
            info.setProportion(bond.getInvestProportion());
            info.setQuantity(bond.getQuantity().intValue());
        }

        List<ReturnRateVO> sevenNetWorth = new ArrayList<>();
        List<ReturnRateVO> monthNetWorth = new ArrayList<>();
        List<ReturnRateVO> threeNetWorth = new ArrayList<>();
        for(int i = 0;i<7;i++) {
            double value = incomeServiceForBl.getBondProfitOfDays(po.getId(),i);
            ReturnRateVO vo = new ReturnRateVO(DateConverterUtil.moveForwardByDay(new Date(),-i),value);
            sevenNetWorth.add(vo);
        }
        for(int i = 0;i<30;i++) {
            double value = incomeServiceForBl.getBondProfitOfDays(po.getId(),i);
            ReturnRateVO vo = new ReturnRateVO(DateConverterUtil.moveForwardByDay(new Date(),-i),value);
            monthNetWorth.add(vo);
        }
        for(int i = 0;i<90;i++) {
            double value = incomeServiceForBl.getBondProfitOfDays(po.getId(),i);
            ReturnRateVO vo = new ReturnRateVO(DateConverterUtil.moveForwardByDay(new Date(),-i),value);
            threeNetWorth.add(vo);
        }

        List<Double> returnRate = new ArrayList<>();
        List<Float> commissionRate = mapper.selectRateList().getList();
        if(incomeServiceForBl.getBondProfitOfDays(po.getId(),7)!=-1.0) {
            Double seven = (po.getFundUnitValue() - incomeServiceForBl.getBondProfitOfDays(po.getId(), 7))/incomeServiceForBl.getBondProfitOfDays(po.getId(),7);
            returnRate.add(seven);
        }
        else {
            returnRate.add(1.0);
        }
        if(incomeServiceForBl.getBondProfitOfDays(po.getId(),30)!=-1.0) {
            Double thirty = (po.getFundUnitValue() - incomeServiceForBl.getBondProfitOfDays(po.getId(), 30))/incomeServiceForBl.getBondProfitOfDays(po.getId(),30);
            returnRate.add(thirty);
        }
        else {
            returnRate.add(1.0);
        }
        if(incomeServiceForBl.getBondProfitOfDays(po.getId(),90)!=-1.0) {
            Double ninty = (po.getFundUnitValue() - incomeServiceForBl.getBondProfitOfDays(po.getId(), 90))/incomeServiceForBl.getBondProfitOfDays(po.getId(),90);
            returnRate.add(ninty);
        }
        else {
            returnRate.add(1.0);
        }
        bondFundInfoVO vo = new bondFundInfoVO(sevenNetWorth,monthNetWorth,threeNetWorth,returnRate,new Date(),"Fin-mily家庭资产配置平台",1200000F,"开放购买/开放赎回",commissionRate,infos);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vo);
    }
}