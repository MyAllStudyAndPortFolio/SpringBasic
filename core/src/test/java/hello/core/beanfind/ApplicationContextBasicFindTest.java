package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.MemberApp;
import hello.core.member.MemberService;

import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Documented;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회 타입으로 조회")
    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    /**
     * org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'XXXX' available
     * bean을 못찾아 오류가 발생하게 된다.
     */
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
       // MemberService xxxx = ac.getBean("XXXX", MemberService.class);
        // assertThrows 를 통해 예외 처리를 던져주게 된다.
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("XXXX", MemberService.class));
    }

}
