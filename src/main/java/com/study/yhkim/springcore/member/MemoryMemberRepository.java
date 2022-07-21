package com.study.yhkim.springcore.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component //(Refactoring) - ComponentScan 을 통한 자동 빈 등록 어노테이션. AutoAppConfig 참조
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
