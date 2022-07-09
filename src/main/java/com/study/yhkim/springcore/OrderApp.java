package com.study.yhkim.springcore;

import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;
import com.study.yhkim.springcore.member.MemberService;
import com.study.yhkim.springcore.member.MemberServiceImpl;
import com.study.yhkim.springcore.order.Order;
import com.study.yhkim.springcore.order.OrderService;
import com.study.yhkim.springcore.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }
}
