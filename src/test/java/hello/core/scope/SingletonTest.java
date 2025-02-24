package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1: " + singletonBean1);
        System.out.println("singletonBean2: " + singletonBean2);
        assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close();
    }

    @Scope("singleton") // 해당 빈을 singleton으로 지정 -> 그렇기에 같은 인스턴스를 제공하여 출력값이 같음
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean destroy");
        }
    }
}
