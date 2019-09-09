package financial_management.vo;

public final class ResponseStatus {

    public static final ResponseStatus STATUS_SUCCESS = new ResponseStatus("0000", "Success");
    public static final ResponseStatus SERVER_ERROR = new ResponseStatus("0001", "Server error");
    public static final ResponseStatus STATUS_REQUEST_PARAM_ERROR = new ResponseStatus("0002", "Request param error");
    public static final ResponseStatus STATUS_NOT_AUTHORIZED = new ResponseStatus("0003","没有权限");

    public static final ResponseStatus STATUS_ARTICLE_NOT_EXIST = new ResponseStatus("2001","The article does not exist");
    public static final ResponseStatus STATUS_ARTICLE_COLLECTED = new ResponseStatus("2002", "The article has been collected");
    public static final ResponseStatus STATUS_ARTICLE_NOT_COLLECTED = new ResponseStatus("2003", "The article has not been collected");
    public static final ResponseStatus STATUS_COMMENT_LIGHTED = new ResponseStatus("2004", "The comment has been lighted");
    public static final ResponseStatus STATUS_COMMENT_NOT_LIGHTED = new ResponseStatus("2005", "The comment has not been lighted");
    public static final ResponseStatus STATUS_COMMENT_NOT_EXIST = new ResponseStatus("2006", "The comment does not exist");

    public static final ResponseStatus STATUS_WRONG_MESSAGE_TYPE = new ResponseStatus("3001", "消息类型错误");
    public static final ResponseStatus STATUS_MESSAGE_DELETE_SUCCESS = new ResponseStatus("3002", "删除成功");
    public static final ResponseStatus STATUS_MESSAGE_DELETE_FAIL = new ResponseStatus("3003", "删除失败");
    public static final ResponseStatus STATUS_MESSAGE_NOT_EXIST = new ResponseStatus("3404","消息不存在");

    public static final ResponseStatus STATUS_RECORD_NOT_EXIST = new ResponseStatus("4001","记录不存在");
    public static final ResponseStatus STATUS_RECORD_ERROR = new ResponseStatus("4002","记录状态异常");

    public static final ResponseStatus STATUS_PAYPASSWORD_WRONG = new ResponseStatus("5001","支付密码错误");
    public static final ResponseStatus STATUS_DEPOSITPRODUCT_UNFINED = new ResponseStatus("5002","储蓄产品已被下架或不存在");
    public static final ResponseStatus STATUS_INSURANCEPRODUCT_UNFINED = new ResponseStatus("5003","保险产品已被下架或不存在");
    public static final ResponseStatus STATUS_INVESTMENTPRODUCT_UNFINED = new ResponseStatus("5004","投资产品已被下架或不存在");
    public static final ResponseStatus STATUS_TRANSACTION_WRONG = new ResponseStatus("5005","买卖黄金时python函数出错");
    public static final ResponseStatus STATUS_GOLD_NOT_CONFIG = new ResponseStatus("5006","用户未配置过黄金");
    public static final ResponseStatus STATUS_GOLD_NOT_ENOUGH = new ResponseStatus("5007","剩余黄金不够取出需要的金额");
    public static final ResponseStatus STATUS_STOCK_NOT_HOLD = new ResponseStatus("5008","未持有该股票/股指产品");
    public static final ResponseStatus STATUS_STOCK_SELL_LEAK = new ResponseStatus("5009","股票/股指持有额不足卖出金额");

    public static final ResponseStatus STATUS_QUESTIONNAIRE_EXIST = new ResponseStatus("6001","The user has filled out the questionnaire.");
    public static final ResponseStatus STATUS_QUESTIONNAIRE_NOT_EXIST = new ResponseStatus("6002","The user has not filled out the questionnaire.");
    public static final ResponseStatus STATUS_NEWLY_RECORD_NOT_EXIST = new ResponseStatus("6003","The database lacks the transaction record of the user in the past two days.");
    public static final ResponseStatus STATUS_MANAGE_NOT_ADMIN = new ResponseStatus("6004", "The user is not admin.");
    public static final ResponseStatus STATUS_FUNDS_OUT_PLATFORM_NOT_EXIST = new ResponseStatus("6005", "The record of your funds out platform does not exist.");
    public static final ResponseStatus STATUS_INVEST_OUT_PLATFORM_NOT_EXIST = new ResponseStatus("6006", "The record of your invest out platform does not exist.");
    public static final ResponseStatus STATUS_PROPERTY_RECORD_NOT_EXIST = new ResponseStatus("6007", "The record of your property does not exist.");
    public static final ResponseStatus STATUS_RECOMMEND_ALLOCATION_NOT_EXIST = new ResponseStatus("6008", "The record of your recommend allocation does not exist.");

    public static final ResponseStatus STATUS_EMAIL_EXIST = new ResponseStatus("8001", "The email has existed");
    public static final ResponseStatus STATUS_IDENTITY_EXIST = new ResponseStatus("8002", "The identity has existed");
    public static final ResponseStatus STATUS_EMAIL_AND_IDENTITY_EXIST = new ResponseStatus("8003", "The email and identity have existed");
    public static final ResponseStatus STATUS_PASSWORD_WRONG = new ResponseStatus("8004", "The password is wrong");
    public static final ResponseStatus STATUS_USER_NOT_EXIST = new ResponseStatus("8005", "The user does not exist");
    public static final ResponseStatus STATUS_ACCOUNT_ACTIVATED = new ResponseStatus("8006", "The account has been activated");
    public static final ResponseStatus STATUS_INVALID_LINK = new ResponseStatus("8007", "The link is invalid");
    public static final ResponseStatus STATUS_HAS_CHANGED = new ResponseStatus("8008", "You have changed it");
    public static final ResponseStatus STATUS_TIME_OUT = new ResponseStatus("8009", "Time out");

    public static final ResponseStatus STATUS_FEEDBACK_NOT_EXIST = new ResponseStatus("9001","反馈不存在");
    public static final ResponseStatus STATUS_SOLVE_FAIL = new ResponseStatus("9001","答复失败");

    public String code;

    public String msg;

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    private ResponseStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}