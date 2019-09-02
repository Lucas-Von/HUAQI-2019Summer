package financial_management.service.product;

import financial_management.bl.product.InvestmentService;
import financial_management.data.product.BondMapper;
import financial_management.data.product.GoldMapper;
import financial_management.data.product.StockMapper;
import financial_management.entity.*;
import financial_management.entity.product.BondPO;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import financial_management.vo.order.ProductVO4Order;
import financial_management.vo.product.InvestRecProductVO;
import financial_management.vo.product.InvestmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/20 18:37
 * @Version 1.0
 **/
@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    StockMapper stockMapper;

    @Autowired
    GoldMapper goldMapper;

    @Autowired
    BondMapper bondMapper;

    @Override
    public List<InvestmentVO> getSelfInvProduct(Long userId) {
        List<InvestmentVO> investments = new ArrayList<>();
        List<MyGoldPO> golds = goldMapper.selectSelfGold(userId);
//        golds.stream().forEach(o->{
//            GoldPO gold = goldMapper.selectGoldByCode(o.getCode());
//            InvestmentVO vo =new InvestmentVO(gold.getName(),"黄金",o.getCode(),gold.getLatestPrice().doubleValue(),o.getQuantity(),o.getAmount().doubleValue(),o.getProfit().doubleValue(),o.getProfitRate().doubleValue());
//            investments.add(vo);
//        });

        List<MyBondPO> bonds = bondMapper.selectSelfBond(userId);
        bonds.stream().forEach(o -> {
            BondPO bond = bondMapper.selectBondByCode(o.getCode());
            if (bond != null) {
                InvestmentVO vo = new InvestmentVO(bond.getName(), "债券", o.getCode(), bond.getLatestPrice().doubleValue(), o.getQuantity(), o.getAmount().doubleValue(), o.getProfit().doubleValue(), o.getProfitRate().doubleValue());
                investments.add(vo);
            }
        });

        List<MyStockPO> domStocks = stockMapper.selectSelfDomStock(userId);

        domStocks.stream().forEach(o -> {
            DomStockPO domStock = stockMapper.selectDomStockByCode(o.getCode());
            if (domStock != null) {
                InvestmentVO vo = new InvestmentVO(domStock.getName(), "国内股票", o.getCode(), domStock.getLatestPrice().doubleValue(), o.getHoldAmount(), o.getHoldTotal().doubleValue(), o.getProfit().doubleValue(), o.getProfitRate().doubleValue());
                investments.add(vo);
            }
        });

        List<MyQDIIPO> forStocks = stockMapper.selectSelfForStock(userId);
        forStocks.stream().forEach(o -> {
            ForStockPO forStock = stockMapper.selectForStockByCode(o.getCode());
            if (forStock != null) {
                InvestmentVO vo = new InvestmentVO(forStock.getName(), "海外股票", o.getCode(), forStock.getLatestPrice().doubleValue(), o.getHoldAmount(), o.getHoldTotal().doubleValue(), o.getProfit().doubleValue(), o.getProfitRate().doubleValue());
                investments.add(vo);
            }
        });

        return investments;
    }

    @Override
    public List<InvestRecProductVO> getAllInvProduct() {
        List<InvestRecProductVO> invests = new ArrayList<>();

        List<GoldPO> gold = goldMapper.selectAllGold();
        gold.stream().forEach(o -> {
            InvestRecProductVO vo = new InvestRecProductVO(o.getName(), o.getCode(), o.getLatestPrice().doubleValue());
            invests.add(vo);
        });
        List<BondPO> bond = bondMapper.selectAllBond();
        bond.stream().forEach(o -> {
            InvestRecProductVO vo = new InvestRecProductVO(o.getName(), o.getCode(), o.getLatestPrice().doubleValue());
            invests.add(vo);
        });

        List<DomStockPO> domStocks = stockMapper.selectAllDomStock();
        domStocks.stream().forEach(o -> {
            InvestRecProductVO vo = new InvestRecProductVO(o.getName(), o.getCode(), o.getLatestPrice().doubleValue());
            invests.add(vo);
        });
        List<ForStockPO> forStocks = stockMapper.selectAllForStock();
        forStocks.stream().forEach(o -> {
            InvestRecProductVO vo = new InvestRecProductVO(o.getName(), o.getCode(), o.getLatestPrice().doubleValue());
            invests.add(vo);
        });
        return invests;
    }

    /**
     * @return void
     * @Author jyh
     * @Description //TODO amount和holdings有什么区别
     * @Date 20:32 2019/8/21
     * @Param [userId, code, amount, totalprice, type]
     **/
    @Override
    public BasicResponse purchase(Long userId, String code, Float amount, Double totalprice, String type) {
        try {
            switch (type) {
                case "gold":
//                    MyGoldPO po = new MyGoldPO();
//                    po.setAmount(totalprice.floatValue());
//                    po.setCode(code);
//                    po.setUserId(userId);
//                    //因为刚买，没有利润
//                    po.setProfit(0.0F);
//                    po.setProfitRate(0.0F);
//                    po.setPurchasePrice(totalprice.floatValue());
//                    po.setQuantity(amount);
//                    goldMapper.insertMyGold(po);
                    break;
                case "bond":
                    MyBondPO bondPO = new MyBondPO();
                    bondPO.setAmount(totalprice.floatValue());
                    bondPO.setCode(code);
                    bondPO.setUserId(userId);
                    //因为刚买，没有利润
                    bondPO.setProfit(0.0F);
                    bondPO.setProfitRate(0.0F);
                    bondPO.setPurchasePrice(totalprice.floatValue());
                    bondPO.setQuantity(amount);
                    bondMapper.insertMyBond(bondPO);
                    break;
                case "forStock":
                case "domStock":
                    MyStockPO myStockPO = new MyStockPO();
                    myStockPO.setHoldTotal(totalprice.floatValue());
                    myStockPO.setCode(code);
                    myStockPO.setUserId(userId);
                    //因为刚买，没有利润
                    myStockPO.setProfit(0.0F);
                    myStockPO.setProfitRate(0.0F);
                    myStockPO.setPurchasePrice(totalprice.floatValue());
                    myStockPO.setHoldAmount(amount);
                    stockMapper.insertMyStock(myStockPO);
                    break;
            }
            return new BasicResponse<>(ResponseStatus.STATUS_SUCCESS, null);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new BasicResponse<>(ResponseStatus.STATUS_INVESTMENTPRODUCT_UNFINED, null);
        }
    }

    public ProductVO4Order getProduct(Long id, String type) {

        switch (type) {
            case "gold":
                GoldPO po = goldMapper.selectById(id);
                if (po == null) {
                    return getNullProduct();
                } else {
                    ProductVO4Order vo = new ProductVO4Order();
                    vo.setpID(id);
                    vo.setCode(po.getCode());
                    vo.setName(po.getName());
                    return vo;
                }
            case "bond":
                BondPO bond = bondMapper.selectBondById(id);
                if (bond == null) {
                    return getNullProduct();
                } else {
                    ProductVO4Order vo = new ProductVO4Order();
                    vo.setpID(id);
                    vo.setCode(bond.getCode());
                    vo.setName(bond.getName());
                    return vo;
                }
            case "forStock":
                ForStockPO forStock = stockMapper.selectForStockById(id);
                if (forStock == null) {
                    return getNullProduct();
                } else {
                    ProductVO4Order vo = new ProductVO4Order();
                    vo.setpID(id);
                    vo.setCode(forStock.getCode());
                    vo.setName(forStock.getName());
                    return vo;
                }
            default:
                DomStockPO domStock = stockMapper.selectDomStockById(id);
                if (domStock == null) {
                    return getNullProduct();
                } else {
                    ProductVO4Order vo = new ProductVO4Order();
                    vo.setpID(id);
                    vo.setCode(domStock.getCode());
                    vo.setName(domStock.getName());
                    return vo;
                }
        }

    }

    public ProductVO4Order getNullProduct() {
        ProductVO4Order vo = new ProductVO4Order();
        vo.setName(null);
        vo.setCode(null);
        vo.setpID(null);
        return vo;
    }
}
