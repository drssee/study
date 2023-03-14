package org.zerock.b01.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
@RequiredArgsConstructor
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("-----configure-----");
        http.formLogin();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        log.info("-----web configure-----");
        //@FunctionalInterface 함수형 인터페이스를 리턴값으로 가지는 메서드는
        //함수형 인터페이스의 유일한 추상메서드를 람다식으로 구현한 객체를 구현체로 리턴한다
        //단 유일한 추상메서드의 파라미터 객체값을 사용 여기선 WebSecurity websecurity
        return (webSecurity) -> webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
