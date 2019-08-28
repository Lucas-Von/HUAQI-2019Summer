package financial_management.util.Context;

import financial_management.util.Context.Context;

public class ContextHolder {

    private static ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<>();

    public static void create(Context context){
        THREAD_LOCAL.set(context);
    }

    public static Context get(){
        return THREAD_LOCAL.get();
    }

    public static void destroy(){
        THREAD_LOCAL.remove();
    }

}
