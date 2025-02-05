package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 되어야 한다.")
    void Vip_o() {

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Vip가 아닐 때는 할인이 되면 안 된다.")
    void Vip_x() {

        //given
        Member member = new Member(2L, "memberB", Grade.Basic);


        //when
        int discount = discountPolicy.discount(member, 10000);


        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }



}