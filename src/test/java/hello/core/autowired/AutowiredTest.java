package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    @Configuration
    static class TestBean {

        //호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member member) { // bean에 없는 것
            System.out.println("NoBean1 = " + member);
        }

        //null 호출
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { // 없어도 됨 == 없으면 null 출력
            System.out.println("NoBean2 = " + noBean2);
        }

        //Optional.empty 호출
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3) { // 없어도 됨 == 없으면 Optional.empty 출력
            System.out.println("setNoBean3 = " + noBean3);


        }
    }
}
