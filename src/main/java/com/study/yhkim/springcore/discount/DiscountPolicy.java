package com.study.yhkim.springcore.discount;

import com.study.yhkim.springcore.member.Member;

public interface DiscountPolicy {

    /**
     * @return Amount eligible for discount
     */
    int discount(Member member, int price);
}
