package financial_management.util.Cache;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


@Service("redisServer")
public class RedisServerImpl implements RedisServer {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public <T> void set(String key, T obj, int timeout) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(obj),timeout,TimeUnit.MINUTES);
    }

    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void del(String key) {
        redisTemplate.delete(key);
    }

}
