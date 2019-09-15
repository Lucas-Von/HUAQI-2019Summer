package financial_management.service.product.gold;

import financial_management.bl.order.OrderService;
import financial_management.bl.product.FundService;
import financial_management.bl.product.GoldService;
import financial_management.data.product.GoldMapper;
import financial_management.entity.GoldHistoryConfigPO;
import financial_management.entity.MyGoldPO;
import financial_management.service.order.impl.OrderServiceImpl;
import financial_management.service.product.FundServiceImpl;
import financial_management.service.property.income.IncomeServiceForBl;
import financial_management.service.user.UserServiceForBl;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.GoldConfigParam;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyResponse.GoldConfigResponse;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.product.GoldHistoryConfigVO;
import financial_management.vo.product.MyGoldVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/30
 */
@Service
public class GoldServiceImpl implements GoldService, GoldServiceForBl {
    @Autowired
    private GoldMapper goldMapper;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private IncomeServiceForBl incomeServiceForBl;

    @Autowired
    private UserServiceForBl userServiceForBl;

    @Autowired
    private FundService fundService;

    @Override
    public BasicResponse buyGold(Double money, Long userId){
        try {
            int account_already_deployed = 0;
            double diff_already_deployed = 0;
            double money_expected_deployed = money;
            if (goldMapper.ifExistSelfGold(userId)) {
                List<MyGoldPO> myGoldPOS = goldMapper.selectSelfGold(userId);
                MyGoldPO myGoldPO = myGoldPOS.get(0);
                account_already_deployed += myGoldPO.getAmount();
                diff_already_deployed += myGoldPO.getDiff();
                money_expected_deployed =  money_expected_deployed + myGoldPO.getSum() +  myGoldPO.getDiff();
            }
            PyParam pyParam = new GoldConfigParam(account_already_deployed, diff_already_deployed, money_expected_deployed);
            List<Object> invokeResult = PyInvoke.invoke(PyFunc.GOLD_INVEST, pyParam, GoldConfigResponse.class);
            List<GoldConfigResponse> list = new ArrayList<>();
            for (Object object : invokeResult) {
                list.add((GoldConfigResponse) object);
            }
            if (list.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
            }

            GoldConfigResponse goldConfigResponse = list.get(0);
            double nowPrice = goldConfigResponse.getPrice2deploy();
            int nowAmount = goldConfigResponse.getAccount2deployed();
            double nowSum = goldConfigResponse.getMoney2deployed();
            int allAmount = goldConfigResponse.getAccounet_all_deployed();
            double allSum = goldConfigResponse.getMoney_all_deployed();
            double diff = goldConfigResponse.getDiff_all_deployed();

            // 增新一条黄金历史配置信息
            GoldHistoryConfigPO goldHistoryConfigPO = new GoldHistoryConfigPO();
            goldHistoryConfigPO.setUserId(userId);
            goldHistoryConfigPO.setPrice(nowPrice);
            goldHistoryConfigPO.setAmount(nowAmount);
            goldHistoryConfigPO.setSum(nowSum);
            goldHistoryConfigPO.setStatus(0);
            goldMapper.insertGoldHistoryConfig(goldHistoryConfigPO);

            // 更新用户当前黄金配置
            MyGoldPO myGoldPO = new MyGoldPO();
            myGoldPO.setUserId(userId);
            myGoldPO.setAmount(allAmount);
            myGoldPO.setDiff(diff);
            myGoldPO.setSum(allSum);
            if (goldMapper.ifExistSelfGold(userId)) {
                goldMapper.updateSelfGold(myGoldPO);
            } else {
                goldMapper.insertSelfGold(myGoldPO);
            }

            // 新增一条交易记录
            ProductVO4Order productVO4Order = new ProductVO4Order();
            productVO4Order.setpID(1L);
            productVO4Order.setName("华安黄金易ETF");
            productVO4Order.setCode("518880");
            PersonalTradeVO personalTradeVO = new PersonalTradeVO();
            personalTradeVO.setTransID(1L);
            personalTradeVO.setCreateTime(new Date());
            personalTradeVO.setCompleteTime(new Date());
            personalTradeVO.setType(OrderService.Type.GOLD);
            personalTradeVO.setProduct(productVO4Order);
            personalTradeVO.setAmount(nowAmount);
            personalTradeVO.setPrice((float) nowPrice);
            personalTradeVO.setFee(0);
            personalTradeVO.setTotal((float) nowSum);
            personalTradeVO.setUserID(userId);
            orderService.addPersonalTradeRecord(personalTradeVO, true);

            fundService.DecreaseCapital(userId,money);

            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse sellGold(Double money, Long userId){
        try {
            int account_already_deployed = 0;
            double diff_already_deployed = 0;
            double money_expected_deployed = money;
            if (goldMapper.ifExistSelfGold(userId)) {
                List<MyGoldPO> myGoldPOS = goldMapper.selectSelfGold(userId);
                MyGoldPO myGoldPO = myGoldPOS.get(0);
                account_already_deployed += myGoldPO.getAmount();
                diff_already_deployed += myGoldPO.getDiff();
                if (money <= myGoldPO.getSum() + myGoldPO.getDiff()) {
                    money_expected_deployed = myGoldPO.getSum() + myGoldPO.getDiff() - money_expected_deployed;
                } else {
                    return new BasicResponse(ResponseStatus.STATUS_GOLD_NOT_ENOUGH);
                }
            } else {
                return new BasicResponse(ResponseStatus.STATUS_GOLD_NOT_ENOUGH);
            }
            PyParam pyParam = new GoldConfigParam(account_already_deployed, diff_already_deployed, money_expected_deployed);
            List<Object> invokeResult = PyInvoke.invoke(PyFunc.GOLD_INVEST, pyParam, GoldConfigResponse.class);
            List<GoldConfigResponse> list = new ArrayList<>();
            for (Object object : invokeResult) {
                list.add((GoldConfigResponse) object);
            }
            if (list.size() == 0) {
                return new BasicResponse(ResponseStatus.STATUS_TRANSACTION_WRONG);
            }

            GoldConfigResponse goldConfigResponse = list.get(0);
            double nowPrice = goldConfigResponse.getPrice2deploy();
            int nowAmount = goldConfigResponse.getAccount2deployed();
            double nowSum = goldConfigResponse.getMoney2deployed();
            int allAmount = goldConfigResponse.getAccounet_all_deployed();
            double allSum = goldConfigResponse.getMoney_all_deployed();
            double diff = goldConfigResponse.getDiff_all_deployed();

            // 增新一条黄金历史配置信息
            GoldHistoryConfigPO goldHistoryConfigPO = new GoldHistoryConfigPO();
            goldHistoryConfigPO.setUserId(userId);
            goldHistoryConfigPO.setPrice(nowPrice);
            goldHistoryConfigPO.setAmount(nowAmount);
            goldHistoryConfigPO.setSum(nowSum);
            goldHistoryConfigPO.setStatus(0);
            goldMapper.insertGoldHistoryConfig(goldHistoryConfigPO);

            // 更新用户当前黄金配置
            MyGoldPO myGoldPO = new MyGoldPO();
            myGoldPO.setUserId(userId);
            myGoldPO.setAmount(allAmount);
            myGoldPO.setDiff(diff);
            myGoldPO.setSum(allSum);
            if (goldMapper.ifExistSelfGold(userId)) {
                goldMapper.updateSelfGold(myGoldPO);
            } else {
                goldMapper.insertSelfGold(myGoldPO);
            }

            // 新增一条交易记录
            ProductVO4Order productVO4Order = new ProductVO4Order();
            productVO4Order.setpID(1L);
            productVO4Order.setName("华安黄金易ETF");
            productVO4Order.setCode("518880");
            PersonalTradeVO personalTradeVO = new PersonalTradeVO();
            personalTradeVO.setTransID(1L);
            personalTradeVO.setCreateTime(new Date());
            personalTradeVO.setCompleteTime(new Date());
            personalTradeVO.setType(OrderService.Type.GOLD);
            personalTradeVO.setProduct(productVO4Order);
            personalTradeVO.setAmount(-nowAmount);
            personalTradeVO.setPrice((float) nowPrice);
            personalTradeVO.setFee(0);
            personalTradeVO.setTotal((float) nowSum);
            personalTradeVO.setUserID(userId);
            orderService.addPersonalTradeRecord(personalTradeVO, true);

            fundService.IncreaseCapital(userId,money);

            return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getHistoryConfig(Long userId){
        try {
            List<GoldHistoryConfigPO> goldHistoryConfigPOS = goldMapper.selectGoldHistoryConfig(userId);
            List<GoldHistoryConfigVO> goldHistoryConfigVOS = new ArrayList<>();
            for (int i = 0; i < goldHistoryConfigPOS.size(); i++) {
                GoldHistoryConfigPO goldHistoryConfigPO = goldHistoryConfigPOS.get(i);
                goldHistoryConfigVOS.add(goldHistoryConfigPO.getGoldHistoryConfigVO());
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, goldHistoryConfigVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public BasicResponse getNowConfig(Long userId){
        try {
            if (goldMapper.ifExistSelfGold(userId)) {
                List<MyGoldPO> myGoldPOS = goldMapper.selectSelfGold(userId);
                List<MyGoldVO> myGoldVOS = new ArrayList<>();
                for (int i = 0; i < myGoldPOS.size(); i++) {
                    MyGoldPO myGoldPO = myGoldPOS.get(i);
                    myGoldVOS.add(myGoldPO.getMyGoldVO());
                }
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, myGoldVOS);
            } else {
                return new BasicResponse(ResponseStatus.STATUS_GOLD_NOT_CONFIG);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse(ResponseStatus.SERVER_ERROR);
        }
    }

    @Override
    public double getTotalGoldByUser(Long userId){
        if(goldMapper.ifExistSelfGold(userId)) {
            List<MyGoldPO> myGoldPOList = goldMapper.selectSelfGold(userId);
            double total = 0;
            for(int i=0;i<myGoldPOList.size();i++){
                total = total + myGoldPOList.get(i).getSum();
            }
            return total;
        }else {
            return 0;
        }
    }

    @Override
    public void updateProfit(){
        try {
            List<Long> userIds = userServiceForBl.getUserIdList();
            for (int i = 0; i < userIds.size(); i++) {
                Long userId = userIds.get(i);
                double profit = incomeServiceForBl.getTotalGoldIncome(userId);
                goldMapper.updateGoldProfit(userId, profit);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}