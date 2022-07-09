package com.study.yhkim.springcore.order;

import com.study.yhkim.springcore.discount.DiscountPolicy;
import com.study.yhkim.springcore.discount.FixDiscountPolicy;
import com.study.yhkim.springcore.member.Member;
import com.study.yhkim.springcore.member.MemberRepository;
import com.study.yhkim.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discout(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}