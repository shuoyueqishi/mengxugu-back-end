package com.xlt.myproject.utils;

import com.xlt.myproject.constant.JwtConstant;
import com.xlt.myproject.model.JwtCheckResult;
import com.xlt.myproject.service.impl.UserServiceImpl;
import io.jsonwebtoken.*;
import org.apache.log4j.Logger;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

public class JwtUtils {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    /**
     * 签发JWT
     *
     * @param id
     * @param subject   可以是JSON数据 尽可能少
     * @param ttlMillis
     * @return String
     */
    public static String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)   // 主题
                .setIssuer("Alex Xu")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static JwtCheckResult validateToken(String token) {
        JwtCheckResult jwtCheckResult = new JwtCheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(token);
            jwtCheckResult.setSuccess(true);
            jwtCheckResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            jwtCheckResult.setErrCode(JwtConstant.JWT_ERRCODE_EXPIRE);
            jwtCheckResult.setSuccess(false);
        } catch (SignatureException e) {
            jwtCheckResult.setErrCode(JwtConstant.JWT_ERRCODE_FAIL);
            jwtCheckResult.setSuccess(false);
        } catch (Exception e) {
            jwtCheckResult.setErrCode(JwtConstant.JWT_ERRCODE_FAIL);
            jwtCheckResult.setSuccess(false);
        }
        return jwtCheckResult;
    }

    public static SecretKey generalKey() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] encodedKey = DatatypeConverter.parseBase64Binary(JwtConstant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, signatureAlgorithm.getJcaName());
        return key;
    }

    /**
     * 解析JWT字符串
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}


