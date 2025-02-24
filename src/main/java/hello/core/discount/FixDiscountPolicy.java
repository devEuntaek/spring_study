package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy { // 할인 정책 구현 클래스

    private int discountFixAmount = 1000; // 할인 금액은 1000원


    @Override
    public int discount(Member member, int price) { // member와 price를 받아서
        if (member.getGrade() == Grade.VIP) { // 만약 멤버의 grade가 vip라면 /
            return discountFixAmount; // 할인 금액은 1000원
// 궁금했던 점 : 위에 member의 생성자가 없는 상태에서 어떻게 받아올지 몰랐는데, 여기는 그냥 기능만 구현하고 실제 service에서 매개변수로 넣어서 사용하니까 member가 주어졌을때를 가정하여 기능을 구현한다.
        } else {
            return 0; // 아니면 없음
        }
    }
}
