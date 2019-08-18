package financial_management.util;

import financial_management.entity.UserPO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @Description 有一部分是挪用的
 * TODO 重设token部分逻辑还没想好怎么写
 * @Author 233loser
 * @Date 2019/8/17 10:41
 * @Version 1.0
 **/
@Component
public class JwtUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;
    private Clock clock = DefaultClock.INSTANCE;

    private String secret = "SecretForFinancial";


    private static Long expiration = 604800L;

    //这里因为采用yml配置，不清楚怎么导入头部 所以写死
//    public Long getIdFromRequest(HttpServletRequest request, String tokenHeader) {
//        String raw = request.getHeader(tokenHeader);
//        if (raw.length() <= 7)
//            return null;
//        return getIdFromToken(raw.substring(7));
//    }
    public Long getIdFromRequest(HttpServletRequest request) {
        String raw = request.getHeader("Authorization");
        if (raw.length() <= 7)
            return null;
        return getIdFromToken(raw.substring(7));
    }

    /**
     * 从token中获取用户id
     * 在此项目中默认token中保存用户id，为纯数字
     *
     * @param token 登录令牌
     * @return 用户id
     */
    public Long getIdFromToken(String token) {
        //复用方法
        return Long.valueOf(getUsernameFromToken(token));
    }

    /**
     * 通用方法，从token中获取用户名
     *
     * @param token 登录令牌
     * @return 解析出的用户名
     */
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * 获取token生成时间
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    /**
     * 获取过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * token是否过期
     *
     * @param token 待检验登录令牌
     * @return 返回{@code true}如果token已过期，否则返回{@code false}
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    /**
     * 判断token是否是在上次密码重设时间之前生成的
     */
    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    /**
     * 判断token是否是在上次登出之前生成的
     */
    private Boolean isCreatedBeforeLastLogout(Date created, Date lastLogout) {
        return (lastLogout != null && created.before(lastLogout));
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    /**
     * 根据user信息生成token
     *
     * @param user {@link }的实例对象，保存了安全要求相关的信息
     * @return
     */
    public String generateToken(String user) {
        Map<String, Object> claims = new HashMap<>();
        //因不需要额外信息，在此处设信息集为空
        return doGenerateToken(claims, String.valueOf(user));
    }

    /**
     * token生成逻辑
     *
     * @param claims  信息集
     * @param subject 用户名
     * @return 生成的token
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getIssuedAtDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public String refreshToken(String token) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 验证token是否有效
     *
     * @param token 待验证token
     * @param user  用于判断token信息是否与该对象相匹配
     * @return 返回{@code true}如果token仍有效，否则返回{@code false}
     */
    public Boolean validateToken(String token, UserPO user) {
        final Long id = getIdFromToken(token);
        final Date created = getIssuedAtDateFromToken(token);
        //final Date expiration = getExpirationDateFromToken(token);
        return id.equals(user.getUserId())
                && !isTokenExpired(token);
    }

    /**
     * 获取过期时间
     * 根据默认的有效期长度，从创建时间计算出过期时间
     *
     * @param createdDate 创建时间
     * @return 该创建时间对应的过期时间
     */
    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }
}

