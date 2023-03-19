package org.zerock.api01.config;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.zerock.api01.security.APIUserDetailsService;
import org.zerock.api01.security.filter.APILoginFilter;
import org.zerock.api01.security.filter.RefreshTokenFilter;
import org.zerock.api01.security.filter.TokenCheckFilter;
import org.zerock.api01.security.handler.APILoginSuccessHandler;
import org.zerock.api01.util.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class CustomSecurityConfig {

    //시큐리티 사용법(jwt)
    //1.config 파일 작성
    //2.xxxUserDetailsService 구현
    //2-1.프론트와 연계 위한 dto 만들어 스프링user 상속시킴
    //3.xxxUserDetailsService를 이용해 AuthenticationManager(xxxUserDetailsServiceservice) 생성
    //4.AuthenticationManager를 이용하는 filter(AbstractAuthenticationProcessingFilter)를 구현해 인증절차를 태움
    //5.AuthenticationSuccessHandler를 이용해 성공후 절차를 작성
    //6.AuthenticationSuccessHandler를 설정에 등록

    private final APIUserDetailsService apiUserDetailsService;

    private final JWTUtil jwtUtil;

    private static final Logger log = LoggerFactory.getLogger(CustomSecurityConfig.class);


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        log.info("-----web configure-----");
        //함수형 인터페이스 구현체 리턴(매개변수 타입 WebSecurity webSecurity)
        return (webSecurity) -> webSecurity.ignoring()
                .requestMatchers(
                        PathRequest.toStaticResources().atCommonLocations()
                );
    }

    //스프링 필터체인 설정의 핵심
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        log.info("-----configure-----");
        //AuthenticationManager설정
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(apiUserDetailsService)
                        .passwordEncoder(passwordEncoder());
        //Get AuthenticationManager
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        //반드시 필요
        http.authenticationManager(authenticationManager);

        //APILoginFilter
        APILoginFilter apiLoginFilter = new APILoginFilter("/generateToken");
        apiLoginFilter.setAuthenticationManager(authenticationManager);
        //APILoginSuccessHandler
        APILoginSuccessHandler apiLoginSuccessHandler = new APILoginSuccessHandler(jwtUtil);
        apiLoginFilter.setAuthenticationSuccessHandler(apiLoginSuccessHandler);
        //APILoginFilter의 위치 조정
        http.addFilterBefore(apiLoginFilter, UsernamePasswordAuthenticationFilter.class);

        //TokenCheckFilter
        TokenCheckFilter tokenCheckFilter = new TokenCheckFilter(jwtUtil);
        //api로 시작하는 모든 경로는 TokenCheckFilter 동작
        http.addFilterBefore(tokenCheckFilter, UsernamePasswordAuthenticationFilter.class);

        //RefreshTokenFilter
        RefreshTokenFilter refreshTokenFilter = new RefreshTokenFilter("/refreshToken", jwtUtil);
        http.addFilterBefore(refreshTokenFilter, TokenCheckFilter.class);

        http.csrf().disable(); //csrf 토큰의 비활성화
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //세션 사용하지 않음
        return http.build();
    }
}
