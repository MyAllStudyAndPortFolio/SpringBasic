package hello.core.member;


// 실질적으로는 정적
// 멤버의 save 와 find 를 담당
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
