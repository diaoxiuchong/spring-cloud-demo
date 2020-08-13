package com.example.common;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @Author: xiuchong
 * @Date: 2020/8/13 14:25
 * @Description: 封装JwtUtils工具类
 */
public class JwtUtils {

    private final String secretString = "12345678901234567890123456789012";
    private final SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));


    public String generateToken(String userId, String userNick, Map<String, Object> other) {
        // 设置有效时间
        long period = 7200000;
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(other) // 使用setClaims可以将Map数据进行加密，必须放在其他变量之前
                .setId(userId)
                .setSubject(userNick)
                .setExpiration(new Date(System.currentTimeMillis() + period)) // 设置有效期
                .signWith(key);
        return jwtBuilder.compact();
    }

    public Claims parseToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

}
