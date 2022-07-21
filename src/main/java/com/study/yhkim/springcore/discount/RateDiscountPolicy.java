package com.study.yhkim.springcore.discount;

import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;
import org.springframework.stereotype.Component;

@Component //(Refactoring) - ComponentScan 을 통한 자동 빈 등록 어노테이션. AutoAppConfig 참조
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
