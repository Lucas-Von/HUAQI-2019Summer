package financial_management.service.order.stub;

import financial_management.bl.order.OrderService;
import financial_management.entity.Response;
import financial_management.vo.order.TradeRecordVO;
import financial_management.vo.order.TransferRecordVO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceStub implements OrderService {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private TradeRecordVO vo;
    private TradeRecordVO vo1;
    private TradeRecordVO vo2;
    private TransferRecordVO voo;
    private TransferRecordVO voo1;

    {
        vo = new TradeRecordVO();
        vo.setID(1);
        vo.setTransID(1);
        try {
            vo.setCreateTime(sdf.parse("2019-08-09 09:09:09"));
            vo.setCompleteTime(sdf.parse("2019-08-09 09:09:19"));
        } catch (ParseException ignored) {

        }
        vo.setProduct("博时黄金ETF联接C");
        vo.setType("黄金");
        vo.setPcode(2611);
        vo.setAmount(100);
        vo.setPrice((float) 1.1777);
        vo.setTotal((float) 117.77);
        vo.setUserID(1);
        vo.setStatus(1);

        vo1 = new TradeRecordVO();
        vo1.setID(2);
        vo1.setTransID(2);
        try {
            vo1.setCreateTime(sdf.parse("2019-08-19 09:09:09"));
            vo1.setCompleteTime(sdf.parse("2019-08-19 09:09:19"));
        } catch (ParseException ignored) {

        }
        vo1.setProduct("卖了不亏基金");
        vo1.setType("基金");
        vo1.setPcode(777);
        vo1.setAmount(-100);
        vo1.setPrice(1);
        vo1.setTotal(-100);
        vo1.setUserID(1);
        vo1.setStatus(1);

        vo2 = new TradeRecordVO();
        vo2.setID(3);
        vo2.setTransID(2);
        try {
            vo.setCreateTime(sdf.parse("2019-08-09 09:09:20"));
            vo.setCompleteTime(sdf.parse("2019-08-09 09:09:30"));
        } catch (ParseException ignored) {

        }
        vo2.setProduct("买了就赚基金");
        vo2.setType("基金");
        vo2.setPcode(4396);
        vo2.setAmount(50);
        vo2.setPrice(2);
        vo2.setTotal(100);
        vo2.setUserID(1);
        vo2.setStatus(1);

        voo = new TransferRecordVO();
        voo.setID(1);
        try {
            voo.setCreateTime(sdf.parse("2019-08-09 09:09:09"));
            voo.setCompleteTime(sdf.parse("2019-08-09 09:09:19"));
        } catch (ParseException ignored) {

        }
        voo.setBuyType("黄金");
        voo.setBuyList(Collections.singletonList(vo));
        voo.setUserID(1);
        voo.setStatus(1);

        voo1 = new TransferRecordVO();
        voo1.setID(2);
        try {
            voo1.setCreateTime(sdf.parse("2019-08-19 09:09:09"));
            voo1.setCompleteTime(sdf.parse("2019-08-19 09:09:30"));
        } catch (ParseException ignored) {

        }
        voo1.setSellType("基金");
        voo1.setBuyType("基金");
        voo1.setSellList(Collections.singletonList(vo1));
        voo1.setBuyList(Collections.singletonList(vo2));
        voo1.setUserID(1);
        voo1.setStatus(1);
    }

    @Override
    public Response<List<TradeRecordVO>> getTradeRecordByUser(Long ID) {
        Response<List<TradeRecordVO>> response;
        if (ID != 1) {
            String message = "只有ID为1的用户有交易记录！";
            response = new Response<>(false, 404, message, null);
        } else {
            List<TradeRecordVO> list = new ArrayList<>(3);
            list.add(vo);
            list.add(vo1);
            list.add(vo2);
            response = new Response<>(true, 200, null, list);
        }
        return response;
    }

    @Override
    public Response<TradeRecordVO> getTradeRecordByRecord(Long ID) {
        Response<TradeRecordVO> response;
        if (ID < 1 || ID > 3) {
            String message = "只有ID为1~3的交易记录！";
            response = new Response<>(false, 404, message, null);
        } else if (ID == 1) {
            response = new Response<>(true, 200, null, vo);
        } else if (ID == 2) {
            response = new Response<>(true, 200, null, vo1);
        } else {
            response = new Response<>(true, 200, null, vo2);
        }
        return response;
    }

    @Override
    public Response<List<TransferRecordVO>> getTransferRecordByUser(Long ID) {
        Response<List<TransferRecordVO>> response;
        if (ID != 1) {
            String message = "只有ID为1的用户有调仓记录！";
            response = new Response<>(false, 404, message, null);
        } else {
            List<TransferRecordVO> list = new ArrayList<>(2);
            list.add(voo);
            list.add(voo1);
            response = new Response<>(true, 200, null, list);
        }
        return response;
    }

    @Override
    public Response<TransferRecordVO> getTransferRecordByRecord(Long ID) {
        Response<TransferRecordVO> response;
        if (ID == 1) {
            response = new Response<>(true, 200, null, voo);
        } else if (ID == 2) {
            response = new Response<>(true, 200, null, voo1);
        } else {
            String message = "只有ID为1或2的调仓记录！";
            response = new Response<>(false, 404, message, null);
        }
        return response;
    }
}
