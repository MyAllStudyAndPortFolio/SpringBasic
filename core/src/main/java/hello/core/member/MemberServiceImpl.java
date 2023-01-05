package hello.core.member;

//클라이언트인 MemberServiceImpl 입장에서 보면 의존관계를 외부에서 주입 해 주는 것으로 생각
// 의존관계 주입, 의존성 주입
public class MemberServiceImpl implements MemberService{

    // 실질적으로는 동적
    private final MemberRepository memberRepository;

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
