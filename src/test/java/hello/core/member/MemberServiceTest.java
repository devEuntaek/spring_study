package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

public class MemberServiceTest {

    MemberService memberservice;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberservice = appConfig.memberService();
    }
//    MemberService memberservice = new MemberServiceImpl();

    @Test
    void join() {

        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberservice.join(member);
        Member findmember = memberservice.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}
