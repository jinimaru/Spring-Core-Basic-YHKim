package com.study.yhkim.springcore.order;

import com.study.yhkim.springcore.AppConfig;
import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;
import com.study.yhkim.springcore.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    /*
    (First Code) - DIP(의존성 역전 원칙)이 위배된 코드
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    memberService, orderService 인스턴스를 생성할 때
    구현제(MemberServiceImpl, OrderServiceImpl)에 의존. (DIP 위배)
    */

    /*
    (Refactoring) - DI 컨테이너 AppConfig 클래스를 이용, 생성자를 통한 의존성 주입
    */
    private MemberService memberService;
    private OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}