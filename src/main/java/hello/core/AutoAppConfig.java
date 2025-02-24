package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 여기부터 스프링 컨테이너를 설정해주기 위해 파일을 탐색한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 이전에 AppConfig로 수동으로 의존관계 넣어둔 것을(Configuration) 제외해주고 시작함 (충돌방지)

        // 하지만 그냥 아무것도 설정하지 않고, 최상단 파일부터 탐색하는 것을 추천
        // 이러면 최상단 파일부터 탐색하여 모든 @Component가 붙은 모든 bean들을 Spring 컨테이너에 지정
)

public class AutoAppConfig {



//    @Bean(name = "memoryMemberRepository")
//    MemberRepository MemberRepository() {
//        return new MemoryMemberRepository();
//    }


}
