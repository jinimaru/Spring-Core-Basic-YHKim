package com.study.yhkim.springcore.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //(Refactoring) - ComponentScan 을 통한 자동 빈 등록 어노테이션. AutoAppConfig 참조
public class MemberServiceImpl implements MemberService {

    /*
    (First Code) - DIP(의존성 역전 원칙) 위배된 코드
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    memberRepository 인스턴스를 생성할 때 구현체(MemoryMemberRepository)에 의존 (DIP 위배)
    */

    /*
    (Second Code) - 생성자를 통한 의존성 주입

    MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체(인스턴스)가 주입될지 알 수 없음
    외부(AppConfig)에서 MemberServiceImpl 생성자를 호출하여 MemberRepository 구현체(memoryMemberRepository) 주입
    */
    private final MemberRepository memberRepository;

    /*
    (Refactoring) - 자동 의존관계 주입 @Autowired

    ComponentScan 을 통한 자동 빈 등록에 따라서 자동 의존관계 등록을 위한 어노테이션 설정
    */
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
