package financial_management.entity.property;

import java.util.Date;

/**
 * @author lt
 * @version 1.0
 * @description 增加&更新用户问卷信息的数据集
 * @date 2019/09/14 20:22
 */
public class QuestionnaireSetPO {

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
    private String childBornYear;

    /**
     * VIP等级
     */
    private int vipLevel;

    /**
     * 未付欠款
     */
    private double unpaidArrears;

    /**
     * 上期应还欠款
     */
    private double previousArrearsDue;

    /**
     * 信用额度
     */
    private double lineOfCredit;

    /**
     * 预提现金额度
     */
    private double cashAdvance;

    /**
     * 上次付款额
     */
    private double lastPayment;

    /**
     * 最低到期付款额
     */
    private double minimumDuePayment;

    public QuestionnaireSetPO(Long userId, Date recordDate, int finInfo, int volChose, int stockPrefer, int bankCard, double currentDeposit, double fixedDeposit, int haveFund, int haveBank, double boardWages, double boardWageOutside, double monthlySupply, double monthlyTraffic, double monthlyPhone, double monthlyPlay, double lastClothes, double lastTourist, double monthlyTenement, double asset, double totalIncome, int wifeInbornYear, int husInbornYear, int childNum, int oldNum, double husIncome, double wifeIncome, double carValue, double lifeCost, int age, int marriage, String childBornYear, int vipLevel, double unpaidArrears, double previousArrearsDue, double lineOfCredit, double cashAdvance, double lastPayment, double minimumDuePayment) {
        this.userId = userId;
        this.recordDate = recordDate;
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
        this.wifeInbornYear = wifeInbornYear;
        this.husInbornYear = husInbornYear;
        this.childNum = childNum;
        this.oldNum = oldNum;
        this.husIncome = husIncome;
        this.wifeIncome = wifeIncome;
        this.carValue = carValue;
        this.lifeCost = lifeCost;
        this.age = age;
        this.marriage = marriage;
        this.childBornYear = childBornYear;
        this.vipLevel = vipLevel;
        this.unpaidArrears = unpaidArrears;
        this.previousArrearsDue = previousArrearsDue;
        this.lineOfCredit = lineOfCredit;
        this.cashAdvance = cashAdvance;
        this.lastPayment = lastPayment;
        this.minimumDuePayment = minimumDuePayment;
    }

    public QuestionnaireSetPO() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
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

    public String getChildBornYear() {
        return childBornYear;
    }

    public void setChildBornYear(String childBornYear) {
        this.childBornYear = childBornYear;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public double getUnpaidArrears() {
        return unpaidArrears;
    }

    public void setUnpaidArrears(double unpaidArrears) {
        this.unpaidArrears = unpaidArrears;
    }

    public double getPreviousArrearsDue() {
        return previousArrearsDue;
    }

    public void setPreviousArrearsDue(double previousArrearsDue) {
        this.previousArrearsDue = previousArrearsDue;
    }

    public double getLineOfCredit() {
        return lineOfCredit;
    }

    public void setLineOfCredit(double lineOfCredit) {
        this.lineOfCredit = lineOfCredit;
    }

    public double getCashAdvance() {
        return cashAdvance;
    }

    public void setCashAdvance(double cashAdvance) {
        this.cashAdvance = cashAdvance;
    }

    public double getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(double lastPayment) {
        this.lastPayment = lastPayment;
    }

    public double getMinimumDuePayment() {
        return minimumDuePayment;
    }

    public void setMinimumDuePayment(double minimumDuePayment) {
        this.minimumDuePayment = minimumDuePayment;
    }

}