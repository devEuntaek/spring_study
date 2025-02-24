package hello.core.Singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드

//    public void order(String name, int price) {
//        System.out.println("name = " + name + ", price = " + price);
//        this.price = price; // 여기가 문제임
//    }

    // 그냥 price를 return 해주는 order 메소드
    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
//        this.price = price; // 여기가 문제임
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
