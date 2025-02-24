package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    // 마커에너테이션 : 이 파일 안에 아무 코드가 없어도 MyIncludeComponent 이 단어 하나만으로 포함하는 기능을 담당한다.
}
