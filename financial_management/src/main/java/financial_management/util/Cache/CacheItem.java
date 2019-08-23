package financial_management.util.Cache;

public class CacheItem<T> {

    public T content;

    private long timeStamp;

    public CacheItem(T content) {
        this.content = content;
        this.timeStamp = System.currentTimeMillis();
    }
}
