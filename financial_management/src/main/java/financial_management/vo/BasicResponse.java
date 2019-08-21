package financial_management.vo;

public class BasicResponse<T> {

    ResponseStatus status;

    T data;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BasicResponse(ResponseStatus status, T data){
        this.status = status;
        this.data = data;
    }

    public BasicResponse(ResponseStatus status){
        this(status, null);
    }
}
