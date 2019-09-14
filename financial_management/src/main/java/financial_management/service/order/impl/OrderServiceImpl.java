package financial_management.service.order.impl;

import financial_management.bl.message.ITransferMessage;
import financial_management.bl.message.MessageService;
import financial_management.bl.order.OrderService;
import financial_management.bl.product.FundService;
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
import financial_management.vo.message.TransMessageVO;
import financial_management.vo.order.PersonalTradeVO;
import financial_management.vo.order.PlatformTradeVO;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.order.TransferRecordVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService, ITransferMessage {
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
    @Autowired
    @Qualifier("messageServiceImpl")
    private MessageService messageService;
    @Autowired
    private FundService fundService;

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public BasicResponse<List<PersonalTradeVO>> getPersonalTradeRecordByUser(Long ID) {
        List<PersonalTradePO> personalTradePOS = personalTradeMapper.selectByUserID(ID);
        List<PersonalTradeVO> vos = new ArrayList<>(personalTradePOS.size());
        for (PersonalTradePO po : personalTradePOS) {
            PersonalTradeVO vo = new PersonalTradeVO(po);
            ProductVO4Order vo4Order = productService4Order.getProducts(po.getProductID(), po.getType());
            if (vo4Order.getName() != null) {
                vo.setProduct(productService4Order.getProducts(po.getProductID(), po.getType()));
                vos.add(vo);
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
    public TransferRecordPO getTransferRecordByID(long id) {
        return transferRecordMapper.selectByID(id);
    }

    @Override
    public List<TransferRecordPO> getTransferRecordByUserID(long userID) {
        return transferRecordMapper.selectByUserID(userID);
    }

    @Override
    public BasicResponse<PersonalTradeVO> addPersonalTradeRecord(PersonalTradeVO personalTradeVO, boolean isCustomize) {
        PersonalTradePO po = assemblePersonalTradePO(personalTradeVO);
        po.setID(null);
        po.setIsCustomize(isCustomize);
        try {
            int insert = personalTradeMapper.insert(po);
            if (insert != 1) {
                logger.error("Insert into personal trade record error.\nRecord: " + po.toString());
                return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }

        //更新最大投资金额
        long userID = personalTradeVO.getUserID();
        String type = personalTradeVO.getType().name().toUpperCase();
        Float latestSum = personalTradeMapper.selectSum(userID, type, null);
        MaxInvestPO max = maxInvestMapper.selectByUserIDAndType(userID, type);
        if (latestSum == null) {
            latestSum = 0.0f;
        }
        if (max == null) {
            max = new MaxInvestPO(userID, type, latestSum, new Date());
            int insert = maxInvestMapper.insert(max);
            if (insert != 1) {
                logger.error("Insert into max invest error.\nRecord: " + max.toString());
                return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
            }
        } else if (max.getMax() < latestSum) {
            max.setMax(latestSum);
            max.setDate(new Date());
            int update = maxInvestMapper.update(max);
            if (update != 1) {
                logger.error("Update transfer record error.\nRecord: " + max.toString());
                return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
            }
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, personalTradeVO);//TODO no return po
    }

    @Override
    public BasicResponse<?> addPlatformTradeRecord(PlatformTradeVO platformTradeVO) {
        PlatformTradePO po = assemblePlatformTradePO(platformTradeVO);
        po.setID(null);
        try {
            int insert = platformTradeMapper.insert(po);
            if (insert == 1) {
                return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, po.getID());
            } else {
                logger.error("Insert into platform trade record error.\nRecord: " + po.toString());
                return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BasicResponse<>(ResponseStatus.SERVER_ERROR, null);
        }
    }

    @Override
    public TransferRecordPO addTransferRecord(TransferRecordPO transferRecordPO) {
        try {
            int insert = transferRecordMapper.insert(transferRecordPO);
            if (insert == 1) {
                return transferRecordPO;
            } else {
                logger.error("Insert into transfer record error.\nRecord: " + transferRecordPO.toString());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TransferRecordPO updateTransferRecord(TransferRecordPO po) {
        try {
            int update = transferRecordMapper.update(po);
            if (update == 1) {
                if (po.getChecked()) {
                    messageService.readTransferMessage(po.getID());
                }
                return po;
            } else {
                logger.error("Update transfer record return error.\nRecord: " + po.toString());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord() {
        List<PersonalTradePO> pos = personalTradeMapper.selectByDate(new Date(), OrderService.Type.BOND.name().toUpperCase());
        List<PersonalTradeVO> vos = new ArrayList<>(pos.size());
        for (PersonalTradePO po : pos) {
            vos.add(new PersonalTradeVO(po));
        }
        return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, vos);
    }

    @Override
    public BasicResponse<List<PersonalTradeVO>> getTodaysPersonalTradeRecord(Type type) {
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
    public BasicResponse completePersonalTrade(long ID, long userID) {
        PersonalTradePO personalTradePO = personalTradeMapper.selectByID(ID);
        BasicResponse<?> response;
        if (personalTradePO == null) {
            response = new BasicResponse<>(ResponseStatus.STATUS_RECORD_NOT_EXIST, "ID=" + ID);
        } else if (!personalTradePO.getUserID().equals(userID)) {
            response = new BasicResponse<>(ResponseStatus.STATUS_NOT_AUTHORIZED, "无法支付非本人的订单");
        } else if (personalTradePO.getStatus() != 0) {
            String reason;
            switch (personalTradePO.getStatus()) {
                case 1:
                    reason = "该笔交易已经完成支付";
                case 2:
                    reason = "该笔交易已被取消";
                default:
                    reason = "未知原因" + personalTradePO.getStatus();
            }
            response = new BasicResponse<>(ResponseStatus.STATUS_TRADE_CANT_PAY, reason);
        } else {
            float balance = fundService.getFund(userID).getAmount().floatValue();
            float toPay = personalTradePO.getTotal();
            if (balance < toPay) {
                response = new BasicResponse<>(ResponseStatus.STATUS_BALANCE_LEAK, "余额 ￥" + balance + " 不足以支付交易金额 ￥" + toPay);
            } else {
                fundService.DecreaseCapital(userID, new BigDecimal(toPay).doubleValue());
                personalTradePO.setCompleteTime(new Date());
                personalTradePO.setStatus(1);
                int update = personalTradeMapper.update(personalTradePO);
                assert update == 1;
                response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new PersonalTradeVO(personalTradePO));
            }
        }
        return response;
    }

    @Override
    public double getMaxInvestBy(Long userID, String type) {
        //BasicResponse<MaxInvestVO> response;
        MaxInvestPO po = maxInvestMapper.selectByUserIDAndType(userID, type.toUpperCase());
        if (po != null) {
            return po.getMax().doubleValue();
            //response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new MaxInvestVO(po));
        } else {
            return 0.0;
            //response = new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, new MaxInvestVO(userID, type, (float) 0, null));
        }
        //return response;
    }

    @Override
    public double getMaxInvestBy(Long userID, Type type, Date noLaterThanDate) {
        MaxInvestPO candidate = maxInvestMapper.selectByUserIDAndType(userID, type.name());
        if (candidate != null) {
            if (candidate.getDate().after(noLaterThanDate)) {
                List<PersonalTradePO> tradePOS = personalTradeMapper.selectByUserIDAndType(userID, type.name(), noLaterThanDate);
                double max = 0, sum = 0;
                for (PersonalTradePO personalTradePO : tradePOS) {
                    sum += personalTradePO.getTotal().doubleValue();
                    if (sum > max) {
                        max = sum;
                    }
                }
                return max;
            } else {
                return candidate.getMax().doubleValue();
            }
        } else {
            return 0.0;
        }
    }

    @Override
    public double getInvestBy(Long userID, String type, Date date) {
        Float sum = personalTradeMapper.selectSum(userID, type, date);
        if (sum != null) {
            return sum.doubleValue();
        } else {
            return 0.0;
        }
        //return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, personalTradeMapper.selectSum(userID, type, date));
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
        po.setUserID(vo.getUserID());
        po.setStatus(vo.getStatus());
        return po;
    }

    @Override
    public TransMessageVO getTransMessageInfoByID(TransMessageVO transMessageVO) {
        if (transMessageVO == null) {
            return null;
        } else {
            long messageID = transMessageVO.getID();
            TransferRecordPO transferRecordPO = transferRecordMapper.selectByMessageID(messageID);
            if (transferRecordMapper.hasTransferRecord(messageID) == 1) {
                transMessageVO.setTransID(transferRecordPO.getID());
                transMessageVO.setAccepted(!transferRecordPO.getDenied());
            } else {
                logger.warn("Missing transfer message record. messageID is " + messageID);
            }
        }
        return transMessageVO;
    }
}
