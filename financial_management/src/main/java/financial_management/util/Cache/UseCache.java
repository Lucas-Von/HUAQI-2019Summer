package financial_management.util.Cache;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface UseCache {
    CacheType key();
    int expiredTime() default 1;
}
