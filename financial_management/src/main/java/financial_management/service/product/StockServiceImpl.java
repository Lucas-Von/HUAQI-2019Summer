package financial_management.service.product;

import financial_management.bl.message.MessageInterface;
import financial_management.bl.order.OrderService;
import financial_management.bl.product.StockService;
import financial_management.data.product.StockAdjustmentMapper;
import financial_management.data.product.StockMapper;
import financial_management.entity.TransferRecordPO;
import financial_management.entity.stock.*;
import financial_management.parameter.product.StockCustomizeParam;
import financial_management.service.property.questionnaire.QuestionnaireServiceForBl;
import financial_management.util.ArithmeticUtil;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.SingletonStringParam;
import financial_management.util.PyInvoke.PyParam.stock.QDII_CustomizeTrade;
import financial_management.util.PyInvoke.PyParam.stock.QDII_UniversalParam;
import financial_management.util.PyInvoke.PyParam.stock.StockParam;
import financial_management.util.PyInvoke.PyResponse.SingletonFloat;
import financial_management.util.PyInvoke.PyResponse.stock.QDIIAdjustment;
import financial_management.util.PyInvoke.PyResponse.stock.StockAdjustment;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.product.MyStockVO;
import financial_management.vo.product.StockAdjustmentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    @Qualifier(value = "orderServiceImpl")
    private OrderService orderService;
    @Autowired
    private StockAdjustmentMapper adjustmentMapper;
    @Autowired
    private MessageInterface messageInterface;
    @Autowired
    private QuestionnaireServiceForBl questionnaireService;

    private static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);
    private static final double STOCK_BASE = 10000000;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public BasicResponse<Map<String, List<MyStockVO>>> getHoldStock(long userID) {
        BasicResponse<Map<String, List<MyStockVO>>> response;
        List<MyStockPO> myStockPOS = stockMapper.selectSelfDomStock(userID);
        List<MyStockVO> myStockVOS = new ArrayList<>(myStockPOS.size());
        myStockPOS.forEach(myStockPO -> {
            MyStockVO myStockVO = new MyStockVO(myStockPO);
            myStockVO.setName(stockMapper.selectDomStockByCode(myStockPO.getCode()).getName());
            myStockVOS.add(myStockVO);
        });

        List<MyQDIIPO> myQDIIPOS = stockMapper.selectSelfQDII(userID);
        List<MyStockVO> myQDIIVOS = new ArrayList<>(myQDIIPOS.size());
        myQDIIPOS.forEach(myQDIIPO -> {
            MyStockVO myStockVO = new MyStockVO(myQDIIPO);
            myStockVO.setName(stockMapper.selectQDIIByCode(myQDIIPO.getCode()).getName());
            myQDIIVOS.add(myStockVO);
        });

        Map<String, List<MyStockVO>> hold = new HashMap<>();
        hold.put(OrderService.Type.DOMSTOCK.name(), myStockVOS);
        hold.put(OrderService.Type.FORSTOCK.name(), myQDIIVOS);
        response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, hold);
        return response;
    }

    @Override
    public void stockEstablish(Long userId) {
        final PyFunc func = PyFunc.STOCK;
        double whereCanIGetTargetAmount = questionnaireService.getRecStocks(userId);
        String date = sdf.format(new Date());
        StockParam param = new StockParam(date, true);
        List<Object> result = PyInvoke.invoke(func, param, StockAdjustment.class);
//        List<Object> result = getStubData();
        if (result != null) {
            List<StockAdjustment> adjustments = new ArrayList<>(result.size());
            Float latest = 0.0f;
            for (Object object : result) {
                StockAdjustment adjustment = proportionalReadjust(whereCanIGetTargetAmount, STOCK_BASE, (StockAdjustment) object);
                if (adjustment.getComplete_amount() > 0) {
                    adjustments.add(adjustment);
                    if (adjustment.getOrder_time() > latest) {
                        latest = adjustment.getOrder_time();
                    }
                }
            }

            Float finalLatest = latest;
            adjustments.removeIf(adjustment -> adjustment.getOrder_time().compareTo(finalLatest) < 0);
//            domAdjust(adjustments, new ArrayList<>(), userId);
            handlePythonResult(userId, adjustments);
        } else {
            logger.error("Invoke Python function " + func.name() + " return null result.");
        }
    }

    @Override
    public void weeklyStockTransfer(Long userId) {
        final PyFunc func = PyFunc.STOCK;
        double whereCanIGetTargetAmount = questionnaireService.getRecStocks(userId);
        List<MyStockPO> mydoms = stockMapper.selectSelfDomStock(userId);
        StockParam param = new StockParam(sdf.format(adjustmentMapper.selectLastStockTransferDate()), false);//TODO
        List<Object> result = PyInvoke.invoke(func, param, StockAdjustment.class);
//        List<Object> result = getStubData();
        if (result != null) {
            List<StockAdjustment> adjustments = new ArrayList<>(result.size());
            for (Object object : result) {
                StockAdjustment adjustment = proportionalReadjust(whereCanIGetTargetAmount, STOCK_BASE, (StockAdjustment) object);
                if (adjustment.getComplete_amount() > 0) {
                    adjustments.add(adjustment);
                } else {
                    for (MyStockPO myStockPO : mydoms) {
                        if (myStockPO.getCode().equals(adjustment.getCode())) {
                            if (myStockPO.getHoldAmount() <= 0 - adjustment.getComplete_amount()) {
                                float completeAmount = myStockPO.getHoldAmount();
                                float turnover = completeAmount * adjustment.getPrice();
                                float fee = Math.abs(ArithmeticUtil.formatFloat2Float(turnover * 0.001f));

                                adjustment.setFee(fee);
                                adjustment.setTotal(turnover + fee);
                            }
                            adjustments.add(adjustment);
                        }
                    }
                }
            }
            handlePythonResult(userId, adjustments);
        } else {
            logger.error("Invoke Python function " + func.name() + " return null result.");
        }
    }

    private static StockAdjustment proportionalReadjust(double moneyUserHave, double base, StockAdjustment originalAdjustment) {
        final double ratio = moneyUserHave / base;
        int orderAmount = originalAdjustment.getOrder_amount();
        int completeAmount = originalAdjustment.getComplete_amount();
        float price = originalAdjustment.getPrice();

        orderAmount = (int) Math.floor(orderAmount * ratio);
        completeAmount = (int) Math.floor(completeAmount * ratio);
        float turnover = completeAmount * price;
        float fee = Math.abs(ArithmeticUtil.formatFloat2Float(turnover * 0.001f));

        originalAdjustment.setTotal(turnover + fee);
        originalAdjustment.setOrder_amount(orderAmount);
        originalAdjustment.setComplete_amount(completeAmount);
        originalAdjustment.setFee(fee);
        return originalAdjustment;
    }

    @Override
    public void firstQDII(Long userId) {
        final PyFunc func = PyFunc.QDII_FIRST_PURCHASE;
        float whereCanIGetTargetAmount = (float) questionnaireService.getRecQdii(userId);
        QDII_UniversalParam param = new QDII_UniversalParam(whereCanIGetTargetAmount, 0, 0, new ArrayList<>());
        List<Object> result = PyInvoke.invoke(func, param, QDIIAdjustment.class);
//        List<Object> result = getStubData();
        if (result != null) {
            handlePythonResult_QDII(userId, result);
        } else {
            logger.error("Invoke Python function " + func.name() + " return null result.");
        }
    }

    @Override
    public void MonthlyQDIITransfer(Long userId) {
        final PyFunc func = PyFunc.QDII_ADJUST_MONTHLY;
        //TODO 对接上要改回来
        List<MyQDIIPO> myQDIIs = stockMapper.selectSelfQDII(userId);
        List<List<Object>> hold = new ArrayList<>(myQDIIs.size());
        for (MyQDIIPO po : myQDIIs) {
            List<Object> stockInfo = new ArrayList<>(2);
            stockInfo.add(po.getCode());
            stockInfo.add(po.getHoldNum());
            hold.add(stockInfo);
        }

        float whereCanIGetTargetAmount = new Double(questionnaireService.getRecQdii(userId)).floatValue();
        int hold_num = myQDIIs.stream().mapToInt(MyQDIIPO::getHoldNum).sum();
        float sum = new Double(myQDIIs.stream().mapToDouble(MyQDIIPO::getHoldTotal).sum()).floatValue();
        QDII_UniversalParam param = new QDII_UniversalParam(whereCanIGetTargetAmount, sum, 100 - hold_num, hold);
        List<Object> result = PyInvoke.invoke(func, param, QDIIAdjustment.class);
//        List<Object> result = getStubData();

        if (result != null) {
            handlePythonResult_QDII(userId, result);
        } else {
            logger.error("Invoke Python function " + func.name() + " return null result.");
        }
    }

    @Transactional
    void handlePythonResult(long userID, List<StockAdjustment> result) {
        Date createTime = new Date();
        TransferRecordPO transferRecordPO = orderService.addTransferRecord(new TransferRecordPO(createTime, userID, false, false));
        if (transferRecordPO != null) {
            StringBuilder message = new StringBuilder("尊敬的用户，您有新的股票调仓计划需要确认，请在24小时之内选择是否需要进行这次调仓:");
            for (StockAdjustment raw : result) {
                StockAdjustmentPO adjustmentPO = new StockAdjustmentPO(raw);
                adjustmentPO.setTransID(transferRecordPO.getID());
                adjustmentPO.setUserID(userID);
                if (adjustmentMapper.insertStock(adjustmentPO) != 1) {
                    logger.error("Insert into stock adjustments error.\nRecord: " + adjustmentPO.toString());
                    return;
                }
                StockAdjustmentVO stockAdjustmentVO = new StockAdjustmentVO(raw);
                stockAdjustmentVO.setName(stockMapper.selectDomStockByCode(raw.getCode()).getName());
                message.append("\n").append(stockAdjustmentVO.toString());
            }
            try {
                messageInterface.postTransMessage(userID, message.toString(), transferRecordPO.getID());
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw e;
            }
        } else {
            logger.error("At " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Add transfer records error.");
            throw new RuntimeException();
        }
    }

    @Transactional
    void handlePythonResult_QDII(Long userId, List<Object> result) {
        Date createTime = new Date();
        TransferRecordPO transferRecordPO = orderService.addTransferRecord(new TransferRecordPO(createTime, userId, false, true));
        if (transferRecordPO != null) {
            StringBuilder message = new StringBuilder("尊敬的用户，您有新的股指调仓计划需要确认，请在24小时之内选择是否需要进行这次调仓:");
            for (Object object : result) {
                QDIIAdjustment raw = (QDIIAdjustment) object;
                QDIIAdjustmentPO adjustment = new QDIIAdjustmentPO(raw);
                adjustment.setTransID(transferRecordPO.getID());
                adjustment.setUserID(userId);
                if (adjustmentMapper.insertQDII(adjustment) != 1) {
                    logger.error("Insert into QDII adjustments error.\nRecord: " + adjustment.toString());
                    return;
                }
                message.append("\n").append(raw.toString());
            }
            try {
                messageInterface.postTransMessage(userId, message.toString(), transferRecordPO.getID());
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw e;
            }
        } else {
            logger.error("At " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Add transfer records error.");
            throw new RuntimeException();
        }
    }

    @Override
    public BasicResponse<?> StockCustomize(StockCustomizeParam param, long userID) {
        BasicResponse<?> response;
        List<MyStockPO> myStockPOS = stockMapper.selectSelfDomStock(userID);
        float money = param.getMoney();
        double holdTotal = myStockPOS.stream().mapToDouble(MyStockPO::getHoldTotal).sum();
        List<StockAdjustment> adjustments = new ArrayList<>(myStockPOS.size());
        float orderTime = new Date().getTime();
        for (MyStockPO myStockPO : myStockPOS) {
            DomStockPO stockPO = stockMapper.selectDomStockByCode(myStockPO.getCode());
            StockAdjustment adjustment = new StockAdjustment();

            adjustment.setOrder_time(orderTime);
            adjustment.setCode(myStockPO.getCode());
            adjustment.setState_message("");

            int amount = money > 0 ? myStockPO.getHoldAmount() : 0 - myStockPO.getHoldAmount();
            adjustment.setOrder_amount(amount);
            adjustment.setComplete_amount(amount);
            adjustment.setPrice(stockPO.getLatestPrice());
            float turnover = amount * adjustment.getPrice();
            float fee = Math.abs(turnover * 0.001f);
            adjustment.setFee(fee);
            adjustment.setTotal(turnover + fee);

            proportionalReadjust(Math.abs(money), holdTotal, adjustment);
            adjustments.add(adjustment);
        }
        List<PersonalTradeVO> personalTradeVOS = domAdjust(adjustments, myStockPOS, userID);
        if (personalTradeVOS != null && personalTradeVOS.size() > 0) {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, personalTradeVOS);
        } else {
            response = new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }
        return response;
    }

    @Override
    public BasicResponse<?> QDIICustomize(StockCustomizeParam param, long userID) {
        final PyFunc func = PyFunc.QDII_CUSTOMIZE;
        String code = param.getCode();
        MyQDIIPO myQDIIPO = stockMapper.selectSelfQDIIByCode(userID, code);
        BasicResponse<?> response;
        if (myQDIIPO == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_STOCK_NOT_HOLD, null);
        } else {
            float money = param.getMoney();
            float hold = myQDIIPO.getHoldTotal();
            if (Float.compare(-money, hold) > 0) {
                response = new BasicResponse<>(ResponseStatus.STATUS_STOCK_SELL_LEAK, myQDIIPO);
            } else {
                float holdShare = ArithmeticUtil.divide(hold, myQDIIPO.getHoldPrice());
                QDII_CustomizeTrade pyparam = new QDII_CustomizeTrade(code, myQDIIPO.getHoldNum(), holdShare, money);
                List<Object> result = PyInvoke.invoke(func, pyparam, QDIIAdjustment.class);
//                List<Object> result = getStubData();
                if (result != null) {
                    List<QDIIAdjustment> adjustments = new ArrayList<>(result.size());
                    for (Object o : result) {
                        adjustments.add((QDIIAdjustment) o);
                    }
                    List<PersonalTradeVO> personalTradeVOS = qdiiAdjust(adjustments, stockMapper.selectSelfQDII(userID), userID);
                    response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, personalTradeVOS);
                } else {
                    logger.error("Invoke Python function " + func.name() + " return null result.");
                    return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
                }
            }
        }
        return response;
    }

    @Override
    public BasicResponse<?> transferCheck(long transID, long userID, boolean accepted) {
        TransferRecordPO trans = orderService.getTransferRecordByID(transID);
        BasicResponse<?> response;
        if (trans == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_NOT_EXIST, "调仓记录不存在：ID=" + transID);
        } else if (!trans.getUserID().equals(userID)) {
            response = new BasicResponse<>(ResponseStatus.STATUS_NOT_AUTHORIZED, "非本用户调仓记录");
        } else if (trans.getChecked()) {
            response = new BasicResponse<>(ResponseStatus.STATUS_TRANSFER_CHECKED, "ID=" + transID);
        } else if (trans.getQDII()) {
            response = QDIITransferCheck(transID, userID, accepted);
        } else {
            response = StockTransCheck(transID, userID, accepted);
        }
        return response;
    }

    @Override
    public BasicResponse<?> QDIITransferCheck(long transID, long userID, boolean accepted) {
        TransferRecordPO trans = orderService.getTransferRecordByID(transID);
        BasicResponse<?> response;

        trans.setChecked(true);
        if (accepted) {
            List<QDIIAdjustmentPO> adjustmentPOS = adjustmentMapper.selectQDIIAdjustmentByTransID(transID);
            if (adjustmentPOS.isEmpty()) {
                logger.warn("Got an empty list of QDII adjustment? That's INSANE!\nCause transID: " + transID);
            }
            List<MyQDIIPO> myQDIIs = stockMapper.selectSelfQDII(userID);
            qdiiAdjust(adjustmentPOS, myQDIIs, userID);
            trans.setCompleteTime(new Date());
        }
        trans.setStatus(accepted ? 1 : 2);
        trans.setDenied(!accepted);
        if (orderService.updateTransferRecord(trans) != null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_ERROR, null);
        }
        return response;
    }

    @Override
    public BasicResponse<?> StockTransCheck(long transID, long userID, boolean accepted) {
        TransferRecordPO trans = orderService.getTransferRecordByID(transID);
        BasicResponse<?> response;

        trans.setChecked(true);
        if (accepted) {
            List<StockAdjustmentPO> adjustmentPOS = adjustmentMapper.selectStockAdjustmentByTransID(transID);
            if (adjustmentPOS.isEmpty()) {
                logger.warn("Got an empty list of stock adjustment? That's INSANE!\nCause transID: " + transID);
            }

            List<MyStockPO> myStockPOS = stockMapper.selectSelfDomStock(userID);
            domAdjust(adjustmentPOS, myStockPOS, userID);
            trans.setCompleteTime(new Date());
        }
        trans.setStatus(accepted ? 1 : 2);
        trans.setDenied(!accepted);
        if (orderService.updateTransferRecord(trans) != null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_ERROR, null);
        }

        return response;
    }

    @Override
    public double getTotalStockByUser(long userID) {
        double total = 0;
        List<MyStockPO> myStockPOS = stockMapper.selectSelfDomStock(userID);
        for (MyStockPO myStockPO : myStockPOS) {
            total += myStockPO.getHoldTotal().doubleValue();
        }
        return total;
    }


    @Override
    public double getTotalQDIIByUser(long userID) {
        double total = 0;
        List<MyQDIIPO> myQDIIPOS = stockMapper.selectSelfQDII(userID);
        for (MyQDIIPO myQDIIPO : myQDIIPOS) {
            total += myQDIIPO.getHoldTotal().doubleValue();
        }
        return total;
    }

    private List<PersonalTradeVO> domAdjust(List<? extends StockAdjustment> adjustments, List<MyStockPO> mydoms, Long userID) {
        List<PersonalTradeVO> personalTradeVOS = new ArrayList<>(adjustments.size());
        for (StockAdjustment adjustment : adjustments) {
            float price = adjustment.getPrice();
            int amount = adjustment.getComplete_amount();
            float total = adjustment.getTotal();
            String code = adjustment.getCode();

            MyStockPO myStockPO = null;

            for (MyStockPO po : mydoms) {
                if (po.getCode().equals(adjustment.getCode())) {
                    myStockPO = po;

                    float newTotal = myStockPO.getHoldTotal() + total;
                    float newAmount = myStockPO.getHoldAmount() + amount;
                    myStockPO.setHoldAmount(myStockPO.getHoldAmount() + amount);
                    myStockPO.setHoldPrice(computeHoldPrice(newTotal, newAmount));
                    myStockPO.setHoldTotal(myStockPO.getHoldTotal() + total);
                    stockMapper.updateMyStock(myStockPO);
                    break;
                }
            }

            if (myStockPO == null) {
                myStockPO = new MyStockPO();
                myStockPO.setUserId(userID);
                myStockPO.setCode(code);
                myStockPO.setHoldPrice(price);
                myStockPO.setHoldAmount(amount);
                myStockPO.setHoldTotal(total - adjustment.getFee());
                stockMapper.insertMyStock(myStockPO);
            }

            ProductVO4Order productVO4Order = new ProductVO4Order();
            DomStockPO stockPO = stockMapper.selectDomStockByCode(code);
            productVO4Order.setCode(code);
            productVO4Order.setpID(stockPO.getId());
            productVO4Order.setName(stockPO.getName());

            PersonalTradeVO vo = new PersonalTradeVO();
            vo.setType(OrderService.Type.DOMSTOCK);
            vo.setUserID(userID);
            vo.setCreateTime(new Date());
            vo.setProduct(productVO4Order);
            vo.setAmount(amount);
            vo.setPrice(price);
            vo.setTotal(total);
            vo.setFee(0);
            vo.setStatus(0);
            BasicResponse<PersonalTradeVO> response = orderService.addPersonalTradeRecord(vo, false);
            assert response.getStatus() == ResponseStatus.STATUS_SUCCESS;

            if (orderService.completePersonalTrade(response.getData().getID(), userID).getStatus() == ResponseStatus.STATUS_SUCCESS) {
                personalTradeVOS.add(response.getData());
            } else {
                return null;
            }
        }
        return personalTradeVOS;
    }

    private List<PersonalTradeVO> qdiiAdjust(List<? extends QDIIAdjustment> adjustments, List<MyQDIIPO> myfors, Long userID) {
        List<PersonalTradeVO> personalTradeVOS = new ArrayList<>(adjustments.size());
        for (QDIIAdjustment adjustment : adjustments) {
            float price = adjustment.getPrice_deployed();
            float amount = adjustment.getShare_deployed();
            int num = adjustment.getNumber_deployed();
            float total = adjustment.getM_already_deployed();
            String code = adjustment.getQdii_code();

            MyQDIIPO myQDIIPO = null;

            for (MyQDIIPO po : myfors) {
                if (po.getCode().equals(adjustment.getQdii_code())) {
                    myQDIIPO = po;

                    float newTotal = po.getHoldTotal() + total;
                    float newAmount = ArithmeticUtil.divide(po.getHoldTotal(), po.getHoldPrice()) + amount;
                    myQDIIPO.setHoldPrice(computeHoldPrice(newTotal, newAmount));
                    myQDIIPO.setHoldNum(po.getHoldNum() + num);
                    myQDIIPO.setHoldTotal(newTotal);
                    stockMapper.updateMyQDII(myQDIIPO);
                    break;
                }
            }

            if (myQDIIPO == null) {
                myQDIIPO = new MyQDIIPO();
                myQDIIPO.setUserId(userID);
                myQDIIPO.setCode(code);
                myQDIIPO.setHoldPrice(price);
                myQDIIPO.setHoldNum(num);
                myQDIIPO.setHoldTotal(total);
                stockMapper.insertMyQDII(myQDIIPO);
            }

            ProductVO4Order productVO4Order = new ProductVO4Order();
            ForStockPO stockPO = stockMapper.selectQDIIByCode(code);
            productVO4Order.setCode(code);
            productVO4Order.setpID(stockPO.getId());
            productVO4Order.setName(stockPO.getName());

            PersonalTradeVO vo = new PersonalTradeVO();
            vo.setType(OrderService.Type.FORSTOCK);
            vo.setCreateTime(new Date());
            vo.setProduct(productVO4Order);
            vo.setAmount(amount);
            vo.setPrice(price);
            vo.setTotal(total);
            vo.setFee(0);
            vo.setUserID(userID);
            vo.setStatus(1);
            //TODO 到时候要真正去扣钱
            BasicResponse<PersonalTradeVO> response = orderService.addPersonalTradeRecord(vo, false);
            assert response.getStatus() == ResponseStatus.STATUS_SUCCESS;

            if (orderService.completePersonalTrade(response.getData().getID(), userID).getStatus() == ResponseStatus.STATUS_SUCCESS) {
                personalTradeVOS.add(response.getData());
            } else {
                return null;
            }
        }
        return personalTradeVOS;
    }

    @Override
    public void marketDailyUpdate() {
        final PyFunc qdiiFunc = PyFunc.QDII_DAILY_UPDATE;
        final PyFunc stockFunc = PyFunc.STOCK_DAILY_UPDATE;

        long startStock = System.currentTimeMillis();

        List<DomStockPO> domStockPOS = stockMapper.selectAllDomStock();
        for (DomStockPO domStockPO : domStockPOS) {
            List<Object> result = PyInvoke.invoke(stockFunc, new SingletonStringParam(domStockPO.getCode()), SingletonFloat.class, true);
            if (result != null && !result.isEmpty()) {
                float price = ((SingletonFloat) result.get(0)).getaFloat();
                domStockPO.setLatestPrice(price);
                assert stockMapper.updateStock(domStockPO) == 1;
                //TODO 更新持有用户收益
            } else {
                logger.warn("更新股票数据时" + stockFunc + "返回空的结果，股票代码：" + domStockPO.getCode());
            }
        }

        long afterStock = System.currentTimeMillis();
        logger.info("更新" + domStockPOS.size() + "条股票记录，用时" + (afterStock - startStock) + "毫秒");

        long startQDII = System.currentTimeMillis();

        List<ForStockPO> forStockPOS = stockMapper.selectAllQDII();
        for (ForStockPO forStockPO : forStockPOS) {
            List<Object> result = PyInvoke.invoke(qdiiFunc, new SingletonStringParam(forStockPO.getCode()), SingletonFloat.class, false);
            if (result != null && !result.isEmpty()) {
                float price = ((SingletonFloat) result.get(0)).getaFloat();
                forStockPO.setLatestPrice(price);
                assert stockMapper.updateQDII(forStockPO) == 1;
                //TODO 同上
            } else {
                logger.warn("更新股指数据时" + stockFunc + "返回空的结果，股指代码：" + forStockPO.getCode());
            }
        }

        long afterQDII = System.currentTimeMillis();
        logger.info("更新" + forStockPOS.size() + "条股指记录，用时" + (afterQDII - startQDII) + "毫秒");
    }


    private float computeHoldPrice(float newTotal, float newAmount) {
        return ArithmeticUtil.divide(newTotal, newAmount);
    }

    private List<Object> getStubData() {
        List<Object> result = new ArrayList<>(2);
        result.add(new StockAdjustment(1566144000.0f, "600339.XSHG", "全部成交", 920800, 920800, 3314.88f, 3318194.88f, 3.6f));
        result.add(new StockAdjustment(1566144000.0f, "002625.XSHE", "全部成交", 400100, 400100, 3432.858f, 3436290.858f, 8.58f));
        return result;
    }
}
