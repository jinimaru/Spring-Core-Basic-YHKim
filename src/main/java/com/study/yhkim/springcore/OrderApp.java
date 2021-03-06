package com.study.yhkim.springcore;

import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;
import com.study.yhkim.springcore.member.MemberService;
import com.study.yhkim.springcore.order.Order;
import com.study.yhkim.springcore.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        /*
        (First Code) - DIP(의존성 역전 원칙)이 위배된 코드
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        memberService, orderService 인스턴스를 생성할 때
        구현제(MemberServiceImpl, OrderServiceImpl)에 의존. (DIP 위배)
        */


        /*
        (Second Code) - DI 컨테이너 AppConfig 클래스를 이용, 생성자를 통한 의존성 주입
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        */


        /*
        (Refactoring) - 스프링 DI 컨테이너 ApplicationContext 이용
        */
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }
}
