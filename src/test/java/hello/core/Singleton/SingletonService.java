package hello.core.Singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;

    }

    private SingletonService() {

    }

    // Spring 컨테이너를 사용하지 않으면, 이 복잡한 코드를 계속 사용해야한다.
    // 추가적으로 dip, ocp도 위반한다.

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
