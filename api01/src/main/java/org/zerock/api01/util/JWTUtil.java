package org.zerock.api01.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Log4j2
public class JWTUtil {

    @Value("${org.zerock.jwt.secret}")
    private String key;

    public String generateToken(Map<String, Object> valueMap,int days) {
        log.info("generateKey..."+key);

        //헤더 부분
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ","JWT");
        headers.put("alg","HS256");

        //페이로드 부분
        Map<String, Object> payloads = new HashMap<>();
        payloads.putAll(valueMap);

        //유효시간
        int time = (1) * days;

        //jsonwebtoken 라이브러리 이용해 jwt 생성
        String jwtStr = Jwts.builder()
                //헤더
                .setHeader(headers)
                //페이로드
                .setClaims(payloads)
                //발행시간
                .setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                //만료시간
                .setExpiration(Date.from(ZonedDateTime.now().plusDays(time).toInstant()))
                //서명알고리즘+개인키
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                //jwt를 base64로 인코딩된 결과를 반환
                .compact();

        return jwtStr;
    }

    public Map<String, Object> validateToken(String token) throws JwtException {
        Map<String, Object> claim = null;

        claim = Jwts.parser()
                //디코딩시 사용할 개인키
                .setSigningKey(key.getBytes())
                //토큰 디코딩(base64)
                .parseClaimsJws(token)
                //페이로드 얻기
                .getBody();

        return claim;
    }
}
