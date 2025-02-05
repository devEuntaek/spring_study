package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy { // 할인 정책 인터페이스

    int discount(Member member, int price); // return이 할인 대상 금액

    // 회원과 가격을 받아서 할인을 해준다.





}
