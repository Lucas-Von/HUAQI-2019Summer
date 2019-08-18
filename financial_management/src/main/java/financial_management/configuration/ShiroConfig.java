package financial_management.configuration;


import financial_management.util.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 配置类，要3个bean
 * @Author 233loser
 * @Date 2019/8/13 6:58
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    /**
     * @Author jyh
     * @Description //创建ShiroFilterFactoryBean
     * @Date 6:59 2019/8/13
     * @Param
     * @return
     **/
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * @Author jyh
         * @Description //添加常用过滤器，可以实现权限相关的拦截
         *  常用的过滤器：
         *      anon：无需认证（登陆）可以访问
         *      authc：必须认证才可访问
         *      user:如果使用rememberMe的功能可以直接访问
         *      perms：该资源必须获取资源权限才可访问
         *      role：该资源必须得到角色权限才可访问
         **/
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
//        filterMap.put("/add","authc");//第一个是路径，第二个是过滤器
//        filterMap.put("/update","authc");
//        filterMap.put("/testThymeleaf","anon");
//        filterMap.put("/Login","anon");
//        //授权拦截。当授权拦截后，shiro自动跳转到未授权页面
//        filterMap.put("/add","perms[user:add]");
        filterMap.put("/user/register","anon");
        filterMap.put("/user/login/email","anon");
        filterMap.put("/user/activate","anon");
        filterMap.put("/user/get","anon");
        filterMap.put("/user/getAll","anon");
        filterMap.put("/*","anon");//通配

        shiroFilterFactoryBean.setLoginUrl("/user/login/email");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * @Author jyh
     * @Description //创建DefaultWebSecurityManager,Qualifier获取下面的realm
     * @Date 6:59 2019/8/13
     * @Param
     * @return
     **/
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * @Author jyh
     * @Description //创建Realm,bean注解的作用是放入spring环境方便上面方法使用
     * @Date 6:59 2019/8/13
     * @Param
     * @return
     **/
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
}
