package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);

    }

    public void call(String message) {
        System.out.println("call: "+ url + "message: " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct // 이 방법을 쓰면 된다. bean의 초기화 삭제를 자동으로 해주는 가장 최신 방법
    public void init(){ // 위 어노테이션으로 인해 객체가 생성되면 자동으로 실행이 되는 메소드
        System.out.println("NetworkClient.init");
        disconnect();

    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        connect();
        call("초기화 연결 메시지");

    }
}
