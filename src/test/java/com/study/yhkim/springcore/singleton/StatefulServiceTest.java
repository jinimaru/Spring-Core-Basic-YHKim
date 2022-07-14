package com.study.yhkim.springcore.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤의 잘못된 stateful 설계")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        /*
        최대한 단순화하기 위해 실제 Thread 는 사용하지 않음
        Thread A 가 사용자A 코드를 호출하고, Thread B 가 사용자B 코드를 호출한다 가정
        statefulService 의 price 필드는 공유되는 필드인데, 특정 클라이언트가 값을 변경함함
        사용자A 주문금액은 10,000원 이어야 하는데, 20,000원 이라는 결과 나옴

        - 스프링 빈은 항상 stateless 로 설계해야 함!!!
         : 특정 클라이언트에 의존적인 필드가 있으면 안됨
         : 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안됨
         : 가급적 읽기만 가능해야 함
         : 필드 대신에 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 사용해야 함
         : 공유 필드는 조심해야 함!
       */

        //Thread A: 사용자A 10,000 주문
        statefulService1.order("userA", 10000);
        //Thread B: 사용자B 20,000 주문
        statefulService2.order("userB", 20000);

        //Thread A: 사용자A 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("UserA price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}