package com.example.nh.anonymousObject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class AnonymousObjectTest {

    static AnonymousObjectTest anony;

    @Test
    @DisplayName("익명 객체 생성 후 this, super 확인")
    void test1() {
        /*
        익명클래스1
         */
        new MyAnonymous() {
            public void logging() {
                super.loggingThis();
                //익명클래스 이름 생성규칙에 맞는지 확인
                assertThat(this.getClass().toString()).isEqualTo("class com.example.nh.anonymousClass.AnonymousClassTest$1");
            }
        }.logging();


        /*
        익명클래스2
         */
        new MyAnonymous() {
            public void logging() {
                super.loggingThis();
                //익명클래스 이름 생성규칙에 맞는지 확인
                assertThat(this.getClass().toString()).isEqualTo("class com.example.nh.anonymousClass.AnonymousClassTest$2");
            }
        }.logging();

        anony = this;
    }

    @Test
    @DisplayName("인터페이스를 이용한 익명 구현객체 생성")
    void test2() {

        /*
        익명클래스1(구현객체)
         */
        new MyAnonymousInterface() {
            @Override
            public void loggingThis() {
                log.info("this.getclass={}", this.getClass());
                //서로 다른 테스트 객체일텐데
                //익명함수의 index가 기억 되어 3이 되야함?
                assertThat(this.getClass().toString()).isEqualTo("class com.example.nh.anonymousClass.AnonymousClassTest$3");
            }
        }.loggingThis();

        //서로 다른 테스트 객체에서 실행됐다는것을 증명
        assertThat(this).isNotEqualTo(anony);
    }
}
