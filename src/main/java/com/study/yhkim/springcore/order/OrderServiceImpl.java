package com.study.yhkim.springcore.order;

import com.study.yhkim.springcore.discount.DiscountPolicy;
import com.study.yhkim.springcore.member.Member;
import com.study.yhkim.springcore.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //(Refactoring) - ComponentScan 을 통한 자동 빈 등록 어노테이션. AutoAppConfig 참조
public class OrderServiceImpl implements OrderService {

    /*
    (First Code) - DIP(의존성 역전 원칙) 위배된 코드
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    memberRepository, discountPolicy 인스턴스를 생성할 때
    구현체(MemoryMemberRepository, FixDiscountPolicy)에 의존 (DIP 위배)
     */

    /*
    (Second Code) - 생성자를 통한 의존성 주입

    OrderServiceImpl 입장에서 생성자를 통해 어떤 구현 객체(인스턴스)가 주입될지 알 수 없음
    외부(AppConfig)에서 OrderServiceImpl 생성자를 호출하여,
    MemberRepository 구현체(memoryMemberRepository), DiscountPolicy 구현체(fixDiscountPolicy) 주입
    */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /*
    (Refactoring) - 자동 의존관계 주입 @Autowired

    ComponentScan 을 통한 자동 빈 등록에 따라서 자동 의존관계 등록을 위한 어노테이션 설정
    */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
