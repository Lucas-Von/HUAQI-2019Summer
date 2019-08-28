package financial_management.util.Interceptor;

import com.alibaba.fastjson.JSON;
import financial_management.util.Cache.CacheType;
import financial_management.util.Cache.RedisServer;
import financial_management.util.Cache.UseCache;
import financial_management.util.Context.ContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UseCacheInterceptor {

    @Autowired
    RedisServer redisServer;

    @Around(value = "@annotation(financial_management.util.Cache.UseCache)")
    public Object useCache(ProceedingJoinPoint pjp){
//        System.out.println("_____________________________");
//        return null;
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        UseCache useCache = signature.getMethod().getAnnotation(UseCache.class);
        CacheType key = useCache.key();
        String type = key.type;
        Class clazz = key.clazz;
        int expiredTime = useCache.expiredTime();
//        Long userId = ContextHolder.get().getUserId();
        Long userId = 123L;
        String realKey = type + ":" + userId;
        String record = redisServer.get(realKey);
//        缓存区中不存在该数据
        if (record == null || record.equals("") || record.equals("{}")){
            return getResult(pjp, realKey, expiredTime);
        }
//        缓存区中存在该数据
        else {
            return JSON.parseObject(record, clazz);
        }
    }

//    从下层获取数据并存入redis
    private Object getResult(ProceedingJoinPoint pjp, String key, int expiredTime){
        try {
            Object result = pjp.proceed();
            String str = JSON.toJSONString(result);
            redisServer.set(key, str, expiredTime);
            return result;
        } catch (Throwable throwable) {
            return null;
        }
    }
}
