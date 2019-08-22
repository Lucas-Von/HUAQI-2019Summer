package financial_management.util.Interceptor;

import financial_management.util.Context.Context;
import financial_management.util.Context.ContextHolder;
import financial_management.util.JwtUtil;
import financial_management.vo.BasicResponse;
import financial_management.vo.ResponseStatus;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class SetContextInterceptor {

    @Autowired
    JwtUtil jwtUtil;

    @Around("@annotation(financial_management.util.Context.SetContext)")
    public BasicResponse setContext(ProceedingJoinPoint pjp){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if (attr != null && attr.getRequest() != null){
            HttpServletRequest request = attr.getRequest();
            Long userid = jwtUtil.getIdFromRequest(request);
            ContextHolder.create(new Context(userid));
            try {
                return (BasicResponse) pjp.proceed();
            } catch (Throwable throwable) {
                return new BasicResponse(ResponseStatus.STATUS_SERVER_ERROR);
            } finally {
                ContextHolder.destroy();
            }
        }
        return new BasicResponse(ResponseStatus.STATUS_REQUEST_PARAM_ERROR);
    }

}
