package hello.core.member;

// memberService 의 join 과 findMember 담당
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
