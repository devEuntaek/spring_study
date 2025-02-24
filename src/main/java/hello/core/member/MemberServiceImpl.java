package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 회원 저장,조회하는 틀을 가져온다. 이를 어떤 방식으로 저장할지 (MemoryMemberRepository)의 방식으로 저장한다는 룰을 가져온다.
    // 인터페이스는 정책만, MemoryMemberRepository의 틀로 db말고 메모리에 저장할 것

    private final MemberRepository memberRepository; // 원래 MemoryMemberRepository에 의존하였기에 선언하여 쓸 수 있게 함.

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) { // 괄호 안에 넣는 이유는 외부에서 이 메소드를 사용할 수 있게 하기 위해서 == 어떤 걸 넣어도 상관없음
        this.memberRepository = memberRepository; // 외부에서 넣는 값으로 객체를 생성하여 사용할 수 있게 한다.
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); // 회원가입
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId); // id로 회원찾기
    }

    //test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
