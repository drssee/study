package com.example.nh.functionalInterface;

import com.example.nh.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 함수형 인터페이스는(익명객체 하위 카테고리 느낌)
 * 해당 인터페이스의 구현 익명객체이자,
 * 람다식으로 간략하게 활용될 수 있다
 */
@Slf4j
public class FunctionalInterface {

    @Test
    @DisplayName("함수형 인터페이스 구현체, 생성 & 사용")
    void test1() {
        new MyFunctional1() {
            public void run() {
                log.info("함수형 인터페이스의 객체이름은?={}", this);
            }
        }.run();
    }

    @Test
    @DisplayName("특정 메서드의 매개변수에 함수형 인터페이스 구현체, 생성 & 주입")
    void test2() {
        executeFunctional1(new MyFunctional1() {
            public void run() {
                log.info("함수형 인터페이스의 객체이름은?={}", this);
            }
        });
    }

    @Test
    @DisplayName("함수형 인터페이스는, 자바의 람다식으로 간략하게 표현 가능")
    void test3() {
        executeFunctional1(() -> {
            log.info("함수형 인터페이스(람다식)의 객체이름은?={}", this);
        });
    }

    @Test
    @DisplayName("람다식을, 다형성을 이용해 참조 연결")
    void test4() {
//        MyFunctional1 myFunctional1 = new MyFunctional1() {
//            @Override
//            public void run() {
//                log.info("count={}", count);
//            }
//        };
        final String str = "함수형 인터페이스";
        MyFunctional1 myFunctional1 = () -> {
            log.info("str={}", str);
        };
        log.info("myFunctional1={}", myFunctional1);
        myFunctional1.run();
        myFunctional1.run();
    }

    private void executeFunctional1(MyFunctional1 myFunctional1) {
        myFunctional1.run();
    }

    @Test
    @DisplayName("매개변수를 가지는 함수형 인터페이스 활용하기")
    void test5() {
        Person person1 = new Person("name1", 20);

        new MyFunctional2() {
            @Override
            public void runWithParam(Person person) {
                log.info("person={}", person);
            }
        }.runWithParam(person1);
    }

    @Test
    @DisplayName("매개변수를 가지는 함수형 인터페이스를, 람다식으로 활용하기")
    void test6() {
        Person person1 = new Person("name1", 20);

        /*
        이 케이스는 많이 활용되는 경우인데
        함수형 인터페이스 MyFunctional2에 존재하는 유일한 추상메서드 runWithParam(Person person)을 이용해
        함수형 인터페이스 타입의 변수에
        익명구현객체 -> 람다식 -> 람다식에, 추상메서드의 파라미터 전달하여 사용 가능
         */
        MyFunctional2 myFunctional2 = (Person person) -> {
            log.info("person={}", person);
        };

        myFunctional2.runWithParam(person1);
    }
}
