package financial_management.service.product;

import financial_management.bl.product.GoldService;
import financial_management.data.product.GoldMapper;
import financial_management.entity.GoldHistoryConfigPO;
import financial_management.entity.MyGoldPO;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.GoldConfigParam;
import financial_management.util.PyInvoke.PyParam.PyParam;
import financial_management.util.PyInvoke.PyResponse.GoldConfigResponse;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.product.GoldHistoryConfigVO;
import financial_management.vo.product.MyGoldVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xyh
 * @date 2019/8/30
 */
@Service
public class GoldServiceImpl implements GoldService {
    @Autowired
    private GoldMapper goldMapper;

    @Override
    public BasicResponse buyGold(Double money, Long userId){
        int account_already_deployed = 0;
        double diff_already_deployed = 0;
        double money_expected_deployed = money;
        if(goldMapper.ifExistSelfGold(userId)){
            List<MyGoldPO> myGoldPOS = goldMapper.selectSelfGold(userId);
            MyGoldPO myGoldPO = myGoldPOS.get(0);
            account_already_deployed += myGoldPO.getAmount();
            diff_already_deployed += myGoldPO.getDiff();
            money_expected_deployed += myGoldPO.getSum();
        }
        PyParam pyParam = new GoldConfigParam(account_already_deployed,diff_already_deployed,money_expected_deployed);
        List<Object> invokeResult = PyInvoke.invoke(PyFunc.GOLD_INVEST, pyParam, GoldConfigResponse.class);
        List<GoldConfigResponse> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((GoldConfigResponse) object);
        }if(list.size() == 0){
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
        if(goldMapper.ifExistSelfGold(userId)){
            goldMapper.updateSelfGold(myGoldPO);
        }else {
            goldMapper.insertSelfGold(myGoldPO);
        }

        // 新增一条交易记录


        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @Override
    public BasicResponse sellGold(Double money, Long userId){
        int account_already_deployed = 0;
        double diff_already_deployed = 0;
        double money_expected_deployed = money;
        if(goldMapper.ifExistSelfGold(userId)){
            List<MyGoldPO> myGoldPOS = goldMapper.selectSelfGold(userId);
            MyGoldPO myGoldPO = myGoldPOS.get(0);
            account_already_deployed += myGoldPO.getAmount();
            diff_already_deployed += myGoldPO.getDiff();
            if(money <= myGoldPO.getSum()) {
                money_expected_deployed = myGoldPO.getSum() - money_expected_deployed;
            }else {
                return new BasicResponse(ResponseStatus.STATUS_GOLD_NOT_ENOUGH);
            }
        }else {
            return new BasicResponse(ResponseStatus.STATUS_GOLD_NOT_ENOUGH);
        }
        PyParam pyParam = new GoldConfigParam(account_already_deployed,diff_already_deployed,money_expected_deployed);
        List<Object> invokeResult = PyInvoke.invoke(PyFunc.GOLD_INVEST, pyParam, GoldConfigResponse.class);
        List<GoldConfigResponse> list = new ArrayList<>();
        for (Object object : invokeResult){
            list.add((GoldConfigResponse) object);
        }if(list.size() == 0){
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
        if(goldMapper.ifExistSelfGold(userId)){
            goldMapper.updateSelfGold(myGoldPO);
        }else {
            goldMapper.insertSelfGold(myGoldPO);
        }

        // 新增一条交易记录


        return new BasicResponse(ResponseStatus.STATUS_SUCCESS);
    }

    @Override
    public BasicResponse getHistoryConfig(Long userId){
        List<GoldHistoryConfigPO> goldHistoryConfigPOS = goldMapper.selectGoldHistoryConfig(userId);
        List<GoldHistoryConfigVO> goldHistoryConfigVOS = new ArrayList<>();
        for(int i=0;i<goldHistoryConfigPOS.size();i++){
            GoldHistoryConfigPO goldHistoryConfigPO = goldHistoryConfigPOS.get(i);
            goldHistoryConfigVOS.add(goldHistoryConfigPO.getGoldHistoryConfigVO());
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, goldHistoryConfigVOS);
    }

    @Override
    public BasicResponse getNowConfig(Long userId){
        if(goldMapper.ifExistSelfGold(userId)) {
            List<MyGoldPO> myGoldPOS = goldMapper.selectSelfGold(userId);
            List<MyGoldVO> myGoldVOS = new ArrayList<>();
            for(int i=0;i<myGoldPOS.size();i++){
                MyGoldPO myGoldPO = myGoldPOS.get(i);
                myGoldVOS.add(myGoldPO.getMyGoldVO());
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, myGoldVOS);
        }else {
            return new BasicResponse(ResponseStatus.STATUS_GOLD_NOT_CONFIG);
        }
    }
}