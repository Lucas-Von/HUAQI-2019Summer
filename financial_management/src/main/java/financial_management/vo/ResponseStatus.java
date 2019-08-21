package financial_management.vo;

public final class ResponseStatus {

    public static final ResponseStatus STATUS_SUCCESS = new ResponseStatus("0000", "Success");

    public static final ResponseStatus SERVER_ERROR = new ResponseStatus("0001", "Server error");


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