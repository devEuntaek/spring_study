package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration을 통하여서 싱글톤이 보장된다. == '설정정보'
// 각 bean을 함으로 스프링 빈 컨테이너에 넣어주지만, @Configuration을 통하여 하나의 객체를 돌려쓸 수 있게 해준다.
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

//    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


    // memberService -> MemoryMemberRepository
    // orderService -> MemoryMemberRepository
    // 동일한 MemoryMemberRepository를 생성하는데 이거 싱글톤을 위반하는 것 아닌가요?

//    @Bean
//    public MemberService memberService() { // MemberService의 객체 memberService를 만듦
//        return new MemberServiceImpl(new MemoryMemberRepository()); // memberService를 선언하면 return될 값
//        // MemberServiceImpl안에 MemoryMemberRepository값을 넣음. 근데 MemberServiceImpl 여기보면 안에 넣는 값으로 객체를 설정하는 코드가 있음.
//    }
//
//    @Bean
//    public OrderService orderService() { // OrderService의 틀 orderService를 만듦
//        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
//        // OrderServiceImpl 안에 객체를 설정할 값 두 개를 넣음
//    }
//
//    @Bean
//    public DiscountPolicy discountPolicy() {
//        return new RateDiscountPolicy();
////        return new FixDiscountPolicy();
//    }



}
