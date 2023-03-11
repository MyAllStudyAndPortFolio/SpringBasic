package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//클라이언트인 MemberServiceImpl 입장에서 보면 의존관계를 외부에서 주입 해 주는 것으로 생각
// 의존관계 주입, 의존성 주입
@Component
public class MemberServiceImpl implements MemberService{

    // 실질적으로는 동적
    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public MemberRepository getMemberRepository(){
        return memberRepository;
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
