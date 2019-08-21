package financial_management.vo;

public final class ResponseStatus {
    public String code;

    public String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    private ResponseStatus(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
