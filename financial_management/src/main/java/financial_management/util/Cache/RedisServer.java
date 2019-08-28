package financial_management.util.Cache;

public interface RedisServer {

//    添加记录
    <T> void set(String key, T obj, int timeout);

//    获取记录
    String get(String key);

//    删除记录
    void del(String key);

}
