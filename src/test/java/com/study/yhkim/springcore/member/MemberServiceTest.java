package com.study.yhkim.springcore.member;

import com.study.yhkim.springcore.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    /*
    (First Code) - DIP(의존성 역전 원칙) 위배된 코드
    MemberService memberService = new MemberServiceImpl();

    memberService 인스턴스를 생성할 때 구현체(MemberServiceImpl)에 의존 (DIP 위배)
    */

    /*
    (Refactoring) - DI 컨테이너 AppConfig 클래스를 이용, 생성자를 통한 의존성 주입
    */
    private MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
