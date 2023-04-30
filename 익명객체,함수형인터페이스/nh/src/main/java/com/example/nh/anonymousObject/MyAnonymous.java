package com.example.nh.anonymousObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAnonymous {

    public void loggingThis() {
        log.info("this.class={}", this.getClass());
    }

    public void loggingSuper() {
        /*
        인스턴스가 생성 된 후 super.getClass()를 해도 자기자신이다?
        getClass()는 객체의 실제 타입을 가져온다(조상 a = new 자손()), 여기서 getClass() = 자손
        그러므로 해당 메서드의 실행 시점엔 MyAnonymous인것이 자명하다
         */
        log.info("super.class={}", super.getClass());
    }

    public static void main(String[] args) {
        MyAnonymous myAnonymous = new MyAnonymous();
        myAnonymous.loggingThis();
        myAnonymous.loggingSuper();
    }
}
