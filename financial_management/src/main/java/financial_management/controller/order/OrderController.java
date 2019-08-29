package financial_management.controller.order;

import financial_management.bl.order.OrderService;
import financial_management.bl.product.ProductService4Order;
import financial_management.entity.TradeRecordPO;
import financial_management.entity.TransferRecordPO;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.order.TradeRecordVO;
import financial_management.vo.order.TransferRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    @Qualifier(value = "orderServiceImpl")
    private OrderService orderService;
    @Autowired
    private ProductService4Order productService4Order;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("trade")
    public BasicResponse getTradeRecordsByUserID(HttpServletRequest request) {
        List<TradeRecordPO> tradeRecordPOS = new ArrayList<>();
        TradeRecordPO tradeRecordPO1 = new TradeRecordPO();
        tradeRecordPO1.setID(1L);
        tradeRecordPO1.setTransID(1L);
        tradeRecordPO1.setCreateTime(new Date());
        tradeRecordPO1.setCompleteTime(new Date());
        tradeRecordPO1.setType("funds");
        tradeRecordPO1.setProductID(1L);
        tradeRecordPO1.setAmount(5f);
        tradeRecordPO1.setPrice(2f);
        tradeRecordPO1.setTotal(10f);
        tradeRecordPO1.setUserID(1L);
        tradeRecordPO1.setStatus(1);
        tradeRecordPO1.setIsCustomize(true);
        TradeRecordPO tradeRecordPO2 = new TradeRecordPO();
        tradeRecordPO2.setID(2L);
        tradeRecordPO2.setTransID(2L);
        tradeRecordPO2.setCreateTime(new Date());
        tradeRecordPO2.setCompleteTime(new Date());
        tradeRecordPO2.setType("saving");
        tradeRecordPO2.setProductID(2L);
        tradeRecordPO2.setAmount(2f);
        tradeRecordPO2.setPrice(5f);
        tradeRecordPO2.setTotal(10f);
        tradeRecordPO2.setUserID(2L);
        tradeRecordPO2.setStatus(2);
        tradeRecordPO2.setIsCustomize(false);
        tradeRecordPOS.add(tradeRecordPO1);
        tradeRecordPOS.add(tradeRecordPO2);
        List<TradeRecordVO> vos = new ArrayList<>(tradeRecordPOS.size());
        for (TradeRecordPO po : tradeRecordPOS) {
            TradeRecordVO vo = new TradeRecordVO(po);
            ProductVO4Order vo4Order = productService4Order.getProducts(po.getProductID(), po.getType());
            if (vo4Order.getName() != null) {
                vo.setProduct(productService4Order.getProducts(po.getProductID(), po.getType()));
            } else {
                return new BasicResponse<>(financial_management.vo.ResponseStatus.STATUS_RECORD_ERROR, null);
            }
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @GetMapping("trade/{ID}")
    public BasicResponse getTradeRecordByRecordID(@PathVariable Long ID) {
        TradeRecordPO tradeRecordPO = new TradeRecordPO();
        tradeRecordPO.setID(1L);
        tradeRecordPO.setTransID(1L);
        tradeRecordPO.setCreateTime(new Date());
        tradeRecordPO.setCompleteTime(new Date());
        tradeRecordPO.setType("funds");
        tradeRecordPO.setProductID(1L);
        tradeRecordPO.setAmount(5f);
        tradeRecordPO.setPrice(2f);
        tradeRecordPO.setTotal(10f);
        tradeRecordPO.setUserID(1L);
        tradeRecordPO.setStatus(1);
        tradeRecordPO.setIsCustomize(true);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,new TradeRecordVO(tradeRecordPO));
    }

    @GetMapping("transfer")
    public BasicResponse getTransferRecordByUserID(HttpServletRequest request) {
        List<TransferRecordPO> transferRecordPOS = new ArrayList<>();
        TransferRecordPO transferRecordPO1 = new TransferRecordPO();
        transferRecordPO1.setID(1L);
        transferRecordPO1.setCreateTime(new Date());
        transferRecordPO1.setCompleteTime(new Date());
        transferRecordPO1.setGoldTotal(550f);
        transferRecordPO1.setGoldDelta(510f);
        transferRecordPO1.setBondTotal(250f);
        transferRecordPO1.setBondDelta(251f);
        transferRecordPO1.setStockTotal(666f);
        transferRecordPO1.setStockDelta(888f);
        transferRecordPO1.setUserID(1L);
        transferRecordPO1.setStatus(1);
        transferRecordPO1.setIsCustomize(true);
        TransferRecordPO transferRecordPO2 = new TransferRecordPO();
        transferRecordPO2.setID(2L);
        transferRecordPO2.setCreateTime(new Date());
        transferRecordPO2.setCompleteTime(new Date());
        transferRecordPO2.setGoldTotal(550f);
        transferRecordPO2.setGoldDelta(510f);
        transferRecordPO2.setBondTotal(250f);
        transferRecordPO2.setBondDelta(251f);
        transferRecordPO2.setStockTotal(666f);
        transferRecordPO2.setStockDelta(888f);
        transferRecordPO2.setUserID(2L);
        transferRecordPO2.setStatus(2);
        transferRecordPO2.setIsCustomize(false);
        transferRecordPOS.add(transferRecordPO1);
        transferRecordPOS.add(transferRecordPO2);
        List<TransferRecordVO> vos = new ArrayList<>(transferRecordPOS.size());
        for (TransferRecordPO po : transferRecordPOS) {
            TransferRecordVO vo = new TransferRecordVO(po);
            vos.add(vo);
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @GetMapping("/transfer/{ID}")
    public BasicResponse getTransferRecordByRecordID(@PathVariable Long ID) {
        TransferRecordPO transferRecordPO = new TransferRecordPO();
        transferRecordPO.setID(1L);
        transferRecordPO.setCreateTime(new Date());
        transferRecordPO.setCompleteTime(new Date());
        transferRecordPO.setGoldTotal(550f);
        transferRecordPO.setGoldDelta(510f);
        transferRecordPO.setBondTotal(250f);
        transferRecordPO.setBondDelta(251f);
        transferRecordPO.setStockTotal(666f);
        transferRecordPO.setStockDelta(888f);
        transferRecordPO.setUserID(1L);
        transferRecordPO.setStatus(1);
        transferRecordPO.setIsCustomize(true);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,new TransferRecordVO(transferRecordPO));
    }

}
