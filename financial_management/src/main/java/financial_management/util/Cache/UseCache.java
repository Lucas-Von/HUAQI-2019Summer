package financial_management.util.Cache;

public @interface UseCache {
    CacheType key();
    long expiredTime() default 60*1000;
}
