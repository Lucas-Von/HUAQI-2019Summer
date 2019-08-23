package financial_management.util.Interceptor;

import com.alibaba.fastjson.JSON;
import financial_management.util.Cache.CacheType;
import financial_management.util.Cache.UseCache;
import financial_management.util.Context.ContextHolder;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import redis.clients.jedis.Jedis;

@Aspect
public class UseCacheInterceptor {

    private static Jedis jedis = new Jedis("localhost");

    private static final String splitTag = "_";

    @Around("@annotation(financial_management.util.Cache.UseCache)")
    public Object useCache(ProceedingJoinPoint pjp){
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        UseCache useCache = signature.getMethod().getAnnotation(UseCache.class);
        CacheType key = useCache.key();
        long expiredTime = useCache.expiredTime();
        Long userId = ContextHolder.get().getUserId();
        String realKey = jedis.get(key.type + ":" + userId);
        String record = jedis.get(realKey);
//        缓存区中不存在该数据
        if (record == null || record.equals("") || record.equals("{}")){
            return getResult(pjp, realKey);
        }
//        缓存区中存在该数据
        else {
            long  timeStamp = Long.parseLong(record.split(splitTag)[1]);
//            数据已过期
            if (System.currentTimeMillis() - timeStamp > expiredTime){
                return getResult(pjp, realKey);
            }
//            数据未过期
            else {
                String jsonStr = record.split(splitTag)[0];
                return JSON.parse(jsonStr);
            }
        }
    }

//    从下层获取数据并存入redis
    private Object getResult(ProceedingJoinPoint pjp, String key){
        try {
            Object result = pjp.proceed();
            String str = JSON.toJSONString(result) + splitTag + System.currentTimeMillis();
            jedis.set(key, str);
            return result;
        } catch (Throwable throwable) {
            return null;
        }
    }

}
