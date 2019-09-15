package financial_management.util.PyInvoke;

public enum PyFunc {
    //    测试
    DEMO("invoke.py"),
    //    股票
//      首次购买/持有额调整
//        STOCK_MONEY_ADJUST("Stock_Money_Adjust.py"),
//      每周调仓
//        STOCK_ADJUST_WEEKLY("Stock_Adjust_Weekly.py"),
//        股票全都用一个函数了
        STOCK("uqer_spider.py"),
    //股票和黄金日更新
        STOCK_DAILY_UPDATE("Stock_Daily_Update.py"),
    //    股指
//      首次购买/持有额调整
        QDII_FIRST_PURCHASE("QDII_First_Purchase.py"),
    //      每月调仓
        QDII_ADJUST_MONTHLY("QDII_Adjust_Monthly.py"),
    //用户手动买卖
        QDII_CUSTOMIZE("QDII_User_Purchase.py"),
    //股指日更新
        QDII_DAILY_UPDATE("QDII_Daily_Update.py"),
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
    //    现金
//      每日更新
        CASH_DAILY_ADJUSTMENT("Info.py"),
    //    保险
//      推荐
        INSURANCE_RECOMMEND("insurance_recommand.py"),
//    机器学习
        QUESTIONNAIRE_INVEST_PREFERENCE("mLearning/mLearning.py"),
//    财务脆弱性
        QUESTIONNAIRE_VULNERABILITY("vulnerability/vulnerability.py"),
//    资产配置
        QUESTIONNAIRE_ASSET_ALLOCATION("asset/asset.py"),
//    VIP等级计算
        QUESTIONNAIRE_VIP_LEVEL("my_score_card.py"),
    //客服问答
        QA("QA.py");

    public String path;


    /**
     * 为了满足所有人的调试需求及服务器的运行需要，把path的自定义放在了application.yml的python.dir里
     * 在各自的application.yml中自定义即可
     * 因为枚举不能使用Autowired，所以path的生成移动到PyInvoke中
     * @param path 文件名
     */
    PyFunc(String path) {
        this.path = path;
//
//        this.path = "D:\\学习资料\\大二下\\花旗杯\\py\\" + path;

    }

}
