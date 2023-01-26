package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//AppConfig 는 생성한 객체 인스턴스의 참조를 "생성자를 통해서 주입" 해준다.

@Configuration
public class AppConfig {
    //AppConfig Refactoring
    // 스프링 Bean은 @Bean 이 붙은 메서드 명을 스프링 빈의 이름으로 사용

    //@Bean memberService -> new MemorymemberRepository()
    //@Bean orderService ->

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    /**
     *  원래 orderService 안에 있던
     *  MemoryMemberRepository, FixDiscountPolicy 를
     *  밖으로 빼냄
     *  */
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        // fix 에서 Rate 로 교체한다. 구성영역 변경
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }



}
