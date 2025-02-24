package hello.core.member;

// MemberRepository로 간단 기능 제공?
public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);
}
