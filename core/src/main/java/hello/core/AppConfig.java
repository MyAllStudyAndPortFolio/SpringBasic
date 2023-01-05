package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
//AppConfig 는 생성한 객체 인스턴스의 참조를 "생성자를 통해서 주입" 해준다.
public class AppConfig {
    //AppConfig Refactoring
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    /**
     *  원래 orderService 안에 있던
     *  MemoryMemberRepository, FixDiscountPolicy 를
     *  밖으로 빼냄
     *  */
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),discountPolicy());
    }



}
