package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */

    @Transactional
    public Long join(Member member) {
        long start = System.currentTimeMillis();
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();



        // 같은 이름이 있는 중복 회원 X
        //Optional<Member> result = memberRepository.findByName(member.getName());

        // 바로 꺼낸다면
        // result.get();
        // 값이 있다면 ? 아니면 ->> 형식으로 진행 시에는
        // result.orElseGet();

        /**
         * 골라서 꺼낸다면
         *result.ifPresent(member1 ->{
         *     throw new IllegalStateException("이미 현존하는 회원 입니다. ");
         *} );
         */

        // 굳이 이렇게 선언하고 중복 할 필요 없이 이런 형식으로 진행하면 된다.

       // validateDuplicateMember(member); // 중복 회원 검증

       // memberRepository.save(member);
        //return member.getId();

    }

    private void validateDuplicateMember(Member member) {
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });


    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){

            return memberRepository.findAll();


    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
