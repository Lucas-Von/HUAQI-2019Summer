package financial_management.service.product;

import financial_management.bl.message.MessageInterface;
import financial_management.bl.order.OrderService;
import financial_management.bl.product.StockService;
import financial_management.data.product.StockAdjustmentMapper;
import financial_management.data.product.StockMapper;
import financial_management.entity.TransferRecordPO;
import financial_management.entity.stock.*;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyResponse.stock.QDIIAdjustment;
import financial_management.util.PyInvoke.PyResponse.stock.StockAdjustment;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.ProductVO4Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private static Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Override
    public void changeStock(Long userId) {
        List<MyStockPO> mydoms = stockMapper.selectSelfDomStock(userId);
//        float sum = 0;
//        for (MyStockPO po : mydoms) {
//            sum += po.getHoldTotal();
//        }
//        float whereCanIGetTargetAmount = 0;
//        StockAdjustParam param = new StockAdjustParam(whereCanIGetTargetAmount, sum);
//        List<Object> result = PyInvoke.invoke(PyFunc.STOCK_MONEY_ADJUST, param, StockAdjustment.class);
        List<Object> result = getStubData();
        if (result != null) {
            List<StockAdjustment> adjustments = new ArrayList<>(result.size());
            for (Object object : result) {
                adjustments.add((StockAdjustment) object);
            }
            domAdjust(adjustments, mydoms, userId);
        }
    }

    @Override
    public void firstQDII(Long userId) {
        final PyFunc func = PyFunc.QDII_MONEY_ADJUST;
        //float whereCanIGetTargetAmount = 0;
        //QDII_UniversalParam param = new QDII_UniversalParam(whereCanIGetTargetAmount,0,0,new ArrayList<>());
        //List<Object> result = PyInvoke.invoke(PyFunc.STOCK_MONEY_ADJUST, param, QDIIAdjustment.class);
        List<Object> result = getStubData();
        handlePythonResult_QDII(userId, func, result);
    }

    @Override
    public void weeklyStockTransfer(Long userId) {
        List<MyStockPO> mydoms = stockMapper.selectSelfDomStock(userId);
//        List<List<Object>> hold = new ArrayList<>(mydoms.size());
//        for (MyStockPO po : mydoms) {
//            List<Object> stockInfo = new ArrayList<>(2);
//            stockInfo.add(po.getCode());
//            stockInfo.add(po.getHoldNum());
//            hold.add(stockInfo);
//        }
//        float whereCanIGetTargetAmount = 0;
        //StockWeeklyTransferParam param = new StockWeeklyTransferParam(whereCanIGetTargetAmount, hold);
        //List<Object> result = PyInvoke.invoke(PyFunc.STOCK_ADJUST_WEEKLY, param, StockAdjustment.class);
        List<Object> result = getStubData();
        if (result != null) {
            List<StockAdjustment> adjustments = new ArrayList<>(result.size());
            for (Object object : result) {
                adjustments.add((StockAdjustment) object);
            }
            domAdjust(adjustments, mydoms, userId);
        }
    }

    @Override
    public void MonthlyQDIITransfer(Long userId) {
        final PyFunc func = PyFunc.QDII_ADJUST_MONTHLY;
        //TODO 对接上要改回来
        //List<MyQDIIPO> myQDIIs = stockMapper.selectSelfQDII(userId);
        //List<List<Object>> hold = new ArrayList<>(myQDIIs.size());
        //for (MyQDIIPO po : myQDIIs) {
        //List<Object> stockInfo = new ArrayList<>(2);
        //stockInfo.add(po.getCode());
        //stockInfo.add(po.getHoldNum());
        //hold.add(stockInfo);
        //}

        //float whereCanIGetTargetAmount = 6324;
        //int hold_num = myQDIIs.stream().mapToInt(MyQDIIPO::getHoldNum).sum();
        //float sum = new Double(myQDIIs.stream().mapToDouble(MyQDIIPO::getHoldTotal).sum()).floatValue();
        //QDII_UniversalParam param = new QDII_UniversalParam(whereCanIGetTargetAmount, sum, 100 - hold_num, hold);
        //List<Object> result = PyInvoke.invoke(PyFunc.STOCK_ADJUST_WEEKLY, param, QDII_UniversalParam.class);
        List<Object> result = getStubData();

        handlePythonResult_QDII(userId, func, result);
    }

    private void handlePythonResult_QDII(Long userId, PyFunc func, List<Object> result) {
        if (result != null) {
            //List<QDIIAdjustment> adjustments = new ArrayList<>(result.size());
            Date createTime = new Date();
            TransferRecordPO transferRecordPO = orderService.addTransferRecord(new TransferRecordPO(createTime, userId, false));
            if (transferRecordPO != null) {
                StringBuilder message = new StringBuilder("尊敬的用户，您有股指调仓计划需要确认，请在24小时之内选择是否需要进行这次调仓:");
                for (Object object : result) {
                    //adjustments.add((QDIIAdjustment) object);
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
                messageInterface.postMessageToUserBy(userId, message.toString(), MessageInterface.MsgType.TRANSFER_MSG);
            } else {
                logger.error("At " + Thread.currentThread().getStackTrace()[1].getMethodName() + ": Add transfer records error.");
            }
            //qdiiAdjust(adjustments, myQDIIs, userId);
        } else {
            logger.error("Invoke Python function " + func.name() + " return null result.");
        }
    }

    @Override
    public BasicResponse<?> QDIITradeCheck(long transID, long userID, boolean accepted) {
        TransferRecordPO trans = orderService.getTransferRecordByID(transID);
        BasicResponse<?> response;
        if (trans == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_NOT_EXIST, null);
        } else {
            trans.setChecked(true);

            if (accepted) {
                List<QDIIAdjustmentPO> adjustmentPOS = adjustmentMapper.selectQDIITransByTransID(transID);
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

    private void domAdjust(List<StockAdjustment> adjustments, List<MyStockPO> mydoms, Long userID) {
        for (StockAdjustment adjustment : adjustments) {
            float price = adjustment.getPrice_deployed();
            int amount = adjustment.getAccount_deployed_change();
            float total = adjustment.getM_already_deployed();
            String code = adjustment.getStock_code();

            MyStockPO myStockPO = null;

            for (MyStockPO po : mydoms) {
                if (po.getCode().equals(adjustment.getStock_code())) {
                    myStockPO = po;

                    double newTotal = myStockPO.getHoldTotal() + total;
                    double newAmount = myStockPO.getHoldAmount() + amount;
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
                myStockPO.setPurchasePrice(price);
                myStockPO.setPurchaseAmount(amount);
                myStockPO.setPurchaseTotal(total);
                myStockPO.setHoldPrice(price);
                myStockPO.setHoldAmount(amount);
                myStockPO.setHoldTotal(total);
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
            orderService.addPersonalTradeRecord(vo, false);
        }
    }

    private void qdiiAdjust(List<? extends QDIIAdjustment> adjustments, List<MyQDIIPO> myfors, Long userID) {
        for (QDIIAdjustment adjustment : adjustments) {
            float price = adjustment.getPrice_deployed();
            Integer amount = adjustment.getNumber_deployed();
            float total = adjustment.getM_already_deployed();
            String code = adjustment.getQdii_code();

            MyQDIIPO myQDIIPO = null;

            for (MyQDIIPO po : myfors) {
                if (po.getCode().equals(adjustment.getQdii_code())) {
                    myQDIIPO = po;

                    double newTotal = myQDIIPO.getHoldTotal() + total;
                    double newAmount = myQDIIPO.getHoldNum() + amount;
                    myQDIIPO.setHoldPrice(computeHoldPrice(newTotal, newAmount));
                    myQDIIPO.setHoldNum(myQDIIPO.getHoldNum() + amount);
                    myQDIIPO.setHoldTotal(myQDIIPO.getHoldTotal() + total);
                    stockMapper.updateMyQDII(myQDIIPO);
                    break;
                }
            }

            if (myQDIIPO == null) {
                myQDIIPO = new MyQDIIPO();
                myQDIIPO.setUserId(userID);
                myQDIIPO.setCode(code);
                myQDIIPO.setHoldPrice(price);
                myQDIIPO.setHoldNum(amount);
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
            orderService.addPersonalTradeRecord(vo, false);
            //TODO 到时候要真正去扣钱
        }
    }

    private float computeHoldPrice(double newTotal, double newPrice) {
        //舍入模式？
        return new BigDecimal(newTotal).divide(new BigDecimal(newPrice), RoundingMode.HALF_UP).floatValue();
    }

    private List<Object> getStubData() {
        List<Object> result = new ArrayList<>(2);
        result.add(new StockAdjustment("123456", "随便", 1000, 1000.0f, 1.0f));
        result.add(new StockAdjustment("654321", "可以", -1000, -1000.0f, 1.0f));
        return result;
    }
}
