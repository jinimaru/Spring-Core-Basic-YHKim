package com.study.yhkim.springcore;

import com.study.yhkim.springcore.member.Grade;
import com.study.yhkim.springcore.member.Member;
import com.study.yhkim.springcore.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        /*
        (First Code) - DIP(의존성 역전 원칙) 위배된 코드
        MemberService memberService = new MemberServiceImpl();

        memberService 인스턴스를 생성할 때 구현체(MemberServiceImpl)에 의존 (DIP 위배)
        */


        /*
        (Second Code) - DI 컨테이너 AppConfig 클래스를 이용, 생성자를 통한 의존성 주입
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        */


        /*
        (Refactoring)  - 스프링 DI 컨테이너 ApplicationContext 이용
        */
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("New member = " + member.getName());
        System.out.println("Find member = " + findMember.getName());

    }
}
