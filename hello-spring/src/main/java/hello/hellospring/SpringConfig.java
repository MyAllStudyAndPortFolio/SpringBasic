package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.JdbcMemberRepository;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
/* 1, 2
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
*/

    /* 2 private final DataSource dataSource;
    private final EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        // 상호의존적으로 받아야 한다.
        return new MemberService(memberRepository);
    }



//    @Bean
//    public MemberRepository memberRepository() {
//         return new MemoryMemberRepository();
  // 1     return new JdbcMemberRepository(dataSource);
   // 2    return new JdbcTemplateMemberRepository(dataSource);
    // 3   return new JpaMemberRepository(em);
//
//   }
}