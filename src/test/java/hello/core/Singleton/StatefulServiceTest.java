package hello.core.Singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // 사용자 A 10000원 주문, 근데 갑자기 사용자 B가 20000원을 주문했다?
        // 현재 하나의 객체를 사용하였음, 하지만 현재 Test에서 공유필드를 사용하지말고, 지역 변수를 사용해주어 값을 분리시킨다.
        // 근데 그러면 결국 객체를 또 하나 만든 것 아닌가? 싱글톤의 의미가 존재하나?
        int userAprice = statefulService1.order("userA", 10000);
        int userBprice = statefulService2.order("userB", 20000);


//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}