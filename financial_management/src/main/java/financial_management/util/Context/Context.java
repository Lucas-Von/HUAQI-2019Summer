package financial_management.util.Context;

public class Context {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Context(Long userId) {
        this.userId = userId;
    }
}
