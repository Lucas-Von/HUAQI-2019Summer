package financial_management.parameter.property;

import java.util.Date;

public class QuestionnaireParam {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 更新问卷日期
     */
    private Date recordDate;

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

    /**
     * 妻子出生年份
     */
    private int wifeInbornYear;

    /**
     * 丈夫出生年份
     */
    private int husInbornYear;

    /**
     * 孩子数量
     */
    private int childNum;

    /**
     * 老人数量
     */
    private int oldNum;

    /**
     * 丈夫年收入
     */
    private double husIncome;

    /**
     * 妻子年收入
     */
    private double wifeIncome;

    /**
     * 汽车价值
     */
    private double carValue;

    /**
     * 每年的生活消费
     */
    private double lifeCost;

    /**
     * 户主年龄
     */
    private int age;

    /**
     * 是否结婚
     */
    private int marriage;

    /**
     * 小孩年龄
     */
    private int childBornYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getRecordDate() {
        return new Date();
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

    public int getWifeInbornYear() {
        return wifeInbornYear;
    }

    public void setWifeInbornYear(int wifeInbornYear) {
        this.wifeInbornYear = wifeInbornYear;
    }

    public int getHusInbornYear() {
        return husInbornYear;
    }

    public void setHusInbornYear(int husInbornYear) {
        this.husInbornYear = husInbornYear;
    }

    public int getChildNum() {
        return childNum;
    }

    public void setChildNum(int childNum) {
        this.childNum = childNum;
    }

    public int getOldNum() {
        return oldNum;
    }

    public void setOldNum(int oldNum) {
        this.oldNum = oldNum;
    }

    public double getHusIncome() {
        return husIncome;
    }

    public void setHusIncome(double husIncome) {
        this.husIncome = husIncome;
    }

    public double getWifeIncome() {
        return wifeIncome;
    }

    public void setWifeIncome(double wifeIncome) {
        this.wifeIncome = wifeIncome;
    }

    public double getCarValue() {
        return carValue;
    }

    public void setCarValue(double carValue) {
        this.carValue = carValue;
    }

    public double getLifeCost() {
        return lifeCost;
    }

    public void setLifeCost(double lifeCost) {
        this.lifeCost = lifeCost;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarriage() {
        return marriage;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public int getChildBornYear() {
        return childBornYear;
    }

    public void setChildBornYear(int childBornYear) {
        this.childBornYear = childBornYear;
    }

}
