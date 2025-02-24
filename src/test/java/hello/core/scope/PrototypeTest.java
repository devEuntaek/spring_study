package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    public void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close(); // spring 컨테이너의 종료 메소드 (근데 singleton에서만 작동되고, prototype은 spring이 생성, 의존관계 주입, 초기화까지만 관여하고
        // 더는 관리하지 않기에 컨테이너가 종료될 때, @PreDestory 종료 메소드는 실행되지 않는다.


    }

    @Scope("prototype")
    static class PrototypeBean {

        @Scope("prototype")
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean init");

        }
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean destroy");
        }

    }
}
