package financial_management.vo;

public class BasicResponse<T> {

    ResponseStatus status;

    T data;

    public BasicResponse(ResponseStatus status, T data){
        this.status = status;
        this.data = data;
    }

    public BasicResponse(ResponseStatus status){
        this(status, null);
    }
}
