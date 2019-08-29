package financial_management.util.PyInvoke;

public enum PyFunc {
//    测试
    DEMO("invoke.py"),
//    股票
//      首次购买/持有额调整
        STOCK_MONEY_ADJUST("Stock_Money_Adjust.py"),
//      每周调仓
        STOCK_ADJUST_WEEKLY("Stock_Adjust_Weekly.py"),
//    股指
//      首次购买/持有额调整
        QDII_MONEY_ADJUST("QDII_Money_Adjust.py"),
//      每月调仓
        QDII_ADJUST_MONTHLY("QDII_Adjust_Monthly.py"),
//    债券
//      首次购买
        BOND_FIRST_PURCHASE("First_Purchase.py"),
//      调整持有额
        BOND_ADJUSTMENT("Adjustment.py"),
//      每天购买
        BOND_DAILY_PURCHASE("Daily_Purchase.py"),
//      指数维护
        BOND_INDEX_MAINTENANCE("Index_Maintenance.py"),
//    黄金
//      持有额调整
        GOLD_INVEST("Invest_Gold.py"),
//    保险
//      推荐
        INSURANCE_RECOMMEND("Insurance_Recommend.py"),
//    用户投资偏好
        INVEST_PREFERENCE("Invest_Preference.py"),
//    财务脆弱性+总体资产配置
        FIN_FRAGILITY_ASSET_ALLOCATION("Fin_Fragility_Asset_Allocation.py");

    public String path;

    PyFunc(String path){
        this.path = "..\\PyFuncs\\" + path;
    }

}
