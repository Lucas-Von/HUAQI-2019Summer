package financial_management.entity;

public class Response<T> {
    private boolean success;
    private int statusCode;
    private String message;
    private T content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Response(boolean success, int statusCode, String message, T content) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.content = content;
    }
}
