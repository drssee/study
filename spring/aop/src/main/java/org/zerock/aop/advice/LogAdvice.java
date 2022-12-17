package org.zerock.aop.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAdvice {
	//기본 before aop
    @Before("execution(* org.zerock.aop.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("=======================");
        log.info("기본 before aop");
        log.info("=======================");
    }
    //파라미터에 aop 적용하기
    @Before("execution(* org.zerock.aop.service.SampleService*.doAdd(String,String)) && args(str1,str2)")
    public void logBeforeWithParam(String str1,String str2) {
        log.info("=======================");
    	log.info("파라미터에 aop 적용하기");
    	log.info("str1: "+str1);
    	log.info("str2: "+str2);
        log.info("=======================");
    }
    
    //예외발생체크 aop
    @AfterThrowing(pointcut = "execution(* org.zerock.aop.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("=======================");
    	log.info("예외발생체크 aop");
    	log.info("Exception...!!!");
    	log.info("exception = "+exception);
        log.info("=======================");
    }
    
    //로그타임책정 around-proceedingJoinPoint
    @Around("execution(* org.zerock.aop.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Around=======================");
    	
    	log.info("로그타임책정 around-proceedingJoinPoint");
    	
    	long start = System.currentTimeMillis();
    	
    	log.info("Target: "+pjp.getTarget());
    	log.info("Args: "+Arrays.toString(pjp.getArgs()));
    	
    	Object result = null;
    	
    	//JoinPoint메서드 실행 후 리턴값 저장
    	try {
			result = pjp.proceed();
		} catch (Throwable e) {
			throw new Throwable();
		} finally {
	    	long end = System.currentTimeMillis();
	    	
	    	log.info("Time: "+(end-start)+"ms");
	    	
	        log.info("Around=======================");
		}
    	
    	return result;
    }
}
