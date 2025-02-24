package hello.core.Singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수한 di 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        // 1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인한다.
        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        // memberService1 != memberService2 (서로 다른 시기에 생성된 객체) -> 이 순수한 di 컨테이너는 메모리 낭비가 심하다!!
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

        // 이를 해결할 수 있는 것은 싱글톤 패턴

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 생성")
    void singletonServiveTest() {

        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1: " + singletonService1);
        System.out.println("singletonService2: " + singletonService2);
        // 이 둘은 같은 객체 (싱글톤)

        assertThat(singletonService1).isSameAs(singletonService2);
        // same : ==
        // equal :

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        //  Spring 컨테이너에서 객체를 생성
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

//        AppConfig appConfig = new AppConfig();

        // 스프링 컨테이너에서 memberService 이름으로 등록된 bean을 가져온다.
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        System.out.println("memberService1: " + memberService1);
        System.out.println("memberService2: " + memberService2);

        // Spring 컨테이너를 사용하여 싱글톤 기능을 사용함 -> 기존 코드 수정x
        assertThat(memberService1).isSameAs(memberService2);

    }
}
