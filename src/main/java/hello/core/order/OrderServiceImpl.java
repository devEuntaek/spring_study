package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//     현재 의존 관계 하는 생성자가 하나 존재하기에 @Autowired 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
//        // fix인지, rate인지는 @Component 붙여져 있는 파일이 rate이기에 rate로 의존관계 주입
//    } -> @RequiredArgsConstructor 이를 선언함으로 final 붙은 생성자를 자동으로 만들어줌 (== 위 코드와 같은 역할)
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { // 주문을 이 매개변수들로 받아서
        Member member = memberRepository.findById(memberId); // memberId로 찾아 member에 담는다.
        int discountPrice = discountPolicy.discount(member, itemPrice); // 위 member와 가격을 받아온다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
        // 결과적으로 memberId와 itemName, itemPrice를 받아 discountPrice와 함께 반환해준다.
    }

    // test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
