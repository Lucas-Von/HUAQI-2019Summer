package financial_management.service.order.impl;

import financial_management.bl.order.OrderService;
import financial_management.bl.product.ProductService4Order;
import financial_management.data.order.TradeRecordMapper;
import financial_management.data.order.TransferRecordMapper;
import financial_management.entity.TradeRecordPO;
import financial_management.entity.TransferRecordPO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.order.TradeRecordVO;
import financial_management.vo.order.TransferRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TradeRecordMapper tradeRecordMapper;
    @Autowired
    private TransferRecordMapper transferRecordMapper;
    @Autowired
    private ProductService4Order productService4Order;

    @Override
    public BasicResponse<List<TradeRecordVO>> getTradeRecordByUser(Long ID) {
        List<TradeRecordPO> tradeRecordPOS = tradeRecordMapper.selectByUserID(ID);
        List<TradeRecordVO> vos = new ArrayList<>(tradeRecordPOS.size());
        for (TradeRecordPO po : tradeRecordPOS) {
            TradeRecordVO vo = new TradeRecordVO(po);
            ProductVO4Order vo4Order = productService4Order.getProducts(po.getProductID(), po.getType());
            if (vo4Order.getName() != null) {
                vo.setProduct(productService4Order.getProducts(po.getProductID(), po.getType()));
            } else {
                return new BasicResponse<>(ResponseStatus.STATUS_RECORD_ERROR, null);
            }
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @Override
    public BasicResponse<TradeRecordVO> getTradeRecordByRecord(Long ID) {
        BasicResponse<TradeRecordVO> response;
        TradeRecordPO po = tradeRecordMapper.selectByID(ID);
        if (po == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_NOT_EXIST, null);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,new TradeRecordVO(po));
        }
        return response;
    }

    @Override
    public BasicResponse<List<TransferRecordVO>> getTransferRecordByUser(Long ID) {
        List<TransferRecordPO> transferRecordPOS = transferRecordMapper.selectByUserID(ID);
        List<TransferRecordVO> vos = new ArrayList<>(transferRecordPOS.size());
        for (TransferRecordPO po:transferRecordPOS){
            vos.add(new TransferRecordVO(po));
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,vos);
    }

    @Override
    public BasicResponse<TransferRecordVO> getTransferRecordByRecord(Long ID) {
        BasicResponse<TransferRecordVO> response;
        TransferRecordPO po = transferRecordMapper.selectByID(ID);
        if (po == null){
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_NOT_EXIST,null);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,new TransferRecordVO(po));
        }
        return response;
    }

    @Override
    public BasicResponse<?> addTradeRecord(TradeRecordVO tradeRecordVO, boolean isCustomize) {
        TradeRecordPO po = assembleTradeRecordPO(tradeRecordVO);
        po.setID(null);
        po.setIsCustomize(isCustomize);
        long id = tradeRecordMapper.insert(po);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,id);
    }

    @Override
    public BasicResponse<?> addTransferRecord(TransferRecordVO transferRecordVO, boolean isCustomize) {
        TransferRecordPO po = assembleTransferRecordPO(transferRecordVO);
        po.setID(null);
        po.setIsCustomize(isCustomize);
        long id = transferRecordMapper.insert(po);
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS,id);
    }

    private static TradeRecordPO assembleTradeRecordPO(TradeRecordVO vo){
        TradeRecordPO po = new TradeRecordPO();
        po.setID(vo.getID());
        po.setTransID(vo.getTransID());
        po.setCreateTime(vo.getCreateTime());
        po.setCompleteTime(vo.getCompleteTime());
        po.setType(vo.getType());
        po.setProductID(vo.getProduct().getpID());
        po.setAmount(vo.getAmount());
        po.setPrice(vo.getPrice());
        po.setTotal(vo.getTotal());
        po.setUserID(vo.getUserID());
        po.setStatus(vo.getStatus());
        return po;
    }

    private static TransferRecordPO assembleTransferRecordPO(TransferRecordVO vo){
        TransferRecordPO po = new TransferRecordPO();
        po.setID(vo.getID());
        po.setCreateTime(vo.getCreateTime());
        po.setCompleteTime(vo.getCompleteTime());
        po.setGoldTotal(vo.getGoldTotal());
        po.setGoldDelta(vo.getGoldDelta());
        po.setBondTotal(vo.getBondTotal());
        po.setBondDelta(vo.getBondDelta());
        po.setStockTotal(vo.getStockTotal());
        po.setStockDelta(vo.getStockDelta());
        po.setUserID(vo.getUserID());
        po.setStatus(vo.getStatus());
        return po;
    }
}
