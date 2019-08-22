package financial_management.vo;

public final class ResponseStatus {

    public static final ResponseStatus STATUS_SUCCESS = new ResponseStatus("0000", "Success");
    public static final ResponseStatus STATUS_SERVER_ERROR = new ResponseStatus("0001", "Server error");
    public static final ResponseStatus STATUS_REQUEST_PARAM_ERROR = new ResponseStatus("0002", "Request param error");

    public static final ResponseStatus STATUS_ARTICLE_NOT_EXIST = new ResponseStatus("2001","The article does not exist");
    public static final ResponseStatus STATUS_ARTICLE_COLLECTED = new ResponseStatus("2002", "The article has been collected");
    public static final ResponseStatus STATUS_ARTICLE_NOT_COLLECTED = new ResponseStatus("2003", "The article has not been collected");
    public static final ResponseStatus STATUS_COMMENT_LIGHTED = new ResponseStatus("2004", "The comment has been lighted");
    public static final ResponseStatus STATUS_COMMENT_NOT_LIGHTED = new ResponseStatus("2005", "The comment has not been lighted");
    public static final ResponseStatus STATUS_COMMENT_NOT_EXIST = new ResponseStatus("2006", "The comment does not exist");

    public static final ResponseStatus STATUS_QUESTION_EXIST = new ResponseStatus("6001","The user has filled out the questionnaire.");
    public static final ResponseStatus STATUS_QUESTION_NOT_EXIST = new ResponseStatus("6002","The user has not filled out the questionnaire.");

    public static final ResponseStatus STATUS_EMAIL_EXIST = new ResponseStatus("8001", "The email has existed");
    public static final ResponseStatus STATUS_IDENTITY_EXIST = new ResponseStatus("8002", "The identity has existed");
    public static final ResponseStatus STATUS_EMAIL_AND_IDENTITY_EXIST = new ResponseStatus("8003", "The email and identity have existed");
    public static final ResponseStatus STATUS_PASSWORD_WRONG = new ResponseStatus("8004", "The password is wrong");
    public static final ResponseStatus STATUS_USER_NOT_EXIST = new ResponseStatus("8005","The user does not exist");
    public static final ResponseStatus STATUS_ACCOUNT_ACTIVATED = new ResponseStatus("8006", "The account has been activated");

    public String code;

    public String msg;

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    private ResponseStatus(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}