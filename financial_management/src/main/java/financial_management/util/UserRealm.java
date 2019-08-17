package financial_management.util;

import financial_management.data.user.UserMapper;
import financial_management.entity.UserPO;
import financial_management.service.user.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author 233loser
 * @Date 2019/8/13 7:01
 * @Version 1.0
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserMapper userMapper;

    /**
     * @Author jyh
     * @Description //执行授权逻辑
     * @Date 7:02 2019/8/13
     * @Param
     * @return
     **/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        subject.getPrincipal();//是下面那个方法中提供的user

        //添加资源的授权字符串
        info.addStringPermission("user:add");
        return info;
    }

    /**
     * @Author jyh
     * @Description //执行认证逻辑
     * @Date 7:02 2019/8/13
     * @Param [authenticationToken]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("授权");

        //假设数据库的用户名和密码


        //编写shiro判断逻辑，判断用户名和密码;但因为我们的密码是加密字符串且无法解码，故放弃密码验证，转为token验证
//        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        UserPO po = new UserPO();
//        String name = po.getName();
//        String password = po.getPassword();
//        if(!token.getUsername().equals(name)){
//            return null;//shiro的底层会抛出UnknownAccountException
//        }
//        return new SimpleAuthenticationInfo(po,po.getPassword(),"");//密码在这里会自动判断
//    }
        String token = (String) authenticationToken.getPrincipal();
        Long id = jwtUtil.getIdFromToken(token);
        //这里使用原来的mapper与实体User，以后可能会需要更改
        //如果user找不到，应该抛出一个异常
        UserPO user = userMapper.selectSimpleUser(id);
        //认证失败应该抛出一个异常，因项目还未完善，暂不处理
        if (!jwtUtil.validateToken(token, user))
            throw new AuthenticationException("Username or password error");

        //参考代码的返回写法是这样，还有待研究
        return new SimpleAuthenticationInfo(token, token, "custom_realm");
    }
}
