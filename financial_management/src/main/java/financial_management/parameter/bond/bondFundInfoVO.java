package financial_management.parameter.bond;

import financial_management.util.PyInvoke.PyParam.bond.BondsInfo;

import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/9/5 23:44
 * @Version 1.0
 **/
public class bondFundInfoVO {
    List<ReturnRateVO> sevenNetWorth;
    List<ReturnRateVO> monthNetWorth;
    List<ReturnRateVO> threeMonthNetWorth;
    List<Double> returnRate;
    Date startDate;
    Float fundScale;
    String manager;
    String transactionState;
    List<Float> commissionRate;
    List<BondsInfo> bonds;

    public List<ReturnRateVO> getSevenNetWorth() {
        return sevenNetWorth;
    }

    public void setSevenNetWorth(List<ReturnRateVO> sevenNetWorth) {
        this.sevenNetWorth = sevenNetWorth;
    }

    public List<ReturnRateVO> getMonthNetWorth() {
        return monthNetWorth;
    }

    public void setMonthNetWorth(List<ReturnRateVO> monthNetWorth) {
        this.monthNetWorth = monthNetWorth;
    }

    public List<ReturnRateVO> getThreeMonthNetWorth() {
        return threeMonthNetWorth;
    }

    public void setThreeMonthNetWorth(List<ReturnRateVO> threeMonthNetWorth) {
        this.threeMonthNetWorth = threeMonthNetWorth;
    }

    public List<Double> getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(List<Double> returnRate) {
        this.returnRate = returnRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(String transactionState) {
        this.transactionState = transactionState;
    }

    public List<Float> getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(List<Float> commissionRate) {
        this.commissionRate = commissionRate;
    }

    public List<BondsInfo> getBonds() {
        return bonds;
    }

    public void setBonds(List<BondsInfo> bonds) {
        this.bonds = bonds;
    }

    public bondFundInfoVO() {
    }

    public Float getFundScale() {
        return fundScale;
    }

    public void setFundScale(Float fundScale) {
        this.fundScale = fundScale;
    }

    public bondFundInfoVO(List<ReturnRateVO> sevenNetWorth, List<ReturnRateVO> monthNetWorth, List<ReturnRateVO> threeMonthNetWorth, List<Double> returnRate, Date startDate, String manager,Float scale, String transactionState, List<Float> commissionRate, List<BondsInfo> bonds) {
        this.sevenNetWorth = sevenNetWorth;
        this.monthNetWorth = monthNetWorth;
        this.threeMonthNetWorth = threeMonthNetWorth;
        this.returnRate = returnRate;
        this.startDate = startDate;
        this.fundScale = scale;
        this.manager = manager;
        this.transactionState = transactionState;
        this.commissionRate = commissionRate;
        this.bonds = bonds;
    }
}
