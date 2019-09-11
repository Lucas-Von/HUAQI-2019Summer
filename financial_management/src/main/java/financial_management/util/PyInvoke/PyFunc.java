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
        QDII_MONEY_ADJUST("QDII_First_Purchase.py"),
//      每月调仓
        QDII_ADJUST_MONTHLY("QDII_Adjust_Monthly.py"),
        //用户手动买卖
        QDII_CUSTOMIZE("QDII_User_Purchase.py"),
//    债券
//      首次购买
        BOND_FIRST_PURCHASE("First_Purchase.py"),
//      调整持有额
        BOND_ADJUSTMENT("Adjustment.py"),
//      每天购买
        BOND_DAILY_PURCHASE("Daily_Purchase2.py"),
//      指数维护
        BOND_INDEX_MAINTENANCE("Index_Maintenance.py"),
//    黄金
//      持有额调整
        GOLD_INVEST("Invest_Gold.py"),
//    现金
//      每日更新
        CASH_DAILY_ADJUSTMENT("Info.py"),
//    保险
//      推荐
        INSURANCE_RECOMMEND("insurance_recommand.py"),
//    机器学习
        QUESTIONNAIRE_INVEST_PREFERENCE("mLearning.py"),
//    财务脆弱性
        QUESTIONNAIRE_VULNERABILITY("vulnerability.py"),
//    资产配置
        QUESTIONNAIRE_ASSET_ALLOCATION("asset.py");

    public String path;

    PyFunc(String path){
        this.path = "C:\\Users\\NJ\\Desktop\\py文件\\" + path;
    }

}
