package com.study.yhkim.springcore.discount;

import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP member should receive a 10% discount.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discout(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("If the member is not a VIP, the 10% discount should not be applied.")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.Basic);

        //when
        int discount = discountPolicy.discout(member, 10000);

        //then
        Assertions.assertThat(discount).isNotEqualTo(1000);
    }
}