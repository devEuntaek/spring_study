package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { // 주문을 이 매개변수들로 받아서
        Member member = memberRepository.findById(memberId); // memberId로 찾아 member에 담는다.
        int discountPrice = discountPolicy.discount(member, itemPrice); // 위 member와 가격을 받아온다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
        // 결과적으로 memberId와 itemName, item가격,
    }
}
