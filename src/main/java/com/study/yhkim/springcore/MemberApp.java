package com.study.yhkim.springcore;

import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;
import com.study.yhkim.springcore.member.MemberService;
import com.study.yhkim.springcore.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("New member = " + member.getName());
        System.out.println("Find member = " + findMember.getName());

    }
}
