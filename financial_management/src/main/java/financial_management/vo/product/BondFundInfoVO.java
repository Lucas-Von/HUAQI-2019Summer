package financial_management.vo.product;

import financial_management.entity.PlatformTradePO;
import financial_management.entity.bond.BondAndFundPO;
import financial_management.entity.bond.NetWorthPO;
import financial_management.entity.bond.RateList;
import financial_management.vo.order.PlatformTradeVO;

import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/12 22:00
 * @Version 1.0
 **/
public class BondFundInfoVO {
    String exponent;
    Float fundScale;
    Float fundShare;
    List<BondAndFundPO> list;
    Float bondAmount;
    Float cashAmount;
    List<NetWorthPO> netWorths;
    List<PlatformTradeVO> trades;
    List<Float> rateList;

    public List<Float> getRateList() {
        return rateList;
    }

    public void setRateList(List<Float> rateList) {
        this.rateList = rateList;
    }

    public List<PlatformTradeVO> getTrades() {
        return trades;
    }

    public void setTrades(List<PlatformTradeVO> trades) {
        this.trades = trades;
    }

    public List<NetWorthPO> getNetWorths() {
        return netWorths;
    }

    public void setNetWorths(List<NetWorthPO> netWorths) {
        this.netWorths = netWorths;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public Float getFundScale() {
        return fundScale;
    }

    public void setFundScale(Float fundScale) {
        this.fundScale = fundScale;
    }

    public Float getFundShare() {
        return fundShare;
    }

    public void setFundShare(Float fundShare) {
        this.fundShare = fundShare;
    }

    public List<BondAndFundPO> getList() {
        return list;
    }

    public void setList(List<BondAndFundPO> list) {
        this.list = list;
    }

    public Float getBondAmount() {
        return bondAmount;
    }

    public void setBondAmount(Float bondAmount) {
        this.bondAmount = bondAmount;
    }

    public Float getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Float cashAmount) {
        this.cashAmount = cashAmount;
    }
}
