package com.study.yhkim.springcore;

import com.study.yhkim.springcore.discount.FixDiscountPolicy;
import com.study.yhkim.springcore.member.MemberService;
import com.study.yhkim.springcore.member.MemberServiceImpl;
import com.study.yhkim.springcore.member.MemoryMemberRepository;
import com.study.yhkim.springcore.order.OrderService;
import com.study.yhkim.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}