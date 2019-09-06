package financial_management.util.PyInvoke.PyParam.questionnaire;

import financial_management.util.PyInvoke.PyParam.PyParam;

/**
 * @author lt
 * @date 2019/08/31 16:35
 */
public class MLearningConfigParam extends PyParam {

    /**
     * 金融信息关注程度
     */
    private int finInfo;

    /**
     * 风险和汇报组合选择
     */
    private int volChose;

    /**
     * 股票和基金个人偏好
     */
    private int stockPrefer;

    /**
     * 银行储蓄卡数
     */
    private int bankCard;

    /**
     * 活期存款余额
     */
    private double currentDeposit;

    /**
     * 定期存款总额
     */
    private double fixedDeposit;

    /**
     * 是否持有基金
     */
    private int haveFund;

    /**
     * 是否拥有银行理财产品
     */
    private int haveBank;

    /**
     * 去年平均每月伙食费
     */
    private double boardWages;

    /**
     * 伙食费中在外就餐花费
     */
    private double boardWageOutside;

    /**
     * 去年平均每月购买日常用品支出
     */
    private double monthlySupply;

    /**
     * 去年平均每月本地交通支出
     */
    private double monthlyTraffic;

    /**
     * 去年每月通信费支出
     */
    private double monthlyPhone;

    /**
     * 去年平均每月文化娱乐支出
     */
    private double monthlyPlay;

    /**
     * 去年购买衣物支出
     */
    private double lastClothes;

    /**
     * 去年旅游总支出
     */
    private double lastTourist;

    /**
     * 去年平均每月水/电/燃料费/物业费
     */
    private double monthlyTenement;

    /**
     * 总资产
     */
    private double asset;

    /**
     * 总收入
     */
    private double totalIncome;

    public MLearningConfigParam(int finInfo, int volChose, int stockPrefer, int bankCard, double currentDeposit, double fixedDeposit, int haveFund, int haveBank, double boardWages, double boardWageOutside, double monthlySupply, double monthlyTraffic, double monthlyPhone, double monthlyPlay, double lastClothes, double lastTourist, double monthlyTenement, double asset, double totalIncome) {
        this.finInfo = finInfo;
        this.volChose = volChose;
        this.stockPrefer = stockPrefer;
        this.bankCard = bankCard;
        this.currentDeposit = currentDeposit;
        this.fixedDeposit = fixedDeposit;
        this.haveFund = haveFund;
        this.haveBank = haveBank;
        this.boardWages = boardWages;
        this.boardWageOutside = boardWageOutside;
        this.monthlySupply = monthlySupply;
        this.monthlyTraffic = monthlyTraffic;
        this.monthlyPhone = monthlyPhone;
        this.monthlyPlay = monthlyPlay;
        this.lastClothes = lastClothes;
        this.lastTourist = lastTourist;
        this.monthlyTenement = monthlyTenement;
        this.asset = asset;
        this.totalIncome = totalIncome;
    }

    public MLearningConfigParam() {

    }

    public int getFinInfo() {
        return finInfo;
    }

    public void setFinInfo(int finInfo) {
        this.finInfo = finInfo;
    }

    public int getVolChose() {
        return volChose;
    }

    public void setVolChose(int volChose) {
        this.volChose = volChose;
    }

    public int getStockPrefer() {
        return stockPrefer;
    }

    public void setStockPrefer(int stockPrefer) {
        this.stockPrefer = stockPrefer;
    }

    public int getBankCard() {
        return bankCard;
    }

    public void setBankCard(int bankCard) {
        this.bankCard = bankCard;
    }

    public double getCurrentDeposit() {
        return currentDeposit;
    }

    public void setCurrentDeposit(double currentDeposit) {
        this.currentDeposit = currentDeposit;
    }

    public double getFixedDeposit() {
        return fixedDeposit;
    }

    public void setFixedDeposit(double fixedDeposit) {
        this.fixedDeposit = fixedDeposit;
    }

    public int getHaveFund() {
        return haveFund;
    }

    public void setHaveFund(int haveFund) {
        this.haveFund = haveFund;
    }

    public int getHaveBank() {
        return haveBank;
    }

    public void setHaveBank(int haveBank) {
        this.haveBank = haveBank;
    }

    public double getBoardWages() {
        return boardWages;
    }

    public void setBoardWages(double boardWages) {
        this.boardWages = boardWages;
    }

    public double getBoardWageOutside() {
        return boardWageOutside;
    }

    public void setBoardWageOutside(double boardWageOutside) {
        this.boardWageOutside = boardWageOutside;
    }

    public double getMonthlySupply() {
        return monthlySupply;
    }

    public void setMonthlySupply(double monthlySupply) {
        this.monthlySupply = monthlySupply;
    }

    public double getMonthlyTraffic() {
        return monthlyTraffic;
    }

    public void setMonthlyTraffic(double monthlyTraffic) {
        this.monthlyTraffic = monthlyTraffic;
    }

    public double getMonthlyPhone() {
        return monthlyPhone;
    }

    public void setMonthlyPhone(double monthlyPhone) {
        this.monthlyPhone = monthlyPhone;
    }

    public double getMonthlyPlay() {
        return monthlyPlay;
    }

    public void setMonthlyPlay(double monthlyPlay) {
        this.monthlyPlay = monthlyPlay;
    }

    public double getLastClothes() {
        return lastClothes;
    }

    public void setLastClothes(double lastClothes) {
        this.lastClothes = lastClothes;
    }

    public double getLastTourist() {
        return lastTourist;
    }

    public void setLastTourist(double lastTourist) {
        this.lastTourist = lastTourist;
    }

    public double getMonthlyTenement() {
        return monthlyTenement;
    }

    public void setMonthlyTenement(double monthlyTenement) {
        this.monthlyTenement = monthlyTenement;
    }

    public double getAsset() {
        return asset;
    }

    public void setAsset(double asset) {
        this.asset = asset;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

}
