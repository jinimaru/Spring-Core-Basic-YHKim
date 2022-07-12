package com.study.yhkim.springcore;

import com.study.yhkim.springcore.discount.DiscountPolicy;
import com.study.yhkim.springcore.discount.RateDiscountPolicy;
import com.study.yhkim.springcore.member.MemberRepository;
import com.study.yhkim.springcore.member.MemberService;
import com.study.yhkim.springcore.member.MemberServiceImpl;
import com.study.yhkim.springcore.member.MemoryMemberRepository;
import com.study.yhkim.springcore.order.OrderService;
import com.study.yhkim.springcore.order.OrderServiceImpl;

public class AppConfig {

    /*
    (First Code)
    역할과 구현 클래스가 잘 보이지 않음
    코드 중복: new MemoryMemberRepository()
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
    */

    /*
    (Refactoring)
    코드 중복을 제거하고 역할과 구현이 보이도록 리펙터링
     - 메서드 이름을 보면 역할(Implements)이 드러나고, 구현(Class)이 보인다.
    */
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}