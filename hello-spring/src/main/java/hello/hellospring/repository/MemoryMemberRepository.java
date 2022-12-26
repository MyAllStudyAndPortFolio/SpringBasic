package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.swing.text.html.Option;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    /*
     * 원래는 더 보안성이 높고 안정성이 높아야 하지만
     * 예제이기 때문에 이렇게 진행행    * */
    // 공유 변수
    private static Map<Long, Member> store = new HashMap<>();
    // 키값 생성
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
