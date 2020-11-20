package com.xsg.sscm.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @des:    JWT生成令牌、验证令牌、获取令牌
 * @package: com.xsg.sscm.compoent
 * @author: xsg
 * @date: 2020/9/14
 **/
@Component
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String SECRET_KEY;
    @Value("${jwt.expiration}")
    private long EXPIRATION_TIME;
    @Value("${jwt.head}")
    private String HEAD;

    /**
     * 数据声明（用户信息）
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(Claims.SUBJECT, userDetails.getUsername());
        claims.put(Claims.ISSUED_AT, new Date());
        return generateToken(claims);
    }

    /**
     * 生成令牌（根据数据声明）
     */
    private String generateToken(Map<String, Object> claims) {
        //生成过期时间
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        return HEAD + ' '  + Jwts.builder()
                                    .setClaims(claims)
                                    .setExpiration(expirationDate)
                                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                                    .compact();
    }

    /**
     * 从令牌中获取用户名
     */
    public String getUsernameFromToken(String token) {
        String username = null;
        try {
            Claims claims = getClaimsFromToken(token);
            //System.out.println("claims = " + claims.toString());
            username = claims.getSubject();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
        return username;
    }

    /**
     * 从令牌中获取数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            new Throwable(e);
        }
        return claims;
    }

    /**
     * 判断令牌是否过期
     */
    public Boolean isTokenExpired(String token) throws  Exception{
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            new Throwable(e);
        }
        return true;
    }

    /**
     * 刷新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(Claims.ISSUED_AT, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     */
    public Boolean validateToken(String token, UserDetails userDetails) throws Exception {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
