package org.zerock.api01.util;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Log4j2
public class JWTUtilTests {

    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate() {
        Map<String, Object> claimMap = Map.of("mid","ABCDE");
        String jwtStr = jwtUtil.generateToken(claimMap,1);
        log.info(jwtStr);
    }

    @Test
    public void testValidate() {
        //유효 시간이 지난 토큰
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NzkxOTg1NjQsIm1pZCI6IkFCQ0RFIiwiaWF0IjoxNjc5MTk4NTA0fQ.QFFV6_tBo2waT4V423JIE6mUuyU5cyL2n7n-vozMM3E";
        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);
        log.info(claim);
    }

    @Test
    public void testAll() {
        String encodedJwt = jwtUtil.generateToken(Map.of("mid","AAAA", "email","aaaa@bbb.com"),1);
        log.info(encodedJwt);
        Map<String, Object> claim = jwtUtil.validateToken(encodedJwt);
        claim.keySet().forEach(key -> {
            log.info(claim.get(key));
        });
    }
}
