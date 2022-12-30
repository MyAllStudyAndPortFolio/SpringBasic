package hello.core.member;


// 실질적으로는 정적
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
