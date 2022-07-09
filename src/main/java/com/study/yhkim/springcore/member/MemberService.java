package com.study.yhkim.springcore.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
