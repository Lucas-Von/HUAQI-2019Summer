package financial_management.vo;

public enum  ResponseStatus {

    STATUS_SUCCESS("0000", "success"),
    STATUS_SERVER_ERROR("1111", "server error"),

    STATUS_PSW_WRONG("1000", "password wrong"),
    STATUS_USERNAME_WRONG("1001", "username wrong");

    public String code;

    public String msg;

    private ResponseStatus(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
