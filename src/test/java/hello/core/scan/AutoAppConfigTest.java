package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        // ApplicationContext ac 와 차이점은 위 코드는 구현체로 초기화하여 다시 세팅?

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

//        System.out.println("memberService: " + memberService);
        // MemberServiceImpl로 출력이 되는데 이는 MemberServiceImpl파일에 @AutoWired로 의존관계 설정이 되어있기 때문이다.
    }
}
