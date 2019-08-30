package financial_management.service.order.impl;

import financial_management.bl.order.OrderService;
import financial_management.bl.product.ProductService4Order;
import financial_management.data.order.MaxInvestMapper;
import financial_management.data.order.PersonalTradeMapper;
import financial_management.data.order.PlatformTradeMapper;
import financial_management.data.order.TransferRecordMapper;
import financial_management.entity.MaxInvestPO;
import financial_management.entity.PersonalTradePO;
import financial_management.entity.PlatformTradePO;
import financial_management.entity.TransferRecordPO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private PersonalTradeMapper personalTradeMapper;
    @Autowired
    private PlatformTradeMapper platformTradeMapper;
    @Autowired
    private TransferRecordMapper transferRecordMapper;
    @Autowired
    private ProductService4Order productService4Order;
    @Autowired
    private MaxInvestMapper maxInvestMapper;

    @Override
    public BasicResponse<List<PersonalTradeVO>> getPersonalTradeRecordByUser(Long ID) {
        List<PersonalTradePO> personalTradePOS = personalTradeMapper.selectByUserID(ID);
        List<PersonalTradeVO> vos = new ArrayList<>(personalTradePOS.size());
        for (PersonalTradePO po : personalTradePOS) {
            PersonalTradeVO vo = new PersonalTradeVO(po);
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
    public BasicResponse<PersonalTradeVO> getPersonalTradeRecordByRecord(Long ID) {
        BasicResponse<PersonalTradeVO> response;
        PersonalTradePO po = personalTradeMapper.selectByID(ID);
        if (po == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_NOT_EXIST, null);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new PersonalTradeVO(po));
        }
        return response;
    }

    @Override
    public BasicResponse<List<TransferRecordVO>> getTransferRecordByUser(Long ID) {
        List<TransferRecordPO> transferRecordPOS = transferRecordMapper.selectByUserID(ID);
        List<TransferRecordVO> vos = new ArrayList<>(transferRecordPOS.size());
        for (TransferRecordPO po : transferRecordPOS) {
            vos.add(new TransferRecordVO(po));
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @Override
    public BasicResponse<TransferRecordVO> getTransferRecordByRecord(Long ID) {
        BasicResponse<TransferRecordVO> response;
        TransferRecordPO po = transferRecordMapper.selectByID(ID);
        if (po == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_NOT_EXIST, null);
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new TransferRecordVO(po));
        }
        return response;
    }

    @Override
    public BasicResponse<?> addPersonalTradeRecord(PersonalTradeVO personalTradeVO, boolean isCustomize) {
        PersonalTradePO po = assemblePersonalTradePO(personalTradeVO);
        po.setID(null);
        po.setIsCustomize(isCustomize);
        long id;
        try {
            id = personalTradeMapper.insert(po);
        } catch (Exception e) {
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }

        //更新最大投资金额
        long userID = personalTradeVO.getUserID();
        String type = personalTradeVO.getType().name().toUpperCase();
        MaxInvestPO max = maxInvestMapper.selectByUserIDAndType(userID, type);
        float latestSum = personalTradeMapper.selectSum(userID, type, null);
        if (max.getMax() < latestSum) {
            max.setMax(latestSum);
            max.setDate(new Date());
            maxInvestMapper.update(max);
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, id);
    }

    @Override
    public BasicResponse<?> addPlatfromTradeRecord(PlatformTradeVO platformTradeVO) {
        PlatformTradePO po = assemblePlatformTradePO(platformTradeVO);
        po.setID(null);
        try {
            long id = platformTradeMapper.insert(po);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, id);
        } catch (Exception e) {
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }
    }

    @Override
    public BasicResponse<?> addTransferRecord(TransferRecordVO transferRecordVO, boolean isCustomize) {
        TransferRecordPO po = assembleTransferRecordPO(transferRecordVO);
        po.setID(null);
        po.setIsCustomize(isCustomize);
        try {
            long id = transferRecordMapper.insert(po);
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, id);
        } catch (Exception e) {
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }
    }

    @Override
    public BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord() {
        List<PersonalTradePO> pos = personalTradeMapper.selectByDate(new Date(), PersonalTradeVO.Type.BOND.name().toUpperCase());
        List<PersonalTradeVO> vos = new ArrayList<>(pos.size());
        for (PersonalTradePO po : pos) {
            vos.add(new PersonalTradeVO(po));
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @Override
    public BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord(PersonalTradeVO.Type type) {
        List<PersonalTradePO> pos = personalTradeMapper.selectByDate(new Date(), type.name().toUpperCase());
        List<PersonalTradeVO> vos = new ArrayList<>(pos.size());
        for (PersonalTradePO po : pos) {
            vos.add(new PersonalTradeVO(po));
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @Override
    public BasicResponse<List<PlatformTradeVO>> getAllPlatformTradeRecord() {
        List<PlatformTradePO> pos = platformTradeMapper.selectAll();
        List<PlatformTradeVO> vos = new ArrayList<>(pos.size());
        for (PlatformTradePO po : pos) {
            vos.add(new PlatformTradeVO(po));
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }


    @Override
    public BasicResponse<MaxInvestVO> getMaxInvestBy(Long userID, String type) {
        BasicResponse<MaxInvestVO> response;
        MaxInvestPO po = maxInvestMapper.selectByUserIDAndType(userID, type);
        if (po != null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new MaxInvestVO(po));
        } else {
            response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new MaxInvestVO(userID, type, (float) 0, null));
        }
        return response;
    }

    @Override
    public BasicResponse<Float> getInvestBy(Long userID, String type, Date date) {
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, personalTradeMapper.selectSum(userID, type, date));
    }

    private static PersonalTradePO assemblePersonalTradePO(PersonalTradeVO vo) {
        PersonalTradePO po = new PersonalTradePO();
        po.setID(vo.getID());
        po.setCreateTime(vo.getCreateTime());
        po.setCompleteTime(vo.getCompleteTime());
        po.setType(vo.getType().name().toUpperCase());
        po.setProductID(vo.getProduct().getpID());
        po.setAmount(vo.getAmount());
        po.setPrice(vo.getPrice());
        po.setFee(vo.getFee());
        po.setTotal(vo.getTotal());
        po.setUserID(vo.getUserID());
        po.setStatus(vo.getStatus());
        return po;
    }

    private static PlatformTradePO assemblePlatformTradePO(PlatformTradeVO vo) {
        PlatformTradePO po = new PlatformTradePO();
        po.setID(vo.getID());
        po.setTime(vo.getTime());
        po.setProduct(vo.getProduct());
        po.setAmount(vo.getAmount());
        po.setPrice(vo.getPrice());
        po.setTotal(vo.getTotal());
        po.setRealTotal(vo.getRealTotal());
        po.setStatus(vo.getStatus());
        return po;
    }

    private static TransferRecordPO assembleTransferRecordPO(TransferRecordVO vo) {
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
