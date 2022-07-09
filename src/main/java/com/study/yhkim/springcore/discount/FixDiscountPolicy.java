package com.study.yhkim.springcore.discount;

import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discout(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
