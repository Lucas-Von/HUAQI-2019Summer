package financial_management.service.property.estate;

import financial_management.bl.order.OrderService;
import financial_management.data.product.StockMapper;
import financial_management.entity.DomStockPO;
import financial_management.entity.ForStockPO;
import financial_management.entity.MyQDIIPO;
import financial_management.entity.MyStockPO;
import financial_management.util.PyInvoke.PyFunc;
import financial_management.util.PyInvoke.PyInvoke;
import financial_management.util.PyInvoke.PyParam.stock.StockAdjustParam;
import financial_management.util.PyInvoke.PyParam.stock.StockWeeklyTransferParam;
import financial_management.util.PyInvoke.PyResponse.stock.QDIIAdjustment;
import financial_management.util.PyInvoke.PyResponse.stock.StockAdjustment;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.ProductVO4Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stock_SorryIDontKnowWhereToPlace {
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    @Qualifier(value = "orderServiceImpl")
    private OrderService orderService;

    public void changeDomStock(Long userId) {
        List<MyStockPO> mydoms = stockMapper.selectSelfDomStock(userId);
        float sum = 0;
        for (MyStockPO po : mydoms) {
            sum += po.getHoldTotal();
        }
        float whereCanIGetTargetAmount = 0;
        StockAdjustParam param = new StockAdjustParam(whereCanIGetTargetAmount, sum);
        List<Object> result = PyInvoke.invoke(PyFunc.STOCK_MONEY_ADJUST, param, StockAdjustment.class);
        if (result != null) {
            List<StockAdjustment> adjustments = new ArrayList<>(result.size());
            for (Object object : result) {
                adjustments.add((StockAdjustment) object);
            }
            domAdjust(adjustments, mydoms, userId);
        }
    }

    public void changeForStock(Long userId) {
        List<MyQDIIPO> myfors = stockMapper.selectSelfForStock(userId);
        float sum = 0;
        for (MyQDIIPO po : myfors) {
            sum += po.getHoldTotal();
        }
        float whereCanIGetTargetAmount = 0;
        StockAdjustParam param = new StockAdjustParam(whereCanIGetTargetAmount, sum);
        List<Object> result = PyInvoke.invoke(PyFunc.STOCK_MONEY_ADJUST, param, QDIIAdjustment.class);
        if (result != null) {
            List<QDIIAdjustment> adjustments = new ArrayList<>(result.size());
            for (Object object : result) {
                adjustments.add((QDIIAdjustment) object);
            }
            forAdjust(adjustments, myfors, userId);
        }
    }

    public void weeklyDomTransfer(Long userId) {
        List<MyStockPO> mydoms = stockMapper.selectSelfDomStock(userId);
        List<List<Object>> hold = new ArrayList<>(mydoms.size());
        for (MyStockPO po : mydoms) {
            List<Object> stockInfo = new ArrayList<>(2);
            stockInfo.add(po.getCode());
            stockInfo.add(po.getHoldAmount());
            hold.add(stockInfo);
        }
        float whereCanIGetTargetAmount = 0;
        StockWeeklyTransferParam param = new StockWeeklyTransferParam(whereCanIGetTargetAmount, hold);
        List<Object> result = PyInvoke.invoke(PyFunc.STOCK_ADJUST_WEEKLY, param, StockAdjustment.class);
        if (result != null) {
            List<StockAdjustment> adjustments = new ArrayList<>(result.size());
            for (Object object : result) {
                adjustments.add((StockAdjustment) object);
            }
            domAdjust(adjustments, mydoms, userId);
        }
    }

    public void weeklyForTransfer(Long userId) {
        List<MyQDIIPO> myfors = stockMapper.selectSelfForStock(userId);
        List<List<Object>> hold = new ArrayList<>(myfors.size());
        for (MyQDIIPO po : myfors) {
            List<Object> stockInfo = new ArrayList<>(2);
            stockInfo.add(po.getCode());
            stockInfo.add(po.getHoldAmount());
            hold.add(stockInfo);
        }
        float whereCanIGetTargetAmount = 1;
        StockWeeklyTransferParam param = new StockWeeklyTransferParam(whereCanIGetTargetAmount, hold);
        List<Object> result = PyInvoke.invoke(PyFunc.STOCK_ADJUST_WEEKLY, param, QDIIAdjustment.class);
        if (result != null) {
            List<QDIIAdjustment> adjustments = new ArrayList<>(result.size());
            for (Object object : result) {
                adjustments.add((QDIIAdjustment) object);
            }
            forAdjust(adjustments, myfors, userId);
        }
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
            vo.setType(PersonalTradeVO.Type.DOMSTOCK);
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

    private void forAdjust(List<QDIIAdjustment> adjustments, List<MyQDIIPO> myfors, Long userID) {
        for (QDIIAdjustment adjustment : adjustments) {
            float price = adjustment.getPrice_deployed();
            float amount = adjustment.getAccount_deployed_change();
            float total = adjustment.getM_already_deployed();
            String code = adjustment.getQdii_code();

            MyQDIIPO myQDIIPO = null;

            for (MyQDIIPO po : myfors) {
                if (po.getCode().equals(adjustment.getQdii_code())) {
                    myQDIIPO = po;

                    double newTotal = myQDIIPO.getHoldTotal() + total;
                    double newAmount = myQDIIPO.getHoldAmount() + amount;
                    myQDIIPO.setHoldPrice(computeHoldPrice(newTotal, newAmount));
                    myQDIIPO.setHoldAmount(myQDIIPO.getHoldAmount() + amount);
                    myQDIIPO.setHoldTotal(myQDIIPO.getHoldTotal() + total);
                    stockMapper.updateMyQDII(myQDIIPO);
                    break;
                }
            }

            if (myQDIIPO == null) {
                myQDIIPO = new MyQDIIPO();
                myQDIIPO.setUserId(userID);
                myQDIIPO.setCode(code);
                myQDIIPO.setPurchasePrice(price);
                myQDIIPO.setHoldPrice(price);
                myQDIIPO.setPurchaseAmount(amount);
                myQDIIPO.setHoldAmount(amount);
                myQDIIPO.setPurchaseTotal(total);
                myQDIIPO.setHoldTotal(total);
                stockMapper.insertMyQDII(myQDIIPO);
            }

            ProductVO4Order productVO4Order = new ProductVO4Order();
            ForStockPO stockPO = stockMapper.selectForStockByCode(code);
            productVO4Order.setCode(code);
            productVO4Order.setpID(stockPO.getId());
            productVO4Order.setName(stockPO.getName());

            PersonalTradeVO vo = new PersonalTradeVO();
            vo.setType(PersonalTradeVO.Type.FORSTOCK);
            vo.setCreateTime(new Date());
            vo.setProduct(productVO4Order);
            vo.setAmount(amount);
            vo.setPrice(price);
            vo.setTotal(total);
            vo.setFee(0);
            vo.setUserID(userID);
            orderService.addPersonalTradeRecord(vo, false);
        }
    }

    private float computeHoldPrice(double newTotal, double newPrice) {
        //舍入模式？
        return new BigDecimal(newTotal).divide(new BigDecimal(newPrice), RoundingMode.HALF_UP).floatValue();
    }
}